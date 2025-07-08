package com.example.app.base.Controler.data_struct.queue;

import com.example.app.base.Controler.data_struct.list.Linkendlist;

public class QueueImplementation<E> extends Linkendlist<E> {
    private Integer top;

    public Integer getTop() {
        return this.top;
    }

    public QueueImplementation(Integer top){
        this.top = top;
    }

    protected Boolean isFullQueue() {
        return this.top >= getLength();
    }

    protected void queue(E info) throws Exception {
        if(!isFullQueue()) {
            add(info);
        } else {
            throw new ArrayIndexOutOfBoundsException("Queue full");
        }
    }
    protected E dequeue() throws Exception {       
        return deleteFirst();
        
    }
}
