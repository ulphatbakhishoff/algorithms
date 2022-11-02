package leetcode;

import java.util.Scanner;

/**
 * @author ulfat
 **/
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        System.out.println(lengthOfLongestSubstring(input));
    }

    public static int lengthOfLongestSubstring(String s) {
        final int n = s.length();
        int len = 0;
        int[] position = new int[128];
        int ch;
        int start = 0;
        for (int end = 0; end < n; end++) {
            ch = s.charAt(end);
            start = Math.max(position[ch], start);
            len = Math.max(len, end - start + 1);
            position[ch] = end + 1;
        }
        return len;
    }
}
