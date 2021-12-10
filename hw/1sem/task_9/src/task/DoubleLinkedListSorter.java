package task;

public class DoubleLinkedListSorter {
    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {
        for(int i = 0; i < list.getSize(); i++) {
            DoubleLinkedListItem <T> min = list.getFirst();
            DoubleLinkedListItem <T> temp = list.getFirst();
            for (int j = 0; j< list.getSize()-i;j++){
                if (min.getData().compareTo(temp.getData())>0){
                    min = temp;
                }
                temp = temp.getNext();
            }
            list.remove(min);
            list.insertAfter(list.getLast(),min.getData());
        }
    }
}
