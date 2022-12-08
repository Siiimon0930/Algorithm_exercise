import codeCapriccio.array.Solution;

public class Main {
    public static void main(String[] args){
        int[] list = {2,3,1,2,4,3};
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, list));
    }
}
