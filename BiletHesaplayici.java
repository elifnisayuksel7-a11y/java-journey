package BiletHesaplayici;

import java.util.Scanner;

public class BiletHesaplayici {

	public static void main(String[] args) {
Scanner al= new Scanner (System.in);
		
		double fiyat=100;
		
		System.out.println("Yaşınızı giriniz");
		int yas= al.nextInt();
		
		
		System.out.println("Öğrenci misiniz(true/false)");
		boolean ogrenci=al.nextBoolean();
		
		System.out.println("Hafta sonu mu(true/false)");
		boolean haftasonu =al.nextBoolean();
		
		
		if(yas<18) {
			fiyat= fiyat*0.5;
		}
		else if(yas>65) {
			fiyat=fiyat*0.7;

		}
		else if(ogrenci) {
			fiyat=fiyat*0.8;
		}
		else {
			fiyat=100;
		}
		if (haftasonu) {
			fiyat=fiyat+20;
		}
		
		System.out.println("Bilet fiyatı  " + fiyat + "Türk Lirasıdır" );
		

		
	}

}

	

