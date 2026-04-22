package l12.collections.part1.inclass;

public class MyLinkedList {

    public Node root;
    private int size;

    public class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public MyLinkedList() {

    }

    public void add(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            size++;
        } else {
            Node current = root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void print() {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }
}
