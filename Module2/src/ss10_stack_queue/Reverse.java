package ss10_stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        int[] numberOne = new int[]{1,2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverseIntegerUseStack(numberOne);
        System.out.println(Arrays.toString(numberOne));
        String fullName = "NGUYỄN HOÀNG DUY";
        fullName = reverseIntegerUseStack(fullName);
        System.out.printf(fullName);
    }

    static void reverseIntegerUseStack(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int number : numbers) {
            stack.push(number);
        }
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = stack.pop();
        }
    }

    static String reverseIntegerUseStack(String str) {
        Stack<String> stack = new Stack<>();
        final int STR_LENGTH = str.length();
        for (int i = 0; i < STR_LENGTH; i++) {
            stack.push(str.charAt(i) + "");
        }
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {
            strBuilder.append(stack.pop());
        }
        str = strBuilder.toString();
        return str;
    }
}
