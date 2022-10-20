package module9.task5;

import java.util.Objects;

public class MyHashMap<K, E> {
    private int size = 0;
    private Entry<K, E>[] arrayEntry = new Entry[16];

    private int countBuket(E key) {
        if (key == null) {
            return 0;
        }
        return (arrayEntry.length - 1) & hash(key);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void put(K key, E value) {
        arrayEntry[countBuket((E) key)] = new Entry<>(key, value, arrayEntry[countBuket((E) key)], hashCode());
        size++;
    }

    public boolean remove(K key) {
        boolean isNecessaryElement = false;
        Entry<K, E> temporaryEntry = arrayEntry[countBuket((E) key)];
        Entry<K, E> prevEntry = null;
        while (!isNecessaryElement) {
            if (temporaryEntry == null) {
                System.out.println("Key isn`t exist");
                return false;
            } else if (temporaryEntry.key != key) {
                prevEntry = temporaryEntry;
                temporaryEntry = temporaryEntry.nextEntry;
            } else if (prevEntry != null) {
                prevEntry.nextEntry = temporaryEntry.nextEntry;
                isNecessaryElement = true;
            } else {
                arrayEntry[countBuket((E) key)] = arrayEntry[countBuket((E) key)].nextEntry;
                isNecessaryElement = true;
            }
        }
        size--;
        return true;
    }

    public void clear() {
        int i = 0;
        for (Entry<K, E> bucket : arrayEntry) {
            arrayEntry[i] = null;
            i++;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(K key) {
        boolean isNecessaryElement = false;
        Entry<K, E> temporaryEntry = arrayEntry[countBuket((E) key)];
        while (!isNecessaryElement) {
            if (temporaryEntry == null) {
                System.out.println("Key isn`t exist");
                return null;
            }
            if (temporaryEntry.key != key) {
                temporaryEntry = temporaryEntry.nextEntry;
            } else {
                isNecessaryElement = true;
            }
        }
        return temporaryEntry.value;
    }


    private static class Entry<K, E> {
        private K key;
        private E value;
        private MyHashMap.Entry<K, E> nextEntry;
        private int hashCode;


        Entry(K key, E value, MyHashMap.Entry<K, E> nextEntry, int hashCode) {
            this.key = key;
            this.value = value;
            this.nextEntry = nextEntry;
            this.hashCode = hashCode;

        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    @Override
    public String toString() {
        int countBuket = 0;
        String res = "{ ";
        for (Entry<K, E> bucket : arrayEntry) {
            res +="{ buket="+ countBuket + " ";
            while (bucket != null) {
                res += bucket.key + " = " + bucket.value + "= " + bucket.hashCode + ", " ;
                bucket = bucket.nextEntry;
            }
            res += "} \n " ;
            countBuket++;
        }
        return "MyHashMap{" + res
                +
                        '}' + " size= " + size;
    }
}
