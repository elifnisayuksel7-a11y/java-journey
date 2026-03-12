package GuessGame;

import java.util.Scanner;
import java.util.Random;

public class GuessGame {

    public static void main(String[] args) {
        
        Scanner alinansayi = new Scanner(System.in);
        Random rastgele = new Random();
        
        int hedefsayi = rastgele.nextInt(100) + 1;
        int deneme = 0;
        int tahmin = 0;
        
        System.out.println("--- Sayı Tahmin Oyununa Hoş Geldiniz! ---");
        System.out.println("1 ile 100 arasında bir sayı tuttum. Hadi tahmin et!");
        
        while (tahmin != hedefsayi) {
            System.out.print("Tahmininiz: ");
            tahmin = alinansayi.nextInt();
            deneme++;

            // KONTROLLER DÖNGÜNÜN İÇİNDE OLMALI
            if (tahmin > hedefsayi) {
                System.out.println("Tahmininizi Küçültün (Daha aşağı!)");
            } 
            else if (tahmin < hedefsayi) {
                System.out.println("Tahmininizi Büyültün (Daha yukarı!)");
            } 
            else {
                System.out.println("------------------------------------");
                System.out.println("TEBRİKLER! " + deneme + ". denemede bildiniz.");
                System.out.println("------------------------------------");
            }
        } 
        
        alinansayi.close();
    }
}