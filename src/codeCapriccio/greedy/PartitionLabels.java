package codeCapriccio.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {
    /*
    * 题意（leetcode763. 划分字母区间）：
    *   给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
    *   注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
    *   返回一个表示每个字符串片段的长度的列表。
    * 解题思路：
    *   从前往后遍历，如果遇见的字母是之前片段出现过的，就把相同字母出现的最靠前的片段和当前字母之前的片段都放入一个片段中去（牛逼，ac了）
    *   另一种方法见代码随想录，更加妙
    */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[][] alphabet = new int[26][2];  // 保存26个字母出现的最早的片段数，和该片段的起始index
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            // 当前字母没在之前的片段出现时，片段数加1，alphabet更新
            if(alphabet[index][0] == 0){
                segmentCount++;
                alphabet[index][0] = segmentCount;
                alphabet[index][1] = i;
            }else{  // 若是出现过， 最早出现的片段和当前字母直接的片段合并，片段数变为最早出现的片段
                segmentCount = alphabet[index][0];
                for (int j = 0; j < alphabet.length; j++) {
                    if(alphabet[j][0] > segmentCount){
                        alphabet[j][0] = alphabet[index][0];
                        alphabet[j][1] = alphabet[index][1];
                    }
                }
            }
        }
        // 收取答案
        Arrays.sort(alphabet, (a, b) -> a[0] - b[0]);
        int cur_segment = 0;
        int cur_segment_index = 0;
        for (int i = 0; i < alphabet.length ; i++) {
            if(alphabet[i][0] != cur_segment){
                if(cur_segment != 0)
                    res.add(alphabet[i][1] - cur_segment_index);
                cur_segment = alphabet[i][0];
                cur_segment_index = alphabet[i][1];
            }
        }
        // 收取最后一个片段
        res.add(s.length() - cur_segment_index);
        return res;

    }
}
