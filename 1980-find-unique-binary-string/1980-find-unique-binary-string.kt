class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val sb = StringBuilder()
        for (s in nums.indices) {
            sb.append(if (nums[s][s] == '0') '1' else '0')
        }
        return sb.toString()
    }
}

/*
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}
 */