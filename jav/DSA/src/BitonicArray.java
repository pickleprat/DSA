class MountainArray{
    public int length(){
        return -1; 
    }

    public int get(int index){
        return index; 
    }
}

public class BitonicArray {
    public int findInMountainArrayWrong(int target, MountainArray mountainArr) {

        int startIndex = 0; int endIndex = mountainArr.length() - 1; 
        int midIndex = -1; int onLeft, onRight; 
        while(startIndex <= endIndex){
            midIndex = startIndex + (endIndex - startIndex)/2; 
            onLeft = mountainArr.get(midIndex - 1); 
            onRight = mountainArr.get(midIndex + 1); 

            if(mountainArr.get(midIndex) == target){
                return midIndex;
            }
            else if(mountainArr.get(midIndex) > target){
                if(mountainArr.get(midIndex) < onLeft && mountainArr.get(midIndex) > onRight){
                    // This indicates you are on the decreasing side of things. 
                    // Your mid is also greater than target this means you need to reduce your search region by moving the start to mid
                    startIndex = midIndex + 1; 
                }
                else{
                    // indicates that you are on the increasing side of things which means restricting by moving the end to mid - 1
                    endIndex = midIndex - 1; 
                }
            }
            else{

                if(mountainArr.get(midIndex) < onLeft && mountainArr.get(midIndex) > onRight){
                    // This indicates you are on the decreasing side of things. 
                    // Your target is now greater than midIndex this means you need to reduce your search region by moving the start to mid
                    endIndex = midIndex - 1; 
                }
                else{
                    // indicates that you are on the increasing side of things which means restricting by moving the end to mid - 1
                    startIndex = midIndex + 1; 
                }

            }

        }

        return -1; 
        
    }

    

    public static int peakIndexInMountainArray(int[] arr) {
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

    public static int agnosticBinarySearch(MountainArray mountainArr, int startIndex, int endIndex, int target){
        boolean isAscending = (mountainArr.get(startIndex) < mountainArr.get(endIndex)); 
        int midIndex = -1; int midElement = -1; 
        while(startIndex <= endIndex){
            // target found
            midIndex = startIndex + (endIndex - startIndex)/2; 
            midElement = mountainArr.get(midIndex); 

            if(midElement == target){
                return midIndex; 
            }
            
            else if((midElement < target && isAscending) || (midElement > target && !isAscending)){
                // if it is ascending and midIndex > target then move the start to mid + 1
                // or if it is descending and midIndex < target
                startIndex = midIndex + 1; 

            }
            else{
                // if it is ascending and midIndex < target or if it is descending and midIndex > target move end to midIndex - 1; 
                endIndex = midIndex - 1; 
            }
        }

        return -1; 
    }

    public static int findPeakMountainArray(MountainArray mountainArr){
        int startIndex = 0; int endIndex = mountainArr.length() - 1; 
        int midIndex = -1; int onLeft, onRight; int midElement = -1; 

        while(startIndex <= endIndex){
            midIndex = startIndex + (endIndex - startIndex)/2; 
            midElement = mountainArr.get(midIndex); 
            onLeft = mountainArr.get(midIndex - 1); onRight = mountainArr.get(midIndex+1); 
            
            // found the peak if the element is in between two lower points
            if(midElement > onLeft && midElement > onRight){
                return midIndex; 
            }

            // In the region of Ascension if right element is greater and left element is lesser 
            // this means that we need to move the startIndex to midIndex + 1; 
            else if(midElement < onRight){
                startIndex = midIndex + 1;
            }

            // otherwise we move the endIndex to mid
            else{
                endIndex = midIndex; 
            }
            
        }

        return midIndex; 
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakMountainArray(mountainArr); 
        int startIndex = 0; int endIndex = mountainArr.length() - 1; 
        int foundIndex = agnosticBinarySearch(mountainArr, startIndex, peakIndex, target);
        if(foundIndex == -1){
            foundIndex = agnosticBinarySearch(mountainArr, peakIndex+1, endIndex, target); 
        } 

        return foundIndex; 

    
    }



    public static void main(String[] args) {
        
    }
}
