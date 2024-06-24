package dao;

import connectdb.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import models.Customer;

public class CustomerDao {
    
    public List<Customer> getAllCustomers(){
        List<Customer> Customers = new ArrayList<>();
        String sql = "SELECT * FROM tbl_customer";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setAddress(rs.getString("address"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setEmail(rs.getString("email"));
                customer.setBirthDate(rs.getString("birthDate"));
                customer.setAccountId(rs.getInt("accountId"));
                customer.setTeamId(rs.getInt("TeamId"));
                Customers.add(customer);
            }
            
        } catch (Exception e) {
        }
        return Customers;
    }
    public String getCustomerTeamNameById(int TeamId) {
        String TeamName = null;
        try {
            String sql = "SELECT tbl_team.name FROM tbl_team WHERE tbl_team.id = ?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, TeamId);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                TeamName = rs.getString("name");
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return TeamName;
    }
    
    public int getIdByCustomer(String CustomerCode){
        String sql = "SELECT id from tbl_customer WHERE code = ?";
        int CustomerId = -1;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, CustomerCode);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                CustomerId = rs.getInt("id");
            }
            return CustomerId;
        } catch (Exception e) {
            return -1;
        }
    }
    
    public Customer getCustomerById(int CustomerId){
        String sql = "SELECT * FROM tbl_customer WHERE id = ?";
        Customer customer = new Customer();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, CustomerId);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setBirthDate(rs.getString("birthDate"));
                customer.setAddress(rs.getString("address"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setImagePath(rs.getString("imagePath"));
                customer.setEmail(rs.getString("email"));
                customer.setAccountId(rs.getInt("accountId"));
                customer.setTeamId(rs.getInt("TeamId"));
            }
            
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
    
    public void addCustomer(Customer customer){
        String sql = "INSERT INTO tbl_customer (id,code,firstName,lastName,birthDate,address,phoneNumber,email,imagePath,accountId,TeamId) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getCode());
            preparedStatement.setString(3, customer.getFirstName());
            preparedStatement.setString(4, customer.getLastName());
            preparedStatement.setString(5, customer.getBirthDate());
            preparedStatement.setString(6, customer.getAddress());
            preparedStatement.setString(7, customer.getPhoneNumber());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getImagePath());
            preparedStatement.setInt(10, customer.getAccountId());
            preparedStatement.setInt(11, customer.getTeamId());
            
            int addRows = preparedStatement.executeUpdate();
            if (addRows > 0) {
                System.out.println("Add Customer successful!");
            } else {
                System.out.println("Add Customer failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addListCustomers(List<Customer> Customers) {
        String sql = "INSERT INTO tbl_customer (id, code, firstName, lastName, birthDate, address, phoneNumber, email, imagePath, accountId, TeamId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (Customer customer : Customers) {
                preparedStatement.setInt(1, customer.getId());
                preparedStatement.setString(2, customer.getCode());
                preparedStatement.setString(3, customer.getFirstName());
                preparedStatement.setString(4, customer.getLastName());
                preparedStatement.setString(5, customer.getBirthDate());
                preparedStatement.setString(6, customer.getAddress());
                preparedStatement.setString(7, customer.getPhoneNumber());
                preparedStatement.setString(8, customer.getEmail());

                // Ensure 'imagePath' is set to null if it is null in the Customer object
                if (customer.getImagePath() != null) {
                    preparedStatement.setString(9, customer.getImagePath());
                } else {
                    preparedStatement.setNull(9, Types.VARCHAR);
                }

                preparedStatement.setInt(10, customer.getAccountId());
                preparedStatement.setInt(11, customer.getTeamId());
                preparedStatement.addBatch();
            }

            int[] addRows = preparedStatement.executeBatch();

            // Check the number of rows affected for each batch
            for (int rows : addRows) {
                if (rows > 0) {
                    System.out.println("Add Customer successful!");
                } else {
                    System.out.println("Add Customer failed!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateCustomer(Customer customer , int CustomerId){
        String sql = "UPDATE tbl_customer SET "
                + "code = ? , "
                + "firstName = ? , "
                + "lastName = ?, "
                + "birthDate = ? , "
                + "address = ? , "
                + "phoneNumber = ? , "
                + "imagePath = ? , "
                + "email = ? , "
                + "accountId = ?,"
                + "teamId = ? "
                + "WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, customer.getCode());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getBirthDate());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getImagePath());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setInt(9, customer.getAccountId());
            preparedStatement.setInt(10, customer.getTeamId());
            preparedStatement.setInt(11, CustomerId);
            
            System.out.println("SQL: " + preparedStatement.toString());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Customer updated.");
            }else {
                System.out.println("No changes detected. Customer not updated.");
            }
        } catch (Exception e) {
        }
    }
    
    public void deleteCustomerById(int CustomerId){
        String sql = "DELETE FROM tbl_customer WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, CustomerId);
            
            int rowDeleted = preparedStatement.executeUpdate();
            if(rowDeleted > 0){
                System.out.println("Customer deleted.");
            }else {
                System.out.println("No changes detected. Customer not deleted.");
            }
        } catch (Exception e) {
        }
    }
    public int getTeamIdByCustomerId(int CustomerId) {
        int TeamId = -1;
        String sql = "SELECT teamId from tbl_customer WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, CustomerId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                TeamId = rs.getInt("TeamId");
            }
            return TeamId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public Customer getCustomerByAccountId(int accountId){
        String sql = "SELECT * FROM tbl_customer WHERE accountId = ?";
        Customer customer = new Customer();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setBirthDate(rs.getString("birthDate"));
                customer.setAddress(rs.getString("address"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setImagePath(rs.getString("imagePath"));
                customer.setEmail(rs.getString("email"));
                customer.setAccountId(rs.getInt("accountId"));
                customer.setTeamId(rs.getInt("TeamId"));
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
    
    public Customer getCustomerByCustomerCode(String CustomerCode) {
        String sql = "SELECT * FROM tbl_customer WHERE code = ?";
        Customer customer = null;  // Initialize to null
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, CustomerCode);

            ResultSet rs = preparedStatement.executeQuery();

            // Check if there is at least one row in the result set
            if (rs.next()) {
                customer = new Customer();  // Initialize only if there are results

                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setBirthDate(rs.getString("birthDate"));
                customer.setAddress(rs.getString("address"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setImagePath(rs.getString("imagePath"));
                customer.setEmail(rs.getString("email"));
                customer.setAccountId(rs.getInt("accountId"));
                customer.setTeamId(rs.getInt("TeamId"));
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
    
    public List<Customer> getCustomersByTourId(int tourId){
        String sql = "SELECT tbl_customer.id , code,firstName,lastName,birthDate,address,phoneNumber,email,imagePath,TeamId\n" +
                     "from tbl_customer JOIN tbl_customer_tour ON tbl_customer.id = tbl_customer_tour.CustomerId WHERE tbl_customer_tour.tourId = ?";
        List<Customer> Customers = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setAddress(rs.getString("address"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setEmail(rs.getString("email"));
                customer.setBirthDate(rs.getString("birthDate"));
//                customer.setAccountId(rs.getInt("accountId"));
                customer.setTeamId(rs.getInt("TeamId"));
                customer.setImagePath(rs.getString("imagePath"));
                Customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Customers;
    }
    
    public List<Customer> getCustomersByTeamId(int TeamId){
        String sql = "SELECT * FROM tbl_customer WHERE tbl_customer.TeamId = ? ";
        List<Customer> Customers = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, TeamId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setCode(rs.getString("code"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setAddress(rs.getString("address"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setEmail(rs.getString("email"));
                customer.setBirthDate(rs.getString("birthDate"));
                customer.setAccountId(rs.getInt("accountId"));
                customer.setTeamId(rs.getInt("TeamId"));
                customer.setImagePath(rs.getString("imagePath"));
                Customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Customers;
    }
}
