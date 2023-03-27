package codeCapriccio.greedy;

public class LemonadeChange {
    /*
    * 题意（leetcode860. 柠檬水找零）：
    *   在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
    *   每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
    *   注意，一开始你手头没有任何零钱。
    *   给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，否则返回 false。
    * 解题思路：
    */

    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[2];
        // 如果第一个就需要找钱直接返回false
        if(bills[0] != 5)
            return false;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5)
                change[0] += 1;
            else if(bills[i] == 10){
                if(change[0] <= 0)
                    return false;
                else{
                    change[0] -= 1;
                    change[1] += 1;
                }
            }else {
                // 20 找零 5 + 10
                if(change[0] > 0 && change[1] > 0){
                    change[0] -= 1;
                    change[1] -= 1;
                }
                // 20 找零 5 * 3
                else if(change[0] >= 3){
                    change[0] -= 3;
                }else
                    return false;
            }
        }
        return true;
    }
}
