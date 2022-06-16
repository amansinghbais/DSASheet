package linkedList;

public class MiddleElementOfLinkedList extends LL{

    /*
        Naive Approach:
            Traversing over whole list and find the total length of the list
            then again traversing n/2 time
            return the node at n/2th position.
            Time Complexity - O(n)
    */
    public static Node naiveApproach(Node head){
        if(head == null){
            return null;
        }
        Node temp = head;
        int n = 1;
        while(temp != null){
            temp  = temp.next;
            n++;
        }
        n = n/2 - 1;
        while(n-- > 0){
            head = head.next;
        }
        return head;
    }

    // Optimal Approach : Using Two Pointer
    //  Here we use two pointer slow and fast starting from the head
    //  We iteratively move slow pointer 1 time and fast pointer 2 times simultaneously
    //  When the fast pointer reach the last or second last node we return the slow pointer.
    // Time Complexity - O(n)
    public static Node optimalApproach(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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

//        Node res = naiveApproach(list.head());
        Node res = optimalApproach(list.head());

        //Printing the result
        if(res == null){
            System.out.println("The list is empty.");
        }else{
            System.out.println(res.data);
        }
    }
}
