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

            // Backup the original interests table
            statement.execute("CREATE TABLE BackupInterests AS SELECT * FROM interests");

            // Create a new table to store aggregated interests
            statement.execute("CREATE TABLE AggregatedInterests AS " +
                    "SELECT student_id, ARRAY_AGG(interest ORDER BY interest) AS interests " +
                    "FROM interests " +
                    "GROUP BY student_id");

            statement.execute("DROP TABLE interests");

            statement.execute("ALTER TABLE AggregatedInterests RENAME TO interests");

            System.out.println("Migration successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
