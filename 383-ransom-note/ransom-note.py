from collections import Counter

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        note_count = Counter(ransomNote)
        mag_count = Counter(magazine)
        for char, count in note_count.items():
            if mag_count[char] < count:
                return False
                
        return True