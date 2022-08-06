package pradee;
import java.io.Serializable;
import java.util.Iterator;
/*
 * generics
 */


public class PradeeList<T> implements Iterable<T>, Serializable {
    Node head;

    class Node implements Serializable{
        T data;
        Node next;
        Node(T val){
            data = val;
            next = null;
        }
    }

    public PradeeList(){
        head = null;
    }

    public void insertAtBeginning(T val){
        Node newNode = new Node(val);
        //when list empty
        if(head==null)
            head = newNode;
        else { //list is not empty
            newNode.next = head;
            head = newNode;
        }

    }
    public void add(T val){
       Node newNode = new Node(val);
        if(head ==null)
    {
       head = newNode;
    }

        Node temp = head;
        Node fine = head;
        while (temp != null){ //jump to prev node
            fine = temp;
            temp = temp.next;
        }
        //reassign pointers
        fine.next = newNode;
    }

    public void display() {
        Node temp = head; //start from head
        while(temp != null) { //null implies end of list
            System.out.print( temp.data );
            temp = temp.next; //jump
        }

    }
public  int search(T val){
    Node temp = head; //start from head
    int index =-1,c = 0;
    while(temp != null) { //null implies end of list
        if (val == temp.data) {
            index = c;
            break;
        }
        temp = temp.next;//jump
        c++;
    }
    return index;
}
public void remove(T val){
        deleteAtPos(search(val));
}
    public void insertAtPos(int pos,T val) {
        if(pos==0)
        {
            insertAtBeginning(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;
        for(int i=1;i<pos;i++) { //jump to prev node
            temp = temp.next;
            if(temp==null)
                throw new IndexOutOfBoundsException("Invalid Pos " + pos);
        }

        //reassign pointers
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void deleteAtPos(int pos) {

        if(head==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");

        if(pos==0) {
            head = head.next;
            return;
        }

        Node temp = head;
        Node prev = null;

        //jump till node to be deleted
        for(int i=1;i<=pos;i++) {
            prev = temp; //keep track of prev node
            temp = temp.next; //jump to next node
        }

        prev.next = temp.next; //reassign pointers
    }

    public void deleteAtBeginning() {

        if(head==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");

        head = head.next;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = head.next;

        while(current!=null) {
            next=current.next;
            current.next = prev; //reverse link
            prev = current;
            current = next;
        }

        head = prev;
    }



    public Iterator<T> iterator(){
        return new Iterator<T>() {
            Node temp = head;

            public boolean hasNext() {
                return temp!=null;
            }

            public T next() {
                T val = temp.data;
                temp = temp.next;
                return val;

            }
        };
    }


}

/*try the following methods
 *
 * get(pos) - get(2)
 * update(pos,val)
 * deleteAtEnd
 * insertAtEnd(val)
 * search(val) - return index, -1
 * contains(val) - return true or false
 * length
 */