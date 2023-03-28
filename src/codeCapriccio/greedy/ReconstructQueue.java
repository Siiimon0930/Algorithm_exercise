package codeCapriccio.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReconstructQueue {
    /*
    * 题意（leetcode406. 根据身高重建队列）：
    *   假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
    *   请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
    * 解题思路：
    *   先按身高排递减序，而后安装k再来重新插入调整即可，不能对people直接进行插入，否则可能会重复访问同一个元素
    *   局部最优：优先按身高高的people的k来插入。插入操作过后的people满足队列属性
    *   全局最优：最后都做完插入操作，整个队列满足题目队列属性
    */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for(int[] person : people){
            queue.add(person[1], person);
        }
        return queue.toArray(new int[people.length][2]);
    }
}
