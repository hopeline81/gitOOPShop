package ui.product.printsProduct;


public class ViewListenerProductImpl implements ViewListenerProduct {

    @Override
    public void printAllProduct(int id, String name, double price, int quantity) {
        System.out.println(" " + id + ". " + name + ", price: " + price + ", qty -  " + quantity);
    }

    @Override
    public void printSortedProduct() {

    }

    @Override
    public void printSpecificProduct(int id, String name) {
        System.out.println(" " + id + ". " + name);
    }

    @Override
    public void printAllProductsWitPriceHigherThanOrEqualToSelectedPrice(int id, String name, double price) {
        System.out.println(" " + id + ". " + name + " - " + price);
    }

    @Override
    public void printAllProductsWitPriceLowerThanSelectedPrice(int id, String name, double price) {
        System.out.println(" " + id + ". " + name + " - " + price);
    }

    @Override
    public void printAllProductsWithQuantityGreaterThanSelectedQuantity(int id, String name, int quantity) {
        System.out.println(" " + id + ". " + name + " - " + quantity);
    }

    @Override
    public void printAllProductsWithQuantityLessThanSelectedQuantity(int id, String name, int quantity) {
        System.out.println(" " + id + ". " + name + " - " + quantity);
    }

    @Override
    public void printProductTypeFood(int id, String name, double price, int quantity, String expiryDate) {
        System.out.println(" " + id + ". " + name + " - " + price + ", qty -  " + quantity + " " + expiryDate);
    }

    @Override
    public void printProductTypeSanitary(int id, String name, double price, int quantity) {
        System.out.println(" " + id + ". " + name + " - " + price + ", qty -  " + quantity);
    }

    @Override
    public void printProductTypeMakeup(int id, String name, double price, int quantity, String color, String expiryDate) {
        System.out.println(" " + id + ". " + name + " - " + price + ", qty -  " + quantity + " " + color + " " + expiryDate);
    }

    @Override
    public void printProductTypeOthers(int id, String name, double price, int quantity, String color) {
        System.out.println(" " + id + ". " + name + " - " + price + ", qty -  " + quantity + " " + color);
    }
}
