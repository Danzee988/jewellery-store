package jewellery.store.project;

public class LinkedList<E> {
    public int actualSize;
    private Node head = null;


    public LinkedList() {}

    public boolean isEmpty(){
        return size() == 0;
    }

    public void add(E data) {
        //creating a node head if not present yet
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node temp = new Node(data);
            Node current = head;


            //checking for a null pointer exception
            if (current != null) {

                //scrolling through list to add a node at the end
                while (current.getNext() != null) {
                    current = current.getNext();
                }

                //setting last node to reference new node
                current.setNext(temp);


            }
        }
        actualSize++;
    }

    public void deleteNode(int index) {
        if (head != null) {
            if (index <= 0) {
                if (head.getNext() == null) {
                    head = null;
                } else {
                    head = head.getNext();
                }
            } else {
                index--;
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.getNext();
                }
                Node temp = current.getNext().getNext();
                if(temp != null) {
                    current.setNext(temp);
                }else {
                    current.setNext(null);
                }
            }
        }
        --actualSize;
    }

    public int size(){
        return actualSize;
    }


    public Object get(int index)
    {
        // index must be 1 or higher
        if (index == 0)
            return head.getData();
        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 1; i < index; i++) {
                if (current.getNext() == null)
                    return null;
                current = current.getNext();
            }
            return current.getData();
        }
        else {
            return null;
        }
    }

    public String listAll() {
        if (head == null) {
            return "";
        } else {
            Node temp = head;
            String allItems = "";
            while (temp != null) {
                allItems += temp.getData();
                temp = temp.next;
            }
            return allItems;
        }
    }

    public String listOne() {
        if (head == null) {
            return "";
        } else {
            Node temp = head;
            String singleItem = "";
            while (temp != null) {
                singleItem = String.valueOf(temp.getData());
                temp = temp.next;
            }
            return singleItem;
        }
    }

    public void delAll(){
        if(head!=null){
            head = null;
            actualSize = 0;
        }
    }

}

