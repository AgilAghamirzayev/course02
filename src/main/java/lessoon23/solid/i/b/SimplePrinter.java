package lessoon23.solid.i.b;

class SimplePrinter implements Machine {
    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        throw new UnsupportedOperationException("Scan not supported");
    }

    public void fax() {
        throw new UnsupportedOperationException("Fax not supported");
    }
}