package 数组;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class TwoNumberSum {
    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{0, 1}, solution(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 2}, solution(new int[]{3, 2, 4}, 6));
    }
    public int[] solution(int[] nums, int target){
        return solution1(nums, target);
    }
    public int[] solution1(int[] nums, int target){
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            m.put(target-nums[i], i);
        }
        for (int i=0; i<nums.length; i++){
            if(m.containsKey(nums[i]) && m.get(nums[i]) != i){
                return new int[]{i, m.get(nums[i])};
            }
        }
        return new int[0];
    }
}
