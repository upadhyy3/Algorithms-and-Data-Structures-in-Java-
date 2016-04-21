package Arrays;

public class MedianOfSorted {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return 0.0;
        int m = nums1.length;
        int n= nums2.length;
        int midElement = (m+n)/2;
        if((m+n)%2 == 0){
           return (findMedianSortedArrays(nums1,nums2,0,m-1,0,n-1,midElement-1) +  findMedianSortedArrays(nums1,nums2,0,m-1,0,n-1,midElement))*0.5;
        }
        else{
            return findMedianSortedArrays(nums1,nums2,0,m-1,0,n-1,midElement);
        }
    }
    
   public double findMedianSortedArrays(int[] nums1,int[] nums2,int n1start,int n1end,int n2start,int n2end,int k)
    {
        int l1 = n1end - n1start +1;
        int l2 = n2end - n2start +1;
        if(l1 == 0) return nums2[n2start+k];
        if(l2 == 0) return nums1[n1start+k];
        
        if(k==0)
        {
            return (nums1[n1start]<nums2[n2start])?nums1[n1start]:nums2[n2start];
        }
        int mid1 = (l1 * k)/(l1+l2);
        int mid2 = k-mid1-1;
        mid1 = n1start + mid1;
        mid2 = n2start + mid2;
        if(nums1[mid1] > nums2[mid2])
        {
             k = k-(mid2-n2start+1);
            n1end = mid1;
            n2start = mid2+1;
           
        }
        else
        {
            k=k-(mid1-n1start+1);
            n1start = mid1+1;
            n2end = mid2;
            
        }
        return findMedianSortedArrays(nums1,nums2,n1start,n1end,n2start,n2end,k);
    }
}
