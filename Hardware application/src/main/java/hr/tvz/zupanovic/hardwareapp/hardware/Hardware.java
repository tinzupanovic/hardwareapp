package hr.tvz.zupanovic.hardwareapp.hardware;

import hr.tvz.zupanovic.hardwareapp.review.Review;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="hardware")
public class Hardware implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String code;

    private double price;

    private String type;
    @Column(name = "units")
    private int stock;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hardware")
    private List<Review> reviews;

    protected Hardware() {}

    public Hardware(int id, String name, String code, double price, String type, int stock) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }
}
