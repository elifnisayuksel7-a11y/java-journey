package PalindromeChecker;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner al = new Scanner(System.in);
        
        System.out.println("Bir Metin veya Cümle Giriniz:");
        String hamMetin = al.nextLine();
        
        
        String temizMetin = hamMetin.toLowerCase().replaceAll("[^a-zçğıöşü]", "");
        
        String ters = new StringBuilder(temizMetin).reverse().toString();
        
        if (temizMetin.equals(ters) && !temizMetin.isEmpty()) {
            System.out.println("Sonuç: Bu bir palindromdur!");
        } else {
            System.out.println("Sonuç: Palindrom değildir.");
        }
        
        al.close();
    }
}