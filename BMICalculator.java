package BMICalculator;

import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		Scanner al= new Scanner (System.in);
		
		System.out.println("boyunuzu giriniz(m cinsinden)");
		double boy=al.nextDouble();
		
		System.out.println("kilonuzu giriniz ");
		double kilo=al.nextDouble();
		
		double BMI= kilo/(boy*boy);
		
		System.out.println("vücut kitleindeksiniz " + BMI);

	}

}
