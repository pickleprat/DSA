public class RotatedArray {

    public static int agnosticBinarySearch(int[] nums, int target, int startIndex, int endIndex){
        boolean isAscending = (nums[startIndex] < nums[endIndex]); 
        int midIndex = -1; 
        while(startIndex <= endIndex){
            midIndex = startIndex + (endIndex - startIndex)/2; 
            if(nums[midIndex] == target){
                return midIndex; 
            }

            else if((nums[midIndex] > target && isAscending) || (nums[midIndex] < target && !isAscending)){
                endIndex = midIndex - 1; 
            }

            else{
                startIndex = midIndex + 1; 
            }
        }

        return -1; 
    }

    public static int getPivot(int[] nums){
        int startIndex = 0; int endIndex = nums.length - 1; 
        int midIndex = -1; 
        while(startIndex <= endIndex){
            midIndex = startIndex + (endIndex - startIndex)/2; 
            if(startIndex == midIndex){
                return (nums[startIndex] > nums[endIndex]) ? startIndex : endIndex; 
            }
            else if(nums[midIndex] < nums[startIndex]){
                // this means that we are in the right part of the rotated array
                // it implies that the pivot could be start and mid - 1
                endIndex = midIndex - 1; 

            }
            else {
                // this implies that we are in the rotated part of the array
                // pivot could be in mid to end and could be the mid itself
                startIndex = midIndex; 
            }
        }

        return midIndex; 
    }
    // this code is implementation of binary search algorithm in a k-rotated array
    public int search(int[] nums, int target){
        int startIndex = 0; int endIndex = nums.length - 1; 
        int pivotIndex = getPivot(nums); 
        int targetIndex = agnosticBinarySearch(nums, target, startIndex, pivotIndex); 
        if(targetIndex == -1 && pivotIndex != endIndex) targetIndex = agnosticBinarySearch(nums, target, pivotIndex + 1, endIndex); 
        return targetIndex; 
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 5, 7, 0}; 
        
    }
}
