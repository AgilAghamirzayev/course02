package az.texnoera.lesson29;

import az.texnoera.lesson29.dao.AccountDao;
import az.texnoera.lesson29.dao.AccountDaoImpl;
import az.texnoera.lesson29.entity.Account;
import az.texnoera.lesson29.service.AccountService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {

    AccountDao accountDao = new AccountDaoImpl();
    AccountService service = new AccountService(accountDao);
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Main main = new Main();

//      main.service.transferMoney(1L,2L,BigDecimal.valueOf(500));
        List<Account> allAccounts = main.service.getAllAccounts();

        allAccounts.forEach(System.out::println);
//        System.out.print("Enter Account Owner: ");
//        String owner = main.scanner.nextLine();
//        System.out.print("Enter Account Balance: ");
//        BigDecimal balance = main.scanner.nextBigDecimal();
//
//        main.service.createAccount(owner, balance);
    }
}
