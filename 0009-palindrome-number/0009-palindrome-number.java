class Solution {
    public boolean isPalindrome(int x) {
        String numStr = String.valueOf(x);
        StringBuilder sb = new StringBuilder(numStr);
        return numStr.equals(sb.reverse().toString());
    }
}