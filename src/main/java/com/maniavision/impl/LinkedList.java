package com.maniavision.impl;

import com.maniavision.adts.IList;

public class LinkedList implements IList {

    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public void addFront(int value) {
        LinkedListNode newNode = new LinkedListNode(value);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        ++size;
    }

    public void addBack(int value) {
        LinkedListNode newNode = new LinkedListNode(value);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        ++size;
    }
    @Override
    public void add(int value) {
        addBack(value);
    }

    @Override
    public int get(int index) {
        if(!isEmpty()) {
            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException();

            int indx = 0;
            LinkedListNode temp = head;
            while (temp != null) {
                if (index == indx)
                    return temp.data;
                else {
                    temp = temp.next;
                    ++indx;
                }
            }
        }
        return -1;
    }

    @Override
    public int search(int value) {
        if(!isEmpty()) {
            LinkedListNode temp = head;
            int index = 0;
            while(temp != null) {
                if(value == temp.data)
                    return index;
                else {
                    index++;
                    temp = temp.next;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean remove(int value) {
        if(!isEmpty() && search(value) != -1) {

           LinkedListNode curr = head;
           LinkedListNode prev = null;
           while(curr != null) {
               if(value == curr.data)
                   break;
               else {
                   prev = curr;
                   curr = curr.next;
               }
           }

           if(prev == null) { // value found in head
               prev = head;
               head = head.next;
               prev.next = null;
           } else {
               prev.next = curr.next;
               curr.next = null;
               if(curr == tail)
                   tail = prev;
           }
            --size;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void print() {
        if(!isEmpty()) {
            LinkedListNode temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
