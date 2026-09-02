class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        int oddc=0;
        int evenc=0;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0)
                evenc++;
            else 
                oddc++;
        }
        boolean makeEven=(oddc==0 || oddc>=2);
        boolean makeOdd=(oddc>0);
        return (makeEven || makeOdd);
        
    }
}