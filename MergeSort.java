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