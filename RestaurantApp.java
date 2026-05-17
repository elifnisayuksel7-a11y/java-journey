package proje;

import java.util.Scanner;
import java.util.ArrayList;

class SpicyAlarmException extends Exception{
	public SpicyAlarmException(String mesaj) {
		super(mesaj);
	}
}

class Customer {
	private String name;
	private int maxSpikeLimit;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxSpikeLimit() {
		return maxSpikeLimit;
	}
	public void setMaxSpikeLimit(int maxSpikeLimit) {
		this.maxSpikeLimit = maxSpikeLimit;
	}
	
	public Customer(String name, int maxSpikeLimit) {
		this.name = name ;
		this.maxSpikeLimit=maxSpikeLimit;
	}
	
	public void eatLahmacun(int sauceDrops)throws SpicyAlarmException{
		if(sauceDrops>maxSpikeLimit) {
			throw new SpicyAlarmException(name + " yandı! Acil ayran getirin!");
		}
		else {
			System.out.println("Müşteri lahmacunu afiyetle yedi.");
		}
	}
	
}


class GourmetCustomer extends Customer{
	public GourmetCustomer(String name ,int maxSpikeLimit ) {
		super (name , maxSpikeLimit);
	}
	@Override 
	public void eatLahmacun(int sauceDrops)throws SpicyAlarmException{
		super.eatLahmacun(sauceDrops);
		System.out.println( getName() +" Lezzet harika, tam kıvamında!");
	}

	
}

class Restaurant{
	ArrayList<Customer> müsteriler = new ArrayList<>();
	
	public void welcomeCustomer(Customer c) {
		müsteriler.add(c);
	}
	
	public void serveOrder(int tableIndex, int sauceDrops) throws SpicyAlarmException{
		müsteriler.get(tableIndex).eatLahmacun(sauceDrops);
	}
}
public class RestaurantApp {

	public static void main(String[] args) {
		
		Scanner al = new Scanner (System.in);
		Restaurant restaurant = new Restaurant();
		
		System.out.println("Müşterinin adını giriniz:");
        String isim = al.nextLine();
        
        System.out.println("Müşterinin maksimum acı limitini giriniz (Örn: 5):");
        int limit = al.nextInt();
        GourmetCustomer gc = new GourmetCustomer(isim, limit);
        restaurant.welcomeCustomer(gc);
		
		while(true) {
			System.out.println("kaç damla acı sos istersiniz");
			int damla = al.nextInt();
			
			if(damla==0) {
				System.out.println("çıkış yapılıyor");
				break;
			}
			
			try {
				restaurant.serveOrder(0, damla);
			}
			
			catch(SpicyAlarmException e) {
				System.out.println(e.getMessage());
				
				
			}
			
		}

	}

}
