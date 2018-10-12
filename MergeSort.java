import java.util.*;

public class MergeSort{
    public static void main(String[] args){
        int[] nums = new int[] { 2, 5, 7, 3, 8, 6, 6, 9 };
        print(nums);
        mergeSort(nums,0, nums.length-1);
        print(nums);
    }

    public static void merge(int[] arr, int p, int q, int r){
        // Separate two arrays
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] l1 = new int[n1];
        int[] l2 = new int[n2];
        for (int i = 0 ; i < n1; i++){
            l1[i] = arr[p+i];
        }
        for (int i = 0; i < n2; i++){
            l2[i] = arr[q+1+i];
        }

        // Merge the two arrays
        int i = 0, j = 0, k = p;
        while (i < n1 && j < n2){
            if (l1[i] < l2[j]){
                arr[k] = l1[i];
                i++;
            }else{
                arr[k] = l2[j];
                j++;
            }
            k++;
        }

        // add the rest of l1 or l2
        while (i < n1){
            arr[k++] = l1[i++];
        }
        while (j < n2){
            arr[k++] = l2[j++];
        }
    }

    public static void mergeSort(int[] arr, int p, int r){
        if (p<r){
            int q = (p+r)/2;
            mergeSort(arr, p, q);
            mergeSort(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }

    public static void print(int[] array) {
        for (int a : array) {
            System.out.print(a);
        }
        System.out.println();
    }
}

/**
 * loop invariant: At the start of each iteration of the for loop, the subarray
 * A[p:k-1] contains the k-p smallest elements of L[1:n1+1] and R[1:n2+1], in
 * sorted order. Moreover, L[i] and R[j] are the smallest elements of their
 * arrays that have not been copied back into A.
 * 
 * Initialization: Prior to the first iteration of the loop, we have k D p, so
 * that the subarray A[p:k-1] is empty. This empty subarray contains the k-p=0
 * smallest elements of L and R, and since i=j=1, both L[i] and R[j] are the
 * smallest elements of their arrays that have not been copied back into A.
 * 
 * Maintenance: To see that each iteration maintains the loop invariant, let us
 * first suppose that L[i] R[j]. Then L[i] is the smallest element not yet
 * copied back into A. Because A[p:k-1] contains the k-p smallest elements,
 * after line 14 copies L[i] into A[k] , the subarray A[p:k] will contain the
 * k-p+1 smallest elements. Incrementing k (in the for loop update) and i (in
 * line 15) reestablishes the loop invariant for the next iteration. If instead
 * L[i] > R[j] , then lines 16–17 perform the appropriate action to maintain the
 * loop invariant.
 * 
 * Termination: At termination, k = r + 1. By the loop invariant, the subarray
 * A[p:k-1] , which is A[p:r] , contains the k-p=r-p+1 smallest elements of
 * L[1:n1+1] and R[1:n2+1] , in sorted order. The arrays L
 * and R together contain n1+n2+2=r-p+3 elements. All but the two largest have been
 * copied back into A, and these two largest elements are the sentinels.
 * 
 */