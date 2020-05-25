package Commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:mysql://localhost:3306/furama";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connection connection = getJDBCConnection();
        if (connection != null) {
            System.out.println("thanhcong");

        } else {
            System.out.println("erro");
        }
    }
}
