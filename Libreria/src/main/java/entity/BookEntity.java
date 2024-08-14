package entity;

import java.sql.Date;

public class BookEntity {
    //atributes
    private int id;
    private String title;
    private String age;
    private float price;
    private int Author;

    //Constructor
    public BookEntity() {}

    public BookEntity(int id) {
        this.id = id;
    }

    public BookEntity(String title, String age, float price, int author) {
        this.title = title;
        this.age = age;
        this.price = price;
        Author = author;
    }

    public BookEntity(int id, String title, String age, float price, int author) {
        this.id = id;
        this.title = title;
        this.age = age;
        this.price = price;
        Author = author;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAge() {
        return age;
    }

    public float getPrice() {
        return price;
    }

    public int getAuthor() {
        return Author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAuthor(int author) {
        this.Author = author;
    }

    //toString

    @Override
    public String toString() {
        return "| id: " + id + " | " +
                "title: " + title + " | " +
                "age: " + age + " | " +
                "price: " + price + " | " +
                "Author: " + Author +  " |\n";
    }
}
