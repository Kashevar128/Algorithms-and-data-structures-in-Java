package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverseOrder implements Runnable {
    private MyStack<Character> stack;
    private final int CAPACITY = 10;
    Thread t;

    reverseOrder() {
        stack = new MyStack<>(CAPACITY);
        this.t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        String stringIn;
        StringBuilder stringOut;
        while (true) {
            try {

                stringIn = getString();
                stringOut = new StringBuilder();

                for (int i = 0; i < stringIn.length(); i++) {
                    stack.push(stringIn.charAt(i));
                }

                for (int j = 0; j < stringIn.length(); j++) {
                    stringOut.append(stack.pop());
                }

                info(stringOut);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getString() throws IOException {
        System.out.print("\nВведите строку: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return br.readLine();
    }

    public static void info(StringBuilder stringBuilder) {
        System.out.println("Преобразованная строка: " + stringBuilder);
    }

}
