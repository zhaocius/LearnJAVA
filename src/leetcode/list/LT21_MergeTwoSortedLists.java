package leetcode.list;

import algorithm4thedition.MyLinkedList;

public class LT21_MergeTwoSortedLists {
    public static MyLinkedList.Node mergeTwoLists( MyLinkedList.Node l1,MyLinkedList.Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        MyLinkedList.Node  newHead = null;
        if(l1.item < l2.item){
            newHead = l1;
            newHead.next = mergeTwoLists(l1.next, l2);
        } else{
            newHead = l2;
            newHead.next = mergeTwoLists(l1, l2.next);
        }
        return newHead;
    }



    public static void main(String[] args) {
        MyLinkedList myLinkedListA = new MyLinkedList();
        myLinkedListA.insert(1);
        myLinkedListA.insert(2);
        myLinkedListA.insert(3);
        myLinkedListA.insert(31);
        myLinkedListA.insert(32);

        MyLinkedList myLinkedListB = new MyLinkedList();
        myLinkedListB.insert(21);
        myLinkedListB.insert(22);
        myLinkedListB.insert(41);
        myLinkedListB.insert(42);

        MyLinkedList.Node node = mergeTwoLists(myLinkedListA.first,myLinkedListB.first);
        while(node.next!=null) {
            System.out.println(node.item);
            node= node.next;
        }
    }
}
