package 数组;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray {
    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{5,6,1,2,3,4}, rotate(new int[]{1,2,3,4,5,6}, 2));
        Assert.assertArrayEquals(new int[]{2, 1}, rotate(new int[]{1, 2}, 1));
        Assert.assertArrayEquals(new int[]{2, 1}, rotate(new int[]{1, 2}, 3));
    }
    public int[] rotate(int[] nums, int k) {
        int start = 0;
        int i = k % nums.length;
        int temp = nums[0];
        int save;

        for(int cnt=0; cnt<nums.length; cnt++){
            save = nums[i];
            nums[i] = temp;
            if(i == start){
                i++;
                start++;
                temp = nums[i % nums.length];
            }else {
                temp = save;
            }
            i = (i + k) % nums.length;
        }
        return nums;
    }
}
