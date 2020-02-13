package service;

import model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteProduct {
    Scanner sc = new Scanner(System.in);
    private static final String PATH = "/home/bbt/Git/java-new/ManagerProducts/files/Products.md";
    private static WriteProduct writeProduct;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    private WriteProduct() {
    }

    public static WriteProduct getWriteProduct() {
        if (writeProduct == null) {
            writeProduct = new WriteProduct();
        }
        return writeProduct;
    }

    public void writeListProducts(ArrayList<Product> arrayListProducts) {
        File file = new File(PATH);
        if (!file.exists()) {
            this.overWriteListProducts(arrayListProducts);
        }
        else {
            this.writeMoreListProducts(arrayListProducts);
        }
    }
    public void overWriteListProducts(ArrayList<Product> arrayListProducts) {
        try {
            fileOutputStream = new FileOutputStream(PATH);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Product product : arrayListProducts) {
                objectOutputStream.writeObject(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;

    }
    public void writeMoreListProducts(ArrayList<Product> arrayListProducts) {
        try {
            fileOutputStream = new FileOutputStream(PATH, true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Product product : arrayListProducts) {
            try {
                objectOutputStream.writeObject(product);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


//    public void writeProduct(Product product) {
//        try {
//            fileOutputStream = new FileOutputStream(PATH, true);
//            objectOutputStream = new ObjectOutputStream(fileOutputStream) {
//                @Override
//                protected void writeStreamHeader() throws IOException {
//                    reset();
//                }
//            };
//            objectOutputStream.writeObject(product);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
