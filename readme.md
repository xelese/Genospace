This contains source code for a web take away assignment by given by Genospace on 9th January 2020 written by Ravi Voleti.

The main website for demonstration can be found here:

    http://genospace.us-east-1.elasticbeanstalk.com/

All the source code files for the backend can be found under:
      
    src/main/java/genospace

To run the application execute: 
        
    GenospaceWebApplication.java
        
All the front end code is under:

    src/main/webapp
        
You will see two files under here. index.html is the landing page and index.js is the javascript
file for executing the api keys.

This project has three API.

    /find                  Returns list of drugs followed by list of mechanisms.
    /find/drug/{id}        Returns the drug and all of its details.
    /find/mechanism/{id}   Returns all the drugs that have the given mechanism.

Connection details for the RDS database can be found here:
    
    HOST: genospace.cnwbfkqaiv0g.us-east-1.rds.amazonaws.com 
    USER: admin 
    PASSWORD: 12345678. 

Thank you for reading this :)