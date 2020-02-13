package service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherLookingAt {
    public static void main(String[] args) {
        String country1 = "iran";
        String country2 = "Iraq";

        // Bắt đầu bởi I tiếp theo là ký tự bất kỳ.
        // Tiếp theo là ký tự a hoặc e.
        String regex = "^I.[ae]";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(country1);

        // lookingAt() tìm kiếm khớp phần đầu.
        System.out.println("lookingAt = " + matcher.lookingAt());
        // Trong khi matches() phải khớp toàn bộ
        System.out.println("matches = " + matcher.matches());

        // Reset matcher với text mới, country2


        System.out.println("lookingAt = " + matcher.lookingAt());
        System.out.println("matches = " + matcher.matches());
    }
}
