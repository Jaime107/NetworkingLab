package ServerCalculations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerTrigo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        String answer;
        String fun = "cos";
        String nxtFun;
        String message = "...";
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir mensaje en puerto 35000:");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje recibido:" + inputLine);
            nxtFun = separateFunVal(inputLine);
            if(nxtFun != null){
                fun = nxtFun;
                message = "La funcion actual es:" + fun;
                outputLine = message ;
                out.println(outputLine);
            }else{
                answer = chooseFuntion(fun, inputLine);
                message = "El " + fun +" del número "+ inputLine + "es: " + answer;
                outputLine = message ;
                out.println(outputLine);
                if (outputLine.equals("Bye."))break;
            }
        }out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static String chooseFuntion (String choose, String number) {
        String answer;

        switch (choose)
        {
            case "sin":
                answer = sin(number);
                break;
            case "tan":
                answer = tan(number);
                break;
            case "cos":
                answer = cos(number);
                break;
            default: answer = "Función inválida";
                break;
        }
        return answer;
    }

    public static String separateFunVal (String funVal) {
        String[] parts = funVal.split(":");
        if (parts.length > 1){return parts[1];}
        return null;
    }

    public static String sin (String x) {

        double num = Double.parseDouble(x);
        num = Math.sin(num);

        return String.valueOf(num);
    }

    public static String cos (String x) {

        double num = Double.parseDouble(x);
        num = Math.cos(num);

        return String.valueOf(num);
    }

    public static String tan (String x) {

        double num = Double.parseDouble(x);
        num = Math.tan(num);

        return String.valueOf(num);
    }


}
