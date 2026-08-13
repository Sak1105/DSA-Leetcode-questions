class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
        ans.add(intervals[0]);
        int[] curr=intervals[0];
       
        for(int[] interval:intervals){
            if(curr[1]>=interval[0]){
                curr[1]=Math.max(curr[1],interval[1]);
               
            }
            else{
                curr=interval;
                ans.add(curr);
                 
            }
        }
        return ans.toArray(new int[ans.size()][]);
        
    }
}