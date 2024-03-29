package codeCapriccio.greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class WeeklyGame337 {
    // 1. 6319. 奇偶位数
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        boolean oddFlag = false;
        while(n > 0){
            int temp = n % 2;
            n = n / 2;
            if(temp == 1){
                if(oddFlag)
                    res[1] += 1;
                else
                    res[0] += 1;
            }
            oddFlag = !oddFlag;
        }
        return res;
    }

    // 2. 6322. 检查骑士巡视方案
    private boolean[][] used; 
    public boolean checkValidGrid(int[][] grid) {
        used = new boolean[grid.length][grid.length];
        used[0][0] = true;
        return isValid(grid, used, 0, 0);
    }
    
    private boolean isValid(int[][] grid, boolean[][] used, int row, int col){
        int tempRow, tempCol;
        // 右上1
        tempRow = row - 2;
        tempCol = col + 1;
        if(tempRow >= 0 && tempCol < grid.length && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 右上2
        tempRow = row - 1;
        tempCol = col + 2;
        if(tempRow >= 0 && tempCol < grid.length && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 右下1
        tempRow = row + 1;
        tempCol = col + 2;
        if(tempRow < grid.length && tempCol < grid.length && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 右下2
        tempRow = row + 2;
        tempCol = col + 1;
        if(tempRow < grid.length && tempCol < grid.length && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 左上1
        tempRow = row - 2;
        tempCol = col - 1;
        if(tempRow >= 0 && tempCol >= 0 && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 左上2
        tempRow = row - 1;
        tempCol = col - 2;
        if(tempRow >= 0 && tempCol >= 0 && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 左下1
        tempRow = row + 1;
        tempCol = col - 2;
        if(tempRow < grid.length && tempCol >= 0 && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 左下2
        tempRow = row + 2;
        tempCol = col - 1;
        if(tempRow < grid.length && tempCol >= 0 && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }

        return isFull(used);
    }

    private boolean isFull(boolean[][] used){
        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < used.length; j++) {
                if(used[i][j] == false)
                    return false;
            }
        }
        return true;
    }


    // 3. 6352. 美丽子集的数目
    private int res = 0;
    private LinkedList<Integer> subSet = new LinkedList<>();
    public int beautifulSubsets(int[] nums, int k) {
        backTracking(nums, k, 0);
        return res;
    }

    private void backTracking(int[] nums, int k, int startIndex){
        if(startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(isValid(subSet, k, nums[i])){
                subSet.add(nums[i]);
                res++;
                backTracking(nums, k, i+1);
                subSet.removeLast();
            }
        }
    }
    
    private boolean isValid(LinkedList<Integer> subSet, int k, int newValue){
        for (int i = 0; i < subSet.size(); i++) {
            if(newValue - subSet.get(i) == k || subSet.get(i) - newValue == k)
                return false;
        }
        return true;
    }

    // 4. 6321. 执行操作后的最大 MEX （没做出来！栈溢出，以下是网上找的题解）
    public int findSmallestInteger(int[] nums, int value) {
        //flag只用来保存取余之后的值的个数，也就是[0,value-1]
        int[] flag=new int[value];
        //暂存nums[i]用
        int temp;
        //遍历nums数组，将每个数数都和value取余，然后存放在flag中
        for(int i=0;i<nums.length;i++){
            temp=nums[i];
            //当nums[i]<0的时候，有两种情况
            //一种是value的倍数，取余直接为0，不能和不为0的合并，因为0+value直接溢出flag数组了
            //第二种取余不为0，直接加上value就行
            //当nums[i]>0的时候，直接取余就好
            //当nums[i]==0的时候，直接记录在flag中
            if(temp<0){
                if(temp%value==0){
                    temp=0;
                }else{
                    temp=temp%value+value;
                }
            }else if(temp>0){
                temp=temp%value;
            }
            flag[temp]++;
        }
        int num=0;
        int min=Integer.MAX_VALUE;
        //找到[0,value-1]中出现次数最少的数的频率，用min记录
        //并使用num记录出现次数最少的数
        for(int i=0;i<flag.length;i++){
            if(flag[i]<min){
                min=flag[i];
                num=i;
            }
        }
        //如果min为0，说明num就是我们要找的答案，否则num+value*min就是我们要找的答案
        if(min==0){
            return num;
        }else{
            return num+value*min;
        }

    }

}
