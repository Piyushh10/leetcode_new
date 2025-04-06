class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max = 0;

        while(start < end){
            int l = Math.min(height[start], height[end]);
            int b = end - start;
            int area = l*b;
            max = Math.max(max, area);

            if(height[end] > height[start]){
                start++;
            }else{
                end--;
            }
        }
        return max;
    }
}

/*

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int startB = 0;
        int endB = 0;
        int startL = 0;
        int endL = 0;
        int area = 0;
        int max = 0;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1;j<n;j++){
                startB = i;
                endB = j;
                startL = height[i];
                endL = height[j];
                area = (endB-startB)*(Math.min(startL, endL));
                max = Math.max(max, area);
            }
        }
        return max;
    }
}

*/