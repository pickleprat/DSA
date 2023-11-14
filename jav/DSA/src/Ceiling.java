import java.util.Arrays; 

public class Ceiling {

    public static int searchInfiniteArray(int[] arr, int target){
        int start = 0; int end; 
        int chunksize = 1;
        int mid = -1; 

        if(arr[start] > target) return mid; 

        // find number greater than target
        int[] range = findPotentialChunk(arr, target, chunksize); 

        start = range[0]; 
        end = range[1]; 
        while(start <= end){
            mid = start + (end - start)/2; 
            if(arr[mid] == target){
                return mid; 
            }
            else if(arr[mid] < target){
                start = mid + 1; 
            }
            else{
                end = mid - 1; 
            }
        }

        return start; 

    }

    public static int[] findPotentialChunk(int[] arr, int target, int chunksize){
        int start = 0; int end = start + chunksize; 
        int[] range = {0, Integer.MAX_VALUE}; 
        while(true){
            if(arr[start] <= target && arr[end] >= target){
                range[0] = start; 
                range[1] = end; 
                return range; 
            }
            else if(arr[start] > target || arr[end] < target){
                return range; 
            }
            else{
                chunksize = 2 * chunksize; 
                start = end + 1; 
                end = start + chunksize; 
            }
        }
    }
    public static int searchApproximate(int[] arr, int target){
        int answer = -1, start = 0, end = arr.length -1, mid; 
        while(start <= end){
            mid = start + (end - start)/2; 

            if(arr[mid] == target) return mid; 
            else if(arr[mid] > target){
                answer = mid; 
                end = mid - 1; 
            }else{
                start = mid + 1; 
            }

        }

        return answer; 
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length -1; 
        int mid; 
        while(start <= end){
            mid = start +(end - start)/2; 
            if(letters[mid] > target){
                end = mid - 1; 
            }else{
                start = mid + 1; 
            }
        }

        return letters[start % letters.length]; 
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0; 
        int end = nums.length - 1; 
        int mid = -1; 
        int[] sol = {-1, -1}; 

        // search for first index
        while(start <= end){
            mid = start + (end - start)/2; 
            if(nums[mid]==target){
                sol[0] = mid; 
                end = mid - 1; 
            }
            else if(nums[mid] < target){
                start = mid + 1; 
            }
            else{
                end = mid - 1; 
            }
        }

        sol[0] = mid; 

        // find the last index 
        start = 0; end = nums.length - 1;
        mid = -1; 
        while(start <= end){

            mid = start + (end - start)/2; 
            if(nums[mid] == target){
                sol[1] = mid; 
                start = mid + 1; 
            }
            else if(nums[mid] < target){
                start = mid + 1; 
            }
            else{
                end = mid - 1; 
            }
        }

        sol[1] = mid; 

        return sol; 
    }

    public static int searchEfficient(int[] arr, int target){
        int start = 0, end = arr.length -1, mid; 
        while(start <= end){
            mid = start + (end - start)/2; 

            if(arr[mid] == target) return mid; 
            else if(arr[mid] > target){
                end = mid - 1; 
            }else{
                start = mid + 1; 
            }

        }
        return start; 
    }

    
    public static void main(String[] args) throws Exception {
        // given an array of elements find the element with the smallest possible element greater than the target 
        // int[] arr = {2, 3, 5, 9, 14, 16, 18}; 
        // int index = searchApproximate(arr, 15); 
        // int effIndex = searchEfficient(arr, 15); 
        // System.out.printf("The index is at : %d and %d\n", index, effIndex); 
        // char ch = 'a'; 
        // System.out.printf("Integer Parseint: %s\n", 'c' > 'a'); 

        int[] numbers = {1};
        int[] ans = searchRange(numbers, 1); 
        System.out.println(Arrays.toString(ans)); 

    }
}
