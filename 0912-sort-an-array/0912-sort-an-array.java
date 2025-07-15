class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] merged = new int[right-left+1];

        int ind1=left;
        int ind2=mid+1;
        int a = 0;

        while(ind1 <= mid && ind2 <=right){
            if(arr[ind1] <= arr[ind2]){
                merged[a++] = arr[ind1++];
            }else{
                merged[a++] = arr[ind2++];
            }
        }
        while(ind1<=mid){
            merged[a++] = arr[ind1++];
        }
        while(ind2<=right){
            merged[a++] = arr[ind2++];
        }
        for(int i = 0, j = left; i<merged.length;i++, j++){
            arr[j] = merged[i];
        }
    }
}