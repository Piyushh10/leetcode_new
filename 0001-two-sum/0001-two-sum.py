class Solution(object):
    def twoSum(self, nums, target):
        for num in nums:
            for i in range(nums.index(num)+1,len(nums)):
                if num+nums[i]==target:
                    return [nums.index(num),i]



        