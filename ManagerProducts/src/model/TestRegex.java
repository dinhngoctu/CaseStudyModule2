package model;

import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String str = "dang làm gi day dang da an chua";
        String reg = "lam";
        String REG = reg.toUpperCase();
        System.out.println(str.contains(reg));


    }

}
