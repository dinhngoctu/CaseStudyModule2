package model;

public class TestRegex {
    public static void main(String[] args) {
        String str = "a + bc - c * d / e < f > g >= h <= i == j";
        String reg = "\\s*[a-zA-Z] *";
        String reg1 = " \\S | \\S\\S ";
        String[] res = str.split(reg1);
        for (String out : res) {
            if (!"".equals(out)) {
                System.out.println(","+out+",");
            }
        }
    }
}
