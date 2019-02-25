package 字符串;
import org.junit.Assert;
import org.junit.Test;

public class ReverseString {
    @Test
    public void test(){
        char[] test1 = new char []{'h','e','l','l','o'};
        reverseString(test1);
        char[] test2 = new char []{'H','a','n','n','a','h'};
        reverseString(test2);
        Assert.assertArrayEquals(test1, new char []{'o','l','l','e','h'});
        Assert.assertArrayEquals(test2, new char []{'h','a','n','n','a','H'});
    }
    public void reverseString(char[] s) {
        int headPoint = 0;
        int tailPoint = s.length - 1;
        while (headPoint < tailPoint){
            char temp = s[headPoint];
            s[headPoint] = s[tailPoint];
            s[tailPoint] = temp;
            headPoint++;
            tailPoint--;
        }
    }
}
