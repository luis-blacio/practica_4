package com.example.app.base.Controler.data_struct.stack;

import com.example.app.base.Controler.data_struct.list.Linkendlist;

public class Stackimplementation<E> extends Linkendlist<E> {
    private Integer top;

    public Integer getTop() {
        return this.top;
    }

    public Stackimplementation(Integer top){
        this.top = top;
    }

    protected Boolean isFullStack() {
        return getLength() >  this.top ;
    }

    protected void push(E info) throws Exception {
        if(!isFullStack()) {
            add(info, 0);
        } else {
            throw new ArrayIndexOutOfBoundsException("Stack full");
        }
    }
    protected E pop() throws Exception {       
        return deleteFirst();
        
    }
}