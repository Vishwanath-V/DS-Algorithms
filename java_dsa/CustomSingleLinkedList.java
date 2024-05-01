public class CustomSingleLinkedList {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        CustomSingleLinkedList ll = new CustomSingleLinkedList();
        ll.push(10);
        ll.push(20);
        ll.push(30);
        ll.push(45);

        Node hd = ll.head;

        while(!(hd == null)) {
            System.out.println(hd.data);
            hd = hd.next;
        }

        System.out.print("    "+"abc");
        System.out.print("\raccvuyuyu");
        System.out.print(" " + "aaaa"); 
    }

}
