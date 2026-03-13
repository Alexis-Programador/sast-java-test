import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SqlInjectionExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        try {

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "1234"
            );

            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM users WHERE username = '" + username + "'";

            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                System.out.println("User found: " + rs.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}