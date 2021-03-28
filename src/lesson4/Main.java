package lesson4;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.insertFirst("one");
        mll.insertFirst("two");
        mll.insertFirst("three");
        mll.insertFirst("five");
        mll.insertFirst("six");
        mll.insert(1, "four");
        mll.insertLast("ten");
        System.out.println(mll);

////        System.out.println(mll.removeFirst());
////
////        System.out.println(mll.removeLast());
////        System.out.println(mll.removeLast());
//        System.out.println(mll);
////        mll.insertLast("four");
////        System.out.println(mll);
//
//        mll.insert(1, "four");
//        System.out.println(mll);
////
//        mll.remove("one");
//        System.out.println(mll);

//        for (String s : mll) {
//            System.out.println(s);
//        }

        ListIterator<String> li = mll.listiterator();

        int count_0 = 0;
        while (li.hasNext() && count_0 <= 1) {
            System.out.println(li.next());
              li.remove();
            System.out.println(li.nextIndex());
            System.out.println(li.previousIndex());
            count_0++;
        }

        System.out.println(mll);


        int count = 0;
        while (li.hasPrevious() && count <= 1) {
            System.out.println(li.previous());
            li.remove();
            count++;
        }

        System.out.println(mll);

        li.add("nine");

        System.out.println(mll);

        count = 0;
        while (li.hasNext() && count <= 1) {
            System.out.println(li.next());
            li.set("zero");
            count++;
        }

        System.out.println(mll);



    }
}
