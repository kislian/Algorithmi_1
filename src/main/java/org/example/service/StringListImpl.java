package org.example.service;

import org.example.exception.ElementNotFoundException;
import org.example.exception.IllegalArgumentException;
import org.example.exception.InvalidIndexException;
import org.example.exception.StorageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] storage;
    private int size;

    public StringListImpl(String[] storage) {
        this.storage = storage;
    }

    public StringListImpl() {
        storage = new String[10];
    }

    public StringListImpl(int initSize) {
        storage = new String[initSize];
    }

    private void validateItem(String Item) {
        if (Item == null) {
            //throw new NullItemsException();
            throw new IllegalArgumentException("Argument cannot be null");
        }
    }

    public void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException("StorageIsFull");
        }
    }
//валидация  индекса  проверка диапазона допустимых значений
    private void validateIndex(int index) {
        if (index < 0 || index >=storage.length) {
            throw new InvalidIndexException("Индекс вне диапазона");
        }
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        storage [size++]= item;
        return "Элемент " + item + " добавлен в ячейку под № "+ (size-1) ;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index <= size - 1) {
            storage[size++] = item;
            return "Элемент " + item + " добавлен в позицию № " + size;
        }
        storage[index] = item;
            return "Элемент " + item + " добавлен в позицию № " + index;
        }
    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        String oldValue = storage[index];
        storage[index] = item;
        if (index > size - 1) {
            return "Элемент " + item + " записан в ячейку № " + index;
        }
        return "В ячейке № " + index + "старый  элемент" + oldValue + " заменён на новый " + item;
    }
    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException("Element " + item + " is not present in the list");
        }
        if(index != size) {
            System.arraycopy(storage, index+1, storage, index , size - index);
        }
        size--;
        return "Удалёно значение " + item +"по индексу № "+ index;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String removeItem = storage[index];
        if(index != size) {
            System.arraycopy(storage, index+1, storage, index, size - index);
        }
        size--;
        return removeItem;
    }

    @Override
    public boolean contains(String item) {
                   return indexOf(item) !=-1;
        }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear(){
            Arrays.fill(storage,"");
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }


    @Override
    public String
    toString() {
        return "StringListImpl{" +
                "storage=" + Arrays.toString(storage) +
                ", size=" + size +
                '}';
    }
}
