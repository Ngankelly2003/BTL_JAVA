package models;

import java.util.List;
import java.util.Objects;

public class Team {

    public static int count = 0;

    private int id;
    private String code;
    private String name;
    private List<Customer> Customers;

    public Team(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
    
    public Team(String code, String name) {
        this.code = code;
        this.name = name;
    }
    

    public Team() {
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

    public List<Customer> getCustomer() {
        return Customers;
    }

    public void setCustomer(List<Customer> Customers) {
        this.Customers = Customers;
    }
    @Override
    public String toString(){
        return name;
    }
    public String toStringFile() {
        return id + "," + code + "," + name + "," + Customers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Team other = (Team) obj;
        return Objects.equals(id, other.id);
    }

}
