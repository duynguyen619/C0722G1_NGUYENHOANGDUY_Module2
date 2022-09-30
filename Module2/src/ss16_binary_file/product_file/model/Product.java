package ss16_binary_file.product_file.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String producer;
    private double price;


    public Product(String id, String name,String producer, double price) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                '}';
    }
}
