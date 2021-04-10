package lesson8;

import java.util.Random;

public class Main {
    static Random random;
    public static void main(String[] args) {
   //     random = new Random();
        ChainingHashMap<Integer, String> chm= new ChainingHashMap<>(7);

        chm.put(1, "one");
        chm.put(2, "two");
        chm.put(3, "three");

        System.out.println(chm.get(1));
        System.out.println(chm.get(2));
        System.out.println(chm.get(3));


        chm.delete(2);

        System.out.println(chm.get(1));
        System.out.println(chm.get(2));
        System.out.println(chm.get(3));
//
//        for (int i = 0; i < 12; i++) {
//            chm.put(random.nextInt(100), "");
//        }
//
//        System.out.println(chm);

        System.out.println();

        LinearProbingHashMap<Integer, String> lphm = new LinearProbingHashMap<>(7);
        lphm.put(1, "one");
        lphm.put(2, "two");
        lphm.put(3, "three");
        lphm.put(4, "three");
        lphm.put(5, "three");
        lphm.put(6, "three");
        lphm.put(7, "three");
        lphm.put(8, "three");
        lphm.put(9, "three");
        lphm.put(10, "three");

//        lphm.put(2, "twosdfsdf");
//        System.out.println(lphm.get(2));

        for (int i = 1; i <= 10 ; i++) {
            System.out.println(lphm.get(i));
        }

        lphm.deleted(5);

        System.out.println();

        for (int i = 1; i <= 10 ; i++) {
            System.out.println(lphm.get(i));
        }

        lphm.put(5, "hoy");

        for (int i = 1; i <= 10 ; i++) {
            System.out.println(lphm.get(i));
        }

    }
}
