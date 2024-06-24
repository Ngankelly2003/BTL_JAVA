package services;

import dao.CustomerDao;
import java.util.List;
import models.Customer;

public class CustomerService {
    
    public CustomerDao customerDao;
    
    public CustomerService(){
        customerDao = new CustomerDao();
    }
    //Customer
    public List<Customer> getAllCustomers(){
        return customerDao.getAllCustomers();
    }
    
    public String getCustomerTeamNameById(int TeamId){
        return customerDao.getCustomerTeamNameById(TeamId);
    }
    
    public int getIdByCustomer(String CustomerCode){
        return customerDao.getIdByCustomer(CustomerCode);
    }
    
    public Customer getCustomerById(int CustomerId){
        return customerDao.getCustomerById(CustomerId);
    }
    
    public void addCustomer(Customer Customer){
        customerDao.addCustomer(Customer);
    }
    
    public void addListCustomers(List<Customer> Customers) {
        customerDao.addListCustomers(Customers);
    }
    
    public void updateCustomer(Customer Customer , int CustomerId){
        customerDao.updateCustomer(Customer, CustomerId);
    }
    
    public void deleteCustomerById(int CustomerId){
        customerDao.deleteCustomerById(CustomerId);
    }
    
    public boolean isExistedCustomerCode(String CustomerCode) throws Exception{
        List<Customer> Customers_data = customerDao.getAllCustomers();
        for(Customer Customer : Customers_data){
            if(Customer.getCode().equalsIgnoreCase(CustomerCode)){
                return true;
            }
        }
        return false;
    }
    
    public int getTeamIdByCustomerId(int CustomerId){
        return customerDao.getTeamIdByCustomerId(CustomerId);
    }

    public Customer getCustomerByAccountId(int accountId) throws Exception {
        return customerDao.getCustomerByAccountId(accountId);
    }
    
    public Customer getCustomerByCustomerCode(String CustomerCode){
        return customerDao.getCustomerByCustomerCode(CustomerCode);
    }
    
    public List<Customer> getCustomersByTourId(int tourId){
        return customerDao.getCustomersByTourId(tourId);
    }
    public List<Customer> getCustomersByTeamId(int TeamId){
        return customerDao.getCustomersByTeamId(TeamId);
    }
}
