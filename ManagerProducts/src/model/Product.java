package model;

import java.io.Serializable;

public class Product implements Serializable {
    public String link;
    public String name;
    public String price;
    public String phoneNumber;

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDescripe(String descripe) {
        this.descripe = descripe;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDescripe() {
        return descripe;
    }

    public String descripe;

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Product(String link, String name, String price, String phoneNumber, String descripe) {
        this.link = "https://nhattao.com/"+link;
        this.name = name;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.descripe = descripe;
    }
    public Product(String link, String name, String price) {
        this.link = "https://nhattao.com/"+link;
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Link: "+this.link+", "+"name: "+this.name+", "+"Price: "+this.price+";";
    }
}
