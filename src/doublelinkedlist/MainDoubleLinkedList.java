/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doublelinkedlist;

/**
 *
 * @author quyet
 */
public class MainDoubleLinkedList {
    
    public static void main(String[] args) {
        DoubleLinkedList<String> myDoubleLinkedList = new DoubleLinkedList<>("123");
        myDoubleLinkedList.append("1234556");
        myDoubleLinkedList.insert(1, "123d");
        myDoubleLinkedList.remove(0);
        System.out.println(myDoubleLinkedList.get(0).value);
        myDoubleLinkedList.printList();
    }
}
