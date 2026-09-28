class Solution(object):
    def maxDepth(self, s):
        depth=0
        maxdepth=0
        for ch in s:
            if ch=='(':
                depth+=1
                maxdepth=max(maxdepth,depth)
            elif ch ==')':
                depth-=1
        return maxdepth
        