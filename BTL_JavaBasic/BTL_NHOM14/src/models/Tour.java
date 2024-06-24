package models;

import java.util.List;

public class Tour {

    public static int count = 0;

    private int id;
    private String code;
    private String name;
    private String description;
    private String startDate;
    private int availables; // number of seats for a tour, ex: 100 => 100 Customers can be engaged in this tour
    private List<CustomerTour> CustomerTours;
    private int DestinateId;
    private int GuideId;
    private String presentator;

    public Tour() {
    }
    
    public Tour(int id, String code, String name, String description, String startDate, int availables, int DestinateId, int GuideId, String presentator){
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.availables = availables;
        this.DestinateId = DestinateId;
        this.GuideId = GuideId;
        this.presentator = presentator;
    }
    
    public Tour(String code, String name, String description, String startDate, int availables, int DestinateId, int GuideId, String presentator){
        this.code = code;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.availables = availables;
        this.DestinateId = DestinateId;
        this.GuideId = GuideId;
        this.presentator = presentator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getAvailables() {
        return availables;
    }

    public void setAvailables(int availables) {
        this.availables = availables;
    }

    public List<CustomerTour> getCustomerTours() {
        return CustomerTours;
    }

    public void setCustomerTours(List<CustomerTour> CustomerTours) {
        this.CustomerTours = CustomerTours;
    }

    public int getDestinateId() {
        return DestinateId;
    }

    public void setDestinateId(int DestinateId) {
        this.DestinateId = DestinateId;
    }
    public int getGuideId() {
        return GuideId;
    }
    public void setGuideId(int GuideId) {
        this.GuideId = GuideId;
    }

    public String getPresentator() {
        return presentator;
    }

    public void setPresentator(String presentator) {
        this.presentator = presentator;
    }

    @Override
    public String toString() {
        return id + "," + code + "," + name + "," + description + "," + startDate + "," + availables + "," + CustomerTours + "," + DestinateId + "," + GuideId + "," + presentator;
    }

}
