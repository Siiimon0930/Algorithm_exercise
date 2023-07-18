package codeCapriccio.hashTable;

/*
* leetcode383. 赎金信:
*   给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
*   如果可以，返回 true ；否则返回 false 。
*   magazine 中的每个字符只能在 ransomNote 中使用一次。
* 解题思路：使用int[26]数组保存magazine中各字母出现的频次
*/
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char i : magazine.toCharArray()) {
            alphabet[i -'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            if(alphabet[c - 'a'] <= 0)
                return false;
            alphabet[c - 'a'] -= 1;
        }
        return true;
    }
}
