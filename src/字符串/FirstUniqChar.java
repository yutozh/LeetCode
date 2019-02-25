package 字符串;

import org.junit.Assert;
import org.junit.Test;

public class FirstUniqChar {
    @Test
    public void test(){
        Assert.assertEquals(0, firstUniqChar1("leetcode"));
        Assert.assertEquals(2, firstUniqChar1("loveleetcode"));
    }
    public int firstUniqChar(String s) {
        int[] index = new int[s.length()];
        for(int i = 0; i<index.length; i++){
            if(index[i] == -1){
                continue; // 已经标记和之前的值重复
            }
            int flag = 0;
            for(int j=i+1; j<index.length; j++){
                if(s.charAt(i) == s.charAt(j)){
                    index[i] = -1;
                    index[j] = -1;
                    flag = 1;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s){
        char[] arr = s.toCharArray();
        int[] cntArr = new int[26];
        for(char c : arr){
            cntArr[c - 'a'] ++;
        }
        for(int i = 0; i<arr.length; i++){
            int num = cntArr[arr[i] - 'a']; // 取s的第i个字符，找它出现的此数
            if(num==1){
                return i;
            }
        }
        return -1;
    }
}
