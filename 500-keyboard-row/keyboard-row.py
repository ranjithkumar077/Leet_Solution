class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        row1 = set("qwertyuiop")
        row2 = set("asdfghjkl")
        row3 = set("zxcvbnm")
        
        result = []
        for word in words:
            w_lower = set(word.lower())
            if w_lower <= row1 or w_lower <= row2 or w_lower <= row3:
                result.append(word)
                
        return result