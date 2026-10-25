class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int min=prices[0];
        for(int s : prices){
            max=Math.max(max,s-min);
            min=Math.min(min,s);
        }
        return max;
    }
}
