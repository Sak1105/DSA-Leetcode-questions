class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int len=0;
        String lps="";
       for(int i=0;i<n;i++){
        int low=i;
        int high=i;
        while(low>-1 && high<n && s.charAt(low)==s.charAt(high)){
            low--;;
            high++;
             
        }
       
        if(len<high-low+1){
            len=high-low+1;
            lps=s.substring(low+1,high);
        }
        low=i-1;
        high=i;
        
        while((low>-1 && high<n)&& (s.charAt(low)==s.charAt(high))){
             
            low--;;
            high++;
           
        }
        
        if(len<high-low+1){
            len=high-low+1;
             lps=s.substring(low+1,high);
        }
       }
       return lps;
}
}

   