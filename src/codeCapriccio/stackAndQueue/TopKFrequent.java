package codeCapriccio.stackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

/*
* leetcode347. 前 K 个高频元素:
*   给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
* 解题思路：
*   1. 使用map存储，而后对整个map根据频率排序，时间复杂度主要在排序，O(nlogn)
*   2. 同样使用map存储，排序使用一个大小为k的小顶堆进行排序，时间复度O(nlogk)
*/
public class TopKFrequent {
    // 1.O(nlogn)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int[] result = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .stream().mapToInt(Integer::intValue)
                .toArray();
        return result;
    }
    // 2.O(nlogk)
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair1[1]-pair2[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){//小顶堆只需要维持k个元素有序
            if(pq.size()<k){//小顶堆元素个数小于k个时直接加
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            }else{
                if(entry.getValue()>pq.peek()[1]){//当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                    pq.poll();//弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    pq.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}


