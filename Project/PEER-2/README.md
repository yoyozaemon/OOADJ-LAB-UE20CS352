# Secure-file-sharing-springMVC

Secure File Sharing P2P application. Developed using SpringMVC framework, built using Maven.
  
  The project is an end to end secure file sharing system which mimics the P2P architecture. Files are shared via a room which is created by the client. The invite link of the sharing platform which in this case is a room is created for the peers who want to access and download files. The link has to be submitted by each peer to join the network to send or receive the files. The files being sent are encrypted with AES (Advanced Encryption Standard) encryption algorithm. On the sender side the file is encrypted using the secret key before sending the file.
      
  The encrypted files are decrypted on the receiving end using the secret key available in the room to validate the file. After the decryption the file is downloaded on the receiving end. In order to account for the file not being corrupted, the concept of checksum is used to verify the integrity of the file. The checksum algorithm used here is SHA-256. The encrypted file here is being sent to the peers in the room using different sockets in the local system presently. All the files being sent/transmitted in the room are stored in the mongodb database for future reference of the ongoing session. Each user is assigned a database to keep track of his files used in the session.
  
### Class Diagram
![image](https://user-images.githubusercontent.com/51696356/174445259-a6a40d22-550d-4ef5-bf93-00b223462aa8.png)

### Design Principles and Design Patterns Applied:
Design principles: The following SOLID principles are followed.

S - *Single Responsibility Principle (SRP)* --
All files in the model have only one logical responsibility. Eg: Classes like sendFile and receiveFile only take the responsibility of sending and receiving files respectively. Hence encrypting and decrypting is delegated to another class called Crypto. 

O - *Open-Closed Principle (OCP)* --
Class peer inherits the properties of client class by extending its properties.
Class CustomMultipartFile implements MultipartFile with additional functionalities.

L - *The Liskov Substitution Principle (LSP)* --
A client object can be replaced with a peer object without any flaws.

I - *Interface Segregation Principle (ISP)* --
There are no interfaces or classes with functionality which overburden them or ones which are not used by the client.

D - *Dependency Inversion Principle (DIP)* --
There is no high level class that directly depends on classes at lower levels.


### Design Patterns:

#### Singleton - Classes:
   SendFile 
   ReceiveFile
   
#### Factory - Classes:
   UserFactory that creates: 
   Peer 
   Client


### Requirements and installation
  Java - JRE
  MongoDB for database
  
### Commands to run:
By navigating to the filesharingsystems folder,

  `java filesharingsystemApplication.java`
  
*Change the application.properties file by providing with mongoDB connection variables.*
  
*The server port needs to be changed and run again to start a new process, thereby allowing another client to join the room.*
  



> OOAD Project 2022
