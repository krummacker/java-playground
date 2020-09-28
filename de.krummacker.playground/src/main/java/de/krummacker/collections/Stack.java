package de.krummacker.collections;

public class Stack<E> {

    private static class Entry<E> {
        private Entry<E> next;
        private E element;
    }

    private Entry<E> head;

    public void push(E element) {
        Entry<E> newEntry = new Entry<>();
        newEntry.next = head;
        newEntry.element = element;
        head = newEntry;
    }

    public E pop() {
        E result = head.element;
        head = head.next;
        return result;
    }

    public E peek() {
        return head.element;
    }

    public int size() {
        int result = 0;
        Entry<E> pointer = head;
        while (pointer != null) {
            ++result;
            pointer = pointer.next;
        }
        return result;
    }
}
