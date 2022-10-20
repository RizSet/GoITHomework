package module9.task2;

public class MyLinkedList<E> {
    private int size = 0;
    private Node<E> firstNode;
    private Node<E> lastNode;

    public boolean add(E value) {
        if (size == 0) {
            lastNode = firstNode = new Node<>(null, value, null);
        } else {
            lastNode.nextNode = new Node<>(lastNode, value, null);
            lastNode = lastNode.nextNode;
        }
        size++;
        return true;
    }

    public E remove(int index) {
        Node<E> curentNode = firstNode;
        if (index == 0){
            firstNode.nextNode.prevNode = null;
            firstNode = firstNode.nextNode;
            size--;
            return curentNode.value;
        }
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("You are out of LinkedList");
        }
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                curentNode.prevNode.nextNode = curentNode.nextNode;
                curentNode.nextNode.prevNode = curentNode.prevNode;
            } else {
                curentNode = curentNode.nextNode;
            }
        }
        size--;
        return curentNode.value;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            firstNode = firstNode.nextNode;
            if (i != size - 1) {
                firstNode.prevNode = null;
            }
        }
        lastNode.prevNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Node<E> curentNode = firstNode;
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("You are out of LinkedList");
        }
        for (int i = 0; i <= index; i++) {
            if (i != index) {
                curentNode = curentNode.nextNode;
            }
        }
        return curentNode.value;
    }


    private static class Node<E> {
        E value;
        Node<E> prevNode;
        Node<E> nextNode;

        Node(Node<E> prevNode, E value, Node<E> nextNode) {
            this.nextNode = nextNode;
            this.prevNode = prevNode;
            this.value = value;
        }

    }

//    @Override
//    public String toString() {
//        Node<E> curentNode = firstNode;
//        String string = "MyLinkedList{" +
//                "size=" + size + " ";
//        for (int i = 0; i < size; i++) {
//            string += curentNode.value + " ";
//            curentNode = curentNode.nextNode;
//        }
//        string += '}';
//        return string;
//    }
}
