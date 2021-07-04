package data;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    String fileNameRead = "Employee.csv";
    String fileReadProduct = "Product.csv";
    String fileNameWriteProduct = "ChangedProduct.csv";
    private final OnEventListener eventListener;

    public FileManager(OnEventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void readEmployeesDataFile() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> resultEmployeesData = readEmployeeData();
                eventListener.onRead(resultEmployeesData);
            }
        }).start();
    }

    public void readProductDataFile() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> resultProductData = readProductData();
                eventListener.onRead(resultProductData);
            }
        }).start();
    }

    public void writeChangedProductFile(String text) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                write(text);
                eventListener.onWrite();
            }
        }).start();
    }

    private ArrayList<String> readEmployeeData() {
        ArrayList<String> arrayList = new ArrayList<>();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(fileNameRead))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                arrayList.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Exception while reading the file was thrown");
            System.out.println(e.getMessage());
        }
        return arrayList;
    }

    private ArrayList<String> readProductData() {
        ArrayList<String> arrayList = new ArrayList<>();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(fileReadProduct))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                arrayList.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Exception while reading the file was thrown");
            System.out.println(e.getMessage());
        }
        return arrayList;
    }

    private void write (String text) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(fileNameWriteProduct))) {
            bufferedWriter.write(text);

        } catch (IOException e) {
            System.out.println("Exception while reading the file was thrown");
            System.out.println(e.getMessage());
        }
    }

}