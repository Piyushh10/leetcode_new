class Solution {
    public int strStr(String haystack, String needle) {
        int ans = -1;
        for(int i = 0; i<=haystack.length()-needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                ans=i;
                for(int j = i; j<i+needle.length();j++){
                    if(haystack.charAt(j) != needle.charAt(j-i)){
                        ans=-1;
                        break;
                    }
                }
            }
            if(ans!= -1){
                    break;
                }
        }
        return ans;
    }
}