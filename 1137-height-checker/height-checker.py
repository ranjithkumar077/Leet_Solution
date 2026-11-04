class Solution:
    def heightChecker(self, heights: list[int]) -> int:
        expected = sorted(heights)
        count = 0
        for h, e in zip(heights, expected):
            if h != e:
                count += 1
                
        return count