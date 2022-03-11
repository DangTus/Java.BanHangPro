package model;

public class Product {

    private int id;
    private String name;
    private int price;
    private int amount;
    private int id_categori;
    private String about;
    private int status;

    public Product() {

    }

    public Product(int id, String name, int price, int amount, int id_categori, String about, int status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.id_categori = id_categori;
        this.about = about;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId_categori() {
        return id_categori;
    }

    public void setId_categori(int id_categori) {
        this.id_categori = id_categori;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
