class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs.length==1){
            List<List<String>> solution = new ArrayList<>();
            List<String> leafSolution = new ArrayList<>();
            leafSolution.add(strs[0]);
            solution.add(leafSolution);
            return solution;
        }
       
        List<List<String>> solution = new ArrayList<>();
        HashMap<String,Boolean> flag = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            flag.put(strs[i],false);
        }

        for(int i=0;i<strs.length;i++){
            List<String> leaf = new ArrayList<>();
            if(!flag.get(strs[i])){
                flag.put(strs[i],true);
                leaf.add(strs[i]);

                if(i==strs.length-1){
                    solution.add(leaf);
                    continue;
                }
            }
            else continue;

            for(int j=i+1;j<strs.length;j++){
                if(this.isAnagram(strs[i],strs[j])){
                    leaf.add(strs[j]);
                    flag.put(strs[j],true);
                } 
            }

            solution.add(leaf);
        }

        return solution;
    }

    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length())
            return false;

        int[] latinChar = new int[26];
        for(int i=0;i<s.length();i++){
            latinChar[s.charAt(i)-'a']++;
            latinChar[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(latinChar[i]!=0)
                return false;
        }

        return true;     
    }
}
