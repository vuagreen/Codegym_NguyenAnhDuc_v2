package DAO.data;

import DAO.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatement {
    public static void main(String[] args) {
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM customer";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
