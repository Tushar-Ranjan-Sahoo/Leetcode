//16. 3Sum Closest
//        Medium
//        9.3K
//        484
//        Companies
//        Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//        Return the sum of the three integers.
//
//        You may assume that each input would have exactly one solution.
//
//
//
//        Example 1:
//
//        Input: nums = [-1,2,1,-4], target = 1
//        Output: 2
//        Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//        Example 2:
//
//        Input: nums = [0,0,0], target = 1
//        Output: 0
//        Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
//
//
//        Constraints:
//
//        3 <= nums.length <= 500
//        -1000 <= nums[i] <= 1000
//        -104 <= target <= 104



public class threesumclosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        var closest = 0;

        for (int i =0, n = nums.length, minDiff = Integer.MAX_VALUE; i< n-2 ; i++){
            for(int j = i+1, k = n- 1 ; j<k;){
                var sum = nums[i]+ nums[j]+ nums[k];
                if (sum == target)
                    return target;
                else if ( sum<target)
                    j++;
                else
                    k--;
                var diff = Math.abs(target - sum);
                if (diff < minDiff){
                    minDiff = diff;
                    closest = sum;

                }
            }
        }
        return closest;
    }
}
