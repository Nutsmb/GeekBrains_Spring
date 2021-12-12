package ru.gb.springProject.dto;

public class Product {
    private int id;
    private String title;
    private float coast;

    public Product(int id, String title, float coast){
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

    public Product(){}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getCoast() {
        return coast;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoast(float coast) {
        this.coast = coast;
    }
}
