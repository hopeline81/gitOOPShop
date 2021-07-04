package ui.product.printsProduct;

public interface ViewListenerProduct {

    void printAllProduct(int id, String name, double price, int quantity);

    void printSortedProduct();

    void printSpecificProduct(int id, String name);

    void printAllProductsWitPriceHigherThanOrEqualToSelectedPrice(int id, String name, double price);

    void printAllProductsWitPriceLowerThanSelectedPrice(int id, String name, double price);

    void printAllProductsWithQuantityGreaterThanSelectedQuantity(int id, String name, int quantity);

    void printAllProductsWithQuantityLessThanSelectedQuantity(int id, String name, int quantity);

    void printProductTypeFood(int id, String name, double price, int quantity, String expiryDate);

    void printProductTypeSanitary(int id, String name, double price, int quantity);

    void printProductTypeMakeup(int id, String name, double price, int quantity,String color, String expiryDate);

    void printProductTypeOthers(int id, String name, double price, int quantity,String color);

}
