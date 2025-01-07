class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));


          
        for(int i = 0; i < words.length; i++) {
            String sub = words[i];  
            for(int j = i + 1; j < words.length; j++) {
                if (words[j].contains(sub)) {
                    res.add(sub);
                    break;
                }
            }
        }
        return res;
    }
}