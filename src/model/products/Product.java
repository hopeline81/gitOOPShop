package model.products;

public abstract class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private int quantity;

    public Product(int productID, String productName, double productPrice, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return " " + productID +
                ", " + productName +
                ", price: " + productPrice +
                ", quantity: " + quantity;
    }
}
