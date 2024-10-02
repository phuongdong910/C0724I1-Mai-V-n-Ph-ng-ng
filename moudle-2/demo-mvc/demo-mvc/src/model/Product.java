package model;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;
    private Integer id;

    private String name;

    public Product() {
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String convertLine() {
        String comma = ",";
        return this.id + comma + this.name;
    }

    @Override
    public String toString() {
        return "----------------------------" + " \n" +
                "Product: " + " \n" +
                "Id: " + this.id + " \n" +
                "Name: " + this.name;
    }
}
