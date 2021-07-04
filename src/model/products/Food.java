package model.products;

public class Food extends Product {
    private String expiration_date;

    public Food(int productID, String productName, double productPrice, int quantity, String expiration_date) {
        super(productID, productName, productPrice, quantity);
        this.expiration_date = expiration_date;
    }

    public String getExpiration_date() {
        return expiration_date;
    }
}
