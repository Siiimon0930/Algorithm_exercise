package codeCapriccio.stackAndQueue;

import java.util.*;

public interface TopKFrequent {
    /*
    * 题目描述（leetcode347. 前 K 个高频元素）：
    *   给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    * 解题思路：
    *   1. 直觉(可通过，但太暴力了)：用一个map，key为nums中的元素，value为元素的频次，而后将这个map按照value进行排序（时间复杂度O（排序算法））
    *   2. 小顶堆法：先用一个map统计数组元素的出现频率，而后用一个小顶堆遍历一遍map，小顶堆存储元素为<item, frequency>，比较根据为frequency 时间复杂度O(nlogk)，logk为堆的树高
    * */

    // 1. 暴力法
//    default int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> record = new HashMap<>();
//        for(int i = 0; i < nums.length; i++){
//            record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
//        }
//        List<Integer> frequency = new ArrayList<>(record.values());
//        frequency.sort((a, b) -> b - a);
//        List<Integer> res = new ArrayList<>();
//        for(int i = 0; i < k; i++){
//            // 这层循环是傻瓜式遍历法的通过value去找key
//            for(Map.Entry<Integer, Integer> pair: record.entrySet()){
//                // !res.contains(pair.getKey())是防止有频率相同的不同数字
//                if(pair.getValue() == frequency.get(i) && !res.contains(pair.getKey())){
//                     res.add(pair.getKey());
//                    break;
//                }
//            }
//        }
//        // 这里是List<Integer> 转为 int[]
//        return res.stream()
//                .mapToInt(Integer::intValue)
//                .toArray();
//    }

    // 2. 小顶堆法
    default int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
        }

        // 通过优先级队列创建小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>((pair1, pair2) -> pair1.getValue() - pair2.getValue());
        for(Map.Entry<Integer, Integer> pair: record.entrySet()){
            if(que.size() < k)
                que.add(pair);
            else{
                if(pair.getValue() > que.peek().getValue()){    // 当前元素的频率大于堆顶元素的频率时 弹出堆顶并将当前元素加入堆中
                    que.poll();
                    que.add(pair);
                }
            }
        }
        int[] res = new int[k];
        for(int i = k-1; i >= 0; i--){ //依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            res[i] = que.poll().getKey();
        }
        return res;
    }

//    // 3. 大顶堆法(O(nlogn))
//    default int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> record = new HashMap<>();
//        for(int i = 0; i < nums.length; i++){
//            record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
//        }
//
//        // 通过优先级队列创建小顶堆
//        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>((pair1, pair2) -> pair2.getValue() - pair1.getValue());
//        for(Map.Entry<Integer, Integer> pair: record.entrySet()){
//                que.add(pair);
//        }
//        int[] res = new int[k];
//        for(int i = 0; i < k; i++){ //依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
//            res[i] = que.poll().getKey();
//        }
//        return res;
//    }
}
