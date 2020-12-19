# Spring Boot 

## Prerequisites
- One of the Java versions
    - <a href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">Java SE 8 </a>
    - <a href ="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html">Java SE 11 </a>
- <a href = "https://www.jetbrains.com/idea/download/">IntelliJ</a>
- <a href = "https://www.postman.com/downloads/">Postman</a>
- Depending on your database, use one of the following
    - MySQL: https://www.apachefriends.org/download.html
    - MongoDB: https://www.mongodb.com/try/download/enterprise
- NOTE: This repository is for SQL-based projects. For MongoDB related projects, go to
  https://github.com/alanngo/SpringBoot-Mongo
  
## Getting Started
<img src="springinit.PNG">

1. Go to https://start.spring.io/
    - Apply the following settings
        - <b>Project</b>: Maven
        - <b>Language</b>: Java
        - <b>Group</b>: com.{project name}
        - <b>Artifact</b>: {NAME}
        - <b>Name</b>: {NAME}
        - <b>Description</b>: Spring Project (Doesn't matter)
        - <b>Package name</b>: com.{project name}
        - <b>Packaging</b>: Jar
        - <b>Java</b>: {Your version of Java installed}
    - Add the following Dependencies:
        - Lombok
        - Spring Web
        - Spring Data JPA

2. Click "Generate"
3. Unzip the download to your working directory
4. Manually add the following dependencies in pom.xml
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
    <version>2.3.3.RELEASE</version>
</dependency>

```
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

## File Structure

```bash
com/example/api
com/example/dto
com/example/entity
com/example/repository
com/example/service
com/example/utility
```
## Integrating Lombok
##### IntelliJ:
https://www.youtube.com/watch?v=RwX1x7_k1b0
1. Depending on your OS
   - Windows/ Linux: File -> Settings -> Plugins (Ctrl + Alt + S)
   - Mac: IntelliJ Idea -> Preferences -> Plugins
2. Click on 'Marketplace tab' and search 'lombok'
3. Click Install
4. Click Apply and restart IntelliJ

######  Errors and Solutions :
If you are getting
``You aren't using a compiler supported by lombok, so lombok will not work and has been disabled``
error, follow the steps below.

1. Open Settings/Preferences -> Compiler
2. Add ``-Djps.track.ap.dependencies=false`` to 'Shared build process VM options'
3. Apply and OK
4. Rerun your program

https://i.stack.imgur.com/jwTAw.png
    

## Important Annotations

###### API
```java
// Class Based
@RestController // allows the class to have API routes
@CrossOrigin // allows other programs to consume SpringBoot app
@RequestMapping // root url mapping

// Field Based
@Autowired // dependency injection

// Method Based
@GetMapping("/URL") // allows a method to be called when GET request is made w/ '/URL'
@PostMapping("/URL") // allows a method to be called when POST request is made w/ '/URL'
@PutMapping("/URL") // allows a method to be called when PUT request is made w/ '/URL'
@DeleteMapping("/URL") // allows a method to be called when DELETE request is made w/ '/URL'

// Method Parameter Based
@RequestBody // allows POJO to be parsed as JSON request body
@PathVariable // used for url patterns of *./{pathVar}, method arg name must also be the same
@QueryParam // used for url patterns of ?key=value
```

###### DTO
```java
// Class Based
@Data // constructor, getters, setters, equals, hashCode, toString 
```

###### Entity
```java
// Class Based
@Data // constructor, getters, setters, equals, hashCode, toString 
@Table("TABLE_NAME") // binds class to SQL table if class/table name is different
@Entity // represents class as SQL table

// Field Based
@Id // primary key
@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment PK
@Column("COL_NAME") // binds field to DB column if field/column name is different
```

    
###### Repository
   - none
    
###### Service
```java
// Class Based
@Service // denotes service layer
@Transactional // allows the class to update DB fields

// Field Based
@Autowired // dependency injection
```

    
###### Utility

ErrorInfo
```java
// Class Based
@Data // constructor, getters, setters, equals, hashCode, toString 
```

ExceptionControllerAdvice

```java
// Class Based
@RestControllerAdvice // allows the app to output errors to user in a useful manner
@Slf4j // creates a logger variable automatically

// Field Based
@Autowired // dependency injection

// Method Based
@ExceptionHandler(value = Exception.class) // allows method to be called when exception is raised
```

LoggingAspect
```java
// Class Based
@Component // denotes spring bean
@Aspect // used for crosscutting concern
@Slf4j // creates a logger variable automatically

// Method Based
@AfterThrowing(pointcut = "execution(CLASS_NAME)") // will execute after throwing exception
```

## Repository Layer
```java
public interface ExampleRepository extends CrudRepository<ENTITY, ID> 
{
    // SQL based programs use CrudRepository
}
```







