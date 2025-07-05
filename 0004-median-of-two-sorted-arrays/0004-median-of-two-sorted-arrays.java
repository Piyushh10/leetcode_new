class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int a = nums1.length;
        int b = nums2.length;
        int arr[] = new int[a+b];
        //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        System.arraycopy(nums1,0,arr,0,a);
        System.arraycopy(nums2,0,arr,a,b);
        Arrays.sort(arr);
        int n = arr.length;
        if(n%2 != 0){
            return arr[n/2];
        }else{
            return (double)(arr[n/2]+arr[(n/2)-1])/2;
        }
    }
}