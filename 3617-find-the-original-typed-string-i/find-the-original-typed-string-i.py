class Solution:
    def possibleStringCount(self, word: str) -> int:
        # Count the number of adjacent identical characters
        return 1 + sum(1 for i in range(1, len(word)) if word[i] == word[i-1])