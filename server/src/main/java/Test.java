import java.sql.*;

public class Test {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/pos";
    static final String USER = "admin";
    static final String PASS = "admin";
    static final String QUERY = "SELECT * FROM pricing";

    public static void main(String[] args) {
        doSomething();
    }
    public static void doSomething() {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getString("payment_method"));
                System.out.print(", Age: " + rs.getInt("price_modifier_min"));
                System.out.print(", First: " + rs.getInt("price_modifier_max"));
                System.out.println(", Last: " + rs.getInt("point_multiplier"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}