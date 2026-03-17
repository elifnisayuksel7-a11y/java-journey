package ElektrikAlanHesaplayici;

import java.util.Scanner; 

public class ElektrikAlanHesaplayici {

    public static void main(String[] args) {
        
        final double K = 8.99e9; 
        
        Scanner al = new Scanner(System.in);
        
        double E = 0;
        double rKare = 0;
        double r = 0;
        double Ex = 0;
        double Ey = 0;

        System.out.println("Yük miktarını giriniz (C):");
        double q = al.nextDouble();
        
        System.out.println("Yükün X koordinatını giriniz:");
        int qX = al.nextInt();
        
        System.out.println("Yükün Y koordinatını giriniz:");
        int qY = al.nextInt();
        
        System.out.println("P noktasının X koordinatını giriniz:");
        int pX = al.nextInt();
        
        System.out.println("P noktasının Y koordinatını giriniz:");
        int pY = al.nextInt();
        
        // Mesafe bileşenleri
        double dx = pX - qX;
        double dy = pY - qY;
        
        rKare = (dx * dx) + (dy * dy);
        r = Math.sqrt(rKare); 
        
        if (rKare == 0) {
            System.out.println("Hata: Yükün tam üzerinde alan hesaplanamaz!");
        } else {
            
            E = K * q / rKare;

            
            
            Ex = E * (dx / r);
            Ey = E * (dy / r);

            System.out.println("\n--- SONUÇLAR ---");
            System.out.println("Mesafe (r): " + r + " metre");
            System.out.println("Toplam Alan Şiddeti: " + E + " N/C");
            System.out.println("Vektörel Bileşenler:");
            System.out.println("Ex (Yatay): " + Ex + " N/C");
            System.out.println("Ey (Düşey): " + Ey + " N/C");
            System.out.println("Vektörel Gösterim: E = (" + Ex + "i + " + Ey + "j) N/C");
        }
        
        al.close();
    }
}
