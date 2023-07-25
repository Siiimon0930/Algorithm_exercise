package codeCapriccio.string;

/*
* leetcode剑指 Offer 05. 替换空格:请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
* 解题思路：遍历就完事了
*/
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            if(c != ' ')
                stringBuffer.append(c);
            else
                stringBuffer.append("%20");
        }
        return stringBuffer.toString();
    }
}
