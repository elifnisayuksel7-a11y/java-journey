package BMICalculator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner al = new Scanner (System.in);
		
		System.out.println("  HESAP MAKİNESİ UYGULAMASINA HOŞGELDİNİZ  ");
		
		System.out.println("Birinci sayıyı giriniz");
		double x = al.nextDouble();
		
		System.out.println("İkinci sayıyı giriniz");
		double y= al.nextDouble();
		
		System.out.println("Yapacağınız işlemi seçiniz ");
		System.out.println("1:+ , 2:- , 3:* , 4:/");
		int secim=al.nextInt();
		
		switch(secim) {
		case 1:
			System.out.println("Sonuc:" + (x+y));
			break;
		case 2:
			System.out.println("Sonuc:" + (x-y));
			break;
		case 3:
			System.out.println("Sonuc:" + (x*y));
			break;
		case 4:
			if (y!=0) {
				System.out.println("Sonuc:" + (x/y));
			}
			else {
				System.out.println("Hata: Bir sayı sıfıra bölünemez");
			}
			break;
		default:
            System.out.println("Geçersiz seçim yaptınız!");
		}
	
	}

}
