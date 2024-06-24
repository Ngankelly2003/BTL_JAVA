package dao;

import connectdb.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Tour;
public class TourDao {

    public List<Tour> getAllTours(){
        List<Tour> tours = new ArrayList<>();
        String sql = "SELECT tbl_tour.id, tbl_tour.code, tbl_tour.name, startDate, tbl_tour.description, availables, presentator, tbl_Destinate.id as DestinateId, tbl_Destinate.name, tbl_Guide.id as GuideId,CONCAT(COALESCE(tbl_Guide.lastName, ''), ' ', COALESCE(tbl_Guide.firstName, '')) AS fullName FROM tbl_tour\n" +
             "JOIN tbl_destinate ON tbl_destinate.id = tbl_tour.destinateId\n" +
             "LEFT JOIN tbl_guide ON tbl_guide.id = tbl_tour.guideId;";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Tour tour = new Tour();
                tour.setId(rs.getInt("id"));
                tour.setCode(rs.getString("code"));
                tour.setName(rs.getString("name"));
                tour.setStartDate(rs.getString("startDate"));
                tour.setDescription(rs.getString("description"));
                tour.setAvailables(rs.getInt("availables"));
                tour.setPresentator(rs.getString("presentator"));
                tour.setDestinateId(rs.getInt("DestinateId"));
                tour.setGuideId(rs.getInt("GuideId"));
                
                tours.add(tour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }
    
    public String getDestinateNameById(int DestinateId) {
        String DestinateName = null;
        try {
            String sql = "SELECT tbl_Destinate.name FROM tbl_Destinate WHERE tbl_Destinate.id = ?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, DestinateId);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                DestinateName = rs.getString("name");
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DestinateName;
    }
    
    public String getGuideNameById(int GuideId) {
        String GuideName = null;
        try {
            String sql = "SELECT CONCAT(COALESCE(tbl_Guide.lastName, ''), ' ', COALESCE(tbl_Guide.firstName, '')) AS fullName FROM tbl_Guide WHERE tbl_Guide.id = ?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, GuideId);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                GuideName = rs.getString("fullName");
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return GuideName;
    }
    
    public boolean getGuideIdByTour(int tourId) {
        String sql = "SELECT tbl_Guide.id FROM tbl_Guide JOIN tbl_tour ON tbl_Guide.id = tbl_tour.GuideId WHERE tbl_tour.id = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, tourId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSet.getInt("id");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void addTour(Tour tour){
        String sql = "INSERT INTO tbl_tour(code,name,description,startDate,DestinateId,GuideId,presentator,availables) VALUES(?,?,?,?,?,?,?,?)";
        List<Tour> tours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tour.getCode());
            preparedStatement.setString(2, tour.getName());
            preparedStatement.setString(3, tour.getDescription());
            preparedStatement.setString(4, tour.getStartDate());
            preparedStatement.setInt(5, tour.getDestinateId());
            preparedStatement.setInt(6, tour.getGuideId());
            preparedStatement.setString(7, tour.getPresentator());
            preparedStatement.setInt(8, tour.getAvailables());
            
            int addRows = preparedStatement.executeUpdate();
            if (addRows > 0) {
                System.out.println("Add Tour successful!");
            } else {
                System.out.println("Add Tour failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateTour(Tour tour, int tourId){
        String sql = "UPDATE tbl_tour SET code=?, name=?, description=?, startDate=?, DestinateId=?, GuideId=?, presentator=?, availables=? WHERE id=?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tour.getCode());
            preparedStatement.setString(2, tour.getName());
            preparedStatement.setString(3, tour.getDescription());
            preparedStatement.setString(4, tour.getStartDate());
            preparedStatement.setInt(5, tour.getDestinateId());
            preparedStatement.setInt(6, tour.getGuideId());
            preparedStatement.setString(7, tour.getPresentator());
            preparedStatement.setInt(8, tour.getAvailables());
            preparedStatement.setInt(9, tourId);
            
            System.out.println("SQL: " + preparedStatement.toString());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Tour updated.");
            }else {
                System.out.println("No changes detected. Tour not updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateGuideIdByTourId(int tourId) {
        String sql = "UPDATE tbl_tour SET GuideId = NULL WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);

            System.out.println("SQL: " + preparedStatement.toString());

            int rowUpdated = preparedStatement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Tour updated.");
            } else {
                System.out.println("No changes detected. Tour not updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTourById(int tourId){
        String sql = "DELETE FROM tbl_tour WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            int rowDeleted = preparedStatement.executeUpdate();
            if(rowDeleted > 0){
                System.out.println("Tour deleted.");
            }else {
                System.out.println("No changes detected. Tour not deleted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getIdByTourCode(String tourCode){
        String sql = "SELECT id FROM tbl_tour WHERE code = ?";
        int tourId = -1;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, tourCode);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                tourId = rs.getInt("id");
            }
            return tourId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public Tour getTourById(int tourId){
        String sql = "SELECT * FROM tbl_tour WHERE id = ?";
        Tour tour = new Tour();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                tour.setId(rs.getInt("id"));
                tour.setCode(rs.getString("code"));
                tour.setName(rs.getString("name"));
                tour.setDescription(rs.getString("description"));
                tour.setStartDate(rs.getString("startDate"));
                tour.setDestinateId(rs.getInt("DestinateId"));
                tour.setGuideId(rs.getInt("GuideId"));
                tour.setPresentator(rs.getString("presentator"));
                tour.setAvailables(rs.getInt("availables"));
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }
    
    public int getGuideIdByTourId(int tourId){
        int GuideId = -1;
        String sql = "SELECT GuideId from tbl_tour WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                GuideId = rs.getInt("GuideId");
            }
            return GuideId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public int getDestinateIdByTourId(int tourId){
        int DestinateId = -1;
        String sql = "SELECT tbl_tour.DestinateId from tbl_tour WHERE tbl_tour.id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DestinateId = rs.getInt("DestinateId");
            }
            return DestinateId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void addListTours(List<Tour> tourData) {
        String sql = "INSERT INTO tbl_tour(code,name,description,startDate,DestinateId,GuideId,presentator,availables) VALUES(?,?,?,?,?,?,?,?)";
        List<Tour> tours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(Tour tour : tourData){
                preparedStatement.setString(1, tour.getCode());
                preparedStatement.setString(2, tour.getName());
                preparedStatement.setString(3, tour.getDescription());
                preparedStatement.setString(4, tour.getStartDate());
                preparedStatement.setInt(5, tour.getDestinateId());
                preparedStatement.setInt(6, tour.getGuideId());
                preparedStatement.setString(7, tour.getPresentator());
                preparedStatement.setInt(8, tour.getAvailables());
                preparedStatement.addBatch();
            }
            int[] addRows = preparedStatement.executeBatch();

            // Check the number of rows affected for each batch
            for (int rows : addRows) {
                if (rows > 0) {
                    System.out.println("Add Tour successful!");
                } else {
                    System.out.println("Add Tour failed!");
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Tour> getToursByCustomerId(int CustomerId){
        String sql = "SELECT tbl_tour.id,tbl_tour.code,tbl_tour.name,tbl_tour.description,tbl_tour.startDate,tbl_tour.DestinateId,tbl_tour.GuideId,tbl_tour.presentator,tbl_tour.availables \n" +
                    "FROM tbl_tour JOIN tbl_Customer_tour ON tbl_Customer_tour.tourId = tbl_tour.id JOIN tbl_Customer ON tbl_Customer.id = tbl_Customer_tour.CustomerId\n" +
                    "WHERE tbl_Customer.id = ?";
        List<Tour> tours = new ArrayList<>();
        
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, CustomerId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setDestinateId(resultSet.getInt("DestinateId"));
                tour.setGuideId(resultSet.getInt("GuideId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));

                tours.add(tour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }
    
    public List<Tour> getToursByDestinateId(int DestinateId){
        String sql = "SELECT * FROM tbl_tour WHERE tbl_tour.DestinateId = ?";
        List<Tour> tours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, DestinateId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setDestinateId(resultSet.getInt("DestinateId"));
                tour.setGuideId(resultSet.getInt("GuideId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));

                tours.add(tour);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }
    
    public List<Tour> getToursByGuideId(int GuideId){
        String sql = "SELECT * FROM tbl_tour WHERE tbl_tour.GuideId = ?";
        List<Tour> tours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, GuideId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setDestinateId(resultSet.getInt("DestinateId"));
                tour.setGuideId(resultSet.getInt("GuideId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));

                tours.add(tour);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }
    
    public Tour getTourByGuideId(int GuideId){
        String sql = "SELECT * FROM tbl_tour WHERE tbl_tour.GuideId = ?";
        Tour tour = new Tour();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, GuideId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setDestinateId(resultSet.getInt("DestinateId"));
                tour.setGuideId(resultSet.getInt("GuideId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }
    
    public Tour getTourByCustomerId(int CustomerId){
        String sql = "SELECT tbl_tour.id,tbl_tour.code,tbl_tour.name,tbl_tour.description,tbl_tour.startDate,tbl_tour.DestinateId,tbl_tour.GuideId,tbl_tour.presentator,tbl_tour.availables \n" +
                    "FROM tbl_tour JOIN tbl_Customer_tour ON tbl_Customer_tour.tourId = tbl_tour.id JOIN tbl_Customer ON tbl_Customer.id = tbl_Customer_tour.CustomerId\n" +
                    "WHERE tbl_Customer.id = ?";
        Tour tour = new Tour();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, CustomerId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setDestinateId(resultSet.getInt("DestinateId"));
                tour.setGuideId(resultSet.getInt("GuideId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }
    
    public void deleteTourOfGuide(List<Tour> tours){
        String sql = "UPDATE tbl_tour SET GuideId = NULL WHERE code = ? AND GuideId = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        } catch (Exception e) {
        }
    }
}
