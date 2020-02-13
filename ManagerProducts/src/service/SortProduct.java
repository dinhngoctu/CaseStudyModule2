package service;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class SortProduct {
    public static ArrayList sortByName(ArrayList<Product> list) {
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                int result = product.getName().compareTo(t1.getName());
                return result;
            }
        });

        return list;
    }public static ArrayList sortByPrice(ArrayList<Product> list) {
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                int result = product.getPrice().compareTo(t1.getPrice());
                return result;
            }
        });

        return list;
    }public static ArrayList sortByPhone(ArrayList<Product> list) {
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                int result = product.getPhoneNumber().compareTo(t1.getPhoneNumber());
                return result;
            }
        });

        return list;
    }
}
