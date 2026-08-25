class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> s=new HashSet<>();
        for(int x:candyType){
            s.add(x);
        }
        int n=candyType.length;
        int eat=n/2;
        int count=0;
        for(int i=0;i<n;i++){
            if(s.contains(candyType[i]) && count<eat){
                s.remove(candyType[i]);
                count++;
            }
            if(count==eat || s.isEmpty()){
                break;
            }

        }
        return count;
        
    }
}