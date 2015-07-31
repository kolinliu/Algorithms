package com.lk.c1;

import java.util.Scanner;

/**
 * <b>1.3.9</b> Write a program that takes from standard input an expression
 * without left parentheses and prints the equivalent infix expression with the
 * parentheses inserted. For example, given the input:</br>
 * <code>1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) <code><br/>
 * your program should print<br/>
 * <code>( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )</code>
 * 
 * 
 * @author Kolin
 * 
 */
public class CompleteParentheses {
	public static void main(String[] args) {
		LinkedListStack<String> stack = new LinkedListStack<String>();
		System.out.println("输入只有有括号的表达式");
		Scanner in = new Scanner(System.in);
		String input = in.next().trim();
		char[] values = input.toCharArray();
		for (char value : values) {
			if(value==')'){
				String op1 = stack.pop();
				String op = stack.pop();
				String op2 = stack.pop();
				stack.push("("+op2+op+op1+")");
			}else {
				stack.push(String.valueOf(value));
			}
		}
//		System.out.println(stack.peek());
//		StringBuilder sb = new StringBuilder();
//		for (String item : stack) {
//			sb.append(item);
//		}
//		System.out.println(sb.toString());
		System.out.println(stack.toString());
	}
}
