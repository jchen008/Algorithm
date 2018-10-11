import java.util.*;

public class InsertionSort{
    public static void main(String[] args){
        int[] nums = new int[]{2,5,7,3,8,6,6,9};
        print(nums);
        insertion(nums);
        print(nums);
    }
    
    public static void insertion(int[] input){
        for (int i = 1; i < input.length; i++){
            int key = input[i];
            int j = i-1;
            while (j>=0 && input[j]>key){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = key;
        }
    }

    public static void print(int[] array){
        for (int a: array){
            System.out.print(a);
        }
        System.out.println();
    }
}