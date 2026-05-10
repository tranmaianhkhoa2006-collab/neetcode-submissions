class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1)
            return true;

        s = s.toLowerCase();
        String s_array[] = s.split("\\s+");
        s="";
        for(int i=0;i<s_array.length;i++){
            s+= s_array[i];
        }

        int l = 0;
        int r = s.length()-1;
        while(l<r){
            while(l<r && !checker(s.charAt(l)))
                l++;

            while(l<r && !checker(s.charAt(r)))
                r--;    


            if(l<r && s.charAt(l) != s.charAt(r))
                return false;

            l++;
            r--;    
        }

        return true;
    }

    public boolean checker(char c){
        if(Character.isLetter(c) || Character.isDigit(c) )
            return true;
        return false;    
    }
}
