class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];
        int dup = -1, missing = -1;
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 2) {
                dup = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }
        return new int[]{dup, missing};
    }
}