class Solution {
    public String longestCommonPrefix(String[] strs) {
        String p = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < Math.min(p.length(), strs[i].length())) {
                if (p.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }
            p = p.substring(0, j);
        }
        return p;
    }
}