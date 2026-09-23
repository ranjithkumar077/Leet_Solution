class Solution(object):
    def findSubarrays(self, nums):
        sum = set()
        for i in range(len(nums) - 1):
            total = nums[i] + nums[i + 1]
            if total in sum:
                return True
            sum.add(total)
        return False