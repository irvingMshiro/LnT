package project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Menu {
    String kodeMenu;
    String namaMenu;
    int hargaMenu;
    int stokMenu;
}

public class Main {

    private static ArrayList<Menu> menuList = new ArrayList<>();

    public static void main(String[] args) {
        int pilihan;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n== PT Pudding App ==");
            System.out.println("1. Insert Menu Baru");
            System.out.println("2. View Menu");
            System.out.println("3. Update Menu");
            System.out.println("4. Delete Menu");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    insertMenu(input);
                    break;
                case 2:
                    viewMenu();
                    break;
                case 3:
                    updateMenu(input);
                    break;
                case 4:
                    deleteMenu(input);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi PT Pudding.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        } while (pilihan != 5);
    }

    public static void insertMenu(Scanner input) {
        Menu menu = new Menu();
        menu.kodeMenu = "PD-" + (new Random().nextInt(900) + 100);

        System.out.print("Nama Menu: ");
        menu.namaMenu = input.nextLine();

        System.out.print("Harga Menu: ");
        menu.hargaMenu = input.nextInt();

        System.out.print("Stok Menu: ");
        menu.stokMenu = input.nextInt();
        input.nextLine();

        menuList.add(menu);
        System.out.println("Menu berhasil ditambahkan.");
    }

    public static void viewMenu() {
        System.out.println("\nDaftar Menu:");

        // Tampilkan header tabel
        System.out.printf("%-15s %-30s %-15s %-15s%n", "Kode Menu", "Nama Menu", "Harga Menu", "Stok Menu");
        System.out.println("-----------------------------------------------------------------------------");

        // Tampilkan data menu dalam bentuk tabel
        for (Menu menu : menuList) {
            System.out.printf("%-15s %-30s %-15d %-15d%n", menu.kodeMenu, menu.namaMenu, menu.hargaMenu, menu.stokMenu);
        }
        System.out.println();
    }

    public static void updateMenu(Scanner input) {
        System.out.print("Masukkan Kode Menu: ");
        String kodeMenu = input.nextLine();

        Menu menuToUpdate = null;
        for (Menu menu : menuList) {
            if (menu.kodeMenu.equals(kodeMenu)) {
                menuToUpdate = menu;
                break;
            }
        }

        if (menuToUpdate != null) {
            System.out.print("Harga Menu baru: ");
            menuToUpdate.hargaMenu = input.nextInt();

            System.out.print("Stok Menu baru: ");
            menuToUpdate.stokMenu = input.nextInt();
            input.nextLine();

            System.out.println("Menu berhasil diperbarui.");
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }

    public static void deleteMenu(Scanner input) {
        System.out.print("Masukkan Kode Menu: ");
        String kodeMenu = input.nextLine();

        Menu menuToDelete = null;
        for (Menu menu : menuList) {
            if (menu.kodeMenu.equals(kodeMenu)) {
                menuToDelete = menu;
                break;
            }
        }

        if (menuToDelete != null) {
            menuList.remove(menuToDelete);
            System.out.println("Menu berhasil dihapus.");
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }
}
