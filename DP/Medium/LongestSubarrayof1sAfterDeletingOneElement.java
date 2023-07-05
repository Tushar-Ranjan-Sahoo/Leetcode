//1493. Longest Subarray of 1's After Deleting One Element
//        Medium
//        2.8K
//        48
//        Companies
//        Given a binary array nums, you should delete one element from it.
//
//        Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,0,1]
//        Output: 3
//        Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
//        Example 2:
//
//        Input: nums = [0,1,1,1,0,1,1,0,1]
//        Output: 5
//        Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
//        Example 3:
//
//        Input: nums = [1,1,1]
//        Output: 2
//        Explanation: You must delete one element.
//
//
//        Constraints:
//
//        1 <= nums.length <= 105
//        nums[i] is either 0 or 1.


public class LongestSubarrayof1sAfterDeletingOneElement {
    class Solution {
        public int longestSubarray(int[] nums) {
            int maxOnes = 0;
            int currentOnes = 0;
            int prevOnes = 0;
            for (int num : nums) {
                if (num == 1) {
                    currentOnes++;
                } else {
                    maxOnes = Math.max(maxOnes, prevOnes + currentOnes);
                    prevOnes = currentOnes;
                    currentOnes = 0;
                }
            }
            maxOnes = Math.max(maxOnes, prevOnes + currentOnes);
            return maxOnes == nums.length ? maxOnes - 1 : maxOnes;
        }
    }
}
