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
		System.out.println("输入只有右括号的表达式");
		Scanner in = new Scanner(System.in);
		boolean end = false;
		while(!end){
			String input = in.next();
			System.out.println(input);
			if("end".equalsIgnoreCase(input)){
				end = true;
			}else if(input.equals(")")){
				String op1 = stack.pop();
				String op = stack.pop();
				String op2 = stack.pop();
				stack.push("("+op2+op+op1+")");
			}else {
				stack.push(input);
			}
		}
		System.out.println(stack.peek());
		StringBuilder sb = new StringBuilder();
		for (String item : stack) {
			sb.append(item);
		}
		System.out.println(sb.toString());
	}
}
