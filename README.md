# RESTProject
RESTProject is small REST API test framework.
# Download and Install
jdk https://download.oracle.com/java/18/latest/jdk-18_linux-x64_bin.rpm
maven https://maven.apache.org/download.cgi
intellij idea https://www.jetbrains.com/idea/download/#section=windows
# Used tools and frameworks
Rest-Assured
Maven repository
TestNG
# Main features
1. A test framework for api automation testing.
2. All classes and methods are implemented in Java with Maven repository and include all dependencies needed.
3. REST-Assured is used to offer a friendly DSL that describes a connection to an HTTP endpoint and expected results in a format.
4. All model classes are reduce the complexity and incresae the flexibility of code as we can use the same data anywhere we need in the project.
5. Also it make sure which type of response data has received for e.g. arrayList or Object.
# Run
Run the class called "TestGET.java"(RESTProject/RESTProject/src/test/java/) to get the output of task 4,5,7.b
It will Display the top10team of NHLseason 20202021.

To run it from command line 
run the command "mvn test -Dtest="TestGET"" from the commandline (prerequisites are jdk and maven)
