import java.util.Arrays; 
import java.lang.Math; 

public class CycleSort {
    private int[] arr; 

    public CycleSort(int[] elements){
        this.arr = elements; 
    }

    private void swap(int i, int j){
        int temp = this.arr[i]; 
        this.arr[i] = this.arr[j]; 
        this.arr[j] = temp; 
    }

    public int getIndex(int element){
        return (int) Math.sqrt(element); 
    }
    
    public int getElement(int index){
        return (int) Math.pow(index, 2); 
    }

    public void create(){
        for(int i = 0; i < this.arr.length; i++){
            this.arr[i] = this.getElement(i); 
        }
    }

    public void cycleSort(){
        int i = 0; 
        while(i < this.arr.length){
            if(this.arr[i] != this.getElement(i)){
                this.swap(i, this.getIndex(this.arr[i])); 
            }
            else{
                i++; 
            }
        }
    }

    public void display(){
        System.out.println(Arrays.toString(this.arr));
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 1, 0}; 
        CycleSort obj = new CycleSort(arr); 
        obj.display(); 
        obj.cycleSort();
        obj.display();
    }


}
