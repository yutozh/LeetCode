package 字符串;

import org.junit.Assert;
import org.junit.Test;

public class MyAtoi {
    @Test
    public void test() {
        Assert.assertEquals(42, myAtoi("42"));
        Assert.assertEquals(-42, myAtoi("   -42"));
        Assert.assertEquals(4193, myAtoi("4193 with words"));
        Assert.assertEquals(0, myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));
        Assert.assertEquals(0, myAtoi("+-2"));
    }

    public int myAtoi(String str) {
        char[] charArr = str.toCharArray();
        int res = 0;
        int sign = 1; // 正负号
        boolean overflow = false;
        boolean gotted = false;
        for (char c : charArr) {
            if (c == ' ' && !gotted) {
                continue;
            } else if (c == '+' && !gotted) {
                gotted = true;
            } else if (c == '-' && !gotted) {
                gotted = true;
                sign = -1;
            } else if ((c - '0') <= 9 && (c - '0') >= 0) {
                // 当前值为214748364时，检查目前读取到的值
                // 当前值大于214748364时，必然溢出
                // 否则，不溢出
                if (res == 214748364 && (c - '0') >= 8) {
                    overflow = true;
                    break;
                } else if (res > 214748364) {
                    overflow = true;
                    break;
                }
                res = 10 * res + (c - '0');
                gotted = true;
            } else {
                break;
            }
        }
        if (!gotted) {
            return 0;
        } else if (overflow && sign == 1) {
            return 2147483647;
        } else if (overflow && sign == -1) {
            return -2147483648;
        } else {
            return sign * res;
        }
    }
}
