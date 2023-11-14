public class MinMax {
    // Rt (3n)
    // Theta (n)
    // n - 1 if comparisons 

    public static int findMinimum(int[] arr){
        int min = arr[0]; 
        for(int i = 1; i <= arr.length - 1; i++){
            if(arr[i] < min){
                min = arr[i]; 
            }
        }
        return min; 
    }

    public static int findMaximum(int[] arr){
        int max = arr[0]; 
        for(int i = 1; i <= arr.length - 1; i++){
            if(arr[i] > max){
                max = arr[i]; 
            }
        }
        return max; 
    }
    
    // index 0 contains min, index 1 contains max 
    public static int[] findMinMaxBrute(int[] arr){

        int[] minmax = {arr[0], arr[0]}; // 2 integers 4 address.
        for(int i = 1; i <= arr.length - 1; i++){ // n + 1 comparisons
            if(arr[i] > minmax[1]){ 
                minmax[1] = arr[i]; 
            }else if(arr[i] < minmax[0]){
                minmax[0] = arr[i]; 
            }
        } // 2 n - 2 comparisons 

        // Runtime Complexity : O (n) { 4n - 1 }
        // Space complexity : theta (1) {4}

        return minmax;  
    }

    public static int[] findMinMax(int[] arr){
        int pairs = arr.length/2, size; // pairs and size 

        if(arr.length % 2 == 0) size = pairs; // 1 comparison 
        else size = pairs + 1; 
        int[] mins = new int[size], maxs = new int[size]; 

        int i = 0, j = 0; 
        while(i <= 2 * (pairs - 1)){ // [n/2 - 1]

            if(arr[i] < arr[i+1]){  // [n/2 - 1]
                mins[j] = arr[i]; 
                maxs[j] = arr[i+1]; 
            }
            else{
                mins[j] = arr[i+1]; 
                maxs[j] = arr[i]; 
            }

            i = i+2; 
            j++; 


        }

        if(arr.length % 2 != 0){
            mins[j] = arr[arr.length - 1]; 
            maxs[j] = arr[arr.length - 1]; 
        }

        int[] minmax = {findMinimum(mins), findMaximum(maxs)}; 
        return minmax; 
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 5, 2, 5, 1, 6, 7, -2, 3, 6, 8}; 
        int min = findMinimum(arr); 
        int max = findMaximum(arr); 
        int[] minmaxBrute = findMinMaxBrute(arr); 
        int[] minmax = findMinMax(arr); 

        System.out.printf("Minimum: %d & Maximum: %d\n", min, max); 
        System.out.printf("Minimum: %d & Maximum: %d by minmax function brute\n", minmaxBrute[0], minmaxBrute[1]); 
        System.out.printf("Minimum: %d & Maximum: %d by least time complexity\n", minmax[0], minmax[1]); 
    
    }
}
