

public class Patterns {
    // box pattern 
    public static void squarePattern(int center){ 
        int a, b; 
        for(int i = 0; i < 2 * center + 1; i ++){
            for(int j = 0; j < 2 * center + 1; j++){
                a = (i > center) ? 2 * center - i: i; 
                b = (j > center) ? 2 * center - j: j; 
                System.out.print(Math.min(a, b) + " ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        squarePattern(8);
    }
}
