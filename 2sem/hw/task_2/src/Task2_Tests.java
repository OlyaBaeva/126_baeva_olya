import org.junit.*;

public class Task2_Tests extends Assert {
    static class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second){
            return first - second;
        }
    }
    @Test
    public void sort_SimpleData_BubbleSortIsCorrect(){
        Integer[] data = {1,1,1};
        BubbleSort<Integer> bSort= new BubbleSort<>();
        bSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,1,1}, data);
    }
    @Test
    public void sort_DecreaseData_BubbleSortIsCorrect(){
     Integer[] data = {9, 5, 4, 1};
     BubbleSort<Integer> bSort= new BubbleSort<>();
     bSort.sort(data, new TestComparator());
     assertArrayEquals(new Integer[] {1,4,5,9}, data);
    }

    @Test
    public void sort_IncreaseData_BubbleSortIsCorrect(){
        Integer[] data = {2,5,7,1,8};
        BubbleSort<Integer> bSort = new BubbleSort<>();
        bSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2,5,7,8}, data);
    }
    @Test
    public void sort_SimpleData_InsertionSortIsCorrect(){
        Integer[] data = {1,2,3};
        InsertionSort<Integer> iSort = new InsertionSort<>();
        iSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2,3}, data);

    }
    @Test
    public void sort_DecreaseData_InsertionSortIsCorrect(){
        Integer[] data = {3,0,1,2};
        InsertionSort<Integer> iSort = new InsertionSort<>();
        iSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {0,1,2,3}, data);

    }
    @Test
    public void sort_someData_InsertionSortIsCorrect(){
        Integer[] data = {333,0,22,4,1};
        InsertionSort<Integer> iSort = new InsertionSort<>();
        iSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {0,1,4,22,333}, data);
    }
    @Test
    public void sort_SimpleData_SelectionSortIsCorrect(){
        Integer[] data = {1,2,1};
        SelectionSort<Integer> sSort = new SelectionSort<>();
        sSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,1,2 }, data);

    }

    @Test
    public void sort_SomeData_SelectionSortIsCorrect(){
        Integer[] data = {1,2,3};
        SelectionSort<Integer> sSort = new SelectionSort<>();
        sSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2,3}, data);
    }
    @Test
    public void sort_IncreaseData_SelectionSortIsCorrect(){
        Integer[] data = {2,1};
        SelectionSort<Integer> sSort = new SelectionSort<>();
        sSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2}, data);
    }
    @Test
    public void sort_DecreaseData_SelectionSortIsCorrect(){
        Integer[] data = {3,2,5};
        SelectionSort<Integer> sSort = new SelectionSort<>();
        sSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {2,3,5}, data);
    }

    @Test
    public void sort_DifficultData_SelectionSortIsCorrect(){
        Integer[] data = {1,2,3,4,0};
        SelectionSort<Integer> sSort = new SelectionSort<>();
        sSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {0,1,2,3,4}, data);
    }


}
