import java.util.Arrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        //int[] ip = new int[] {13,14,15,16,17,1,2,3,4,5,6,7,8,9,10,11,12};
        int[] ip = new int[] {13,14,15,1,2,3,4,5,6,7,8,9,10,11,12};
        //int[] ip = new int[] {5,6,7,8,9,10,11,12,13,14,15,1,2,3,4};
        //int[] ip = new int[] {3,1,2};
        int searchElement = 10;
        rotatedBSearch(ip,searchElement);
    }

    static int rotatedBSearch(int[] input, int searchElement) {
        int rotatedIndex = findRotatedIndex(input);
        System.out.println(rotatedIndex);
        int searchElementIndex;
        if(input[0] <= searchElement && searchElement <= input[rotatedIndex]) {
            searchElementIndex = doBinarySearch(input,0,rotatedIndex,searchElement);
        } else if(input[rotatedIndex] <= searchElement && searchElement <= input[input.length-1]) {
            searchElementIndex = doBinarySearch(input,rotatedIndex,input.length-1,searchElement);
        } else {
            searchElementIndex = -1;
            return -1;
        }
        return searchElementIndex;
    }

    static int findRotatedIndex(int[] input) {
        int st_ind = 0;
        int end_ind = input.length-1;
        int mid_ind = (end_ind+st_ind)/2;
        int st_v;
        int end_v;
        int mid_v;
        //end_ind-st_ind>1 to make sure to come out of infinite loop case
        while(end_ind-st_ind>1) {
            mid_ind = (end_ind+st_ind)/2; // ((end_ind-st_ind)/2)+st_ind is equivalent to (end_ind+st_ind)/2
            st_v = input[st_ind];
            end_v = input[end_ind];
            mid_v = input[mid_ind];
            if(st_v > mid_v) {
                // rotated element index is in the left side
                end_ind = mid_ind;
            } else if(mid_v > end_v) {
                // rotated element index is in right side
                st_ind = mid_ind;
            } 
        }
        return mid_ind;
    }

    static int doBinarySearch(int[] input,int st_ind,int end_ind,int searchElement) {
        int mid_ind = (end_ind+st_ind)/2;
        int mid_v = input[mid_ind];
        while(st_ind<=end_ind) {
            mid_ind = (end_ind+st_ind)/2;
            mid_v = input[mid_ind];
            System.out.println(mid_v);
            if(mid_v == searchElement) {
                System.out.println("SearchElement Found: "+searchElement+" at index: "+mid_ind);
                return mid_ind;
            } else if(mid_v > searchElement) {
                end_ind = mid_ind-1;
            } else if(mid_v < searchElement) {
                st_ind = mid_ind+1;
            }
        }
        System.out.println("SearchElement Not Found: "+searchElement);
        return -1;
    }
}
