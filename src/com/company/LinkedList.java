package com.company;

import java.util.Objects;

public class LinkedList<T> {
    int size;
    Node<T> tail;
    Node<T> head;

    private static class Node<T>{
        T elem;
        Node<T> next;

        public Node(T elem){
            this.elem = elem;
        }
    }

    public void add(T elem){
        Node<T> addedNode = new Node<>(elem);
        if  (head == null){ // && tail == null
            head = tail = addedNode;
        }
        else{
            tail.next = addedNode;
            tail = addedNode;
        }
        size++;
    }

    public void add(int index, T elem){
        Objects.checkIndex(index, size);
        Node<T> addedNode = new Node<>(elem);
        if  (head == null){
            head = tail = addedNode;
        }
        else if(index == 0){
            addedNode.next = head;
            head = addedNode;
        }
        else if (index == size){
            tail.next = addedNode;
            tail = addedNode;
        }
        else{
            Node<T> active = head;
            for (int i=0; i < index - 1; i++){
                active = active.next;
            }
            addedNode.next = active.next;
            active.next = addedNode;
        }
        size++;
    }

    public void setElement(int index, T elem){
        Objects.checkIndex(index, size);
        Node<T> active = head;
        for (int i=0; i < index; i++){
            active = active.next;
        }
        active.elem = elem;
    }

    public T getElement(int index){
        Objects.checkIndex(index, size);
        Node<T> active = head;
        for (int i=0; i < index; i++){
            active = active.next;
        }
        return active.elem;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node<T> active = head;
            for (int i = 0; i < index - 1; i++) {
                active = active.next;
            }
            active.next = active.next.next;
            if (index == size - 1){
                tail = active;
            }
        }
        size--;
    }
    public String toString(){
        String result = "";
        Node<T> active = head;
        for (int i = 0; i < size; i++) {
            if (i != size-1){
                result += active.elem.toString() + ", ";
                active = active.next;
            }
            else {
                result += active.elem.toString();
            }

        }
        return "[" + result + "]";
    }

    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        System.out.println("Linked list after creation:");
        System.out.println(linkedList);

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("Linked list after addition 3 elements");
        System.out.println(linkedList.toString());

        System.out.println("Get element by index 1:");
        System.out.println(linkedList.getElement(1));

        System.out.println("Set element 100 by index 1:");
        linkedList.setElement(1, 100);
        System.out.println(linkedList.toString());
        System.out.println("Linked list after setting element 10 on second position:");
        System.out.println(linkedList.toString());

        System.out.println("Linked list after adding element 13:");
        linkedList.add(13);
        System.out.println(linkedList);

        System.out.println("Linked list after adding element 14 with index 1:");
        linkedList.add(1, 14);
        System.out.println(linkedList);

        System.out.println("Linked list after removing element with index 1:");
        linkedList.remove(1);
        System.out.println(linkedList);
    }
}