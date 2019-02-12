# Stack 

+ JBoss Wildfly 
    + Start JBoss Wildfly : `cd /Users/tw/srv/wildfly-8.2.1.Final/bin ; ./standalone.sh`

+ Glassfish 4 
    + Start on Mac `cd /Applications/NetBeans/glassfish-4.1/bin/` `sudo ./asadmin start-database` `sudo ./asadmin start-database` `sudo ./asadmin start-domain`
    + Start Glassfish with java db - running with JDK 

    + Start Glassfish - Java DB - running with JDK 



+ Test : Selenium2 webdriver, Arquillian drone, Graphana 



# Run test 

+ Application server : Wildfly and Glassfish - using Arquillian ecosystem

+ Only one profile can be active at a given time otherwise there will be dependency conflicts.

* ``mvn clean install -Pwildfly-managed``
    This profile  will install a Wildfly server and start up the server.
    Useful for CI servers.

    Profile : Install Wildfly server - Start the server 
    Used for CI servers 


* ``mvn clean install -Pwildfly-remote``
    This profile requires you to start up a Wildfly server outside of the build.
    Useful for development to avoid the server start up cost per sample.
    


* ``mvn clean install -Pglassfish-remote``
    This profile requires you to start up a GlassFish 4 server outside of the build. Each sample will then
    reuse this instance to run the tests.
    Useful for development to avoid the server start up cost per test.

    Server : Glassfish 4 - start instance server 


* ``mvn clean install -Pglassfish-managed``
    This profile  will install a Glassfish 4 server and start up the server.
    Useful for development, but has the downside of server startup per Test.
    You have to start a JavaDB (Derby) Server outside of the build before running the Test.


    Install Glassfish 4 server - start the server 

