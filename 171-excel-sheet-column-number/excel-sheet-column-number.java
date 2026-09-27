class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0;
        for (char ch:columnTitle.toCharArray()){
            int value=ch-'A'+1;
            ans=ans*26+value;
        }
    return ans;        
    }
}