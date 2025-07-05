class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        int ans = -1;
        for (int num : hm.keySet()) {
            if (hm.get(num) == num) {  
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}