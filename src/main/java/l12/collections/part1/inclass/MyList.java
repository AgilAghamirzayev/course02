package l12.collections.part1.inclass;

public class MyList {


    // [ 1, 2, 3, 4, 5, 6, 7, 8 ]
    private int[] root;
    private int size;

    public MyList() {
        root = new int[8];
        this.size = 0;
    }

    public MyList(int size) {
        root = new int[size];
        this.size = 0;
    }

    public void add(int value) {
        if (size == root.length -1) {
           int temp[] = new int[size * 2];
           for (int i = 0; i < root.length; i++) {
               temp[i] = root[i];
           }
           root = temp;
        }
        root[size] = value;
        size++;
    }

    public int getByIndex(int index) {
        return root[index];
    }

    public void remove(int value) {
        if (size == 0) {
           throw new RuntimeException("List is empty");
        }
        for (int i = 0; i < root.length; i++) {
            if (root[i] == value) {
                if (i == root.length - 1) {
                    root[i] = 0;
                    size--;
                    break;
                }
                int j = root[i + 1];
                int temp = root[i];
                root[i] = j;
                root[i + 1] = temp;
            }
        }
    }

    public void print() {
        System.out.print(" [ ");
        for (int i = 0; i < root.length; i++) {
            if (i == root.length - 1) {
                System.out.print(root[i]);
                break;
            }
            System.out.print(root[i] + ", ");

        }
        System.out.println(" ] ");
    }

    public int getSize() {
        return size;
    }
}
