package Commons;

import Models.Services;
import Models.Villa;
import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.*;

public class InsertSatemment {
    public static void checkID(String sqlQuery,String id) {
        String sqlSelectAll;
        sqlSelectAll = sqlQuery;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(sqlSelectAll);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("\n ID :"+rs.getInt(id) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertRecords(Services services) {
        Connection connection = JDBCConnection.getJDBCConnection();
      try {
          String sqlInsert ="INSERT INTO customer(name) values(?)";
          String selectAll = "SELECT * from customer";
          PreparedStatement pstm = connection.prepareStatement(sqlInsert);
//          pstm.setInt(1,Integer.parseInt(services.getId()));
          pstm.setString(1,services.getTenDichVu());
          pstm.execute();
          pstm = connection.prepareStatement(selectAll);
          ResultSet rs = pstm.executeQuery();
          while (rs.next()) {
              System.out.println("-----------");
              System.out.println("ID :" + rs.getInt("id") + "   Name :" + rs.getString("name"));
              services.setId(String.valueOf(rs.getInt("id")));
          }
          System.out.println(services.getId());


      } catch (SQLException e) {
          e.printStackTrace();
      }
    }

    public static void main(String[] args) {
        Services services = new Villa();
        services.setId("10");
        services.setTenDichVu("villa 2");
        insertRecords(services);
    }
}
