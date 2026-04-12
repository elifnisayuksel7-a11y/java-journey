package security;
import java.util.Scanner;

public class SecurityUser {
	private String username ;
	private String role;
	private String ipAddress;
	private int accessLevel;
	private boolean isVerified;
	
	public String username() {
		return username;
	}
	public void setUserName(String username) {
		this.username=username;
	}
	public String role() {
		return role;
	}
	public void setRole(String role) {
		this.role=role;
	}
	public String ipAddress() {
		return ipAddress;
	}
	public void setİpAddress(String ipAddress) {
		this.ipAddress=ipAddress;
	}
	public int accessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel=accessLevel;
	}
	public SecurityUser(String username, String role){
		this.username=username;
		this.role=role;
		this.ipAddress = "127.0.0.1";
		this.isVerified = false;      
        this.accessLevel = 1;
		
	}
	public SecurityUser(String username, String role, String ipAddress){
		this.username=username;
		this.role=role;
		this.ipAddress=ipAddress;
		this.isVerified = false;
        this.accessLevel = 1;
	}
	
	
	public void displayInfo() {
		System.out.println("User Security Profile");
		System.out.println("Username :" + username);
		System.out.println("User role :" + role);
		System.out.println("User IpAddress : " + ipAddress);
		System.out.println("User Verified : " + isVerified);
		System.out.println("User Acess Level : "+ accessLevel);
		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

	    System.out.println("=== Siber Güvenlik Sistemi Kayıt Ekranı ===");

	    System.out.print("Kullanıcı Adı: ");
	    String userName = input.nextLine();

	    System.out.print("Rol (Admin/User/Pentester): ");
	    String userRole = input.nextLine();

	    System.out.print("IP Adresi girilecek mi? (e/h): ");
	    String cevap = input.nextLine();

	    SecurityUser newUser;

	    if (cevap.equalsIgnoreCase("e")) {
	        System.out.print("IP Adresi: ");
	        String ip = input.nextLine();
	        newUser = new SecurityUser(userName, userRole, ip);
	    } else {
	        newUser = new SecurityUser(userName, userRole);
	    }

	    System.out.println("\n[SİSTEM]: Kullanıcı başarıyla oluşturuldu.");
	    newUser.displayInfo();

	    input.close();
	}

}
