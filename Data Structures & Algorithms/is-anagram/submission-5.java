class Solution {
    public boolean isAnagram(String s, String t) {
      
        if(s.length() != t.length() )
            return false;

        HashMap<Character,Integer> counting_Word_S = new HashMap<>();
        HashMap<Character,Integer> counting_Word_T = new HashMap<>();
        

        for(int i=0;i<s.length();i++){
            counting_Word_S.put(s.charAt(i),0);
            counting_Word_T.put(t.charAt(i),0);
        }

        if(counting_Word_S.size() != counting_Word_T.size())
            return false;
   
        for(int i=0;i<s.length();i++){
            counting_Word_S.put(s.charAt(i), counting_Word_S.get(s.charAt(i))+1);
            counting_Word_T.put(t.charAt(i), counting_Word_T.get(t.charAt(i))+1);
        }

        for(Character key_S: counting_Word_S.keySet()){
            if(!counting_Word_T.containsKey(key_S))
                return false;
        }

        for(int i=0;i<s.length();i++){

            if(!counting_Word_S.get(s.charAt(i)).equals(counting_Word_T.get(s.charAt(i))))
                return false;
        }

        return true;

    }
}
