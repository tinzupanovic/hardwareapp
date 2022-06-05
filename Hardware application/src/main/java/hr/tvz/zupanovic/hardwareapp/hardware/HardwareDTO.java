package hr.tvz.zupanovic.hardwareapp.hardware;

import lombok.Data;

@Data
public class HardwareDTO {

    private String name;
    private String code;
    private double price;

    public HardwareDTO(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
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

    @Override
    public String toString() {
        return "HardwareDTO{" + "name:'" + name + '\'' + ", code:'" + code + '\'' + ", price:" + price + "}";
    }
}
