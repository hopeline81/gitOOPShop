package model.products;

public class Others extends Product {
    private String color;

    public Others(int productID, String productName, double productPrice, int quantity, String color) {
        super(productID, productName, productPrice, quantity);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
