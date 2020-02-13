package service;

import model.Product;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrowIphoneTinhte {

    public static final String[] TAG = "promax,iphone-se,iphone-6,6s,iphone-7,iphone-8,iphone-x,iphone-11,iphone-11-pro,xs,xs-max,7p,7-plus,7plus,8p,8plus,8-plus".split(",");
    public static final String[] NAME = "Iphone Pro Max,Iphone SE,Iphone 6,Iphone 6s,Iphone 7,Iphone 8,Iphone X,Iphone 11,Iphone 11 pro,Iphone xs,Iphone xs max,Iphone 7p,Iphone 7 plus,Iphone 7 plus,Iphone 8 plus,Iphone 8 plus,Iphone 8 plus".split(",");

    public static ArrayList<Product> crowLink() {
        ArrayList<Product> list1 = new ArrayList<>();
        ArrayList<Product> list2 = new ArrayList<>();
        ArrayList<Product> list = new ArrayList<>();
        try {
            URL url = new URL("https://nhattao.com/f/iphone.219/?type=recent&search_id=134488358&order=post_date&direction=desc");
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            String regex1 = "\t\t\t\t\t<a href=\"(.*?)\" class=\"title Tooltip\" title=\"(.*?)\">(.*?)</a>\n" +
                    "\n" +
                    "\t\t\t\t\t\n" +
                    "\n" +
                    "\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t<div class=\"Nhattao-CardItem--classifiedPrice\">\n" +
                    "\t\t\n" +
                    "\t\t\n" +
                    "\t\t\t(.*?) đ\n" +
                    "\t\t\n" +
                    "\t</div>";
            String regex2 = "\t\t\t\t\t<a href=\"(.*?)\" class=\"title\" title=\"(.*?)\">(.*?)</a>\n" +
                    "\n" +
                    "\t\t\t\t\t\n" +
                    "\n" +
                    "\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t<div class=\"Nhattao-CardItem--classifiedPrice\">\n" +
                    "\t\t\n" +
                    "\t\t\n" +
                    "\t\t\t(.*?) đ\n" +
                    "\t\t\n" +
                    "\t</div>";
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(content);
            while (matcher1.find()) {
                for (int i = 0; i < TAG.length; i++) {
                    if (matcher1.group(1).contains(TAG[i])) {
                        list1.add(new Product(matcher1.group(1), NAME[i], matcher1.group(4)));
                    }
                }

            }
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(content);
            while (matcher2.find()) {
                for (int i = 0; i < TAG.length; i++) {
                    if (matcher2.group(1).contains(TAG[i])) {
                        list2.add(new Product(matcher2.group(1), NAME[i], matcher2.group(4)));
                    }
                }
            }
            list.add(list2.get(0));
            list.add(list2.get(1));
            list.add(list1.get(5));
            list.add(list1.get(6));
            System.out.println(list);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void setNameBytag(ArrayList<Product> list) {
        for (Product product : list) {
            for (int i = 0; i < TAG.length; i++) {
                if (product.getLink().contains(TAG[i])) {
                    product.setName(NAME[i]);
                }
//               else{list.remove(product);}
            }
        }
        System.out.println(list);
    }

    public static void crowDes(Product product) {
        try {
            URL url = new URL(product.getLink());
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            content = content.replaceAll("\\n+", "");
            String regex = "<li><a href=\"tel://(.*?)\" target=\"_blank\".*?<blockquote class=\"messageText SelectQuoteContainer ugc baseHtml\">(.*?)<div class=\"messageTextEndMarker\">&nbsp;</div>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                product.setPhoneNumber(matcher.group(1));
                String desc = (matcher.group(2).replaceAll("\t", "")).replaceAll("<br />", ". ");
                product.setDescripe(desc);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main1() {
        ArrayList<Product> list = crowLink();
//        setNameBytag(list);
        Thread t1 = new Thread() {
            public void run() {
                crowDes(list.get(0));
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                crowDes(list.get(1));
            }
        };
        Thread t3 = new Thread() {
            public void run() {
                crowDes(list.get(2));
            }
        };

        Thread t4 = new Thread() {
            public void run() {
                crowDes(list.get(3));
            }
        };
        try {
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WriteProduct writeProduct = WriteProduct.getWriteProduct();
        Collections.reverse(list);
        writeProduct.writeListProducts(list);
    }

    public static void main(String[] args) {
        main1();
    }
}
