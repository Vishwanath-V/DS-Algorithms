import java.util.Arrays;

class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = new int[] {3,5,6,3,7,8,9,10,12};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Search element found at index (-1 index no element found): "+bs.binarySearch(8,arr));
    }

    private int binarySearch(int searchNum, int[] sortedArr) {
        int stidx = 0;
        int endidx = sortedArr.length-1;
        while(stidx<=endidx) {
            int mididx = (endidx-stidx)/2 + stidx;
            int midv = sortedArr[mididx];
            if(midv==searchNum)
                return mididx;
            else if(midv>searchNum)
                endidx = mididx-1;
            else if(midv<searchNum)
                stidx = mididx+1;
            System.out.println(mididx+"--"+midv);
        }
        return -1;
    }
}