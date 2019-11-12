# Project Java : JEE

Design and build of an Employees Management Application.



### The structure of the project
The project consists of 2 Versions of the same website : each uses a different set of technologies.

The website contains these pages :
* Login - Connect to website (creates a session)
* Logout - Delete the Session
* Employees - The main page ; It displays all the employees.
* Employee - The detail page ; All the data concerning a given Employee are displayed.

Note that you can connect to the website whether as an ADMIN or an EMPLOYEE, the Admin having dedicated rights. Most notably, you can ADD, DELETE and MODIFY employees.



## Getting Started
The programmation is fully completed, but we have a small requirement : creating the database.
Don't worry ! We got you covered.

For the V1 :
```
You'll need to create a JavaDB database.
Here are the file to help you create & fill the database.
Creating the Database : projetJEE\V1\JEE_PROJECT_V1\web\WEB-INF\SQL\codedb.sql
Filling the Database : projetJEE\V1\JEE_PROJECT_V1\web\WEB-INF\SQL\remplissage.sql

You'll need to create the database within the project, thanks to the service/database window.
```


For the V2 :
```
You'll need to create an SQL database.
Here are the file to help you create & fill the database.
Creating the Database : projetJEE\V2\JEE_PROJECT_V2\web\WEB-INF\SQL\codedb.sql
Filling the Database : projetJEE\V2\JEE_PROJECT_V2\web\WEB-INF\SQL\remplissage.sql

You'll need to open phpMyAdmin (and, notably, also open Wamp / Wamp / whatever you use).
Create a new database, and giving any name you want.
Now, how to create the table with the sql code we provided you, then fill it.

Next, in the project, you'll just have to link the database to the project with :
services/Register my SQL server...
```



## Concerning the Servlets
We are aware that the subject specifically said "Unique Servlet".
Yet, we deployed many of them in each versions.

We felt that it was more convenient and more secure to have several files doing the job, instead of a big one doing all at once.
Hence, we have 5 servlets for our V1, and 3 for our V2 (we enhanced our handling of servlet, so we reduced their number).

For instance, we have a dedicated servlet doing the transition from the Login.jsp to the Employees.jsp page,
or a dedicated servlet doing the operations in the Logout.jsp page.


It felt more natural, despite of the directive.



## Built With

* [Netbeans 8.2](https://netbeans.org/downloads/8.2/) - The Java IDE we used
* [PhpMyAdmin 4.8.5](https://https://www.phpmyadmin.net) - The SQL database we used for the V2
  


## Authors

It was made by the following Efrei Paris students :
* **BEGEOT Hugues** - [his Git repository](https://github.com/opsilonn)
* **BONI François** - [his Git repository](https://github.com/scorpionsdu78)
* **DULCHE Eddy** - [his Git repository](https://github.com/DulcheE)

See also the list of [contributors](https://github.com/scorpionsdu78/projetJEE/contributors) who participated in this project.

Note : we are currently in our 4th year, in a Software Engineering cursus.



## Acknowledgments

* NetBeans isn't very compliant, at time --> choose a better IDE
* There are some features of JavaDB that made the project way harder than it should be, hence we prefered to use SQL database
