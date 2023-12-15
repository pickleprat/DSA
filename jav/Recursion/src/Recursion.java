import java.util.ArrayList;
import java.util.Arrays; 

public class Recursion {
    // Sum triangle array problem: https://www.geeksforgeeks.org/sum-triangle-from-array/

    public static void printTriangleArray(int[] arr, int endIndex){
        if(endIndex <= 0){
            System.out.printf("{ %d }\n", arr[endIndex]);
            return; 
        } 
        // System.out.println(Arrays.toString(arr));

        for(int i = 0; i < endIndex; i++){
            arr[i] = arr[i] + arr[i+1]; 
        }


        printTriangleArray(arr, endIndex - 1); 

        for(int i = endIndex - 1; i >= 0; i--){
            arr[i] = arr[i] - arr[i + 1]; 
        }
        
        System.out.print("{");
        for(int i = 0; i <= endIndex; i++){
            System.out.printf(" %d", arr[i]);
        }
        System.out.println(" }");        
    }

    public static int sumDigits(int n){
        if(n == 0) return 0; 
        return n % 10 + sumDigits(n / 10); 
    }

    public static int countZeroes(int n, int count){
        if(n == 0) return count; 
        if(n % 10 == 0) {
            return countZeroes(n / 10, count+1); 
        }

        return countZeroes(n / 10, count); 
    }

    public static int reverseDigits(int number){
        if(number == 0){
            return 0; 
        }
        int base = (int)Math.pow(10, (int)Math.log10(number)); 
        return (number % 10) * base + reverseDigits(number/10);  
    }

    public static ArrayList<Integer> findAllInstances(int[] arr, int index, int target){
        ArrayList<Integer> ls = new ArrayList<>(); 
        if(index < 0){
            return ls; 
        }

        if(arr[index] == target){
            ls.add(index); 
        }

        ls.addAll(findAllInstances(arr, index-1, target)); 
        return ls; 

    }

    public static int findPivot(int[] nums, int startIndex, int endIndex){
        int midIndex = startIndex + (endIndex - startIndex)/2; 
        if(startIndex + 1 == endIndex) return endIndex; 
        else if(startIndex >= endIndex) return midIndex; 
        
        if(nums[midIndex] < nums[endIndex] && nums[midIndex] < nums[startIndex]){
            return findPivot(nums, startIndex, midIndex - 1);
        }
        else{
            return findPivot(nums, midIndex, endIndex); 
        }

    }

    public static void printPattern(int row, int column, int max){
        if(column > max) {
            System.out.println();
            return; 
        } 
        else if(row >= column){
            printPattern(row, column+1, max); 
            System.out.print("*");
            
        }
        else{
            printPattern(row+1, 1, max);
            System.out.println();
             
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }

    public static void recursiveBubbleSort (int[] nums, int index, int endIndex){
        if(endIndex == 0) return; 
        else if(index == endIndex) {
            recursiveBubbleSort(nums, 0, endIndex-1);
        }
        else if(nums[index] > nums[index+1]){
            swap(nums, index, index +1); 
            recursiveBubbleSort(nums, index+1, endIndex);
        }
        else{
            recursiveBubbleSort(nums, index+1, endIndex);
        }
        
    }

    public static void recursiveSelectionSort(int[] nums, int index, int endIndex, int max){
        if(endIndex == 0) return; 

        if(nums[index] > nums[max]){
            max = index; 
        }

        if(index == endIndex){
            swap(nums, endIndex, max); 
            recursiveSelectionSort(nums, 0, endIndex - 1, 0); 
        }
        else{
            recursiveSelectionSort(nums, index+1, endIndex, max);
        }


    }

    public static int rotatedBS(int[] nums, int target, int startIndex, int endIndex){
        int midIndex = startIndex + (endIndex - startIndex)/2; 
        if(nums[midIndex] == target) return midIndex; 
        if(startIndex >= endIndex) return -1; 

        else if(nums[midIndex] > nums[startIndex]){
            // this means that we are in the rotated region 
            if(target > nums[startIndex] && target < nums[midIndex]){
                return rotatedBS(nums, target, startIndex, midIndex-1); 
            }

            else{ 
                return rotatedBS(nums, target, midIndex+1, endIndex); 
            }
        }

        else{ 
            if(target < nums[midIndex] || target > nums[startIndex]){
                return rotatedBS(nums, target, startIndex, midIndex - 1); 
            }
            else{
                return rotatedBS(nums, target, midIndex+1, endIndex); 
            }
            
        }

    }

    public static void main(String[] args) throws Exception {
        int[] arr = {4, 5, 6, 9, 1, 2, 3, 4}; 
        recursiveSelectionSort(arr, 0, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
        
    }
}
