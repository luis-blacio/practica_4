package com.example.app.base.Controler.data_struct.stack;

public class Stack <E> {
    private Stackimplementation<E> stack;
    public Stack(Integer top) {
        stack = new Stackimplementation<>(top);
    }
    public Boolean push(E data) {
        try {
            stack.push(data);
            return true;
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
    }

    public E pop() {
        try {
            return stack.pop();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    public Boolean isFullStack() {
        return stack.isFullStack();
    }

    public Integer top() {
        return stack.getTop();
    }

    public Integer size() {
        return stack.getLength();
    }
}