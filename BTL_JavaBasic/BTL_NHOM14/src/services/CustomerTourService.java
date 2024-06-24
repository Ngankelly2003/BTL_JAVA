package services;

import dao.CustomerTourDao;
import java.util.List;
import models.CustomerTour;

public class CustomerTourService {
    
    private CustomerTourDao CustomerTourDao;
    
    public CustomerTourService(){
        CustomerTourDao = new CustomerTourDao();
    }
    //Customer
    public List<CustomerTour> getAllCustomerTours(){
        return CustomerTourDao.getAllCustomerTours();
    }
    
    public List<CustomerTour> getAllCustomerToursByTourId(int tourId){
        return CustomerTourDao.getAllCustomerToursByTourId(tourId);
    }
    
    public List<CustomerTour> getAllCustomerToursByCustomerId(int CustomerId){
        return CustomerTourDao.getAllCustomerToursByCustomerId(CustomerId);
    }
    
    public CustomerTour geCustomerTourByCustomerId(int CustomerId){
        return CustomerTourDao.geCustomerTourByCustomerId(CustomerId);
    }
    
    public void addCustomerTour(CustomerTour CustomerTour){
        CustomerTourDao.addCustomerTour(CustomerTour);
    }
    
    public void addListCustomerTours(List<CustomerTour> CustomerTours){
        CustomerTourDao.addListCustomerTours(CustomerTours);
    }
    
    public void updateRateCustomer(int CustomerId , int tourId , int rate){
        CustomerTourDao.updateRateCustomer(CustomerId, tourId, rate);
    }
    
    public void deleteCustomerTour(int CustomerId , int tourId){
        CustomerTourDao.deleteCustomerTour(CustomerId, tourId);
    }
    
    public int getNumberOfCustomers(int tourId){
        return CustomerTourDao.getNumberOfCustomers(tourId);
    }
}
