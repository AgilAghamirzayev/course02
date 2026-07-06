package lesson23.designpatterns.creation.prototype;

public class Main {
    public static void main(String[] args) {

        Document contractTemplate = new Document(
                "Contract Template",
                "This contract is between Company and Client.",
                "Legal Department"
        );

        Document clientContract = contractTemplate.clone();
        clientContract.setTitle("Contract for Ali");
        clientContract.setContent("This contract is between Company and Ali.");

        clientContract.print();
    }
}
