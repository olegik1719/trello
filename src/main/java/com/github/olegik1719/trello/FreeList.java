package com.github.olegik1719.trello;

import java.util.*;

public class FreeList<E> extends ArrayList <E> {



    private boolean rangeCheck(int index){
        if (index < 0) throw new IndexOutOfBoundsException("Index must be positive!");
        if (index > super.size()) return true;
        return false;
    }

    private FreeList grow(int toIndex){
        if (toIndex < 0) throw new IndexOutOfBoundsException("Index must be positive!");
        if (toIndex >= super.size()){
            super.ensureCapacity(toIndex+1);
            for (int i = super.size(); i < toIndex + 1; i++) {
                super.add(null);
            }
        }
        return this;
    }

    public FreeList(){
        super();
    }

    public FreeList(Collection<? extends E> c){
        super(c);
    }

    public FreeList(int beginingSize){
        super(beginingSize);
        grow(beginingSize-1) ;// grow
    }

    @Override
    public E get(int index) {
        if (rangeCheck(index)) return null;
        return super.get(index);
    }

    @Override
    public E set(int index, E element) {
        grow(index);
        return super.set(index,element);
    }

    @Override
    public void add(int index, E element) {
        grow(index-1);
        super.add(index,element);
    }

    @Override
    public E remove(int index) {
        // Small optimization:
        // if we remove something after end -- We don't need in growing!!!
        if (rangeCheck(index)) return null;
        return super.remove(index);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        grow(index-1);
        return super.addAll(index,c);
    }
}
