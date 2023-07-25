package codeCapriccio.string;

/*
* leetcode541. 反转字符串 II:
*   给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
*   如果剩余字符少于 k 个，则将剩余字符全部反转。
*   如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
* 解题思路：
*/
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int fold = chars.length / (2 * k);
        int remain = chars.length % (2 * k);
        // 翻转前k折
        for (int i = 0; i < fold; i++) {
            reverse(chars, i*k*2, i*2*k + k -1);
        }
        if(remain >= k)
            // 剩下如果大于k，只翻转前k个
            reverse(chars, fold*2*k, fold*2*k + k -1);
        else
            // 小于k，翻转全部
            reverse(chars, fold*2*k, chars.length-1);

        return new String(chars);

    }

    public void reverse(char[] s, int left, int right){
        char temp;
        while(left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
