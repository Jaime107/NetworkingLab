package HttpServer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HttpServer {
    private static HttpServer _instance = new HttpServer();

    //Constructor
    private HttpServer(){}
    //Obtener solo dentro de la clase
    private static HttpServer getInstance(){
        return _instance;
    }

    public static void main(String... args) throws IOException {
        HttpServer.getInstance().startServer(args);
    }

    public void startServer(String[] args) throws IOException {
        int port = 35000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port:" + port);
            System.exit(1);
        }
        Socket clientSocket = null;
        boolean running = true;
        while(running){
            try {
                System.out.println("Listo para recibir en puerto: " + port);
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            processRequest(clientSocket);
        }

        serverSocket.close();
    }

    public void processRequest(Socket clientSocket) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        String method= "";
        String path= "";
        String version= "";
        List<String> headers = new ArrayList<String>();
        while ((inputLine = in.readLine()) != null) {
            if (method.isEmpty()){
                String[] resquestString = inputLine.split(" ");
                method = resquestString[0];
                path = resquestString[1];
                version = resquestString[2];
                System.out.println("Request:" + method + path );

            }else{
                System.out.println("Headers:" + headers );
                headers.add(inputLine);

            }
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        String responseMessage =  createTextResponse(path);
        out.println(responseMessage);


        out.close();
        in.close();

        clientSocket.close();
    }

    public String createTextResponse(String path){
        String type = "text/html";
        if (path.endsWith(".css")){
            type = "text/css";
        }else if(path.endsWith(".js")){
            type = "text/javascript";
        }
        Path file = Paths.get("./www" + path);
        Charset charset = Charset.forName("UTF-8");
        String outmsg ="";
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                outmsg = outmsg + "\r\n" + line ;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: "+ type + "/html\r\n"
                + "\r\n"
                + outmsg;
    }
}