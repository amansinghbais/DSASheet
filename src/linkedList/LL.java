package linkedList;

public class LL {
    public Node head;
    // Node class to create a new Node.
    public static class Node{
        int data;
        Node next = null;
        //Constructor without a parameter
        public Node(){
            this.data = 0;
        }
        //Constructor with a parameter
        public Node(int x){
            this.data = x;
        }
    }

    //Function to return the head of the linked list.
    public Node head(){
        return head;
    }

    //Add function to add a new Node at the last of the LinkedList.
    public void add(int n){
        Node newNode = new Node(n);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    //Function to print the whole Linked List.
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    //Function to print all the elements of the linked list when head is given
    public void printList(Node h){
        Node temp = h;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

}
