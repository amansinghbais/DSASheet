package linkedList;

//Problem Statement: Write a function to delete a node in a singly-linked list. You will not be given access to the head
//of the list instead, you will be given access to the node to be deleted directly. It is guaranteed that the node to be
//deleted is not a tail node in the list.

public class DeleteNthNode extends LL {

    //Solution:
    //      Copy the value of the next node to the current node
    //      Then store the  next value of the next node in the next value of the current node
    //Time Complexity - O(1)
    //Space Complexity - O(1)

    public static void deleteNode(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
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

        deleteNode(list.head().next.next.next);

        list.printList();

    }
}
