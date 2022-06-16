package linkedList;

//Given two singly linked lists that are sorted in increasing order of node values, merge two sorted linked lists and
//return them as a sorted list. The list should be made by splicing together the nodes of the first two lists.

public class MergeSortedLinkedList extends LL{

    //Method-1 : Using and External Linked List to store the answer.
    //Time Complexity - O(n + m)
    //Space Complexity - O(n + m)
    public static Node method1(Node headA , Node headB){
        Node dummyNode = new Node(0);
        Node temp = dummyNode;

        while(true){
            if(headA == null){
                temp.next = headB;
                break;
            }else if(headB == null){
                temp.next = headA;
                break;
            }

            if(headA.data <= headB.data){
                temp.next = headA;
                headA = headA.next;
            }else{
                temp.next = headB;
                headB = headB.next;
            }
            temp = temp.next;
        }
        return dummyNode;
    }

    // Method - 2 : In-Place
    public static Node optimalSolution(Node headA , Node headB){
        Node dummyNode = headA , temp = headA;
        if(headA.data > headB.data){
            dummyNode = headB;
            temp = headB;
        }else{
            dummyNode = headA;
            temp = headA;
        }
        while(true){
            if(headA == null){
                temp.next = headB;
                break;
            }else if(headB == null){
                temp.next = headA;
                break;
            }

            if(headA.data <= headB.data){
                Node n = headA.next;
                temp.next = headA;
                headA = n;
            }else if(headB.data < headA.data){
                Node n = headB.next;
                temp.next = headB;
                headB = n;
            }
            temp = temp.next;
        }
        return dummyNode;
    }

    public static void main(String[] args) {
        LL list1 = new LL();
        LL list2 = new LL();
        list1.add(3);
        list1.add(7);
        list1.add(9);
        list2.add(1);
        list2.add(2);
        list2.add(5);
        list2.add(8);
        list2.add(10);

//        Node res =  method1(list1.head() , list2.head());
        Node res = optimalSolution(list1.head() , list2.head());

        if(res == null){
            System.out.println("The list is empty");
        }else{
            list1.printList(res);
        }
    }
}
