package MarketSistemi;

import java.util.Scanner;

public class MarketSistemi {

	public static void main(String[] args) {
		String[] urunler = new String [3];
		urunler[0]= "Ekmek";
		urunler[1]= "Süt";
		urunler[2]= "Yumurta";
		
		double[] fiyat = {15.0 , 50.0 , 100.0};
		double toplam = 0.0;
		
		System.out.println("--- Marketimize Hoş Geldiniz ---");
		
		for(int i = 0; i < 3; i++) {
			System.out.println(i  + ". " + urunler[i] + " fiyatı: " + fiyat[i] + " TL");
		}
		
		Scanner al = new Scanner (System.in);
		
		while(true) {
			System.out.print("\nSeçiminiz (Çıkış için -1): ");
			int secim = al.nextInt();
			
			if(secim == -1) {
				break;
			}
			
			if(secim >= 0 && secim < 3) {
				toplam += fiyat[secim];
				System.out.println(urunler[secim] + " sepete eklendi!");
			} else {
				System.out.println("Geçersiz seçim, lütfen listedeki numaralardan birini girin.");
			}
		}
		
		System.out.println("\n------------------------------------");
		System.out.println("TOPLAM TUTAR: " + toplam + " TL");
		System.out.println("KDV DAHİL (%20): " + (toplam * 1.20) + " TL");
		System.out.println("Bizi tercih ettiğiniz için teşekkürler!");
		System.out.println("------------------------------------");
		
		al.close();
	}
}