/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList;

/**
 *
 * @author quyet
 * @param <E>
 */
public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int length;

    public SinglyLinkedList(E value) {
        Node<E> newNode = new Node<>(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void append(E value) {
        Node<E> newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node<E> removeLast() {
        if (length == 0) {
            return null;
        }

        Node<E> temp = head;
        Node<E> pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            tail = null;
            head = null;
        }
        return temp;
    }

    public void prepend(E value) {
        Node<E> newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node<E> removeFirstNode() {
        if (length == 0) {
            return null;
        }
        Node<E> temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node<E> get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node<E> tmp = head;

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        return tmp;
    }

    public boolean set(int index, E value) {

        Node<E> temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, E value) {
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node<E> newNode = new Node<>(value);
        Node<E> temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;

        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirstNode();
        }
        if (index == length - 1) {
            return removeLast();
        }

        Node<E> prev = get(index - 1);
        Node<E> temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;

    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node<E> after = temp.next;
        Node<E> before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

}
