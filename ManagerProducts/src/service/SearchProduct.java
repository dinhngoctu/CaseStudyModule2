package service;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SearchProduct {
    private Product product;
    private int valueSearch;

    public SearchProduct(Product product, int valueSearch) {
        this.product = product;
        this.valueSearch = valueSearch;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setValueSearch(int valueSearch) {
        this.valueSearch = valueSearch;
    }

    public Product getProduct() {
        return product;
    }

    public int getValueSearch() {
        return valueSearch;
    }

    public static ArrayList<SearchProduct> search(String s, ArrayList<Product> list) {
        ArrayList<SearchProduct> ar = new ArrayList<>();
        String s1 = s.toLowerCase();
        String[] arrS = s1.split(" ");
        for (Product product : list) {
            int value = 0;
            for (String str : arrS) {
                Pattern pattern = Pattern.compile(str);
                String info1 = product.getName() + " " + product.getDescripe() + " " + product.getPrice() + " " + product.getPhoneNumber();
                String info = info1.toLowerCase();
                Matcher matcher = pattern.matcher(info);
                while (matcher.find()) {
                    value++;
                }
            }
            if (value > 0) {
                ar.add(new SearchProduct(product, value));
            }
        }
        Collections.sort(ar, new Comparator<SearchProduct>() {
            @Override
            public int compare(SearchProduct searchProduct, SearchProduct t1) {
                return searchProduct.getValueSearch() < t1.getValueSearch() ? 1 : -1;
            }
        });
        return ar;
    }

    public static ArrayList<SearchProduct> search2(String s, ArrayList<Product> list) {
        ArrayList<SearchProduct> ar = new ArrayList<>();
        String[] arrS = s.split(" ");
        for (Product product : list) {
            int value = 0;
            for (String str : arrS) {
                String regex = "[" + String.valueOf(str.charAt(0)).toUpperCase() + String.valueOf(str.charAt(0)).toLowerCase() + "]" + str.substring(1) + "|" + str.toUpperCase() + "|" + str.toLowerCase();
                Pattern pattern = Pattern.compile(regex);
                String info = product.getName() + " " + product.getDescripe() + " " + product.getPrice() + " " + product.getPhoneNumber();
                Matcher matcher = pattern.matcher(info);
                while (matcher.find()) {
                    value++;
                }
            }
            if (value > 0) {
                ar.add(new SearchProduct(product, value));
            }
        }
        Collections.sort(ar, new Comparator<SearchProduct>() {
            @Override
            public int compare(SearchProduct searchProduct, SearchProduct t1) {
                return searchProduct.getValueSearch() < t1.getValueSearch() ? 1 : -1;
            }
        });
        return ar;
    }


//    public boolean checkNumber(String str) {
//
//    }

}
