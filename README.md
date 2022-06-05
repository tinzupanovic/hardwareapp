# Application made with Spring Boot and Angular

Only uploaded src folder from Angular due to its size.

Application that uses Spring Boot following MVC REST design for backend and Angular for frontend.
Main objects in the application are hardware and review which we can create, read, update and delete.
Backend is separated into controllers, services and repositories.
For repository I use in memory H2 database.
Jdbc, hibernate and Spring data JPA are used to communicate with the database.
Using JWT token as a form of authentication and autorization.
jUnit tests are used to check for any mistakes.
To check how many hardwares are available I used Quartz scheduler to log them every 10 second.
