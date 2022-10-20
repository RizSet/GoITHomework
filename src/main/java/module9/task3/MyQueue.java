package module9.task3;

import java.util.Arrays;

public class MyQueue<E> {
    private Object elementData[];
    private int size = 0;

    public MyQueue() {
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
        System.arraycopy(elementData, index + 1, elementData, index, size - index + 1);
        elementData[size] = null;
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

    public E peek() {
        if (size <= 0){
            throw new IndexOutOfBoundsException();
        }
            return (E) elementData[0];
    }

    public E poll() {
        E firstElement = (E) elementData[0];
        System.arraycopy(elementData, 1, elementData, 0, size - 1);
        return firstElement;
    }

//    @Override
//    public String toString() {
//        return "MyQueue{" +
//                ", size=" + size +
//                ", capacity=" + elementData.length +
//                " elementData=" + Arrays.toString(elementData) +
//                '}';
//    }

}
