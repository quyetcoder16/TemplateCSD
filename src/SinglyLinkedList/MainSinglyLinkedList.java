/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinglyLinkedList;

/**
 *
 * @author quyet
 */
public class MainSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList<String> myLinkedList = new SinglyLinkedList<>("123");

        myLinkedList.append("345");
        myLinkedList.append("sf");
        myLinkedList.append("smnf");

        myLinkedList.printList();
        System.out.println(myLinkedList.getHead().value);

    }
}
