package PraktikumOOP.MODUL1.TPMODUL1_AVISENA;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void clearScreen() { System.out.print ("\033[H\033[2J"); System.out.flush (); }
    public static void main(String[] args) {
        BankEAD bank = new BankEAD();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==ADMIN PANEL BANK EAD==:");
            System.out.println("[1] Tambah Akun");
            System.out.println("[2] Hapus Akun");
            System.out.println("[3] Tambah Saldo");
            System.out.println("[4] Kurangi Saldo");
            System.out.println("[5] Lihat Data Akun");
            System.out.println("[6] Lihat Semua Data Akun");
            System.out.println("[7] Keluar");
            System.out.print("Pilihan Anda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clearScreen();
                    System.out.print("Masukkan nama akun: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan nomor akun: ");
                    String accountNumber = scanner.nextLine();
                    Account newAccount = new Account(name, accountNumber);
                    bank.addAccount(newAccount);
                    System.out.println("Akun berhasil ditambahkan.");
                    break;
                case 2:
                    clearScreen();
                    System.out.print("Masukkan nomor akun yang ingin dihapus: ");
                    String accountToDelete = scanner.nextLine();
                    Account account = bank.getAccount(accountToDelete);
                    if (account != null) {
                        bank.removeAccount(account);
                        System.out.println("Akun berhasil dihapus.");
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 3:
                    clearScreen();
                    System.out.print("Masukkan nomor akun: ");
                    String accountToDeposit = scanner.nextLine();
                    Account depositAccount = bank.getAccount(accountToDeposit);
                    if (depositAccount != null) {
                        System.out.print("Masukkan jumlah yang ingin ditambahkan: ");
                        Integer depositAmount = scanner.nextInt();
                        bank.deposit(depositAccount, depositAmount);
                        System.out.println("Saldo berhasil ditambahkan.");
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 4:
                    clearScreen();
                    System.out.print("Masukkan nomor akun: ");
                    String accountToWithdraw = scanner.nextLine();
                    Account withdrawAccount = bank.getAccount(accountToWithdraw);
                    if (withdrawAccount != null) {
                        System.out.print("Masukkan jumlah yang ingin ditarik: ");
                        Integer withdrawAmount = scanner.nextInt();
                        boolean success = bank.withdraw(withdrawAccount, withdrawAmount);
                        if (success) {
                            System.out.println("Penarikan berhasil.");
                        } else {
                            System.out.println("Saldo tidak mencukupi untuk melakukan penarikan.");
                        }
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 5:
                    clearScreen();
                    System.out.print("Masukkan nomor akun yang ingin dilihat: ");
                    String accountNumberToView = scanner.nextLine();
                    Account viewAccount = bank.getAccount(accountNumberToView);
                    if (viewAccount != null) {
                        System.out.println("\nInformasi Akun: ");
                        System.out.println("Nama: " + viewAccount.getName() +
                                ", Nomor Akun: " + viewAccount.getAccountNumber() +
                                ", Saldo: " + viewAccount.getBalance());
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 6:
                    clearScreen();
                    ArrayList<Account> allAccounts = bank.getAllAccounts();
                    System.out.println("\nSemua Data Akun: ");
                    for (Account viewaccount : allAccounts) {
                        System.out.println("Nama: " + viewaccount.getName() +
                                ", Nomor Akun: " + viewaccount.getAccountNumber() +
                                ", Saldo: " + viewaccount.getBalance());
                    }
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-7.");
            }
        }
    }
}

