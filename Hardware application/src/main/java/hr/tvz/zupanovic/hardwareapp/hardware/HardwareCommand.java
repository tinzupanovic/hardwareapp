package hr.tvz.zupanovic.hardwareapp.hardware;

import javax.validation.constraints.*;

public class HardwareCommand {

    private int id;

    @NotBlank(message = "Name of the product must be entered!")
    private String name;

    @NotBlank(message = "Code of the product must be entered!")
    private String code;

    @NotNull(message = "Price of the product must be entered!")
    @PositiveOrZero(message = "Price of the product must not be a negative value!")
    private double price;

    @NotBlank(message = "Type of the product must be entered!")
    @Pattern(message = "Wrong type of the product!", regexp="CPU|GPU|MBO|RAM|STORAGE|OTHER")
    private String type;

    @PositiveOrZero(message = "Available units of the product must not be a negative value!")
    @Max(message = "Number of available units cannot be greater than 10000", value = 10000)
    private int stock;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
