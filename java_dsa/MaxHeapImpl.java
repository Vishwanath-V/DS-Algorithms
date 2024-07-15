import java.util.Collections;

public class MaxHeapImpl {
    static class MaxHeap {
        private int[] Heap;
        private int size;
        private int maxsize;

        public MaxHeap(int maxsize) {
            this.maxsize=maxsize;
            this.size=0;
            Heap = new int[this.maxsize+1];
            Heap[0] = Integer.MAX_VALUE;
        }

        private int parent(int pos) {
            return pos/2;
        }

        /**
         * heap starts at position 1 instead of 0 then left child = 2*pos else 2*pos+1
         * @param pos
         * @return
         */
        private int leftChild(int pos) {
            return 2*pos;
        }

        /**
         * heap starts at position 1 instead of 0 then right child = 2*pos+1 else 2*pos+2
         * @param pos
         * @return
         */
        private int rightChild(int pos) {
            return (2*pos)+1;
        }

        private void swap(int firstpos, int secondpos) {
            int tmp = Heap[firstpos];
            Heap[firstpos] = Heap[secondpos];
            Heap[secondpos] = tmp;
        }

        /**
         * verify for a given pos element with its child elements to satisfy heap property parentelement > left & right child elements (maxHeap) and swap wherever not satisfied
         * @param pos
         */
        private void downHeapify(int pos) {
            if(pos >= size/2 && pos <= size)
                return; //for child nodes no need to do downheapify
            
            if(Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
                if(Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos,leftChild(pos));
                    downHeapify(leftChild(pos));
                } else {
                    swap(pos,rightChild(pos));
                    downHeapify(rightChild(pos));
                }
            }
        }

        /**
         * verfify for a given pos element with its parent element to satisfy heap property elemet < parent element and swap wherever not satisifed
         * @param pos
         */
        private void upHeapify(int pos) {
            int tmp = Heap[pos];
            while(pos>0 && tmp > Heap[parent(pos)] ) {
                Heap[pos] = Heap[parent(pos)];
                pos = parent(pos);
            }
            Heap[pos] = tmp;
        }

        /**
         * insert an element to the end of the heap and upheafily the element to satisfy heap property
         * @param element
         */
        public void insertElement(int element) {
            Heap[++size] = element;
            upHeapify(size);
        }

        /**
         * max element will be at index 1, copy last element to index 1 and downheapify from element 1 to satisfy the heap condition
         * @return
         */
        public int getMax() {
            int max = Heap[1];
            Heap[1] = Heap[size--];
            downHeapify(1);
            return max;
        }

        public void print() {
            for(int i=1;i<=(size/2);i++) {
                System.out.println(Heap[i]+": L-"+Heap[2*i]+" R-"+Heap[(2*i)+1]);
            }
        }
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(10);
        mh.insertElement(10);
        mh.insertElement(2);
        mh.insertElement(67);
        mh.insertElement(4);
        mh.insertElement(12);
        mh.insertElement(18);

        mh.print();
        System.out.println(mh.getMax());
        mh.print();

    }
}
