package projem;

import java.util.Scanner;
import java.util.ArrayList;

class  WaterTemperatureException extends Exception{
	public WaterTemperatureException(String mesaj) {
		super(mesaj);
	}
	
}

class Fish{
	private String name ;
	private double maxTemperature;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getMaxTemperature(){
		return maxTemperature;
	}
	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature= maxTemperature;
	}
	
	public Fish(String name , double maxTemperature) {//constructor
		this.name = name;
		this.maxTemperature= maxTemperature;
	}
	
	void swimInWater (double currentTemp) throws WaterTemperatureException{
		if(currentTemp > maxTemperature) {
			throw new WaterTemperatureException(name + " için su çok sıcak! Maksimum: " + maxTemperature);
		}
		else {
			System.out.println(name + " keyifle yüzüyor.");
		}
	}
}

class TropicalFish extends Fish{
	private String color;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	 
	public TropicalFish(String name , double maxTemperature, String color) {
		super(name , maxTemperature);
		this.color= color;
	}
	void swimInWater (double currentTemp) throws WaterTemperatureException{
		super.swimInWater(currentTemp);
		System.out.println("Bu tropikal balığın rengi: " + color);	}
	
}

class Aquarium{
	ArrayList<Fish> balık = new ArrayList<>();
	
	void addFish(Fish f) {
		balık.add(f);
	}
	void checkAquarium(double currentTemp) throws WaterTemperatureException {
		for(Fish b:balık) {
			b.swimInWater(currentTemp);
		}
	}
}


public class SmartAquarium {
	public static void main(String[] args) {
		Scanner al = new Scanner (System.in);
		Aquarium aquarium = new Aquarium();
		
		System.out.println("Balığın adını giriniz");
		String ad = al.nextLine();
		
		System.out.println("max sıcaklığı giriniz");
		double max = al.nextDouble();
		
		al.nextLine();
		
		System.out.println("Balığın rengini giriniz");
		String renk = al.nextLine();
		
		
		Fish a = new TropicalFish(ad , max , renk);
		aquarium.addFish(a);
		
		System.out.println("Akvarymun şuanki sıcaklığını giriniz");
		double temp = al.nextDouble();
		
		try {
			aquarium.checkAquarium(temp);
		}
		catch(WaterTemperatureException e) {
			System.err.println("YAKALANAN HATA: " + e.getMessage());
		}
		
		
	}

}