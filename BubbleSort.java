import java.util.*;

public class BubbleSort{
    public static void main(String[] args){
        int[] nums = new int[] { 2, 5, 7, 3, 8, 6, 6, 9 };
        print(nums);
        bubbleSort(nums);
        print(nums);
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++){
            for (int j = 1; j < arr.length; j++){
                if (arr[j-1]>arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    public static void print(int[] array) {
        for (int a : array) {
            System.out.print(a);
        }
        System.out.println();
    }

}