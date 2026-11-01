// optimal method
class Solution{
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] m = new int[128];
        for(char c : t.toCharArray()){
            m[c]++;
        }
        int l = 0,r=0,co=t.length();
        int min = Integer.MAX_VALUE, st=0;

        while(r < s.length()){
            char c =s.charAt(r);
            r++;
            if(m[c]>0){
                co--;
            }
            m[c]--;

            while(co==0){
                if(r-l < min){
                    min = r-l;
                    st=l;
                }
                char ch = s.charAt(l);
                l++;

                m[ch]++;
                if(m[ch]>0){ 
                    co++;
                }
            }
        }
        return min == Integer.MAX_VALUE? "" : s.substring(st,st+min);
    }
}