package task;

public class DoubleLinkedListItem<T extends Comparable<T>> {
    protected T data;
    private DoubleLinkedListItem<T> prev;
    private DoubleLinkedListItem <T> next;

    public DoubleLinkedListItem(T data){
        this.data = data;
    }

    public DoubleLinkedListItem <T> getNext(){
          return next;
    }
    public DoubleLinkedListItem <T> getPrev(){
         return prev;
    }
    public T getData(){
        return data;
    }
     public void setNext(DoubleLinkedListItem<T> next){
        this.next = next;
     }
     public void setPrev(DoubleLinkedListItem<T> prev){
        this.prev = prev;
     }

    public void setData(T data) {
        this.data = data;
    }
}
