public class BitwiseFacts {
    public static int getNthBit(int num, int bitIndex){
        return num & (1 << (bitIndex - 1)); 
    }

    public static int solve(int a, int x){
        if(x <= 0) return 1; 
        int y = solve(a, x/2); 
        y *= y; 
        if(x % 2 != 0){
            y *= a; 
        }
        return y; 
    }

    public static int locateSquareRoot(int n){
        int leftIndex = 0; 
        int rightIndex = n/2; 
        int midIndex = -1; 

        while(leftIndex < rightIndex){
            midIndex = rightIndex - (rightIndex - leftIndex)/2; 
            if(midIndex * midIndex == n) return midIndex; 
            else if(midIndex * midIndex < n){
                leftIndex = midIndex + 1; 
            }
            else{
                rightIndex = midIndex - 1; 
            }

        }

        return midIndex; 
    }

    public static int countSetBits(int a){
        int count = 0; 
        while(a > 0){
            count ++; 
            a -= a & -a; 
        }

        return count; 
    }

    public static float getPreciseSqrt(float n, float precision){
        float lowerBound = 0; 
        float upperBound = n/2; 
        float potentialSqrt = -1; 

        while(lowerBound < upperBound){
            potentialSqrt = upperBound - (upperBound - lowerBound)/2; 
    
            if(Math.abs(potentialSqrt * potentialSqrt - n) <= precision){
                return potentialSqrt; 
            }
            else if(potentialSqrt * potentialSqrt < n){
                lowerBound = potentialSqrt + precision; 
            }
            else{
                upperBound = potentialSqrt - precision; 
            }

        }

        return potentialSqrt; 
    }


    public static void main(String[] args) throws Exception {
        System.out.println(getPreciseSqrt(40f, 0.01f)); 
    }
}
