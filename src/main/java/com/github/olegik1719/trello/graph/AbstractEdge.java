package com.github.olegik1719.trello.graph;

public abstract class AbstractEdge<T> implements Edge<T> {
    private final static int DEFAULT_PRICE = 1;
    private final T begin;
    private final T end;
    private final boolean oriented;
    private final Number price;

    public AbstractEdge(T begin, T end, boolean oriented, Number price) {
        this.begin = begin;
        this.end = end;
        this.oriented = oriented;
        this.price = price;
    }

    public AbstractEdge(T begin, T end, boolean oriented){
        this(begin,end,oriented,DEFAULT_PRICE);
    }

    public AbstractEdge(T begin, T end, Number price){
        this(begin,end,false,price);
    }

    public AbstractEdge(T begin, T end){
        this(begin, end, false);
    }


    @Override
    public T getBegin() {
        return begin;
    }

    @Override
    public T getEnd() {
        return end;
    }

    @Override
    public boolean isOriented() {
        return oriented;
    }

    @Override
    public Number getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return begin.toString() + (oriented? '-':'<') + "-" + price + "->" + end.toString();
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof AbstractEdge)) return false;
        final AbstractEdge other = (AbstractEdge) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$begin = this.getBegin();
        final Object other$begin = other.getBegin();
        final Object this$end = this.getEnd();
        final Object other$end = other.getEnd();
        //
        if ((this$begin == null)||(this$end == null)){
            return false;
        }
        //
        if (this.isOriented() != other.isOriented()) return false;
        else {
            if (!this.isOriented()) {
                if (((this$begin.equals(other$begin)) && (this$end.equals(other$end)))
                        || ((this$begin.equals(other$end)) && (this$end.equals(other$begin)))){
                    return true;
                }else return false;
            }else{
                if ( !this$begin.equals(other$begin)) return false;
                if ( !this$end.equals(other$end)) return false;
            }
        }
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $begin = this.getBegin();
        final Object $end = this.getEnd();
        result = result * PRIME + ($begin == null ? 43 : $begin.hashCode()) + ($end == null ? 43 : $end.hashCode());
        result = result * PRIME + (this.isOriented() ? 79 : 97);
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AbstractEdge;
    }
}
