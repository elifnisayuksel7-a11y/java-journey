package GradeManager;

import java.util.Scanner;
import java.util.Arrays;


public class GradeManager {

    public static void main(String[] args) {
        Scanner al = new Scanner(System.in);

        System.out.print("Kaç öğrenci girilecek: ");
        int ogrencisayisi = al.nextInt();
        al.nextLine(); 

        String[] ogrenciadi = new String[ogrencisayisi];
        double[][] notlar = new double[ogrencisayisi][3];

        for (int i = 0; i < ogrencisayisi; i++) {
            System.out.print("\n" + (i + 1) + ". öğrencinin adı: ");
            ogrenciadi[i] = al.nextLine();

            for (int j = 0; j < 3; j++) {
                System.out.print("   " + (j + 1) + ". Sınav Notu: ");
                notlar[i][j] = al.nextDouble();
            }
            al.nextLine(); 
        }

        System.out.println("\n========================================");
        System.out.println("          ÖĞRENCİ BAŞARI DURUMU         ");
        System.out.println("========================================");
        System.out.println("İsim\t\tOrtalama\tDurum");
        System.out.println("----------------------------------------");

        for (int i = 0; i < ogrencisayisi; i++) {
            double ortalama = ortalamaHesapla(notlar[i]);
            
            String durum = (ortalama >= 50) ? "GEÇTİ" : "KALDI";

            System.out.printf("%-15s\t%.2f\t\t%s\n", ogrenciadi[i], ortalama, durum);
        }
        
        System.out.println("========================================");
        al.close();
    }


    public static double ortalamaHesapla(double[] ogrenciNotlari) {
        double toplam = 0;
        for (double not : ogrenciNotlari) {
            toplam += not;
        }
        return toplam / ogrenciNotlari.length;
    }
}