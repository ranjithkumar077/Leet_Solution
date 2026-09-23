class Solution(object):
    def canPartition(self, nums):
        if len(nums) < 1 or len(nums) > 200 or len(nums) == 1:
            return False
        for i in nums:
            if i < 1 or i > 100:
                return False
        total = sum(nums)
        if total % 2 != 0:
            return False
        target = total // 2
        dp = [False] * (target + 1)
        dp[0] = True
        for num in nums:
            for j in range(target, num - 1, -1):
                dp[j] = dp[j] or dp[j - num]
        return dp[target]