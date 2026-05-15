package btu;

import java.util.Scanner;
import java.util.ArrayList;

class LibraryException extends Exception {
    public LibraryException(String mesaj) {
        super(mesaj);
    }
}

abstract class LibraryItem {
    private String id;
    private String title;
    private boolean isAvailable = true;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void displayInfo() {
        System.out.println("ID: " + id + " | Başlık: " + title + " | Durum: " + (isAvailable ? "Mevcut" : "Ödünçte"));
    }
}

class Book extends LibraryItem {
    private String author;
    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("-> Tür: Kitap | Yazar: " + author);
    }
}

class Magazine extends LibraryItem {
    private int issueNumber;
    public Magazine(String id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("-> Tür: Dergi | Sayı No: " + issueNumber);
    }
}

class LibraryManager {
    private ArrayList<LibraryItem> liste = new ArrayList<>();

    public void addItem(LibraryItem item) {
        liste.add(item);
    }

    public void borrowItem(String title) throws LibraryException {
        for (LibraryItem item : liste) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                if (!item.isAvailable()) throw new LibraryException("Bu eser zaten ödünç verilmiş!");
                item.setAvailable(false);
                System.out.println("Başarıyla ödünç alındı.");
                return;
            }
        }
        throw new LibraryException("Eser kütüphanede bulunamadı!");
    }

    public void showAll() {
        if (liste.isEmpty()) System.out.println("Kütüphane şu an boş.");
        for (LibraryItem item : liste) item.displayInfo();
    }
}

public class AkıllıKütüphane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();
        boolean running = true;

        System.out.println("=== KÜTÜPHANE YÖNETİM SİSTEMİNE HOŞGELDİNİZ ===");

        while (running) {
            System.out.println("\n1- Kitap Ekle  2- Dergi Ekle  3- Listele  4- Ödünç Al  5- Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (secim) {
                    case 1:
                        System.out.print("ID: "); String bid = scanner.nextLine();
                        System.out.print("Kitap Adı: "); String bTitle = scanner.nextLine();
                        System.out.print("Yazar: "); String author = scanner.nextLine();
                        manager.addItem(new Book(bid, bTitle, author));
                        break;
                    case 2:
                        System.out.print("ID: "); String mid = scanner.nextLine();
                        System.out.print("Dergi Adı: "); String mTitle = scanner.nextLine();
                        System.out.print("Sayı No: "); int issue = scanner.nextInt();
                        manager.addItem(new Magazine(mid, mTitle, issue));
                        break;
                    case 3:
                        manager.showAll();
                        break;
                    case 4:
                        System.out.print("Ödünç almak istediğiniz eserin adı: ");
                        String title = scanner.nextLine();
                        manager.borrowItem(title);
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Geçersiz seçim!");
                }
            } catch (LibraryException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Beklenmedik bir hata oluştu: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
        System.out.println("Sistem kapatılıyor...");
        scanner.close();
    }
}