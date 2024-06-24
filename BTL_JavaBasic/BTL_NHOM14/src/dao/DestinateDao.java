package dao;

import connectdb.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Destinate;

// Lớp DAO: Tương tác trực tiếp với database
public class DestinateDao {
    
    // Hàm lấy ra tất cả doanh nghiệp
    public  List<Destinate> getAllDestinate(){
        List<Destinate> Destinate = new ArrayList<>();
        String sql = "SELECT * FROM tbl_destinate";
        try {
            // Gọi đối tượng Connection
            Connection connection = JDBCUtil.getConnection();
            
            // PreparedStatement tương tác với SQL có tham số
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Lưu trữ kết quả truy vấn
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Destinate destinate = new Destinate();
                destinate.setId(rs.getInt("id"));
                destinate.setCode(rs.getString("code"));
                destinate.setName(rs.getString("name"));
                destinate.setDescription(rs.getString("description"));
                destinate.setTimeStay(rs.getString("timeStay"));
                destinate.setSleepPlace(rs.getString("sleepPlace"));
                destinate.setAddress(rs.getString("address"));
                
                Destinate.add(destinate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Destinate;
    }
    
    // Hàm lấy ra thuộc tính của địa điểm qua id
    public Destinate getDestinateById(int DestinateId){
        
        String sql = "SELECT * FROM tbl_destinate WHERE tbl_destinate.id = ?";
        Destinate Destinate = null;
        try{
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, DestinateId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Destinate = new Destinate();
                Destinate.setId(rs.getInt("id"));
                Destinate.setCode(rs.getString("code"));
                Destinate.setName(rs.getString("name"));
                Destinate.setDescription(rs.getString("description"));
                Destinate.setTimeStay(rs.getString("timeStay"));
                Destinate.setSleepPlace(rs.getString("sleepPlace"));
                Destinate.setAddress(rs.getString("address"));
            }
            
            rs.close();
            preparedStatement.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Destinate;
    }
    
    // Hàm thêm đối tượng
    public void addDestinate(Destinate Destinate){
        String sql = "INSERT INTO tbl_destinate (code, name, description, timeStay, sleepPlace, address) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Destinate.getCode());
            preparedStatement.setString(2, Destinate.getName());
            preparedStatement.setString(3, Destinate.getDescription());
            preparedStatement.setString(4, Destinate.getTimeStay());
            preparedStatement.setString(5, Destinate.getSleepPlace());
            preparedStatement.setString(6, Destinate.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Hàm sửa đối tượng
    public void updateDestinate(Destinate Destinate, int id) {
        String sql = "UPDATE tbl_destinate SET code = ?, name = ?, description = ?, timeStay = ?, sleepPlace = ?, address = ? WHERE id = ?";
        
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, Destinate.getCode());
            preparedStatement.setString(2, Destinate.getName());
            preparedStatement.setString(3, Destinate.getDescription());
            preparedStatement.setString(4, Destinate.getTimeStay());
            preparedStatement.setString(5, Destinate.getSleepPlace());
            preparedStatement.setString(6, Destinate.getAddress());
            preparedStatement.setInt(7, id);

            System.out.println("Executing SQL query: " + preparedStatement.toString());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Destinate updated successfully.");
            } else {
                System.out.println("No changes detected. Destinate not updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    // Hàm xóa đối tượng qua id
    public void deleteDestinateById(int DestinateId) {
        String sql = "DELETE FROM tbl_destinate WHERE id = ?";
        
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, DestinateId);

            int deletedRows = preparedStatement.executeUpdate();
            System.out.println(deletedRows);
            
            if(deletedRows > 0){
                System.out.println("Destinate deleted!");
            }else{
                System.out.println("Destinate delete failed! No matching Destinate with ID: " + DestinateId);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Hàm lấy ra id khi tham số là các thuộc tính của đối tượng Destinate
    public int getIdByDestinate(String code, 
                              String name, 
                              String description, 
                              String timeStay,
                              String sleepPlace, 
                              String address){
        int DestinateId = -1;
        String sql = "SELECT tbl_destinate.id FROM tbl_destinate WHERE tbl_destinate.code = ? AND tbl_destinate.name = ? AND tbl_destinate.description = ? AND tbl_destinate.timeStay = ? AND tbl_destinate.sleepPlace = ? AND tbl_destinate.address = ?";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql); 
             
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, timeStay);
            preparedStatement.setString(5, sleepPlace);
            preparedStatement.setString(6, address);
            
            // Lưu trữ kết quả truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DestinateId = resultSet.getInt("id");
            }
            return DestinateId;
           
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int getIdByDestinateName(String name){
        int DestinateId = -1;
        String sql = "SELECT tbl_destinate.id FROM tbl_destinate WHERE tbl_destinate.name = ?";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql); 
             
            preparedStatement.setString(1, name);
            // Lưu trữ kết quả truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DestinateId = resultSet.getInt("id");
            }
            return DestinateId;
           
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}


