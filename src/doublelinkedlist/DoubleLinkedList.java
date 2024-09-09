/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doublelinkedlist;

/**
 *
 * @author quyet
 * @param <E>
 */
public class DoubleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int length;

    public DoubleLinkedList(E Value) {
        Node<E> newNode = new Node(Value);
        head = newNode;
        tail = newNode;
        length = 1;

    }

    public void printList() {
        Node<E> temp = head;
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
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;

    }

    public Node<E> removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = tail;
        tail = temp.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(E value) {
        Node<E> newNode = new Node<>(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node<E> removeFirstNode() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;

        }
        length--;
        return temp;
    }

    public Node<E> get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node<E> tmp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
        } else {
            tmp = tail;
            for (int i = length - 1; i > index; i--) {
                tmp = tmp.prev;
            }
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

        Node<E> newNode = new Node(value);
        Node<E> before = get(index - 1);
        Node<E> after = before.next;
        newNode.next = after;
        after.prev = newNode;
        newNode.prev = before;
        before.next = newNode;

        length++;
        return true;
    }

    public Node<E> remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirstNode();
        }
        if (index == length - 1) {
            return removeLast();
        }

        Node<E> temp = get(index);
        Node<E> before = temp.prev;
        Node<E> after = temp.next;

        before.next = after;
        after.prev = before;
        temp.prev = null;
        temp.next = null;
        length--;

        return temp;

    }

}
