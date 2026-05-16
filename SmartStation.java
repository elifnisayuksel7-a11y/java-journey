package proje;
import java.util.Scanner;
import java.util.ArrayList;

class InsufficientFuelException extends Exception{
	public InsufficientFuelException (String mesaj) {
		super(mesaj);
	}
}

class FuelPump{
	private String pumpıd;
	private double fuelAmount;
	
	public String getPumpıd() { return pumpıd; }
	public void setPumpıd(String pumpıd) { this.pumpıd=pumpıd; }
	
	public double getFuelAmount() { return fuelAmount; }
	public void setFuelAmount(double fuelAmount) { this.fuelAmount=fuelAmount; }
	
	public FuelPump(String pumpıd , double fuelAmount) {
		this.pumpıd=pumpıd;
		this.fuelAmount=fuelAmount;
	}
	
	public void dispenseFuel(double liters) throws InsufficientFuelException{
		if(liters>fuelAmount) {
			 throw new InsufficientFuelException ("HATA: Depoda yeterli yakıt yok! Mevcut: " + fuelAmount);
		}
		else {
			fuelAmount-=liters;
			System.out.println("Kalan yakıt " + fuelAmount);
		}
	}
}

class PremiumFuelPump extends FuelPump{
	private String fuelType;

	public String getFuelType() { return fuelType; }
	public void setFuelType(String fuelType) { this.fuelType = fuelType; }
	
	public PremiumFuelPump(String pumpıd , double fuelAmount , String fuelType) {
		super(pumpıd ,fuelAmount );
		this.fuelType=fuelType;
	}
	
	/*@Override
	public void displayTrayInfo() {
		
	} 
	*/
	public void dispenseFuel(double liters) throws InsufficientFuelException{
		super.dispenseFuel(liters);
		System.out.println("Katkılı "+fuelType+ " başarıyla dolduruldu!");
	}
}

class StationManager{
	ArrayList<FuelPump> yakıt = new ArrayList<>();
	
	public void addPump(FuelPump p) {
		yakıt.add(p);
	}
	
	public void RefuelVehicle(int pumpIndex, double liters) throws InsufficientFuelException{
		yakıt.get(pumpIndex).dispenseFuel(liters);	
	}
}

public class SmartStation {
	public static void main(String[] args) {
		Scanner al = new Scanner (System.in);
		StationManager manager = new StationManager(); 
		
		System.out.println("pompaya konulacak toplam yakıtı giriniz");
		double yakitMiktari = al.nextDouble();
		al.nextLine(); 
		
		System.out.println("yakıt tipini giriniz");
		String tip = al.nextLine();
		
		PremiumFuelPump x = new PremiumFuelPump("POMPA-1", yakitMiktari, tip);
		manager.addPump(x); 
		
		boolean dongu = true;
		
		while(dongu) {
			System.out.println("\nyapılacak işlemi seçiniz 1- Yakıt Al, 2- Çıkış");
			int secim = al.nextInt();
			
			switch(secim) {
			case 1 :
				System.out.println("kaç litre yakıt istiyorsunuz");
				double yakitIstenen = al.nextDouble(); 
				
				try {
					manager.RefuelVehicle(0, yakitIstenen);
				}
				catch(InsufficientFuelException e) {
					System.err.println(e.getMessage());
				}
				break;
				
			case 2:
				System.out.println("Sistemden çıkılıyor...");
				dongu = false;
				break;
				
			default:
				System.out.println("Geçersiz seçim!");
			}
		}
		al.close();
	}
}