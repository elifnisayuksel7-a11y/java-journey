package RentACar;
import java.util.Scanner;

public class RentACar {
	
	public static void menuGoster() {
		System.out.println("ARAÇ KİRALAMA SİSTEMİ");
		System.out.println("1. ARAÇ LİSTELE");
		System.out.println("2.ARAÇ KİRALAMA");
		System.out.println("0. ÇIKIŞ");

	}
	public static void aracDurumlari(String[]isimler , boolean[] durumlar) {
		for (int i =0 ; i<isimler.length;i++) {
			String durum=  durumlar[i] ? "müsait":"kirada" ;
			System.out.println(i + "." + isimler[i] + "[" + durum+ "]");
		}
	}

	public static void main(String[] args) {
		
		Scanner al = new Scanner (System.in);
		
		String[] arabalar = { "Fiat Egea", "Toyota Corolla", "VW Passat"};
		boolean[] musaitlik = {true, true, true};
		while(true) {
            menuGoster(); 
            System.out.print("Seçiminiz: ");
            int secim = al.nextInt();
            
            if(secim == 0) {
                System.out.println("Sistemden çıkılıyor...");
                break;
            }
            
            if(secim == 1) {
                aracDurumlari(arabalar, musaitlik); 
            } 
            else if(secim == 2) {
                System.out.print("Kiralamak istediğiniz araç no: ");
                int no = al.nextInt();
                
                
                if(no >= 0 && no < musaitlik.length) {
                    if(musaitlik[no]) { 
                        musaitlik[no] = false; 
                        System.out.println(arabalar[no] + " başarıyla kiralandı!");
                    } else {
                        System.out.println("HATA: Bu araç zaten kirada.");
                    }
                } else {
                    System.out.println("Geçersiz araç numarası!");
                }
            }
        }
        al.close();
	

	}

}
