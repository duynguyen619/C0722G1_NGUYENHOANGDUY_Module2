package ss10_stack_queue;

import java.util.Stack;

public class Binary {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        int n = 1123;
        while (n != 0) {
            integerStack.push(n % 2);
            n /= 2;
        }
        while (!integerStack.isEmpty()) {
            System.out.print((integerStack.pop()));
        }
    }
}
