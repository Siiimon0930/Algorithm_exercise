package codeCapriccio.string;

public interface ReverseStr {
    /*
    * 题目描述（541. 反转字符串 II）：给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
    * 解题思路：先算有个2k，把这些fold给翻转完，然后再处理尾巴
    * 时间复杂度：O（n）
    * */
    default String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int fold = str.length / (2 * k);
        int tail = str.length % (2 * k);
        int start = 0;
        char temp;
        for(int i = 0; i < fold; i++){
            start = i * k * 2;
            for(int l = start, r = start + k - 1; l < r; l++, r--){
                temp = str[l];
                str[l] = str[r];
                str[r] = temp;
            }
        }
        if(tail < k){
            for(int i = fold * 2 * k, j = str.length - 1; i < j; i++, j--){
                temp = str[i];
                str[i] = str[j];
                str[j] = temp;
            }
        }else {
            for(int i = fold * 2 * k, j = i + k - 1; i < j; i++, j--){
                temp = str[i];
                str[i] = str[j];
                str[j] = temp;
            }
        }

        return new String(str);
    }
}
