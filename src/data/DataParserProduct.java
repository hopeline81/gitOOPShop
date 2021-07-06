package data;

import model.products.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataParserProduct {
    private static final String SPLIT_REGEX = ",";
    private static final String TYPE_FOOD = "food";
    private static final String TYPE_MAKEUP = "makeup";
    private static final String TYPE_SANITARY = "sanitary";
    private static final String TYPE_OTHERS = "others";


    public List<Product> parseStringsToProduct(List<String> productRows) {

        List<Product> products = new ArrayList<>();

        for (String row: productRows) {
            Product currentProduct = parseRowToProduct(row);
            if(currentProduct != null) {
                products.add(currentProduct);
            }
        }
        return products;
    }

    private Product parseRowToProduct(String row) {
        String[] productRow = row.split(SPLIT_REGEX);
        int id = Integer.parseInt(productRow[0]);
        String name = productRow[1];
        double price = Double.parseDouble(productRow[2]);
        int quantity = Integer.parseInt(productRow[3]);
        String type = productRow[4];
        String color = productRow[5];
        String expiryDate = productRow[6];
        Product result = null;
        switch (type) {
            case TYPE_FOOD:
                result = new Food(id, name, price, quantity, expiryDate);
                break;
            case TYPE_MAKEUP:
                result = new Makeup(id, name, price, quantity, color, expiryDate);
                break;
            case TYPE_OTHERS:
                result = new Others(id, name, price, quantity, color);
                break;
            case TYPE_SANITARY:
                result = new Sanitary(id, name, price, quantity);
                break;
            default:
        }
        return result;
    }

    public String parseProductToString(List<Product> products) {
        StringBuilder result = new StringBuilder("id,name,price,quantity,type,color,expiration_date\n");
        for (Product product:products) {
            result.append(parseProduct(product)).append("\n");
        }
        return result.toString();
    }

    private String parseProduct(Product product) {
        String result = "";
        int id = product.getProductID();
        String name = product.getProductName();
        double price = product.getProductPrice();
        int quantity = product.getQuantity();
        if(product instanceof Food) {
            result = id + ", " + name + ", " + price + ", " + quantity + ", "
                    + TYPE_FOOD + ",,"
                    + ((Food) product).getExpiration_date();
        }else if(product instanceof Makeup) {
            result = id + ", " + name + ", " + price + ", " + quantity + ", "
                    + TYPE_MAKEUP + ", "
                    + ((Makeup) product).getColor() + ", "
                    + ((Makeup) product).getExpiration_date();
        }else if(product instanceof Others) {
            result = id + ", " + name + ", " + price + ", " + quantity + ", "
                    + TYPE_OTHERS + ", "
                    + ((Others) product).getColor() + ", ";
        }else if(product instanceof Sanitary) {
            result = id + ", " + name + ", " + price + ", " + quantity + ", "
                    + TYPE_SANITARY + ",,";
        }
        return result;
    }
}
