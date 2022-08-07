package pradee;
import java.io.Serializable;
import java.util.*;

public class PradiArray<T> implements Iterable<T>, Serializable {//variables - methods
    private static final int initialCapacity = 2;
        private T arr[];
        private int size;
        private int capacity;

        @SuppressWarnings("unchecked")
        public PradiArray(){
            size = 0;
            arr = (T[]) new Object[initialCapacity];
            capacity = initialCapacity;
        }

        public void add(T val) {
            if(size==capacity)
                expandArray();
            arr[size++] = val;

        }

        private void expandArray() {
            capacity *= 2;
            arr = java.util.Arrays.copyOf(arr,capacity);
        }

        public void display() {
            System.out.println("Elements in the list: ");
            for(int i=0;i<size;i++)
                System.out.print(arr[i] + " ");
        }

        public void insertAtPos(int pos,T val) {
            if(size==capacity)
                expandArray();
            for(int i=size-1;i>=pos;i--)
                arr[i+1] = arr[i];
            arr[pos] = val;
            size++;
        }

        public void deleteAtPos(int pos) {

            for(int i=pos+1;i<size;i++)
                arr[i-1] = arr[i];

            size--;

            if(capacity > initialCapacity && capacity > 3*size)
                shrinkArray();
        }

        private void shrinkArray() {
            capacity /= 2;
            arr =java.util.Arrays.copyOf(arr, capacity);
        }

        public int length() {
            return size;
        }
public int serarchIndex(T val){
            int index = -1;
            for (int i=0;i<length();i++){
                if (arr[i] == val){
                    index = i;
                }
            }
            return index;

}
public void remove(T val){
            deleteAtPos(serarchIndex(val));
}
public void update(T oval,T nval){
           int i = serarchIndex(oval);
           deleteAtPos(i);
           insertAtPos(i,nval);
}
        public Iterator<T> iterator(){
            return new Iterator<T>(){

                int index = 0;

                public T next() {
                    return arr[index++];
                }

                public boolean hasNext() {
                    return index < size;
                }
            };
        }

    }



