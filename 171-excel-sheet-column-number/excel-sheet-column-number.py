class Solution(object):
    def titleToNumber(self, columnTitle):
        """
        :type columnTitle: str
        :rtype: int
        """

        ans=0
        for ch in columnTitle:
            val=ord(ch)-ord('A')+1
            ans=ans*26+val
        return ans
        