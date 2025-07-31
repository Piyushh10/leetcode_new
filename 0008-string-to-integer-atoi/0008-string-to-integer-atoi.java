class Solution {
    public int myAtoi(String s) {
        if(s==null || s.isEmpty()) return 0;

        int ind=0;
        int res=0;
        int sign=1;
        int n = s.length();

        while(ind < n && s.charAt(ind) == ' '){
            ind++;
        }

        if (ind < n && (s.charAt(ind) == '+' || s.charAt(ind) == '-')){
            sign = (s.charAt(ind) == '-') ? -1 : 1;
            ind++;
        }

        while(ind < n && Character.isDigit(s.charAt(ind))){
            int digit = s.charAt(ind) - '0';

            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            ind++;
        }
        return res * sign;
    }
}