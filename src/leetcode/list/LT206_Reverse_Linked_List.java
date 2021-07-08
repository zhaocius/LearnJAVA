package leetcode.list;

import algorithm4thedition.MyLinkedList;

public class LT206_Reverse_Linked_List {
    public static void reverseLinkedList(MyLinkedList myLinkedListA){
        MyLinkedList.Node dummy = new MyLinkedList.Node(-1);
        dummy.next=myLinkedListA.first;
        MyLinkedList.Node pre = dummy.next;
        MyLinkedList.Node cur= pre.next;
        while(cur!=null){
            pre.next = cur.next;
            cur.next = dummy.next;
            dummy.next=cur;
            cur=pre.next;
        }

        myLinkedListA.first=dummy.next;
        myLinkedListA.display();



    }
    public static void main(String[] args) {
        MyLinkedList myLinkedListA = new MyLinkedList();
        myLinkedListA.insert(1);
        myLinkedListA.insert(2);
        myLinkedListA.insert(3);
        myLinkedListA.insert(31);
        myLinkedListA.insert(32);
        reverseLinkedList(myLinkedListA);

    }
}
