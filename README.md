# TALLER DE NETWORKING


This workshop presents different challenges that will help you explore the concepts of naming schemes and clients and services. 

# DOCUMENTATION

[Lab 3](/NamesNetworkClientService.pdf)

# DESIGN CHALLENGE 1

![Design1](img/diagramaDeClases1.JPG)

## DataManager

### readResource

* @param direction Name of the file, without path.
* @return file, html file.

### readImage
     
* @param direction name of the image that you need to read.
* @return finalData, image in byte array.

### sendResource

* @param direction name of the resource that server needs to send.
* @param client Client Socket to know where to send the resource.

## RequestHandler

### RequestHandler

* @param socket this is the socket that the RequestHandler needs to review request.
* @return finalResource the name of the file that client needs.

### getRequest

* @return name of the request made by the client throught GET petitions.

## SocketConnection

### getServerConnection 

* @return socket server

### getClientConnection 

* @param serverSocket he client will connect to this server. 
* @return clientSocket clientSocket Socket del cliente.



# DESIGN CHALLENGE 2

![Design2](img/diagramaDeClases2.JPG)

## EchoClient

### ejecutaServicio
* Run the service.

### echo
* echo server implementation

## EchoServer 
* (Interface)


# START

Copy the project through git clone in any direction to start working:
```
git clone git@github.com:Jaime107/NetworkingLab.git
```

## PRE-REQUISITES

* Java jdk > 7
* Maven (Apache Maven)
* Git

## INSTALL

1. Run in terminal:

```
$$ mvn package
```
2.(Optional):
If you want to view the documentation of the application, execute the following command and check the following path: root / target / site / apidocs:

```
mvn javadoc:javadoc
```

3. (Run):

# EXERCISE 1

Write a program in which you create a URL object and print each of the components of a URL to the screen. That is, you must use the following methods: getProtocol, getAuthority, getHost, getPort, getPath, getQuery, getFile, getRef. Make sure neither prints an empty string, this implies that the URL you use for your object must contain enough data.
  
```
java -cp target/escuelaing.edu.co-1.0-SNAPSHOT.jar networking.analizadorUrl

```
![Programa1](img/ejercicio1.JPG)

# EXERCISE 2

Write a browser application that, given a URL, reads data from that address and stores it in a file with the name result.html. Try to view this file in the browser. Your implementation must be a program that receives the URL parameter via the command line.
  
```
java -cp target/escuelaing.edu.co-1.0-SNAPSHOT.jar networking.ejercicio2.URLReader

```

![Programa2](img/ejercicio2.JPG)

![Programa2-1](img/ejercicio2-1.JPG)

![Programa2-2](img/ejercicio2-2.JPG)


# EXERCISE 4.3.1

Using sockets write a server that receives a number and answers the square of this number.
  

Power on the server:
```
java -cp target/escuelaing.edu.co-1.0-SNAPSHOT.jar ServerCalculations.EchoServer

```


Request the number:
```
java -cp target/escuelaing.edu.co-1.0-SNAPSHOT.jar ServerCalculations.EchoClient

```

![Programa3-1](img/ejercicio3-1.JPG)

![Programa3-2](img/ejercicio3-2.JPG)


# EXERCISE 4.3.2

Write a server that can receive a number and respond with an operation on this number. This server can receive a message that begins with "fun:", if it receives this message change the operation to the specified ones. The server must answer the sine, cosine and tangent functions. By default you should start calculating the cosine. For example, if the first number it receives is 0, it must respond 1, if afterwards it receivesπ / 2 it must respond 0, if it then receives “fun: sin” it must change the current operation to sine, that is, from that moment on it must calculate breasts. If he immediately receives 0, he must answer 0  

Power on the server:
```
java -cp target/escuelaing.edu.co-1.0-SNAPSHOT.jar ServerCalculations.EchoServerTrigo

```


Request the number:
```
java -cp target/escuelaing.edu.co-1.0-SNAPSHOT.jar ServerCalculations.EchoClientTrigoFuntion

```

![Programa4-3-1](img/ejercicio4-3-2a.png)

![Programa4-3-2](img/ejercicio4-3-2b.png)



# EXERCISE 4.5.1

Write a web server that supports multiple requests in a row (non-concurrent). The server should return all requested files, including html pages and images. Build a website with javascript to test your server. Deploy your solution on Heroku. DO NOT use web frameworks like Spark or Spring use only Java and the libraries for network management.
  
```
java -cp target/escuelaing.edu.co-1.0-SNAPSHOT.jar HttpServer.HttpServer

```

![Reto1-1](img/reto1-1.JPG)



## BUILT

* [Maven](https://maven.apache.org/) - Dependency Management
* [JAVA JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html) - Building
* [JUnit 3.8.1](https://mvnrepository.com/artifact/junit/junit/3.8.1) - Test


## AUTHOR

* **JAIME MARTINEZ** - [Jaime107](https://github.com/Jaime107)


## LICENSE

This project is licensed under the GNU General Public License - [LICENSE](LICENSE) 