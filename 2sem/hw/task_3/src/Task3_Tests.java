import org.junit.*;

public class Task3_Tests extends Assert {
    static class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second){
            return first - second;
        }
    }
    @Test
    public void sort_SortedData_QuickSortIsCorrect(){
        Integer[] data = {1,3,4,5,8};
        QuickSort<Integer> qSort= new QuickSort<>();
        qSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,3,4,5,8}, data);
    }
    @Test
    public void sort_DecreaseData_QuickSortIsCorrect(){
        Integer[] data = {9, 5};
        QuickSort<Integer> qSort= new QuickSort<>();
        qSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {5,9}, data);
    }

    @Test
    public void sort_ComplicatedData_QuickSortIsCorrect(){
        Integer[] data = {9,5,4,2};
        QuickSort<Integer> qSort = new QuickSort<>();
        qSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {2,4,5,9}, data);
    }
    @Test
    public void sort_SomeData_QuickSortIsCorrect(){
        Integer[] data = {9,2,2,7,4,2};
        QuickSort<Integer> qSort = new QuickSort<>();
        qSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {2,2,2,4,7,9}, data);
    }
    @Test
    public void sort_SimpleData_MergeSortIsCorrect(){
        Integer[] data = {1};
        Sort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1}, data);
    }
    @Test
    public void sort_SortedData_MergeSortIsCorrect(){
        Integer[] data = {1,2};
        Sort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2}, data);
    }
    @Test
    public void sort_MiddleData_MergeSortIsCorrect(){
        Integer[] data = {2,1};
        Sort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2}, data);
    }

    @Test
    public void sort_DecreaseData_MergeSortIsCorrect(){
        Integer[] data = {2,3,1};
        Sort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2,3}, data);
    }
    @Test
    public void sort_ThreeData_MergeSortIsCorrect(){
        Integer[] data = {2,1,3};
        Sort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2,3}, data);
    }
    @Test
    public void sort_BigData_MergeSortIsCorrect(){
        Integer[] data = {2,1,3,5,7,1,9};
        Sort<Integer> mSort= new MergeSort<>();
        mSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,1,2,3,5,7,9}, data);
    }
    @Test
    public void sort_SimpleData_HeapSortIsCorrect(){
        Integer[] data = {2,1};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2}, data);
    }
    @Test
    public void sort_SortedData_HeapSortIsCorrect(){
        Integer[] data = {1,2};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2}, data);
    }
    @Test
    public void sort_SomeData_HeapSortIsCorrect(){
        Integer[] data = {2,1,3};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2,3}, data);
    }
    @Test
    public void sort_FourElementsData_HeapSortIsCorrect(){
        Integer[] data = {2,1,7,3};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2,3,7}, data);
    }
    @Test
    public void sort_DifficultData_HeapSortIsCorrect(){
        Integer[] data = {8,8,9,30,22,55};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {8,8,9,22,30,55}, data);
    }
    @Test
    public void sort_SpecificData_HeapSortIsCorrect(){
        Integer[] data = {9,8,7,6,5,4,10};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {4,5,6,7,8,9,10}, data);
    }
    @Test
    public void sort_ComplicatedData_HeapSortIsCorrect(){
        Integer[] data = {8,8,9,30,99,22,55};
        Sort<Integer> hSort= new HeapSort<>();
        hSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {8,8,9,22,30,55,99}, data);
    }


}
