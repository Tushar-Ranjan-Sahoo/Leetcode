//18. 4Sum
//        Medium
//        9.6K
//        1.1K
//        Companies
//        Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//        0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//        nums[a] + nums[b] + nums[c] + nums[d] == target
//        You may return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [1,0,-1,0,-2,2], target = 0
//        Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//        Example 2:
//
//        Input: nums = [2,2,2,2,2], target = 8
//        Output: [[2,2,2,2]]
//
//
//        Constraints:
//
//        1 <= nums.length <= 200
//        -109 <= nums[i] <= 109
//        -109 <= target <= 109

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length; // size of the array
        Set<List<Integer>> set = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {

                    // taking bigger data type
                    // to avoid integer overflow:
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target-sum;
                    if(hashset.contains(fourth)){
                        List<Integer>temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int)fourth);
                        // we need to sort these value

                        temp.sort(Integer::compareTo);
                        set.add(temp);
                    }
                    hashset.add((long)nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}
