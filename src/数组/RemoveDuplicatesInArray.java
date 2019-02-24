package 数组;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesInArray {
    @Test
    public void test(){
        Assert.assertEquals(2, solution(new int[]{1, 1, 2}));
        Assert.assertEquals(5, solution(new int[]{0,0,0,1,1,1,2,2,3,3,4}));
        Assert.assertEquals(1, solution(new int[]{1}));
        Assert.assertEquals(1, solution(new int[]{1,1}));
        Assert.assertEquals(1, solution(new int[]{1,1,1}));
        Assert.assertEquals(2, solution(new int[]{1,2}));
    }
    public int solution(int[] nums){
        return solution2(nums);
    }
    public int solution1(int[] nums){
        for (int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1] && i != nums.length -1){
                int current = nums[i];
                int cnt = 0;
                // 若当前数和该位置最初的数一样，则将该数交换到数组最后，使下一位的数移到当前位置（最多替换nums.length-i次）
                while (nums[i] == current && cnt < nums.length - i){
                    int j = i;
                    // 不断的交换，使第i个数到数组最后
                    while (j<nums.length-1 ){
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                        j++;
                    }
                    cnt++;
                }
            }
        }
//        for (int i=0; i<nums.length; i++){
//            System.out.print(String.valueOf(nums[i])+',');
//        }
//        System.out.print('\n');
        for (int i=1; i<nums.length; i++){
            if(nums[i] <= nums[i-1]){
                return i;
            }
        }
        return nums.length;
    }
    public int solution2(int[] nums){
        int current = 0;
        for (int i=1; i<nums.length; i++){
           if(nums[i]>nums[current]){
               current ++;
               nums[current] = nums[i];
           }
        }
//        for (int i=0; i<nums.length; i++){
//            System.out.print(String.valueOf(nums[i])+',');
//        }
//        System.out.print('\n');
        return current+1;
    }
}
