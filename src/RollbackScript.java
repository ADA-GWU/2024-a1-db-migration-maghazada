package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RollbackScript {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/your-database";
        String username = "your-username";
        String password = "your-password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            // Rollback changes for STUDENTS table
            statement.execute("ALTER TABLE students RENAME COLUMN student_id TO st_id");
            statement.execute("ALTER TABLE students ALTER COLUMN st_name TYPE  VARCHAR(20)");
            statement.execute("ALTER TABLE students ALTER COLUMN st_last TYPE  VARCHAR(20)");

            // Rollback changes for INTERESTS table
            statement.execute("DROP TABLE interests");
            statement.execute("ALTER TABLE BackupInterests RENAME TO interests");
            System.out.println("Rollback successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
