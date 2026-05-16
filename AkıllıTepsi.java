package proje;

import java.util.Scanner;
import java.util.ArrayList;

class EmptyStackException extends Exception {
    public EmptyStackException(String mesaj) {
        super(mesaj);
    }
}

class Tray {
    private String trayıd;
    private String material;
    
    public String getTrayıd() { return trayıd; }
    public void setTrayıd(String trayd) { this.trayıd = trayd; }
    
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    
    public Tray(String trayıd, String material) {
        this.trayıd = trayıd;
        this.material = material;
    }
    
    public void displayTrayInfo() {
        System.out.print("tepsi ıd: " + trayıd + " | malzemesi: " + material);
    }
}

class PremiumTray extends Tray {
    private String logocolor;
    
    public String getLogocolor() { return logocolor; }
    public void setLogocolor(String logocolor) { this.logocolor = logocolor; }
    
    public PremiumTray(String trayıd, String material, String logocolor) {
        super(trayıd, material);
        this.logocolor = logocolor;
    }
    
    public void displayTrayInfo() {
        super.displayTrayInfo();
        System.out.println(" | logo rengi: " + logocolor);
    }
}

class TrayStackManager {
    ArrayList<Tray> tepsiler = new ArrayList<>(); // Hatalı nesne satırını sildik, burası tertemiz oldu.
    
    public void pushTray(Tray t) {
        tepsiler.add(t);
    }
    
    public void popTray() throws EmptyStackException {
        if (tepsiler.isEmpty()) {
            throw new EmptyStackException("HATA: Stantta hiç tepsi kalmadı! Müşteri bekliyor.");
        }
        int sonIndeks = tepsiler.size() - 1;
        Tray sonTepsi = tepsiler.get(sonIndeks);
        tepsiler.remove(sonIndeks);
        
        System.out.print("Müşteri en üstteki tepsiyi aldı -> ");
        sonTepsi.displayTrayInfo();
    }
}

public class AkıllıTepsi {
    public static void main(String[] args) {
        Scanner al = new Scanner(System.in);
        TrayStackManager manager = new TrayStackManager();
        boolean dongu = true;
        
        while (dongu) {
            System.out.println("\nYapılacak işlemi giriniz: (1- Mutfaktan Temiz Tepsi Ekle, 2- Müşteriye Tepsi Ver, 3- Çıkış)");
            int islem = al.nextInt();
            al.nextLine(); 
            
            switch (islem) {
                case 1:
                    System.out.println("Tepsi ID giriniz:");
                    String id = al.nextLine();
                    
                    System.out.println("Tepsi malzemesi giriniz:");
                    String malzeme = al.nextLine();
                    
                    System.out.println("Tepsi logo rengi giriniz:");
                    String renk = al.nextLine();
                    
                    PremiumTray pt1 = new PremiumTray(id, malzeme, renk);
                    manager.pushTray(pt1);
                    System.out.println("Mutfaktan temiz tepsi standın en üstüne eklendi.");
                    break;
                    
                case 2:
                    try {
                        manager.popTray();
                    } catch (EmptyStackException e) {
                        System.err.println(e.getMessage()); 
                    }
                    break;
                    
                case 3:
                    System.out.println("Sistemden çıkılıyor...");
                    dongu = false;
                    break;
                    
                default:
                    System.out.println("Geçersiz işlem!");
            }
        }
        al.close();
    }
}