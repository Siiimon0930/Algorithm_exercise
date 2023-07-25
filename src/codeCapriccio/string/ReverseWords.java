package codeCapriccio.string;

/*
* leetcode151. 反转字符串中的单词:
*   给你一个字符串 s ，请你反转字符串中 单词 的顺序。
*   单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
*   返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
*   注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
*   返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
* 解题思路：0、先trim，而后遍历，遇到空格则append前面的单词
*/
public class ReverseWords {
    public String reverseWords(String s) {
        // 0.去除两端的空格
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
        int right = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' '){
                stringBuilder.append(s.substring(i+1, right));
                // 单词间连续的空格只存入第一个
                if(stringBuilder.charAt(stringBuilder.length()-1) != ' ')
                    stringBuilder.append(s.charAt(i));
                right = i;
            }
            if(i == 0)
                // 最后一个单词需要单独插入
                stringBuilder.append(s.substring(0, right));
        }
        return stringBuilder.toString();
    }
}
