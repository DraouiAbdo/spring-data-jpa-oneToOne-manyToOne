# Establishing oneToOne and ManyToOne relationships between Entities using Spring Data

  Data Access in any application is a non functional requirement that is why we delegate this task to Spring Data to concentrate(us, developers)
on functional requirements of the app.(**Inversion Of Control design principle** ).

  Since we opted for an RDBMS for storing app data, **Spring Data JPA** framework is used. spring data JPA is a declarative framework which use **hibernate**
ORM  (hibernate is an impementation of **Java Persistance Api**) and hibernate itself translate to **JDBC** code.  It's the JDBC who interact directly with 
the RDBMS. (see figure below ). 
  
  Thanks to Spring Data JPA, we can switch smoothly from one RDBMS to the other. simpler method declaration is required to read/write to our db.

  In Order to show how to establish some relationships betweens entities of our project, a simple app for managing a hospital is developped. attributes of our class
and relationships are created from a given class diagram (see figure below).

  The app works smoothly and various RDBMS(H2, MySql) are tested.
