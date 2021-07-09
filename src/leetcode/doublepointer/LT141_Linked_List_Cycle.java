package leetcode.doublepointer;

import algorithm4thedition.MyLinkedList;

public class LT141_Linked_List_Cycle {

    public static boolean findIntersection(MyLinkedList.Node  root) {
        if(root==null)
            return false;
        MyLinkedList.Node node1 = root;
        MyLinkedList.Node node2 = root;
        while(node1 != null && node2 != null){
            if(node1 == node2)
                return true;
            node1 = node1.next;
            if(node2.next == null)
                break;  //快指针为null了，表示没有环，退出返回false
            node2= node2.next.next;
        }
        return false;
    }



}
