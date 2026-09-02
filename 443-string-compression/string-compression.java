 class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
       if(chars.length==1){
        return 1;
       }
       int count=0;
       int idx=0;
       int i=0;
       while(i<n){
        char c=chars[i];
        count=0;
        while(i<n && chars[i]==c){
            i++;
            count++;
        }
        if(count==1){
            chars[idx]=c;
            idx++;
        }
        else{
            chars[idx]=c;
            idx++;
            String str=Integer.toString(count);
            for(char digit : str.toCharArray()) {
                chars[idx] = digit;
                idx++;
}
        }
       }
       return idx;
    }
}

       