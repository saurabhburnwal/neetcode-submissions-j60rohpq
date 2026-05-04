class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = -1;
        int b = -1;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if(n % 2 == 0) {
            a = n / 2 - 1;
            b = n / 2;
        }
        else  b = n / 2;

        int[] merged = new int[b + 1];

        int  i = 0; int j = 0;
        int p = 0;
        while(b != -1) {
            if(i < n1 && j <n2) {
                if(nums1[i] < nums2[j])  {
                    merged[p] = nums1[i];
                    i++;
                }
                else {
                    merged[p] = nums2[j];
                    j++;
                } 
            }
            else if(j >= n2) {
                merged[p] = nums1[i];
                i++;
            }
            else {
                merged[p] = nums2[j];
                j++;
            }
            
            p++;
            b--;
        }
        
        if(a == -1) 
            return merged[p - 1];
        else 
            return (double) (merged[p - 1] + merged[a]) / 2;
    }
}
