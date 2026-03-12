import java.util.Scanner;
import java.util.Random;

package Account;


import java.util.Scanner;
import java.util.Random;

public class Account {

	public static void main(String[] args) {
		Scanner al = new Scanner(System.in);
		Random rastgele = new Random();
		
		
		System.out.println("--- Banka Kayıt Sistemi ---");
		
		System.out.println("Kullanıcı Adı Giriniz");
		String kullanici = al.nextLine();
		
		
		System.out.println("Başlangıç Bakiyenizi Giriniz");
		double bakiye = al.nextDouble();
		if(bakiye<0) {
			System.err.println("HATA:İlk Bakiye Negatif Olamaz!");
			return;
		}
		String hesapNo ="";
		for(int i=0;i<16;i++) {
			hesapNo += rastgele.nextInt(10);
		}
			
		
		
		if(hesapNo.length()==16) {
			System.out.println("SİSTEM DOĞRULANDI:Hesap Numarası Oluşturuldu");
			;
		}
		

		System.out.println("------------------------------------");
		System.out.println("KAYIT BAŞARIYLA OLUŞTURULDU");
		System.out.println("SAYIN " + kullanici);
		System.out.println("HESAP NUMARANIZ " + hesapNo);
		System.out.println("MEVCUT BAKİYENİZ " + bakiye + "TL'DİR");
		System.out.println("------------------------------------");
		

	}

}

