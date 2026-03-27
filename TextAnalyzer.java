package TextAnalyzer.java;
import java.util.Scanner;

public class TextAnalyzer {
	public static int seslisay (String metin  ) {
		String kucukMetin = metin.toLowerCase();
		int sayac=0;
		for(int i = 0; i<kucukMetin.length();i++) {
			char harf=kucukMetin.charAt(i);
			if(harf =='a'||harf =='e'||harf =='ı'||harf =='i'||harf =='o'||harf =='ö'||harf =='u'||harf =='ü') {
				sayac++;
			}
			
		
		}
		return sayac;
		
	}

	public static void main(String[] args) {
Scanner al = new Scanner (System.in);
		
		System.out.println("metni giriniz");
		String metnim = al.nextLine();
		
		System.out.println("sesli harf sayısı " + seslisay(metnim));
		
			}




	}


