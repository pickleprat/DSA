class InvalidIndexException extends Exception{
    public InvalidIndexException(String errorMessage){
        super(errorMessage); 
    }
}

class StackOverFlowException extends Exception{
    public StackOverFlowException(String errorMessage){
        super(errorMessage); 
    }
}

class Array{
    private int[] arr; 
    private int upperBound, size; 

    public Array(int maxsize){
        this.arr = new int[maxsize]; 
        this.upperBound = 0; 
        this.size = 0; 
    }

    public void insert(int element, int index) throws InvalidIndexException, StackOverFlowException{
        if(index < 0 || index > this.upperBound) throw new InvalidIndexException("This index is invalid");
        if(this.upperBound >= this.arr.length) throw new StackOverFlowException("The stack is overflowing lol"); 
        for(int k = this.upperBound; k >= index; k--){
            this.arr[k+1] = this.arr[k]; 
        }

        this.arr[index] = element; 
        this.upperBound++; 
        this.size++; 
    }

    public void delete(int index) throws InvalidIndexException{
        if(index >= this.upperBound || index < 0 ) throw new InvalidIndexException("This index is invalid"); 
        for(int k = index; k < this.upperBound; k++ ){
            this.arr[k] = this.arr[k+1]; 
        }
        this.size--; 
        this.upperBound--; 

    }

    public int getSize(){
        return this.size; 
    }

    public void display(){
        System.out.print("{ ");
        for(int i = 0; i < this.upperBound; i++){
            System.out.printf("%d, ", this.arr[i]);
        }
        System.out.println("}"); 
    }

    public int linearSearch(int item){
        for(int k = 0; k < this.arr.length; k++){
            if(this.arr[k] == item) return k ;
        }

        return -1; 
    }

    public int binarySearch(int item){
        int mid = this.size/2;
        int left = 0, right = this.size-1; 
        while(left <= right){
            if(this.arr[mid] == item) return mid; 
            else if(this.arr[mid] < item){
                left = mid + 1; 
            }else{
                right = mid - 1;  
            }

            mid = (left+right)/2; 
            
        }

        return -1; 
    }
}

public class Manipulate{
    public static void main(String[] args) throws StackOverFlowException, InvalidIndexException{

        Array arr = new Array(10); 
        arr.insert(9, 0); 
        arr.insert(11, 1); 
        arr.insert(13, 2); 
        arr.insert(10, 1); 
        arr.display(); 
        System.out.println(arr.getSize()); 
        int index = arr.binarySearch(11); 
        System.out.printf("Item found at index: %d\n", index);
        
    }
    
}
