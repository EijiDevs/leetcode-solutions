import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Obtener el número completo de cada lista
        String listOneValue = getFullValueOfNodeList(l1);
        String listTwoValue = getFullValueOfNodeList(l2);

        // Invertir los números obtenidos
        listOneValue = invertString(listOneValue);
        listTwoValue = invertString(listTwoValue);

        // Transformar los numeros de String a Integer
        BigInteger listOneNumber = new BigInteger(listOneValue);
        BigInteger listTwoNumber = new BigInteger(listTwoValue);

        // Sumar los valores invertidos
        BigInteger finalListNumber = listOneNumber.add(listTwoNumber);

        // Crear la lista enlazada resultado
        ListNode finalList = new ListNode();
        insertNumberInReverseInListNode(finalListNumber, finalList);

        // Retornar la lista enlazada
        return finalList;
    }

    public String getFullValueOfNodeList(ListNode list) {
        String number = "";
        ListNode current = list;
        while (current != null) {
            
            number += String.valueOf(current.val);
            current = current.next;
        }
        return number;
    }

    public String invertString(String s) {
        String inverted = "";
        for(int i = s.length() - 1; i >= 0; i--){
            inverted += s.charAt(i);
        }
        return inverted;
    }

    public void insertNumberInReverseInListNode(BigInteger number, ListNode list) {
        ListNode current = list;
        boolean isFirstNode = true;

        while (!number.equals(BigInteger.ZERO)) {
            if (isFirstNode) {
                current.val = ((number.mod(BigInteger.TEN).intValue())); 
                isFirstNode = false;
            } else {
                current.next = new ListNode((number.mod(BigInteger.TEN)).intValue());
                current = current.next;
            }
            number = number.divide(BigInteger.TEN);
        }

        // Si number era 0 desde el inicio, aseguramos que la lista tenga un solo nodo con valor 0
        if (isFirstNode) {
            current.val = 0;
        }
    }
}
