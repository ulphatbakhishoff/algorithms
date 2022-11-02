package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ulfat
 **/
public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int target = sc.nextInt();
        sc.close();
        String[] inputStr = s.substring(1, s.length() - 1).split(",");
        int[] input = new int[inputStr.length];
        for (int i = 0; i < inputStr.length; i++) {
            input[i] = Integer.parseInt(inputStr[i]);
        }
        System.out.println(Arrays.toString(twoSum(input, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i= 0; i<nums.length-1; i++) {
            for(int j=i+1; j< nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
