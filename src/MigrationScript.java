package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MigrationScript {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/your-database";
        String username = "your-username";
        String password = "your-password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            // Rename STUDENTS.ST_ID to STUDENTS.STUDENT_ID
            statement.execute("ALTER TABLE students RENAME COLUMN st_id TO student_id");

            // Change the length of STUDENTS.ST_NAME and STUDENTS.ST_LAST from 20 to 30
            statement.execute("ALTER TABLE students ALTER COLUMN st_name TYPE VARCHAR(30)");
            statement.execute("ALTER TABLE students ALTER COLUMN st_last TYPE VARCHAR(30)");

            System.out.println("Migration successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
