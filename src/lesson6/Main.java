package lesson6;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        MyTreeMap<Integer, String> map = new MyTreeMap<>();
//
//        map.put(1, "one");
//        map.put(2, "two");
//        map.put(5, "five");
//        map.put(4, "four");
//        map.put(3, "three");
//
////        System.out.println(map.minKey());
////        System.out.println(map.maxKey());
//
////        System.out.println(map.get(3));
////        map.put(3, "tttrrreee");
////        System.out.println(map.get(3));
////
////        map.deleteMin();
//
//        map.delele(4);
////        System.out.println(map.get(4));
//
//        System.out.println(map);

        Random random = new Random();
        int countTree = 100000;
        int balCount = 0;

        for (int i = 0; i < countTree; i++) {
            MyTreeMap<Integer, Integer> map1 = new MyTreeMap<>();
            int x = 0;
            while (map1.height() < 6) {
                x = random.nextInt(201) - 100;
                map1.put(x, x);
            }
            map1.delele(x);
            if(map1.isBalance()){
                balCount++;
            }
        }
        System.out.println("balCount " + balCount + " countTree " + countTree);
        System.out.println("balanced " + (double) balCount / countTree * 100 + " %");
        System.out.println("no balances " + (double) (countTree - balCount) / countTree * 100 + " %");

    }
}
