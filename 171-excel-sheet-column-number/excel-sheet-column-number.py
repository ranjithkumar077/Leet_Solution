class Solution:
    def titleToNumber(self, columnTitle):
        import string

        answer = 0

        for ch in columnTitle:
            value = string.ascii_uppercase.index(ch) + 1
            answer = answer * 26 + value

        return answer