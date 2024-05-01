import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] input = new int[]{9,34,2,676,4,1,2,7,234};
        System.out.println("Input Array: "+Arrays.toString(input));
        System.out.println("InsertionSorted Output: "+Arrays.toString(insertionSort(input)));
        input = new int[]{9,34,2,676,4,1,2,7,234};
        System.out.println("MergeSorted Output: "+Arrays.toString(mergeSort(input, input.length)));
    }
    // insertion sort - (0 to j-1) sorted, pick j element and compare to sorted(0 to j-1 elements) and insert in right position repeat for all j to i elements
    private static int[] insertionSort(int[] elements) {
        int key;
        for(int i=1; i<elements.length; i++) {
            key=elements[i];
            int j = i-1;
            while(j>=0 && elements[j]>key) {
                elements[j+1] = elements[j];
                j--;
            }
            elements[j+1] = key;
        }
        return elements;
    }

    private static int[] mergeSort(int[] elements,int n) {
        if(n<2)
            return elements;
        int mid = n/2; // odd 9/2=4.5 so (0,4) & (5,8) even 10/2=5 so (0,4) & (5,9)
        int[] l = new int[mid];
        int[] r = new int[n-mid];
        l = Arrays.copyOfRange(elements, 0, mid);
        r = Arrays.copyOfRange(elements, mid, n);
        mergeSort(l,l.length);
        mergeSort(r,r.length);
        //call merge function to merge the individual sorted pieces
        merge(elements,l,r,mid,n-mid);
        return elements;
    }

    private static void merge(int[] elements, int[] l, int[] r, int left, int right) {
        int i=0, j=0, k=0;
        while(i<left && j< right) {
            if(l[i]<=r[j])
                elements[k++] = l[i++];
            else elements[k++] = r[j++];
        }
        while (i<left) {
            elements[k++] = l[i++];
        }
        while (j<right) {
            elements[k++] = r[j++];
        }
    }
}
