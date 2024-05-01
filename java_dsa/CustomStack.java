public class CustomStack {
    class StackImpl {
        private int currentPointer;
        private int size;
        private String[] array;
        public StackImpl(int size) {
            array = new String[size];
            this.size = size;
            this.currentPointer = 0;
        }

        public void push(String item) {
            if (isFull())
                throw new RuntimeException("StackFull");
            array[currentPointer] = item;
            currentPointer++;
            printStack();
        }

        public String pop() {
            if(isEmpty())
                throw new RuntimeException("StackEmpty no element to pop..!!");
            currentPointer--;
            printStack();
            return array[currentPointer];
        }

        private void printStack() {
            //System.out.println("");
            for(int i = currentPointer-1; i>=0; i--) {
                System.out.print(array[i]+"\t");
            }
            System.out.println("");
        }

        boolean isEmpty() {
            return currentPointer==0 ? true : false;
        }

        boolean isFull() {
            return currentPointer > size-1 ? true : false;
        }
    }
    public static void main(String[] args) {
        System.out.println("Testing..!!");
        CustomStack cs = new CustomStack();
        CustomStack.StackImpl stk = cs.new StackImpl(5);
        stk.push("abc");
        stk.push("def1");
        stk.push("def2");
        stk.push("def3");
        stk.push("def4");
        //stk.push("def");
        //stk.printStack();
        //System.out.println(stk.pop());
        stk.pop();
        stk.push("7878");
        stk.pop();
        stk.pop();
        stk.push("123");
        //stk.printStack();
    }
}
