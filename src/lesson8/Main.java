package lesson8;

import java.util.Random;

public class Main {
    static Random random;
    public static void main(String[] args) {
        random = new Random();
        ChainingHashMap<Integer, String> chm= new ChainingHashMap<>(7);

        chm.put(1, "one");
        chm.put(2, "two");
        chm.put(4, "three");
        chm.put(5, "three");
        chm.put(6, "three");
        chm.put(7, "three");
        chm.put(8, "three");
        chm.put(9, "three");
        chm.put(10, "three");
        chm.put(11, "three");
        chm.put(12, "three");
        chm.put(13, "three");
        chm.put(14, "three");
        chm.put(15, "three");
        chm.put(16, "three");

        for (int i = 1; i <= 16; i++) {
            System.out.println(chm.get(i));
        }

//
//        chm.delete(2);
//
//        System.out.println(chm.get(1));
//        System.out.println(chm.get(2));
//        System.out.println(chm.get(3));

//        for (int i = 0; i < 12; i++) {
//            chm.put(random.nextInt(100), "");
//        }
//
//        System.out.println(chm);
//
//        LinearProbingHashMap<Integer, String> lphm = new LinearProbingHashMap<>(19);
//        lphm.put(1, "one");
//        lphm.put(2, "two");
//        lphm.put(3, "three");
//        lphm.put(2, "twosdfsdf");
//        System.out.println(lphm.get(2));
//


    }
}
