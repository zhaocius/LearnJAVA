package leetcode.list;

import algorithm4thedition.MyLinkedList;

import java.util.LinkedList;

public class LT160_Intersection_of_Two_Linked_Lists {
    /*
     *  A:    a1 → a2
     *                ↘
     *                  c1 → c2 → c3
     *                 ↗
     *  B:b1 → b2 → b3
     *
     *
     * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
     * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点
     *
     * 如果只是判断有没有交叉点，则将B的头接到A的尾巴，求A有没有环。或者比较A的最后和B的最后是不是相同。
     * */

    public static MyLinkedList.Node findIntersection(MyLinkedList a, MyLinkedList b) {
        MyLinkedList.Node nodeA = a.first;
        MyLinkedList.Node nodeB = b.first;
        while(nodeA.item!= nodeB.item){
            nodeA=(nodeA.next==null?b.first:nodeA.next);
            nodeB=(nodeB.next==null?a.first:nodeB.next);
        }
        return nodeA;
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
        myLinkedListB.insert(31);
        myLinkedListB.insert(32);

        System.out.println(findIntersection(myLinkedListA,myLinkedListB).item);

    }
}
