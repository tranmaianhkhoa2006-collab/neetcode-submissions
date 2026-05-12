class Solution {
    private boolean checker(char s,char t){
        if(Math.abs(s-t) ==2 && s<t)
            return true;

        if(Math.abs(s-t) == 1 && s<t)
            return true;
        return false;        
    }

    public boolean isValid(String s) {
        if(s.length()%2!=0)
            return false;

        boolean flag1 = true;
        boolean flag2 = true;
        
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if( !checker(s.charAt(l),s.charAt(r)) ){
                flag1 = false;
                break;
            }

            l++;
            r--;
        }

        for(int i = 0;i<s.length()-1;i+=2){
            if( !checker(s.charAt(i),s.charAt(i+1)) ){
                flag2 = false;
                break;
            }
        }

        if(flag1 || flag2)
            return true;

        return false;
    }
}
