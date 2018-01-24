package com.github.olegik1719.trello;

import java.util.*;

public class FreeList<E> extends ArrayList <E> {



    private void rangeCheck(int index){
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index >= super.size()){
            super.ensureCapacity(index+1);
            for (int i = super.size(); i < index + 1; i++) {
                super.add(null);
            }
        }
    }

    public FreeList(){
        super();
    }

    public FreeList(Collection<? extends E> c){
        super(c);
    }

    public FreeList(int beginingSize){
        super(beginingSize);
        rangeCheck(beginingSize-1);
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return super.get(index);
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        return super.set(index,element);
    }

    @Override
    public void add(int index, E element) {
        rangeCheck(index);
        super.add(index,element);
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        return super.remove(index);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheck(index);
        return super.addAll(index,c);
    }
}
