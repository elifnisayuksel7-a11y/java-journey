package deneme;
import java.math.BigDecimal;
import java.util.Scanner; 


class AgirlikSınırıAsildiException extends Exception {
	public AgirlikSınırıAsildiException(String mesaj) {
		super(mesaj);
	}
}



abstract class Kargo {
	String kargoId;
	BigDecimal agirlik;
	
	public Kargo(String kargoId, BigDecimal agirlik) {
		this.kargoId = kargoId;
		this.agirlik = agirlik;
	}
	
	abstract BigDecimal tasimaMaliyetiHesapla();  
	
	public void agirlikKontrol(BigDecimal maxKapasite) throws AgirlikSınırıAsildiException {
		if (this.agirlik.compareTo(maxKapasite) > 0) {
			throw new AgirlikSınırıAsildiException("Ağırlık Sınırı Aşıldı! Maksimum kapasite: " + maxKapasite + " kg, Kargonuz: " + this.agirlik + " kg.");
		}
	}
}



class YurtIciKargo extends Kargo {
	public YurtIciKargo(String kargoId, BigDecimal agirlik) {
		super(kargoId, agirlik);
	}
	
	@Override
	BigDecimal tasimaMaliyetiHesapla() {
		return this.agirlik.multiply(new BigDecimal("5"));
	}
}



class KargoGonderimGörevi implements Runnable {
	private Kargo kargo;
	private BigDecimal limit; 
	
	public KargoGonderimGörevi(Kargo kargo, BigDecimal limit) {
		this.kargo = kargo;
		this.limit = limit;
	}
	
	
	@Override
	public void run() {
		try {
			kargo.agirlikKontrol(limit);
			
			StringBuilder sb = new StringBuilder();
			sb.append("\n--- İŞLEM BAŞARILI ---")
			  .append("\nKargo ID: ").append(kargo.kargoId)
			  .append("\nAğırlık: ").append(kargo.agirlik).append(" kg")
			  .append("\nTaşıma Maliyeti: ").append(kargo.tasimaMaliyetiHesapla()).append(" TL");
			System.out.println(sb.toString());
			
		} catch (AgirlikSınırıAsildiException e) {
			System.out.println("\n--- İSTİSNA YAKALANDI ---");
			System.out.println(e.getMessage());
		}
	}
}



public class KargoSimülasyon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== KARGO SİMÜLASYON SİSTEMİNE HOŞ GELDİNİZ ===");
		
		System.out.print("Kargo ID giriniz (Örn: YI-1234): ");
		String id = scanner.nextLine();
		
		System.out.print("Kargo Ağırlığını giriniz (Örn: 12.5): ");
		String agirlikInput = scanner.nextLine();
		BigDecimal girilenAgirlik = new BigDecimal(agirlikInput);
		
		System.out.print("Araç Maksimum Kapasite Sınırını giriniz (Örn: 20.0): ");
		String limitInput = scanner.nextLine();
		BigDecimal girilenLimit = new BigDecimal(limitInput);
		
		Kargo kullanıcıKargosu = new YurtIciKargo(id, girilenAgirlik);
		
		KargoGonderimGörevi gorev = new KargoGonderimGörevi(kullanıcıKargosu, girilenLimit);
		Thread t1 = new Thread(gorev);
		
		t1.start();
		
		scanner.close();
	}
}