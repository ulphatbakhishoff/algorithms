package leetcode;

import java.util.Scanner;

/**
 * @author ulfat
 **/
public class ZigZagConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int rowCount = sc.nextInt();
        System.out.println(convert(input, rowCount));
    }

    private static String convert(String input, int rowCount) {
        if (rowCount == 1 || rowCount >=input.length()) return input;

        StringBuilder sb = new StringBuilder(input.length());
        int d = (rowCount - 1) * 2;
        for (int i = 0; i < rowCount; i++) {
            for (int j = i; j < input.length(); j += d) {
                sb.append(input.charAt(j));
                int k;
                if (i< rowCount-1 && i > 0 && (k = j + d - 2 * i) < input.length()) {
                    sb.append(input.charAt(k));
                }
            }
        }
        return sb.toString();
    }
}
