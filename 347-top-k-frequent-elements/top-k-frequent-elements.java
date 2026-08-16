class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int x:nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
     
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(mp.entrySet());
        list.sort((a,b)-> Integer.compare(b.getValue(),a.getValue()));
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=list.get(i).getKey();
        }
        return ans;
    }
}