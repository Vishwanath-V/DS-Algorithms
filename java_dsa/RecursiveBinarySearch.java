public class RecursiveBinarySearch {
    public static void main(String[] args) {
        System.out.println("Element Found: "+binarySearch(20,new int[]{10,20,30,40,50},0,4));
    }

    private static boolean binarySearch(int x, int[] array, int stidx, int endidx) {
        if(stidx <= endidx) {
            int mididx = (endidx-stidx)/2 + stidx;
            if(array[mididx] == x) return true;
            else if(array[mididx] > x) return binarySearch(x,array,stidx,mididx-1);
            else return binarySearch(x, array, mididx+1, endidx);
        }
        return false;
    }
}
