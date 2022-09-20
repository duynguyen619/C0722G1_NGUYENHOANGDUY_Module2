package ss10_stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class CheckParentheses {
    public static boolean check(String str) {
        Stack<Character> bStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                bStack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (bStack.isEmpty()) {
                    return false;
                } else {
                    bStack.pop();
                }
            }
        }
        return bStack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter  : ");
        String str = scanner.nextLine();
        System.out.println(check(str));
    }
}
