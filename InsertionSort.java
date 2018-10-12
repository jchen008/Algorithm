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

/**
 * 
 * loop invariant: At the start of each iteration of the for loop , the subarray
 * A[0:i-1] consists of the elements originally in A[0:i-1], but in sorted
 * order.
 * 
 * Initialization: We start by showing that the loop invariant holds before the
 * first loop iteration, when i = 1. The subarray A[0:i-1], therefore, consists
 * of just the single element A[0] , which is in fact the original element in
 * A[0] . Moreover, this subarray is sorted (trivially, of course), which shows
 * that the loop invariant holds prior to the first iteration of the loop.
 * 
 * Maintenance: Next, we tackle the second property: showing that each iteration
 * maintains the loop invariant. Informally, the body of the for loop works by
 * moving A[i-1] , A[i-2] , A[i-3], and so on by one position to the right until
 * it finds the proper position for A[i], at which point it inserts the value of
 * A[i]. The subarray A[0:i] then consists of the elements originally in A[0:i]
 * , but in sorted order. Incrementing i for the next iteration of the for loop
 * then preserves the loop invariant. A more formal treatment of the second
 * property would require us to state and show a loop invariant for the while
 * loop. At this point, however, we prefer not to get bogged down in such
 * formalism, and so we rely on our informal analysis to show that the second
 * property holds for the outer loop.
 * 
 * Termination: Finally, we examine what happens when the loop terminates. The
 * condition causing the for loop to terminate is that i > A.length-1 = n-1.
 * Because each loop iteration increases i by 1, we must have i = n.length at
 * that time. Substituting n for i in the wording of loop invariant, we have
 * that the subarray A[0:n] consists of the elements originally in A[0:n], but
 * in sorted order. Observing that the subarray A[0:n] is the entire array, we
 * conclude that the entire array is sorted. Hence, the algorithm is correct. We
 * shall use this method of loop invariants to show correctness later in this
 * chapter and in other chapters as well.
 * 
 * 
 */