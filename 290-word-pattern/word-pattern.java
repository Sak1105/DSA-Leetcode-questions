class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] c=pattern.toCharArray();
        String[] strs=s.split(" ");
        Map<Character,String> mp=new HashMap<>();
        int n1=c.length;
        int n2=strs.length;
        Set<Character> st1=new HashSet<>();
        Set<String> st2=new HashSet<>();
        for(char ch:c){
            st1.add(ch);
        }
        for(String str:strs){
            st2.add(str);
        }

        if(n1!=n2 || st1.size()!=st2.size()){
            return false;
        }
        for(int i=0;i<n1;i++){
            if(mp.containsKey(c[i])){
                if(!(mp.get(c[i]).equals(strs[i]))){
                    return false;
                }
            }
            else{
                mp.put(c[i],strs[i]);
            }
        }
        return true;
    }
}