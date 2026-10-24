class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totmul = 1;
        int cnt0 = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                cnt0++;
            else
                totmul*=nums[i];
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(cnt0 > 1)
                    ans[i]=0;
                else
                    ans[i]=totmul;
            }
            else{
                if(cnt0 > 0)
                    ans[i]=0;
                else
                    ans[i]=totmul/nums[i];
            }
        }
        return ans;
    }
}  
