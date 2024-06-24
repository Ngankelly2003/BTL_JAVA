package models;

import java.util.ArrayList;
import java.util.List;

public class Destinate {

    public static int count = 0;

    private int id;
    private String code;
    private String name;
    private String description;
    private String timeStay;
    private String sleepPlace;
    private String address;
    private List<Tour> tours;

    public Destinate() {

    }

    public Destinate( String code, String name, String description, String timeStay, String sleepPlace, String address){
        this.code = code;
        this.name = name;
        this.description = description;
        this.timeStay = timeStay;
        this.sleepPlace = sleepPlace;
        this.address = address;    
    }
    
    public Destinate(int id, String code, String name, String description, String timeStay, String sleepPlace, String address){
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.timeStay = timeStay;
        this.sleepPlace = sleepPlace;
        this.address = address;    
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public String getTimeStay() {
        return timeStay;
    }

    public void setTimeStay(String timeStay) {
        this.timeStay = timeStay;
    }

    public String getSleepPlace() {
        return sleepPlace;
    }

    public void setSleepPlace(String sleepPlace) {
        this.sleepPlace = sleepPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public String toStringFile() {
        return id + "," + code + "," + name + "," + description + "," + timeStay + "," + sleepPlace + "," + address;
    }

}


