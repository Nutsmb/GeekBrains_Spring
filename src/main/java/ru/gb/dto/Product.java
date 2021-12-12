package ru.gb.dto;

public class Product {
  private int id;
  private String title;
  private float coast;

  public Product(int id, String title, float coast) {
    this.id = id;
    this.title = title;
    this.coast = coast;
  }

  public Product() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String name) {
    this.title = name;
  }

  public float getCoast() {
    return coast;
  }

  public void setCoast(float score) {
    this.coast = score;
  }
}