package leetcode._150;

import java.util.List;
import java.util.Stack;

// 150. Evaluate Reverse Polish Notation
class Solution {

    public int evalRPN1(String[] tokens) {
        Stack<Integer> l = new Stack();

        for(String s: tokens) {

            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int x = l.pop(), y = l.pop();
                if(s == "+") {
                    l.push(x + y);
                } else if(s == "-") {
                    l.push(y - x);
                } else if(s == "*") {
                    l.push(x * y);
                } else if(s == "/") {
                    l.push(y / x);
                }
            } else {
                l.push(Integer.parseInt(s));
            }
        }
        return l.pop();
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> l = new Stack();
        for(String s: tokens) {
            if(List.of("+","-","*","/").contains(s)) {
                int x = (l.pop()), y = (l.pop());
                switch (s) {
                    case "+":
                        l.push(x + y);
                        break;
                    case "-":
                        l.push(y - x);
                        break;
                    case "*":
                        l.push(x * y);
                        break;
                    case "/":
                        l.push(y / x);
                        break;
                }
            } else {
                l.push(Integer.parseInt(s));
            }            
        }
        return l.pop();
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.evalRPN(new String[]{"2", "1", new String("+"), "3", "*"}));
        // ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        System.out.println(s.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}