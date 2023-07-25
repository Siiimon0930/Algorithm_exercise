package codeCapriccio.string;

/*
* leetcode28. 找出字符串中第一个匹配项的下标:
*   给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从0开始）。
*   如果 needle 不是 haystack 的一部分，则返回  -1 。
* 解题思路：kmp算法，暴力解法O(n2)
*/
public class StrStr {
    /**
     * decription: 暴力解法
     * @param haystack
     * @param needle
     * @return int
     */
    public int strStrVio(String haystack, String needle) {
        // 0.边界条件
        if(haystack.length() < needle.length())
            return -1;
        // 遍历
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                if(needle.equals(haystack.substring(i, i+needle.length())))
                    return i;
            }
        return -1;
    }

}
