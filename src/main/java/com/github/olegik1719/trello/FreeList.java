package com.github.olegik1719.trello;

import java.util.*;

public class FreeList<E> extends ArrayList <E> {



    private boolean rangeCheck(int index){
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index > super.size()) return true;
        return false;
    }

    private FreeList grow(int size){
        if (size >= super.size()){
            super.ensureCapacity(size+1);
            for (int i = super.size(); i < size + 1; i++) {
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
        if (rangeCheck(beginingSize-1)) grow(beginingSize-1) ;// grow
    }

    @Override
    public E get(int index) {
        if (rangeCheck(index)) grow(index);
        return super.get(index);
    }

    @Override
    public E set(int index, E element) {
        if (rangeCheck(index)) grow(index);
        return super.set(index,element);
    }

    @Override
    public void add(int index, E element) {
        if (rangeCheck(index-1)) grow(index-1);
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
        if (rangeCheck(index-1)) grow(index-1);
        return super.addAll(index,c);
    }
}
