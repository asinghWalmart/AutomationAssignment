#Project Title

This project was developed as a part of Technical Evaluation for Walmart.

##Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

##Prerequisites
The Following Softwares needs to be installed before running the tests 

```1) JDK ```

```2) Apache Maven  ```

**Installation** 

 How to Install JDK :- Download JDK Installer from the following link 
 
1) ```https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html```
2) You Should have admin right to run the exe file.
3) Install the 32 or 64 bit configuration for JDK. If the System is on 32 bit use 
```Windows x86```. For a 64 Bit computer use ```Windows x64```
4) Once the download for JDK exe file is completed, double click on the installer
and follow the instruction to complete the process. 
5) In Order to make sure that Java is installed , go to Command prompt and type 
```java -version```. The output should be displayed similar to the one  below. May not be exact and depends on the Version.
```
java version "1.8.0_144"
Java(TM) SE Runtime Environment (build 1.8.0_144-b01)
Java HotSpot(TM) 64-Bit Server VM (build 25.144-b01, mixed mode)
```
 **Update the Path Variable and SET a new JAVA_HOME Env Variable :-**
 1) Rightclick on my computer > Click on properties > Click on Advance System and Settings > Click on Environment Variable
 2) Under the System Variables , click on New and add variable name ```JAVA_HOME``` and variable value as ```Path/To/JDK Directory```
 3) Find an existing Variable ```Path```(do not create a new one, it should be existing) and update the ```Path``` variable to ```%JAVA_HOME%\bin;```
 4) In Order to make sure ```Path``` and ```JAVA_HOME``` is set correctly, open a new Command prompt(cmd.exe) and type ```javac```
 you should see:- 
        ```Usage: javac <options> <source files>
        where possible options include:```
  5) Alternatively you can also try to the following on the cmd
  ```echo %Path%``` and you should see ```jdk installation path\bin```
 
 **How to Install the Apache Maven :-**
 1) Download Apache Maven from the official site ```https://maven.apache.org/download.cgi```
 2) Click on ```Binary Zip archive link```. I have used ```apache-maven-3.6.1-bin.zip``` at the time of building this project
 3) Unzip it to a folder of your choice 
 4) Rightclick on my computer > Click on properties > Click on Advance System and Settings > Click on Environment Variable
 5) Under the System Variables , click on New and add variable name ```MAVEN_HOME``` and variable value as ```Path/To/Maven Directory```
 6) Find an existing Variable ```Path```(do not create a new one, it should be existing) and update the ```Path``` variable to ```%MAVEN_HOME%\bin;```
 
##Running the Test
1) Fork the repository ```https://github.com/asinghWalmart/AutomationAssignment```
2) Go to Command Prompt and navigate to the location where repo has been forked and navigate to ```AutomationAssignment ``` folder.
3) Run the Maven commands ```mvn compile``` to build the project 
4) Run ```mvn test``` to run the tests. It will automatically run the testcases.
 
##Built With
- Maven - Dependency Management


##Authors
- Amrit Singh 








 
 
 



