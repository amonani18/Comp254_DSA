package question3;/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Comparator;


class QuickSort {

  //-------- support for top-down quick-sort of queues --------
  /** Quick-sort contents of a queue. */
  public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
    int n = S.size();
    if (n < 2) return;                       // queue is trivially sorted
    // divide
    K pivot = S.first();                     // using first as arbitrary pivot
    Queue<K> L = new LinkedQueue<>();
    Queue<K> E = new LinkedQueue<>();
    Queue<K> G = new LinkedQueue<>();
    while (!S.isEmpty()) {                   // divide original into L, E, and G
      K element = S.dequeue();
      int c = comp.compare(element, pivot);
      if (c < 0)                             // element is less than pivot
        L.enqueue(element);
      else if (c == 0)                       // element is equal to pivot
        E.enqueue(element);
      else                                   // element is greater than pivot
        G.enqueue(element);
    }
    //System.out.println(L.toString());
    //System.out.println(E.toString());
    //System.out.println(G.toString());


    // conquer
    quickSort(L, comp);                      // sort elements less than pivot
    quickSort(G, comp);                      // sort elements greater than pivot
    // concatenate results
    while (!L.isEmpty())
      S.enqueue(L.dequeue());
    while (!E.isEmpty())
      S.enqueue(E.dequeue());
    while (!G.isEmpty())
      S.enqueue(G.dequeue());
  }

  //-------- support for in-place quick-sort of an array --------
  /** Quick-sort contents of a queue. */




    public static void main(String[] args) {
        // Create a queue of Account objects using LinkedQueue
        Queue<Account> accountQueue = new LinkedQueue<>();

        // Add Account objects to the queue
        accountQueue.enqueue(new Account(101, "John", 10000.00));
        accountQueue.enqueue(new Account(102, "Charlie", 5500.00));
        accountQueue.enqueue(new Account(103, "Tessa", 6000.00));
        accountQueue.enqueue(new Account(104, "Hannah", 8000.00));
        accountQueue.enqueue(new Account(105, "Bishop", 2000.00));

        // Create a Comparator object to compare accounts by balance
        Comparator<Account> accountBalanceComparator = Comparator.comparingDouble(Account::getAccountBalance);

        // Sort the queue using quickSort
        QuickSort.quickSort(accountQueue, accountBalanceComparator);

        // Print the sorted queue
        System.out.println("Accounts sorted by balance:");
        while (!accountQueue.isEmpty()) {
            System.out.println(accountQueue.dequeue());
        }
    }

}
