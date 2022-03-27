import org.junit.*;



public class Task1_Tests extends Assert {

    @Test
    public void pushFront_pushToEmptyList_SizeEqualsOne() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        assertEquals(1, list.getSize());
    }

    @Test
    public void pushFront_pushToEmptyList_HeadAndTailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals(10, head.getData().intValue());
        assertEquals(10, tail.getData().intValue());
        assertEquals(head, tail);
    }

    @Test
    public void pushFront_pushTwoElements_HeadAndTailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        list.pushFront(20);
        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals(20, head.getData().intValue());
        assertEquals(10, tail.getData().intValue());
    }

    @Test
    public void pushBack_pushToEmptyList_HeadAndTailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals(10, head.getData().intValue());
        assertEquals(10, tail.getData().intValue());
        assertEquals(head, tail);
    }

    @Test
    public void pushBack_pushTwoElements_HeadAndTailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals(10, head.getData().intValue());
        assertEquals(20, tail.getData().intValue());
    }

    @Test
    public void insertAfter_insertOneElement_getSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        list.pushFront(20);
        Node<Integer> head = (Node<Integer>) list.getHead();
        list.insertAfter(head, 15);
        assertEquals(3, list.getSize());
    }

    @Test
    public void insertBefore_insertOneElements_HeadAndTailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushFront(20);
        Node<Integer> head = (Node<Integer>) list.getHead();
        list.insertBefore(head , 15);
        Node<Integer> head1 = (Node<Integer>) list.getHead();
        assertEquals(3, list.getSize());
        assertEquals(15, head1.getData().intValue());
    }
    @Test
    public void insertAfter_insertOneElements_HeadAndTailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushFront(20);
        Node<Integer> tail = (Node<Integer>) list.getTail();
        list.insertAfter(tail , 15);
        Node<Integer> tail1 = (Node<Integer>) list.getTail();
        assertEquals(15, tail1.getData().intValue());
    }
    @Test
    public void isEmpty_EmptyList_SizeEqualsNull() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(55);
        assertFalse(list.isEmpty());
    }
    @Test
    public void get_OutOfHighBound_IndexCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushFront(20);
        try {
            list.get(2);
            fail();
        } catch(IndexOutOfBoundsException e) {
        assertTrue("Error", true);
        }
    }
    @Test
    public void get_GetTwoElements_GetIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushFront(20);
        Node<Integer> item1 = (Node<Integer>) list.get(0);
        Node<Integer> item2 = (Node<Integer>) list.get(1);
        assertEquals(10, item2.getData().intValue());
        assertEquals(20, item1.getData().intValue());

    }
    @Test
    public void remove_removeOneElements_SizeIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushFront(20);
        list.pushFront(30);
        list.remove(list.get(0));
        assertEquals(2, list.getSize());
    }
    @Test
    public void remove_removeOneElement_RemoveIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushFront(20);
        list.pushBack(23);
        Node<Integer> item1 = (Node<Integer>) list.get(0);
        list.remove(item1);
        Node<Integer> item2 = (Node<Integer>) list.get(0);
        assertEquals(10, item2.getData().intValue());
    }
    @Test
    public void insertListAfter_insertList_SizeIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushFront(20);
        list.pushBack(23);
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(25);
        list1.pushFront(22);
        list1.pushFront(28);
        list.insertListAfter(list.get(0), list1);
        assertEquals(6, list.getSize());
    }
    @Test
    public void insertListAfter_insertList_TailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushFront(20);
        list.pushBack(23);
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(25);
        list1.pushFront(22);
        list1.pushFront(28);
        list.insertListAfter(list.get(2), list1);
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals(25, tail.getData().intValue());
    }
    @Test
    public void insertListAfter_insertList_GetCorrectItem() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(23);
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(25);
        list1.pushFront(22);
        list1.pushFront(28);
        list.insertListAfter(list.get(0), list1);
        Node<Integer> item = (Node<Integer>) list.get(4);
        assertEquals(20, item.getData().intValue());
    }
    @Test
    public void insertListBefore_insertList_SizeIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushFront(20);
        list.pushBack(23);
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(25);
        list1.pushFront(22);
        list1.pushFront(28);
        list.insertListBefore(list.get(1), list1);
        assertEquals(6, list.getSize());
    }
    @Test
    public void insertListBefore_insertList_TailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(23);
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(25);
        list1.pushFront(22);
        list1.pushFront(28);
        list.insertListBefore(list.get(0), list1);
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals(23, tail.getData().intValue());
    }
    @Test
    public void insertListBefore_insertList_ItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(23);
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(25);
        list1.pushFront(22);
        list1.pushFront(28);
        list.insertListBefore(list.get(1), list1);
        Node<Integer> item = (Node<Integer>) list.get(4);
        assertEquals(20, item.getData().intValue());
    }
    @Test
    public void newArray_CreateArray_SizeEqualsOne() {
        DynamicArray <Integer> array = new DynamicArray<>(1024);
        assertEquals(1024, array.getSize());
    }
    @Test
    public void newArray_CreateArray_SizeEquals() {
        DynamicArray <Integer> array = new DynamicArray<>(2000);
        array.set(1500,200);
        assertEquals(200, array.get(1500).intValue());
    }
    @Test
    public void resize_ChangeArraySize_SizeEquals() {
        DynamicArray <Integer> array = new DynamicArray<>();
        array.resize(6);
        assertEquals(6, array.getSize());
    }
    @Test
    public void get_GetItem_GetCorrectItem() {
        DynamicArray <Integer> array = new DynamicArray<>();
        array.pushBack(24);
        try {
            array.get(1);
            fail();
        } catch(IndexOutOfBoundsException e) {
            assertTrue("Error", true);
        }
    }
    @Test
    public void pushBack_pushItem_SizeIsCorrect() {
        DynamicArray <Integer> array = new DynamicArray<>();
        array.pushBack(6);
        array.pushBack(8);
        assertEquals(2, array.getSize());
        assertEquals(8, array.get(1).intValue());
    }
    @Test
    public void insert_insertItems_SizeIsCorrect() {
        DynamicArray <Integer> array = new DynamicArray<>();
        array.insert(0, 15);
        array.insert(1,20);
        assertEquals(2, array.getSize());
    }
    @Test
    public void insert_insertItems_InsertIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 15);
        array.insert(1, 20);
        array.insert(2, 25);
        assertEquals(20, array.get(1).intValue());
    }
    @Test
    public void set_setElement_SetIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 15);
        array.set(0, 20);
        assertEquals(20, array.get(0).intValue());
    }
    @Test
    public void set_setElement_BoundsAreCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 15);
        array.set(0, 20);
        try {
            array.set(1,25);
            fail();
        } catch(IndexOutOfBoundsException e) {
            assertTrue("Error", true);
        }
    }
    @Test
    public void remove_removeElement_SizeIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 15);
        array.insert(1,20);
        array.remove(0);
        assertEquals(1, array.getSize());
    }
    @Test
    public void remove_removeElement_ValueIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 15);
        array.insert(1,20);
        array.remove(0);
        assertEquals(20, array.get(0).intValue());
    }
    @Test
    public void remove_removeElement_BoundsAreCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 15);
        array.insert(1,20);
        try {
            array.remove(2);
            fail();
        } catch(IndexOutOfBoundsException e) {
            assertTrue("Error", true);
        }
    }
    @Test
    public void popBack_popBackElement_SizeIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 15);
        array.insert(1,20);
        array.popBack();
        assertEquals(1, array.getSize());
    }
    @Test
    public void popBack_popBackElement_BoundsAreCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>();
        try {
            array.popBack();
            fail();
        } catch(UnsupportedOperationException e) {
            assertTrue("Error", true);
        }
    }
}








