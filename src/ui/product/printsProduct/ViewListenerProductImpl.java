package ui.product.printsProduct;


import data.DataParserProduct;

import model.products.Product;

import java.util.List;

public class ViewListenerProductImpl implements ViewListenerProduct {
    private final DataParserProduct dataParserProduct = new DataParserProduct();

    @Override
    public void printAllProduct(List<Product> productList) {
        System.out.println(dataParserProduct.parseProductToString(productList));
    }
}
