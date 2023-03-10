package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestoreIpAddresses {
    /*
    * 题意（leetcode93. 复原 IP 地址）：
    *   给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。
    *   你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
    * 解题思路：
    *   还是分割问题，分割段数是固定的为4，每一层递归的处理需要验证是否符合ip地址的字段
    */
    private List<String> res = new ArrayList<>();
    private LinkedList<String> ip = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() == 0 || s.length() > 12) // >12 算是剪枝了
            return res;
        findIp(s, 0);
        return res;
    }

    private void findIp(String s, int startIndex){
        if(startIndex >= s.length()){   // 还是startIndex>=s.length时终止
            if(ip.size() == 4){     // ip的段数为4时才满足条件
                res.add(concatIp(ip));
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if(isIp(s.substring(startIndex, i+1))){
                ip.add(s.substring(startIndex, i+1));
            }else
                continue;
            findIp(s, i+1);
            ip.removeLast();
        }
    }

    private boolean isIp(String sub){
        Pattern ipPattern = Pattern.compile("0|[1-9][0-9]?|1[0-9]{2}|2[0-4][0-9]|25[0-5]");
        Matcher isNum = ipPattern.matcher(sub);
        if(!isNum.matches())
            return false;
        else
            return true;
    }

    private String concatIp(List<String> ip){
        StringBuilder fullIp = new StringBuilder();
        for (int i = 0; i < ip.size(); i++) {
            fullIp.append(ip.get(i));
            fullIp.append('.');
        }
        return fullIp.deleteCharAt(fullIp.length() - 1).toString();
    }
}
