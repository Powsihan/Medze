package pradee;
import java.io.Serializable; //Use the array as a list
import java.util.*;
//<T> is used to generalize data type
public class PradiArray<T> implements Iterable<T>, Serializable { //iterable-For some iterations in the dynamic array
    private static final int initialCapacity = 2; //Allocates a small memory for the arrays at the initial state
        private T arr[];
        private int size;
        private int capacity;

        @SuppressWarnings("unchecked")
        public PradiArray(){
            size = 0;
            arr = (T[]) new Object[initialCapacity];
            capacity = initialCapacity;
        }
        private void expandArray() { //The size of array will be doubled
            capacity *= 2;
            arr = java.util.Arrays.copyOf(arr,capacity);
        }
        public void add(T val) { //Check the initial size is sufficient
            if(size==capacity)
                expandArray();
            arr[size++] = val;

        }
        //Add an object or a value to a particular place
        public void insertAtPos(int pos,T val) {
            if(size==capacity)
                expandArray();
            for(int i=size-1;i>=pos;i--)
                arr[i+1] = arr[i];
            arr[pos] = val;
            size++;
        }

        public void deleteAtPos(int pos) { //Deletes an object or a value to a particular place

            for(int i=pos+1;i<size;i++)
                arr[i-1] = arr[i];

            size--;

            if(capacity > initialCapacity && capacity > 3*size)
                shrinkArray();
        }

        private void shrinkArray() { //Shrink the array size if there is any extra space
            capacity /= 2;
            arr =java.util.Arrays.copyOf(arr, capacity);
        }

        public int length() {
            return size;
        } //Access the length of the array if the user needs to change
public int serarchIndex(T val){ //If a value is given then the respective index will be returned.
            int index = -1;
            for (int i=0;i<length();i++){
                if (arr[i] == val){
                    index = i;
                }
            }
            return index;

}
//Removes the record by finding the index of that particular value
public void remove(T val){
            deleteAtPos(serarchIndex(val));
}
public void update(T oval,T nval){ //Updates the record
           int i = serarchIndex(oval); //find the index of that particular value
           deleteAtPos(i); //Deletes the old data of the index
           insertAtPos(i,nval); //Add the new data to that index
}
        public Iterator<T> iterator(){ //Iteration in dynamic array
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



