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
        String type = productRow[4];
        Product result = null;
        if(type.equals(TYPE_FOOD)) {
            result = new Food(Integer.parseInt(productRow[0])
                    , productRow[1]
                    , Double.parseDouble(productRow[2])
                    , Integer.parseInt(productRow[3])
                    , productRow[6]);
        }else if(type.equals(TYPE_MAKEUP)) {
            result = new Makeup(Integer.parseInt(productRow[0])
                    , productRow[1]
                    , Double.parseDouble(productRow[2])
                    , Integer.parseInt(productRow[3])
                    , productRow[5]
                    , productRow[6]);

        }else if(type.equals(TYPE_OTHERS)) {
            result = new Others(Integer.parseInt(productRow[0])
                    , productRow[1]
                    , Double.parseDouble(productRow[2])
                    , Integer.parseInt(productRow[3])
                    , productRow[5]);

        }else if(type.equals(TYPE_SANITARY)) {
            result = new Sanitary(Integer.parseInt(productRow[0])
                    , productRow[1]
                    , Double.parseDouble(productRow[2])
                    , Integer.parseInt(productRow[3]));
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
        if(product instanceof Food) {
            result = product.getProductID() + ", "
                    + product.getProductName() + ", "
                    + product.getProductPrice() + ", "
                    + product.getQuantity() + ", "
                    + TYPE_FOOD + ",,"
                    + ((Food) product).getExpiration_date();
        }else if(product instanceof Makeup) {
            result = product.getProductID() + ", "
                    + product.getProductName() + ", "
                    + product.getProductPrice() + ", "
                    + product.getQuantity() + ", "
                    + TYPE_MAKEUP + ", "
                    + ((Makeup) product).getColor() + ", "
                    + ((Makeup) product).getExpiration_date();
        }else if(product instanceof Others) {
            result = product.getProductID() + ", "
                    + product.getProductName() + ", "
                    + product.getProductPrice() + ", "
                    + product.getQuantity() + ", "
                    + TYPE_OTHERS + ", "
                    + ((Others) product).getColor() + ", ";
        }else if(product instanceof Sanitary) {
            result = product.getProductID() + ", "
                    + product.getProductName() + ", "
                    + product.getProductPrice() + ", "
                    + product.getQuantity() + ", "
                    + TYPE_SANITARY + ",,";
        }
        return result;
    }
}
