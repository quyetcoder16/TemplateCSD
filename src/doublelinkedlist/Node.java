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
public class Node<E> {

    E value;
    Node<E> next;
    Node<E> prev;

    public Node() {
    }

    public Node(E value) {
        this.value = value;
    }

}
