import java.util.ArrayList;

public class MissingNumbers {
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }

    public static ArrayList<Integer> missingNumbers(int[] nums){
        ArrayList<Integer> missing = new ArrayList<Integer>();
        int i = 0; 
        while(i < nums.length){
            // If the ith element is not equal to i + 1 and if the rightful position of the integer at ith 
            // index is not having a same element then swap 
            if(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
            else{
                i++; 
            }
        } 

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1) missing.add(j+1);
        }

        return missing; 
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1}; 
        ArrayList<Integer> missingNums = missingNumbers(nums); 
        System.out.println(missingNums.toString()); 
    }
}
