package service;

import model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadProduct implements Serializable {
    Scanner sc = new Scanner(System.in);
    private static ReadProduct readProduct;

    private ReadProduct() {
}
    public static ReadProduct getReadProduct() {
        if (readProduct == null) {
            readProduct = new ReadProduct();
        }
        return readProduct;
    }

    public ArrayList readFilesObject(String path) {
        ArrayList<Product> list = new ArrayList();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Product product;
            while ((product = (Product) objectInputStream.readObject()) != null) {
                list.add(product);
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

//    public void readTxtWriteObjectProducts(String inputPathTxtProducts) {
//        String productCode = "";
//        String productName = "";
//        String manufacturer = "";
//        int price = 0;
//        String describe = "";
//        File fileInput = new File(inputPathTxtProducts);
//        final String outputPath = "files/outputObjectProducts.md";
//        File fileOutput = new File(outputPath);
//        if (fileOutput.exists()) {
//            String anserOverwrite;
//            do {
//                System.out.println("File outputObjectProducts.md alreadly exit. Do you want add data it? y/n/overwrite");
//                anserOverwrite = sc.nextLine();
//            } while (!(anserOverwrite.equalsIgnoreCase("n") || anserOverwrite.equalsIgnoreCase("y") || anserOverwrite.equalsIgnoreCase("overwrite")));
//            if (anserOverwrite.equalsIgnoreCase("n")) {
//                System.out.println("u choose no");
//                return;
//            }
//            if (anserOverwrite.equalsIgnoreCase("overWRite")) {
//                try {
//                    BufferedReader bf = new BufferedReader(new FileReader(fileInput));
//                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outputPath));
//                    String line;
//                    int linkedListIndex = 0;
//                    while ((line = bf.readLine()) != null) {
////                        if (line == null) {
////                            return products;
////                        }
//                        String[] list = line.split(", | \\W ");
//                        productCode = list[0];
//                        productName = list[1];
//                        manufacturer = list[2];
//                        price = Integer.parseInt(list[3]);
//                        describe = list[4];
//                        objectOutputStream.writeObject(new Product(productCode, productName, manufacturer, price, describe));
//                        linkedListIndex++;
//                        objectOutputStream.flush();
//                    }
//                    objectOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("u choose overwrite");
//                System.out.println("wrote products");
//                return;
//            }
//            if (anserOverwrite.equalsIgnoreCase("y")) {
//                try {
//                    BufferedReader bf = new BufferedReader(new FileReader(fileInput));
//                    FileOutputStream fileOutputStream = new FileOutputStream(outputPath, true);
//                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream){
//                        @Override
//                        protected void writeStreamHeader() throws IOException {
//                            reset();
//                        }
//                    };
//                    String line;
//                    int linkedListIndex = 0;
//                    while ((line = bf.readLine()) != null) {
////                        if (line == null) {
////                            return products;
////                        }
//                        String[] list = line.split(", | - ");
//                        productCode = list[0];
//                        productName = list[1];
//                        manufacturer = list[2];
//                        price = Integer.parseInt(list[3]);
//                        describe = list[4];
//                        objectOutputStream.writeObject(new Product(productCode, productName, manufacturer, price, describe));
//                        linkedListIndex++;
//                        objectOutputStream.flush();
//                    }
//                    objectOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("u choose yes");
//            }
//        }
//        System.out.println("wrote products");
//        return;
//    }

    public static void main(String[] args) {
        ReadProduct read = ReadProduct.getReadProduct();
        ArrayList ll = read.readFilesObject("/home/bbt/Git/java-new/ManagerProducts/files/Products.md");
    }
}
