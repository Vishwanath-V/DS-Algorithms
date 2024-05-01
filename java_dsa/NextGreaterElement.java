import java.util.ArrayDeque;
import java.util.Deque;

//https://www.youtube.com/watch?v=niSqYDcH7Aw -- Collection Interface in Java | Collection Interface Methods by Deepak

public class NextGreaterElement {
    public static void main(String[] args) {
        //testDeque();
        nextElement(new int[]{10,7,8,15,27,16});
    }
    private static int nextElement(int[] elements) {
        Deque<Integer> s = new ArrayDeque<>();
        int element, next;
        s.addFirst(elements[0]); // stack.push(e)
        for(int i = 1 ; i<elements.length; i++) {
            next = elements[i];
            if (s.isEmpty() == false) {
 
                // if stack is not empty, then
                // pop an element from stack
                element = s.pop();
 
                /* If the popped element is smaller than
                   next, then a) print the pair b) keep
                   popping while elements are smaller and
                   stack is not empty */
                while (element < next) {
                    System.out.println(element + " --> "
                                       + next);
                    if (s.isEmpty() == true)
                        break;
                    element = s.pop();
                }
 
                /* If element is greater than next, then
                   push the element back */
                if (element > next)
                    s.push(element);
            }
 
            /* push next to stack so that we can find next
               greater for it */
            s.push(next);
        }
        return -1;
    }

    @Deprecated
    private static void testDeque() {
        Deque<Integer> myStack = new ArrayDeque<>();
        myStack.push(1);
        myStack.push(100);
        myStack.push(56);
        myStack.addFirst(23);
        myStack.add(45);
        myStack.addLast(98);
        myStack.push(6767);
        System.out.println(myStack.toString());
    }
}
