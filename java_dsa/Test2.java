import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(x));
        System.out.println(binarySearch(x,3));
    }

    public static int binarySearch(int[] sortedArray, int searchKey) {
        int endidx = sortedArray.length-1;
        int stidx = 0;
        while(stidx<=endidx) {
            int mididx = (endidx-stidx)/2 + stidx;
            int midVal = sortedArray[mididx];
            if(midVal == searchKey)
                return mididx;
            else if(midVal > searchKey) {
                endidx = mididx-1;
            }
            else if(midVal < searchKey) {
                stidx = mididx+1;
            } 
        }
        return -1; // searchKey not found then return index -1
    }
}
