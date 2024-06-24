package models;

import java.awt.image.BufferedImage;
import java.util.List;

public class Customer extends Person {

    private String imagePath;
    private List<CustomerTour> CustomerTours;
    private int TeamId;
    private int accountId;

    public Customer() {
    }
    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int TeamId) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.TeamId = TeamId;
        this.imagePath = imagePath;
    }

    public Customer(int id, String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate,int accountId, int TeamId) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.accountId = accountId;
        this.imagePath = imagePath;
        this.TeamId = TeamId;
    }
    
    public Customer(String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int TeamId) {
        super(code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.TeamId = TeamId;
        this.imagePath = imagePath;
    }

    public Customer(int id, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, List<CustomerTour> CustomerTours, int TeamId) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.CustomerTours = CustomerTours;
        this.TeamId = TeamId;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<CustomerTour> getCustomerTours() {
        return CustomerTours;
    }

    public void setCustomerTours(List<CustomerTour> CustomerTours) {
        this.CustomerTours = CustomerTours;
    }

    public int getTeamId() {
        return TeamId;
    }

    public void setTeamId(int TeamId) {
        this.TeamId = TeamId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return id + "," + code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + birthDate + "," + CustomerTours + "," + TeamId;
    }

    public String toStringFile() {
        return id + "," + code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + birthDate + "," + TeamId;

    }

}
