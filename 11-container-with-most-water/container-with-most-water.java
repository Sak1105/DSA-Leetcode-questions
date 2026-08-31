class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxw=0;
        int minb=height[left];
        while(left<right){
            minb=Math.min(height[left],height[right]);
            int currwt=minb*(right-left);
            maxw=Math.max(currwt,maxw);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxw;
    }
}