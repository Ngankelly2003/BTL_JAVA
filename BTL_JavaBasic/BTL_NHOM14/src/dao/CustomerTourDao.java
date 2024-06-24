package dao;

import connectdb.JDBCUtil;
import java.sql.*;
import models.*;
import services.*;
import java.util.*;

public class CustomerTourDao {
    
    public List<CustomerTour> getAllCustomerTours(){
        String sql = "SELECT * FROM tbl_Customer_tour";
        List<CustomerTour> CustomerTours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                //Customer
                CustomerTour CustomerTour = new CustomerTour();
                CustomerTour.setCustomerId(rs.getInt("CustomerId"));
                CustomerTour.setTourId(rs.getInt("tourId"));
                CustomerTour.setRate(rs.getInt("rate"));
                CustomerTours.add(CustomerTour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CustomerTours;
    }
    
    public List<CustomerTour> getAllCustomerToursByTourId(int tourId){
        String sql = "SELECT * FROM tbl_Customer_tour WHERE tourId = ?";
        List<CustomerTour> CustomerTours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                CustomerTour CustomerTour = new CustomerTour();
                CustomerTour.setCustomerId(rs.getInt("CustomerId"));
                CustomerTour.setTourId(rs.getInt("tourId"));
                CustomerTour.setRate(rs.getInt("rate"));
                CustomerTours.add(CustomerTour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CustomerTours;
    }
    
    public List<CustomerTour> getAllCustomerToursByCustomerId(int CustomerId){
        String sql = "SELECT * FROM tbl_Customer_tour WHERE CustomerId = ?";
        List<CustomerTour> CustomerTours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, CustomerId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                CustomerTour CustomerTour = new CustomerTour();
                CustomerTour.setCustomerId(rs.getInt("CustomerId"));
                CustomerTour.setTourId(rs.getInt("tourId"));
                CustomerTour.setRate(rs.getInt("rate"));
                CustomerTours.add(CustomerTour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CustomerTours;
    }
    
    public CustomerTour geCustomerTourByCustomerId(int CustomerId){
        String sql = "SELECT * FROM tbl_Customer_tour WHERE CustomerId = ?";
        CustomerTour CustomerTour = new CustomerTour();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, CustomerId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                CustomerTour.setCustomerId(rs.getInt("CustomerId"));
                CustomerTour.setTourId(rs.getInt("tourId"));
                CustomerTour.setRate(rs.getInt("rate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CustomerTour;
    }
    
    public void addCustomerTour(CustomerTour CustomerTour){
        String sql = "INSERT INTO tbl_Customer_tour (CustomerId,tourId,rate) VALUES (?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, CustomerTour.getCustomerId());
            preparedStatement.setInt(2, CustomerTour.getTourId());
            preparedStatement.setInt(3, CustomerTour.getRate());
            
            int addRows = preparedStatement.executeUpdate();
            if (addRows > 0) {
                System.out.println("Add CustomerTour successful!");
            } else {
                System.out.println("Add CustomerTour failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addListCustomerTours(List<CustomerTour> CustomerTours){
        String sql = "INSERT INTO tbl_Customer_tour (CustomerId,tourId,rate) VALUES (?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            for(CustomerTour CustomerTour : CustomerTours){
                preparedStatement.setInt(1, CustomerTour.getCustomerId());
                preparedStatement.setInt(2, CustomerTour.getTourId());
                preparedStatement.setInt(3, CustomerTour.getRate());
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
    
    public void updateRateCustomer(int CustomerId , int tourId , int rate){
        String sql = "UPDATE tbl_Customer_tour SET rate = ? WHERE CustomerId = ? AND tourId = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
          
            preparedStatement.setInt(1, rate);
            preparedStatement.setInt(2, CustomerId);
            preparedStatement.setInt(3, tourId);
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Teacher updated.");
            }else {
                System.out.println("No changes detected. Teacher not updated.");
            }
        } catch (Exception e) {
        }
    }
    
    public void deleteCustomerTour(int CustomerId , int tourId){
        String sql = "DELETE FROM tbl_Customer_tour WHERE CustomerId = ? AND tourId = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, CustomerId);
            preparedStatement.setInt(2, tourId);
            
            int rowDeleted = preparedStatement.executeUpdate();
            if(rowDeleted > 0){
                System.out.println("Tour deleted.");
            }else {
                System.out.println("No changes detected. Tour not deleted.");
            }
        } catch (Exception e) {
        }
    }
    
    public int getNumberOfCustomers(int tourId){
        String sql = "SELECT Count(tbl_Customer_tour.CustomerId) AS CustomerCount FROM tbl_Customer_tour WHERE tbl_Customer_tour.tourId = ?";
        int numberOfCustomers = -1;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                numberOfCustomers = resultSet.getInt("CustomerCount");
            }
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
            
            return numberOfCustomers;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
