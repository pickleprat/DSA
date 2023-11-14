public class BitonicArray {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0; int end = arr.length - 1; 
        int mid = -1; int onLeft; int onRight; 
        while(start <= end){
            mid = start + (end - start)/2; 
            onLeft = arr[mid-1]; onRight = arr[mid+1]; 
            if(arr[mid] > onLeft && arr[mid] > onRight){
                return mid; 
            }
            // Region of Ascension 
            else if(arr[mid] > onLeft && arr[mid] < onRight){
                start = mid; 
            }
            // Region of Descent
            else{
                end = mid; 
            }
        }

        return mid; 
        
    }

    public static void main(String[] args) {
        
    }
}
