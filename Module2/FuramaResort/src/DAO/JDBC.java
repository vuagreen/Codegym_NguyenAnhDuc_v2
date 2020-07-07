package DAO;

import Models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
    String villaArray = "";
    String houseArray = "";
    String roomArrayy = "";
    Connection connection = JDBCConnection.getJDBCConnection();
    PreparedStatement pstm;

    public void disConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeId(int id,String columd) {

        String sql;
        sql = "DELETE FROM furama."+columd+" WHERE id_booking = ? ;";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean checkID2(String sqlQuery, String columdname, int id) {
        String sqlSelectAll;
        sqlSelectAll = sqlQuery;
        try {
            pstm = connection.prepareStatement(sqlSelectAll);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                if (rs.getInt(columdname) == id) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void insertVilla(Villa villa) {
        try {
            String sqlInsert = "INSERT INTO villa(ten_dich_vu,dien_tich_su_dung,chi_phi_thue,so_nguoi_toi_da," +
                    "kieu_thue,tieu_chuan_phong,tien_nghi_khac,dien_tich_ho_boi,so_tang) VALUES(?,?,?,?,?,?,?,?,?) ";
            services(sqlInsert, villa.getTenDichVu(), villa.getDienTichSuDung(), villa.getChiPhiThue(), villa.getSoNguoiToiDa(), villa.getKieuThue(), villa);
            pstm.setString(6, villa.getTieuChuanPhong());
            pstm.setString(7, villa.getTienNghiKhac());
            pstm.setDouble(8, villa.getDienTichHoBoi());
            pstm.setInt(9, villa.getSoTang());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertHouse(House house) {
        try {
            String sqlInsert = "INSERT INTO house(ten_dich_vu,dien_tich_su_dung,chi_phi_thue,so_nguoi_toi_da," +
                    "kieu_thue,tieu_chuan_phong,tien_nghi_khac,so_tang) VALUES(?,?,?,?,?,?,?,?) ";
            services(sqlInsert, house.getTenDichVu(), house.getDienTichSuDung(), house.getChiPhiThue(), house.getSoNguoiToiDa(), house.getKieuThue(), house);
            pstm.setString(6, house.getTieuChuanPhong());
            pstm.setString(7, house.getTienNghiKhac());
            pstm.setInt(8, house.getSoTang());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertRoom(Room room) {
        try {
            String sqlInsert = "INSERT INTO room(ten_dich_vu,dien_tich_su_dung,chi_phi_thue,so_nguoi_toi_da," +
                    "kieu_thue,dich_vu_mien_phi_di_kem) VALUES(?,?,?,?,?,?)";
            services(sqlInsert, room.getTenDichVu(), room.getDienTichSuDung(), room.getChiPhiThue(), room.getSoNguoiToiDa(), room.getKieuThue(), room);
            pstm.setString(6, room.getDichVuMienPhiDiKem());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void services(String sqlInsert, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soNguoiToiDa, String kieuThue, Services services) throws SQLException {
        pstm = connection.prepareStatement(sqlInsert);
        pstm.setString(1, tenDichVu);
        pstm.setDouble(2, dienTichSuDung);
        pstm.setDouble(3, chiPhiThue);
        pstm.setInt(4, soNguoiToiDa);
        pstm.setString(5, kieuThue);
    }

    public void insertCustomer(Customer customer) {
        try {
            String sqlInsert = "INSERT INTO customer(ten_customer,ngay_sinh,gioi_tinh,cmnd,so_dien_thoai,email,loai_khach,dia_chi) VALUES(?,?,?,?,?,?,?,?) ";
            pstm = connection.prepareStatement(sqlInsert);
            pstm.setString(1, customer.getTenCustomer());
            pstm.setString(2, customer.getNgaySinh());
            pstm.setString(3, customer.getGioiTinh());
            pstm.setInt(4, customer.getCmnd());
            pstm.setInt(5, customer.getSoDienTHoai());
            pstm.setString(6, customer.getEmail());
            pstm.setString(7, customer.getLoaiKhach());
            pstm.setString(8, customer.getDiaChi());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertBooking(Booking booking) {
        try {
            String sqlInsert = "INSERT INTO booking(id_customer,id_detail,id_services,id_villa,id_house,id_room,day,rentday) VALUES(?,?,?,?,?,?,?,?) ";
            pstm = connection.prepareStatement(sqlInsert);
            pstm.setInt(1, booking.getId_customer());
            pstm.setInt(2, booking.getId_detail());
            pstm.setInt(3, booking.getId_services());
            pstm.setInt(4, booking.getId_villa());
            pstm.setInt(5, booking.getId_house());
            pstm.setInt(6, booking.getId_room());
            pstm.setDate(7, booking.getDay());
            pstm.setInt(8, booking.getRentday());
            pstm.execute();
            System.out.println("ADD BOOKING SUCCESS !!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public void selectIdBooking() {
        Long day;
        java.util.Date dateNow = new java.util.Date();
        java.sql.Date dateNows = convertUtilToSql(dateNow);
        String sqlSelect = "";
        sqlSelect = "SELECT * FROM (booking " +
                "inner join customer  on booking.id_customer=customer.id_customer " +
                "inner join villa  on booking.id_villa=villa.id_villa " +
                "inner join house  on booking.id_house=house.id_house " +
                "inner join room  on booking.id_room=room.id_room " +
                "inner join services  on booking.id_services=services.id_services); ";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                day = dateNows.getTime() - rs.getDate("day").getTime();
                day = day / (24 * 3600 * 1000);
                if (day > rs.getInt("rentday")) {
                    System.out.println(rs.getInt("id_booking"));
                    removeId(rs.getInt("id_booking"), "booking");
                    System.out.println("Villa hết hạn thuê :"+rs.getString("villa.ten_dich_vu") +" - Ngày Thuê : "+rs.getDate("day")+" - Thời Gian Thuê :" +rs.getInt("rentday") +" day");
                } else {
                    if (rs.getInt("villa.id_villa") > 0) {
                        villaArray += String.valueOf(rs.getInt("villa.id_villa")) + ",";
                    } else if (rs.getInt("house.id_house") > 0) {
                        houseArray += String.valueOf(rs.getInt("house.id_house")) + ",";
                    } else {
                        roomArrayy += String.valueOf(rs.getInt("room.id_room")) + ",";
                    }
                }




            }
            System.out.println("ID Villa Đang Được Sử Dụng : " + subString(villaArray));
            System.out.println("ID House Đang Được Sử Dụng : " + subString(houseArray));
            System.out.println("ID Room Đang Được Sử Dụng : " + subString(roomArrayy));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String subString(String s) {
        if (s.length() > 2) {
            s = s.substring(0, s.length() - 1);
        } else {
            s = "Chưa Được book";
        }

        return s;
    }

    public void reset() {
        villaArray = "";
        houseArray = "";
        roomArrayy = "";

    }

    public Boolean checkIdVilla(int x) {
        return villaArray.contains(String.valueOf(x));
    }

    public Boolean checkIdHouse(int x) {
        return houseArray.contains(String.valueOf(x));

    }

    public Boolean checkIdRoom(int x) {
        return roomArrayy.contains(String.valueOf(x));

    }

    public void selectAllBooking() {
        String sqlSelect = "";
        sqlSelect = "SELECT * FROM (booking " +
                "inner join customer  on booking.id_customer=customer.id_customer " +
                "inner join villa  on booking.id_villa=villa.id_villa " +
                "inner join house  on booking.id_house=house.id_house " +
                "inner join room  on booking.id_room=room.id_room " +
                "inner join services  on booking.id_services=services.id_services); ";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            ResultSet rs = pstm.executeQuery();
            System.out.println("\n");
            System.out.printf("%37s", "LIST BOOKING \n");
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-9s%-20s%-20s%-20s\n", "ID", "Tên Customer", "Dịch Vụ Cho Thuê", "Dịch vụ Đi Kèm");

            while (rs.next()) {
                String select;
                if (rs.getInt("villa.id_villa") > 0) {
                    select = "villa";
                } else if (rs.getInt("house.id_house") > 0) {
                    select = "house";
                } else {
                    select = "room";
                }
                System.out.printf("%-10d%-23s%-19s%-19s\n", rs.getInt("booking.id_booking"), rs.getString("customer.ten_customer"), rs.getString(select + ".ten_dich_vu"),
                        rs.getString("services.ten_dich_vu_di_kem"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAllVilla(String sqlQuery) {
        String sqlSelect = "";
        sqlSelect = sqlQuery;
        try {
            pstm = connection.prepareStatement(sqlSelect);
            ResultSet rs = pstm.executeQuery();
            System.out.printf("%-9s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s\n", "ID", "Tên Dịch Vụ", "Diện Tích Sử Dụng", "Chi Phí Thuê", "Số Người Tối Đa", "Kiểu Thuê", "Tiêu Chuẩn Phòng", "Tiện Nghi Khác", "Dien Tích Hồ Bơi", "Số Tầng");

            while (rs.next()) {
                System.out.printf("%-10d%-22s%-20.3f%-25.3f%-15d%-25s%-20s%-18s%-18.3f%-12d\n", rs.getInt("id_villa"), rs.getString("ten_dich_vu"), rs.getDouble("dien_tich_su_dung"),
                        rs.getDouble("chi_phi_thue"), rs.getInt("so_nguoi_toi_da"), rs.getString("kieu_thue"),
                        rs.getString("tieu_chuan_phong"), rs.getString("tien_nghi_khac"), rs.getDouble("dien_tich_ho_boi"), rs.getInt("so_tang"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAllHouse(String sqlQuery) {
        String sqlSelect = "";
        sqlSelect = sqlQuery;
        try {
            pstm = connection.prepareStatement(sqlSelect);
            ResultSet rs = pstm.executeQuery();
            System.out.printf("%-9s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s\n", "ID", "Tên Dịch Vụ", "Diện Tích Sử Dụng", "Chi Phí Thuê", "Số Người Tối Đa", "Kiểu Thuê", "Tiêu Chuẩn Phòng", "Tiện Nghi Khác", "Số Tầng");

            while (rs.next()) {
                System.out.printf("%-10d%-23s%-17f%-25f%-15d%-25s%-20s%-18s%-12d\n", rs.getInt("id_house"), rs.getString("ten_dich_vu"), rs.getDouble("dien_tich_su_dung"),
                        rs.getDouble("chi_phi_thue"), rs.getInt("so_nguoi_toi_da"), rs.getString("kieu_thue"),
                        rs.getString("tieu_chuan_phong"), rs.getString("tien_nghi_khac"), rs.getInt("so_tang"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void selectAllRoom(String sqlQuery) {
        String sqlSelect = "";
        sqlSelect = sqlQuery;
        try {
            pstm = connection.prepareStatement(sqlSelect);
            ResultSet rs = pstm.executeQuery();
            System.out.printf("%-9s%-20s%-20s%-20s%-20s%-20s%s\n", "ID", "Tên Dịch Vụ", "Diện Tích Sử Dụng", "Chi Phí Thuê", "Số Người Tối Đa", "Kiểu Thuê", "Dịch Vụ Đi Kèm");

            while (rs.next()) {
                System.out.printf("%-10d%-23s%-17f%-25f%-15d%-25s%-20s\n", rs.getInt("id_room"), rs.getString("ten_dich_vu"), rs.getDouble("dien_tich_su_dung"),
                        rs.getDouble("chi_phi_thue"), rs.getInt("so_nguoi_toi_da"), rs.getString("kieu_thue"),
                        rs.getString("dich_vu_mien_phi_di_kem"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void selectAllEmployee(String sqlQuery) {
        String sqlSelect = "";
        sqlSelect = sqlQuery;
        try {
            pstm = connection.prepareStatement(sqlSelect);
            ResultSet rs = pstm.executeQuery();
            System.out.printf("%45s", "EMPLOYEE LIST  \n");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.printf("%-9s%-23s%-17s%-20s%s\n", "ID", "Tên Employee", "Tuổi", "Giới Tính", "Địa Chỉ");

            while (rs.next()) {
                System.out.printf("%-10d%-23s%-17d%-19s%s\n", rs.getInt("id_employee"), rs.getString("ten_employee"), rs.getInt("tuoi"),
                        rs.getString("gioi_tinh"), rs.getString("dia_chi"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAllCustomer(String sqlQuery) {
        String sqlSelect = "";
        sqlSelect = sqlQuery;
        try {
            pstm = connection.prepareStatement(sqlSelect);
            ResultSet rs = pstm.executeQuery();
            System.out.printf("%-9s%-20s%-20s%-20s%-20s%-30s%-25s%-20s%s\n", "ID", "Tên Customer", "Ngày Sinh", "Giới Tính", "Số CMND", "Số Điện Thoại", "Email", "Loại Khách", "Địa Chỉ");

            while (rs.next()) {
                System.out.printf("%-10d%-19s%-22s%-19s%-21d%-22d%-33s%-18s%-12s\n", rs.getInt("id_customer"), rs.getString("ten_customer"), rs.getString("ngay_sinh"),
                        rs.getString("gioi_tinh"), rs.getInt("cmnd"), rs.getInt("so_dien_thoai"),
                        rs.getString("email"), rs.getString("loai_khach"), rs.getString("dia_chi"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void selectAllServices(String sqlQuery) {
        String sqlSelect = "";
        sqlSelect = sqlQuery;
        try {
            pstm = connection.prepareStatement(sqlSelect);
            ResultSet rs = pstm.executeQuery();
            System.out.printf("%-9s%-20s%-20s%-20s\n", "ID", "Tên Dịch Vụ ", "Đơn Vị", "Giá Tiền");
            while (rs.next()) {
                System.out.printf("%-10d%-21s%-18s%-19.0f\n", rs.getInt("id_services"), rs.getString("ten_dich_vu_di_kem"), rs.getString("don_vi"),
                        rs.getDouble("gia_tien"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
;