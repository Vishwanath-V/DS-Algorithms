import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePrefixWord {
    public static void main(String[] args) {
        String input = "asdhgfr";
        char c = 'h';

        System.out.println(input.charAt(0));

        Deque<Character> stk = new ArrayDeque<>();
        boolean pushToStack = true;
        int i = -1;
        int charFoundIndex = -1;
        for(char x : input.toCharArray()) {
            if(pushToStack) {
                stk.push(x);
                i++;
            }
            if(x==c) {
                pushToStack = false;
                System.out.println("char found at index:"+i);
                charFoundIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(charFoundIndex>-1) {
            while(!stk.isEmpty())
                sb.append(stk.pop());
            for(int m=charFoundIndex+1;m<input.length();m++) {
                sb.append(input.charAt(m));
            }
        }

        System.out.println(sb.toString());

    }
}
