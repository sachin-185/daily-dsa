class Solution{
    public String frequencySort(String s){
        Map<Character,Integer> m = new HashMap<>();
        for(char c : s.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        } 
        PriorityQueue<Map.Entry<Character,Integer>> p = new PriorityQueue<>((a,b) -> 
            b.getValue() - a.getValue());
        p.addAll(m.entrySet());

        StringBuilder result = new StringBuilder();
        while(!p.isEmpty()){
            Map.Entry<Character,Integer> entry = p.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return result.toString();
    }
}