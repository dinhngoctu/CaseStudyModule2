package model;

import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String str = "dang lam gi day dang da an chua";
        String reg = "abc";
        String REG = reg.toUpperCase();
        System.out.println(str.compareTo(reg));


    }

}
