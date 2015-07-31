package com.lk.c1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Iterable<E> {
	private Node<E> first;
	private int N;

	@SuppressWarnings("hiding")
	private class Node<E> {
		private E item;
		private Node<E> next;
	}

	public LinkedListStack() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(E item) {
		Node<E> newNode = new Node<E>();
		newNode.item = item;
		newNode.next = first;
		first = newNode;
		N++;
	}

	public E pop() {
		if (isEmpty())
			throw new NoSuchElementException("stack underflow");
		E item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public E peek() {
		if (isEmpty())
			throw new NoSuchElementException("stack underflow");
		return first.item;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator<E>(first);
	}

	@SuppressWarnings("hiding")
	public class ListIterator<E> implements Iterator<E> {
		private Node<E> current;

		public ListIterator(Node<E> first) {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (E item : this) {
			sb.append(item + " ");
		}
		return sb.toString();
	}

}
