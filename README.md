[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/JwSLLxUh)
# Database Migration Script for PostgreSQL

This Java application performs database migration and rollback tasks for a PostgreSQL database. Below are the steps to successfully run the provided migration and rollback 
scripts.

## Prerequisites

Before running the application, ensure you have the JDBC driver for PostgreSQL downloaded. You can download the driver JAR file 
from [here](https://jdbc.postgresql.org/download/) with version 42.7.1.

## Adding JDBC Driver to External Libraries

After downloading the JDBC driver JAR file, you need to add it to the external libraries of your project in your preferred Integrated Development Environment (IDE). Follow
the steps below based on your IDE:

### IntelliJ IDEA

1. Open your project in IntelliJ IDEA.
2. Navigate to **File** > **Project Structure**.
3. In the Project Structure dialog, select **Libraries** on the left.
4. Click the **"+"** icon and choose **Java**.
5. Locate and select the downloaded JDBC driver JAR file.
6. Click **OK** to add the library.

### Eclipse

1. Open your project in Eclipse.
2. Right-click on your project in the **Project Explorer**.
3. Choose **Build Path** > **Configure Build Path**.
4. In the Libraries tab, click **Add External JARs**.
5. Select the downloaded JDBC driver JAR file.
6. Click **Apply and Close**.

### Other IDEs

For other IDEs, follow similar steps to add an external library or JAR file to your project.

Ensure the JDBC driver is added correctly to the project's classpath before running the migration and rollback scripts.


## Configuration

In both `MigrationScript.java` and `RollbackScript.java`, there are three lines in the main method that need to be modified to connect the application to your PostgreSQL 
database:

```java
String jdbcUrl = "jdbc:postgresql://localhost:5432/your-database";
String username = "your-username";
String password = "your-password";
```

* Update your-database with the name of the database where you created and added the students and interests tables.
* Replace your-username with the owner of the database (e.g., postgres).
* Change your-password to the password assigned to log in to pgAdmin or SQL shell.

## Compilation

Before running the scripts, you need to compile the Java source files. Open a terminal or command prompt and navigate to the directory containing the Java files:

```bash
    cd path/to/your/project
```

Compile MigrationScript.java:

```bash
    javac MigrationScript.java
```

Compile RollbackScript.java:

```bash
    javac RollbackScript.java
```

## Migration

To apply the changes described in the assignment instructions, run MigrationScript.java. This script will automatically migrate the changes to your database.

```bash
    java MigrationScript
```

## Rollback
If you need to undo the changes made by the migration, run RollbackScript.java. This script will automatically revert all changes made by MigrationScript.java.

```bash
    java RollbackScript
```

Note: Ensure you have backed up your data before running the rollback script, as it will revert the changes made by the migration.
