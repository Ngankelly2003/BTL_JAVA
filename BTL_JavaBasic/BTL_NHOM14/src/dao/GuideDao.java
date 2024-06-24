package dao;

import java.sql.Connection;
import connectdb.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class GuideDao {
    
    public List<Guide> getAllGuides(){
        List<Guide> Guides = new ArrayList<>();
        String sql = "SELECT tbl_guide.id, tbl_guide.code, tbl_guide.firstName,"
                + " tbl_guide.lastName, tbl_guide.address, tbl_guide.phoneNumber,"
                + " tbl_guide.email, tbl_guide.birthDate, \n" +
                      "COUNT(tbl_tour.id) AS tourCount FROM tbl_guide "
                + "LEFT JOIN tbl_tour ON tbl_guide.id = tbl_tour.guideId\n" +
                        "GROUP BY tbl_guide.id";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Guide Guide = new Guide();
                Guide.setId(rs.getInt("id"));
                Guide.setCode(rs.getString("code"));                
                Guide.setFirstName(rs.getString("firstName"));
                Guide.setLastName(rs.getString("lastName"));
                Guide.setAddress(rs.getString("address"));
                Guide.setPhoneNumber(rs.getString("phoneNumber"));
                Guide.setEmail(rs.getString("email"));
                Guide.setBirthDate(rs.getString("birthDate"));
                int tourCount = rs.getInt("tourCount");
                
                // Create a new list of tours
                List<Tour> tours = new ArrayList<>();
                for (int i = 0; i < tourCount; i++) {
                    Tour tour = new Tour();
                    tours.add(tour);
                }
                Guide.setTours(tours);
                
                Guides.add(Guide);
            }
            
        } catch (SQLException e) {
        }
        return Guides;
    }
    
    public void addGuide(Guide Guide){
        String sql = "INSERT INTO tbl_guide (id,code,firstName,lastName,birthDate,address,phoneNumber,imagePath,email,accountId) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, Guide.getId());
            preparedStatement.setString(2, Guide.getCode());
            preparedStatement.setString(3, Guide.getFirstName());
            preparedStatement.setString(4, Guide.getLastName());
            preparedStatement.setString(5, Guide.getBirthDate());
            preparedStatement.setString(6, Guide.getAddress());
            preparedStatement.setString(7, Guide.getPhoneNumber());
            preparedStatement.setString(8, Guide.getImagePath()); 
            preparedStatement.setString(9, Guide.getEmail());
            preparedStatement.setInt(10, Guide.getAccountId());
            
            int addRows = preparedStatement.executeUpdate();
            if (addRows > 0) {
                System.out.println("Add Guide successful!");
            } else {
                System.out.println("Add Guide failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   // Guide
    public int getIdByGuide(String GuideCode){
        String sql = "SELECT id from tbl_guide WHERE code = ?";
        int GuideId = -1;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, GuideCode);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                GuideId = rs.getInt("id");
            }
            
            return GuideId;
        } catch (Exception e) {
            return -1;
        }
    }
    
    public int getIdByGuideName(String name){
        int companyId = -1;
        String sql = "SELECT id \n" +
                    "FROM tbl_guide \n" +
                    "WHERE CONCAT(COALESCE(tbl_guide.lastName, ''), ' ', COALESCE(tbl_guide.firstName, '')) = ?";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql); 
             
            preparedStatement.setString(1, name);
            // Lưu trữ kết quả truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();
           
            while (resultSet.next()) {
                companyId = resultSet.getInt("id");
            }
            return companyId;
           
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public Guide getGuideById(int GuideId){
        String sql = "SELECT id,code,firstName,lastName,birthDate,address,phoneNumber,imagePath,email,accountId FROM tbl_guide WHERE id = ?";
        Guide Guide = new Guide();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, GuideId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Guide.setId(rs.getInt("id"));
                Guide.setCode(rs.getString("code"));
                Guide.setFirstName(rs.getString("firstName"));
                Guide.setLastName(rs.getString("lastName"));
                Guide.setBirthDate(rs.getString("birthDate"));
                Guide.setAddress(rs.getString("address"));
                Guide.setPhoneNumber(rs.getString("phoneNumber"));
                Guide.setImagePath(rs.getString("imagePath"));
                Guide.setEmail(rs.getString("email"));
                Guide.setAccountId(rs.getInt("accountId"));
            }
            
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Guide;
    }
    
    public void updateGuide(Guide Guide , int GuideId){
        String sql = "UPDATE tbl_guide SET "
                + "code = ? , "
                + "firstName = ? , "
                + "lastName = ?, "
                + "birthDate = ? , "
                + "address = ? , "
                + "phoneNumber = ? , "
                + "imagePath = ? , "
                + "email = ? , "
                + "accountId = ? "
                + "WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, Guide.getCode());
            preparedStatement.setString(2, Guide.getFirstName());
            preparedStatement.setString(3, Guide.getLastName());
            preparedStatement.setString(4, Guide.getBirthDate());
            preparedStatement.setString(5, Guide.getAddress());
            preparedStatement.setString(6, Guide.getPhoneNumber());
            preparedStatement.setString(7, Guide.getImagePath());
            preparedStatement.setString(8, Guide.getEmail());
            preparedStatement.setInt(9, Guide.getAccountId());
            preparedStatement.setInt(10, GuideId);
            
            System.out.println("SQL: " + preparedStatement.toString());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Guide updated.");
            }else {
                System.out.println("No changes detected. Guide not updated.");
            }
        } catch (Exception e) {
        }
    }
    
    public void deleteGuideById(int GuideId){
        String sql = "DELETE FROM tbl_guide WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, GuideId);
            
            int rowDeleted = preparedStatement.executeUpdate();
            if(rowDeleted > 0){
                System.out.println("Guide deleted.");
            }else {
                System.out.println("No changes detected. Guide not deleted.");
            }
        } catch (Exception e) {
        }
    }
    
    public Guide getGuideByAccountId(int accountId){
        String sql = "SELECT * FROM tbl_guide WHERE accountId = ?";
        Guide Guide = new Guide();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Guide.setId(rs.getInt("id"));
                Guide.setCode(rs.getString("code"));
                Guide.setFirstName(rs.getString("firstName"));
                Guide.setLastName(rs.getString("lastName"));
                Guide.setBirthDate(rs.getString("birthDate"));
                Guide.setAddress(rs.getString("address"));
                Guide.setPhoneNumber(rs.getString("phoneNumber"));
                Guide.setImagePath(rs.getString("imagePath"));
                Guide.setEmail(rs.getString("email"));
                Guide.setAccountId(rs.getInt("accountId"));
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
        return Guide;
    }
}