package module9.task1;

import java.util.Arrays;

public class MyArrayList<E> {

    private Object elementData[];
    private int size = 0;

    public MyArrayList() {
        elementData = new Object[10];
    }

    public boolean add(E value) {
        if (size >= elementData.length) {
            Object[] temperaryArray = new Object[elementData.length * 3 / 2 + 1];
            System.arraycopy(elementData, 0, temperaryArray, 0, elementData.length);
            elementData = temperaryArray;
        }
        elementData[size++] = value;
        return true;
    }

    public E remove(int index) {
        Object oldElement = elementData[index];
        System.arraycopy(elementData, index + 1 , elementData, index, size - index - 1);
        System.out.println(this);
        elementData[size -1] = null;
        size--;
        return (E) oldElement;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("You are out of Array");
        }
        return (E) elementData[index];
    }

//    @Override
//    public String toString() {
//        return "MyArrayList{" +
//                ", size=" + size +
//                ", capacity=" + elementData.length +
//                " elementData=" + Arrays.toString(elementData) +
//                '}';
//    }
}


