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

    //Optimal Solution :
    //Approach:-
    //Step 1: Create two pointers, say l1 and l2. Compare the first node of both lists and find the small among the two.
    //Assign pointer l1 to the smaller value node.
    //Step 2: Create a pointer, say res, to l1. An iteration is basically iterating through both lists till the value
    // pointed by l1 is less than or equal to the value pointed by l2.
    //Step 3: Start iteration. Create a variable, say, temp. It will keep track of the last node sorted list in an
    // iteration.
    //Step 4: Once an iteration is complete, link node pointed by temp to node pointed by l2. Swap l1 and l2.
    //Step 5: If any one of the pointers among l1 and l2 is NULL, then move the node pointed by temp to the next higher
    //value node.
    //Time Complexity - O(n + m)
    //Space Complexity - O(1)
    public static Node optimalSolution(Node headA , Node headB){
        //If any of the head is null return the other head.
        if(headA == null) return  headB;
        if(headB == null) return headA;
        Node temp;
        //Check value of both head and swap if need to make headA < headB
        if(headA.data > headB.data){
            temp = headA;
            headA = headB;
            headB = temp;
        }
        Node dummyNode = headA;
        //Traversing over both the array until any of the head becomes null
        while(headA != null && headB != null){
            Node last = null;
            //Move to the next node till the value of headA is less than headB
            while(headA != null && headA.data <= headB.data){
                last = headA;
                headA = headA.next;
            }
            //The moment value of headA becomes more than that of headB we connect the last node visited with the headB
            //and then we swap both the head so that headA will point to the lower value.
            last.next = headB;
            temp = headA;
            headA = headB;
            headB = temp;
        }
        return dummyNode;
    }

    public static void main(String[] args) {
        LL list1 = new LL();
        LL list2 = new LL();
        list1.add(1);
        list1.add(7);
        list1.add(9);
        list2.add(1);
        list2.add(2);
        list2.add(5);
        list2.add(8);
        list2.add(10);

//        Node res =  method1(list1.head() , list2.head());
        Node res = optimalSolution(list1.head() , list2.head());


        //Printint the result.
        if(res == null){
            System.out.println("The list is empty");
        }else{
            list1.printList(res);
        }
    }
}
