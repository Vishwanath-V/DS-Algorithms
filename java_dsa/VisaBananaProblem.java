/***
Love for banana

Dolly loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Dolly can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Dolly likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
 
Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

***/

public class VisaBananaProblem {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        
        int[] piles = new int[] {30,11,23,4,20};
        int hours = 7;
        //int no_f_piles = piles.length;
        
        int min_of_k = 1;
        int max_of_k = findMaxbananasInPiles(piles);
        
        // loop from min
        System.out.println(minKLoop(min_of_k,max_of_k,piles,hours));
        
        
    }
    
    static int findMaxbananasInPiles(int[] piles) {
        int max = 0;
        for (int i =0 ; i<piles.length;i++) {
            if(max<=piles[i])  {
                max=piles[i];
            }
        }
        return max;
    }
    
    static int minKLoop(int min_k,int max_k, int[] piles, int h) {
        //loop through min_k to max_k with step as 1
        // for max_k = 11 then 
        //piles = Arrays.sort(piles);
        double hours=0;
        for(int k = min_k; k<= max_k; k++) {
            hours = 0;
            for(int i=0; i<piles.length; i++) {
                hours = hours+Math.ceil(1.0*piles[i]/k);
            }
            if(hours<=h) {
                return k; // above this
            }
        }
        return -1;
    }
}
