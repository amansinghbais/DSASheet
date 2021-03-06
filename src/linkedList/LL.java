package linkedList;

public class LL {
    public Node head;
    // Node class to create a new Node.
    public static class Node{
        public int data;
        public Node next = null;
        //Constructor without a parameter
        public Node(){
            this.data = 0;
        }
        //Constructor with a parameter
        public Node(int x){
            this.data = x;
        }
        //Constructor with a value and reference to next node.
        public Node(int x , Node n){
            this.data = x;
            this.next = n;
        }

    }

    //Function to return the head of the linked list.
    public Node head(){
        return head;
    }

    //Add function to create a new Node and adding it at the last of the LinkedList.
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
    //Adding a new Node given as parameter in the list.
    public void add(Node n){
        if(head == null){
            head = n;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
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
