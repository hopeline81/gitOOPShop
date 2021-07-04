package model.products;

public class Makeup extends Product {
    private String color;
    private String expiration_date;

    public Makeup(int productID, String productName, double productPrice, int quantity, String color, String expiration_date) {
        super(productID, productName, productPrice, quantity);
        this.color = color;
        this.expiration_date = expiration_date;
    }

    public String getColor() {
        return color;
    }

    public String getExpiration_date() {
        return expiration_date;
    }
}
