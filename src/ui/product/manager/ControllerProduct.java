package ui.product.manager;

import data.*;
import model.products.*;
import model.users.Employee;
import ui.employees.printsForEmployee.PrintMessagesEmployees;
import ui.product.printsProduct.ViewListenerProductImpl;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ControllerProduct implements OnEventListener {
    private final DataParserProduct dataParserProduct = new DataParserProduct();
    private final ViewListenerProductImpl viewListenerProduct = new ViewListenerProductImpl();
    private final PrintMessagesEmployees printMessagesEmployees = new PrintMessagesEmployees();
    private final FileManager fileManager = new FileManager(this);
    Scanner scanner = new Scanner(System.in);

    public ControllerProduct() {
        FileManager fileManager = new FileManager(this);
        fileManager.readProductDataFile();
    }

    public void printAllProducts(List<Product> products) {
        System.out.println(dataParserProduct.parseProductToString(products));
    }

    public void changeProductPrice() {

    }

    public void changeProductQuantity() {
        printMessagesEmployees.printMessageEnterProductID();
        int id = scanner.nextInt();
        printMessagesEmployees.printMessageAddQuantity();
        int newQuantity = scanner.nextInt();

        List<Product> products = ProductRepository.getInstance().provideAllProducts();

        List<Product> currentQuantityOfProduct = products.stream()
                .filter(s -> s.getProductID() == id)
                .collect(Collectors.toList());

        int currentQuantity = Integer.parseInt(currentQuantityOfProduct.toString());
        String newCurrentQuantity = String.valueOf(newQuantity + currentQuantity);

        String[] productLine = (String[]) currentQuantityOfProduct.toArray();
        for (int i = 0; i <= productLine.length; i++) {
            productLine[3] = String.valueOf(newCurrentQuantity);
        }
    }

    public void deleteSelectedProduct() {
        printMessagesEmployees.printMessageEnterProductID();
        int id = scanner.nextInt();

        List<Product> products = ProductRepository.getInstance().provideAllProducts();

        Product productToDeleted = products.stream()
                .filter(product -> product.getProductID() == id)
                .findFirst().orElse(null);

        products.remove(productToDeleted);
    }

    public void printSpecificProductById() {
        printMessagesEmployees.printMessageEnterProductID();
        int id = scanner.nextInt();

        ProductRepository.getInstance().provideAllProducts()
                .stream()
                .filter(s -> s.getProductID() == id)
                .forEach(System.out::println);
    }

    public void printAllProductsSortedByNamePriceOrDate() {
        printMessagesEmployees.printMessageSortProductByNameByPriceOrDate();
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> sortProductByName();
            case 2 -> sortProductByPrice();
            case 3 -> sortProductByDate();
            default -> {
                System.out.println("Wrong choice. Try again");
                printAllProductsSortedByNamePriceOrDate();
            }
        }
    }

    private void sortProductByDate() {
    }

    private void sortProductByPrice() {
        ProductRepository.getInstance().provideAllProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getProductPrice))
                .forEach(System.out::println);
    }

    private void sortProductByName() {
        ProductRepository.getInstance().provideAllProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getProductName))
                .forEach(System.out::println);
    }

    public void printProductsWithPriceHigherOrEqualToUserSetPrice() {
        printMessagesEmployees.printMessageChooseMinPrice();
        double userPrice = scanner.nextDouble();
        ProductRepository.getInstance().provideAllProducts()
                .stream()
                .filter(s -> s.getProductPrice() >= userPrice)
                .sorted(Comparator.comparing(Product::getProductPrice))
                .forEach(System.out::println);
    }

    public void printProductsWithPriceLowerOrEqualToUserSetPrice() {
        printMessagesEmployees.printMessageChooseMaxPrice();
        double userPrice = scanner.nextDouble();
        ProductRepository.getInstance().provideAllProducts()
                .stream()
                .filter(s -> s.getProductPrice() <= userPrice)
                .sorted(Comparator.comparing(Product::getProductPrice))
                .forEach(System.out::println);
    }

    public void printProductsWithQualityHigherOrEqualToUserSetQuantity() {
        printMessagesEmployees.printMessageChooseMinQuantity();
        int userQuantity = scanner.nextInt();
        ProductRepository.getInstance().provideAllProducts()
                .stream()
                .filter(s -> s.getQuantity() >= userQuantity)
                .sorted(Comparator.comparing(Product::getQuantity))
                .forEach(System.out::println);
    }

    public void printProductsWithQualityLowerOrEqualToUserSetQuantity() {
        printMessagesEmployees.printMessageChooseMaxQuantity();
        int userQuantity = scanner.nextInt();
        ProductRepository.getInstance().provideAllProducts()
                .stream()
                .filter(s -> s.getQuantity() <= userQuantity)
                .sorted(Comparator.comparing(Product::getQuantity))
                .forEach(System.out::println);
    }

    public void addNewProduct() {
        printMessagesEmployees.printMessageEnterTypeOfNewProduct();
        int type = scanner.nextInt();
        printMessagesEmployees.printMessageEnterProductID();
        int productId = scanner.nextInt();
        printMessagesEmployees.printMessageEnterProductName();
        String productName = scanner.next();
        printMessagesEmployees.printMessageEnterProductPrice();
        double productPrice = scanner.nextDouble();
        printMessagesEmployees.printMessageEnterProductQuantity();
        int productQuantity = scanner.nextInt();
        Product newProduct = null;

        switch (type) {
            case 1:
                printMessagesEmployees.printMessageEnterProductExpiryDate();
                newProduct = new Food(productId, productName, productPrice, productQuantity, scanner.next());
                break;
            case 2:
                printMessagesEmployees.printMessageEnterProductColor();
                printMessagesEmployees.printMessageEnterProductExpiryDate();
                newProduct = new Makeup(productId, productName, productPrice, productQuantity, scanner.next(), scanner.next());
                break;
            case 3:
                printMessagesEmployees.printMessageEnterProductColor();
                newProduct = new Others(productId, productName, productPrice, productQuantity, scanner.next());
                break;
            case 4:
                newProduct = new Sanitary(productId, productName, productPrice, productQuantity);
                break;
            default:
                break;
        }
        ProductRepository.getInstance().provideAllProducts()
                .add(newProduct);
    }

    public void saveChanges() {
        List<Product> products = ProductRepository.getInstance().provideAllProducts();
        String productsLine = dataParserProduct.parseProductToString(products);
        fileManager.writeChangedProductFile(productsLine);
    }

    @Override
    public void onRead(ArrayList<String> resultProductData) {
        List<Product> products = dataParserProduct.parseStringsToProduct(resultProductData);
        ProductRepository.getInstance().setProducts(products);

    }

    @Override
    public void onWrite() {
        printMessagesEmployees.printDone();
    }
}
