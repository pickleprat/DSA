import java.lang.StringBuilder; 
import java.util.Arrays; 

public class Sort {

    public static void swap(int[] nums, int leftIndex, int rightIndex){
        int temp = nums[leftIndex]; 
        nums[leftIndex] = nums[rightIndex]; 
        nums[rightIndex] = temp; 
    }

    public static String selectionSort(int[] nums) {
        StringBuilder sortedSequence = new StringBuilder(); 
        for(int i = 0; i < nums.length - 1; i++){
            // i being the index to be swapped with in the end
            int minIndex = i; 
            for(int j = i; j < nums.length; j++){
                if(nums[j] < nums[minIndex]) minIndex = j; 
            }
            // swap the smallest number with the current index
            swap(nums, i, minIndex); 
            sortedSequence.append(Integer.toString(nums[i])); 
        }
        sortedSequence.append(Integer.toString(nums[nums.length - 1])); 
        return sortedSequence.toString(); 
        
    }

    public static void insertionSort(int[] nums){
        // start from index 0 to index n - 2 to form sub arrays 
        for(int i = 0; i < nums.length - 1; i++){
            int j = i + 1; 
            // as long as the max of the sub sorted array preceeding j is greater than the element j or
            // if j = 0 because j = 0 would make j - 1 = -1 which is indexOutOfBounds 
            while(j > 0 && nums[j] < nums[j - 1]){
                swap(nums, j, j - 1); 
                j--; 
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-5, -3}; 
        // String sortedString = selectionSort(nums); 
        // System.out.println(Arrays.toString(nums));
        // System.out.println(sortedString);
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));

        
    }

}

    
