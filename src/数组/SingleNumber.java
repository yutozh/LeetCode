package 数组;

import org.junit.Assert;
import org.junit.Test;

public class SingleNumber {
    @Test
    public void test(){
        Assert.assertEquals(1, singleNumber(new int[]{2,1,2}));
        Assert.assertEquals(3, singleNumber(new int[]{1,2,1,2,3}));
    }
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}
