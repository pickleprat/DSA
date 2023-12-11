public class FirstPositive {
    // Find minimum value to create a mapping between indices and outcomes 
    public static int findMinimum(int[] nums){
        int min = Integer.MAX_VALUE; 
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]); 
        }
        return min; 
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }

    public int firstMissingPositiveMock(int[] nums) {
        int minValue = findMinimum(nums); 
        // if min value is greater than 1 then it will always return 1
        if(minValue > 1) return 1; 
        int i = 0; int maxValue = nums.length + minValue - 1; 
        while(i < nums.length){
            // if nums[i] != i + minValue and nums[i] <= maxValue then swap
            if(nums[i] != i + minValue && nums[i] <= maxValue){
                swap(nums, i, nums[i] - minValue); 
            }
            else{
                i++; 
            }
        }

        // the first number that does not match the mapping and the number that should be at the index is positive is the answer. 
        int minPos = minValue; 
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + minValue && j + minValue > 0){
                return j + minValue; 
            }
            else if(nums[j] > 0){
                minPos = Math.min(minPos, nums[j]);
            }
        }

        // if smallest positive number does not exist or if the smallest positive number is greater than 1 then return 1. 

        if(minPos != 1) return 1; 

        else {
            return minPos; 
        }

    }
}
