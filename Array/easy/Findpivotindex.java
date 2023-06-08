public class Findpivotindex {
    public int pivotIndex(int[] nums) {
        int sum =0; int left_sum=0;
        for(int x: nums) sum +=x;
        for(int i=0;i<nums.length; i++){
            if(left_sum==sum-left_sum-nums[i]) return i;
            left_sum += nums[i];
        }
        return -1;
    }
}
