package linkedList;

public class ReverseList extends LL {

    //Method - 1: Iterative Approach
    //Using three pointer approach
    //Time Complexity - O(n)    &&  Space Complexity - O(1)
    public static Node reverseIterative(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr != null){
            next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //Method - 2 : Recursive Approach
    //
    //Recursive calling reverseFunction for next node
    //When we reach the last node or the null node we return the last node.
    //And at last we reverse the first and second node.
    //
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static Node reverseRecursive(Node head){
        //Base case return last node when we reach the null or the last node.
        if(head == null || head.next == null){
            return head;
        }
        //Recursively calling own function till we reach last node.
        Node node = reverseRecursive(head.next);
        //When we came back from recursion the last work is to reverse first two nodes.
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

//        Node head = reverseIterative(list.head());
        Node head = reverseRecursive(list.head());

        list.printList(head);
    }
}
