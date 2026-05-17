package proje;

import java.util.Scanner;
import java.util.ArrayList;

class QuotaExceededException extends Exception {
    public QuotaExceededException(String mesaj) {
        super(mesaj);
    }
}

class ClubActivity {
    private String activityName;
    private int quota;
    private int registeredStudents;
    
    public String getActivityName() { return activityName; }
    public void setActivityName(String activityName) { this.activityName = activityName; }
    
    public int getQuota() { return quota; }
    public void setQuota(int quota) { this.quota = quota; }
    
    public int getRegisteredStudents() { return registeredStudents; }
    public void setRegisteredStudents(int registeredStudents) { this.registeredStudents = registeredStudents; }
    
    public ClubActivity(String activityName, int quota) {
        this.activityName = activityName;
        this.quota = quota;
        this.registeredStudents = 0;
    }
    
    public void registerStudent() throws QuotaExceededException {
        if (registeredStudents >= quota) {
            throw new QuotaExceededException("HATA: " + activityName + " etkinliğinin kontenjanı tamamen dolmuştur!");  
        } else {
            registeredStudents++;
            System.out.println("Kayıt numarası: " + registeredStudents);
        }
    }
}

class TechnicalTourActivity extends ClubActivity {
    private String departureLocation;

    public String getDepartureLocation() { return departureLocation; }
    public void setDepartureLocation(String departureLocation) { this.departureLocation = departureLocation; }
    
     public TechnicalTourActivity(String activityName, int quota, String departureLocation) {
        super(activityName, quota);
        this.departureLocation = departureLocation;
    }
    
    @Override 
    public void registerStudent() throws QuotaExceededException {
        super.registerStudent();
        System.out.println("Unutmayın, servisimiz " + departureLocation + " konumundan kalkacaktır!");
    }
}

class ClubManager {
    ArrayList<ClubActivity> aktivite = new ArrayList<>();
    
    public void addActivity(ClubActivity activity) {
        aktivite.add(activity);
    }
    
    public void signupForActivity(int activityIndex) throws QuotaExceededException {
        aktivite.get(activityIndex).registerStudent();
    }
}

public class UniversityApp {
    public static void main(String[] args) {
        Scanner al = new Scanner(System.in);
        ClubManager manager = new ClubManager(); 
        
        System.out.println("etkinliğin adını giriniz");
        String activityName = al.nextLine();
        
        System.out.println("etkinliğin kontenjanını giriniz");
        int quota = al.nextInt();
        al.nextLine(); 
        
        System.out.println("etkinliğin kalkış yerini giriniz");
        String departureLocation = al.nextLine();
        
        TechnicalTourActivity tur = new TechnicalTourActivity(activityName, quota, departureLocation);
        manager.addActivity(tur);
        
        while (true) {
            System.out.println("\n1- Etkinliğe Kaydol, 2- Çıkış");
            int secim = al.nextInt();
            
            if (secim == 2) {
                System.out.println("Çıkış yapılıyor...");
                break;
            }
            
            switch (secim) {
                case 1:
                    try {
                        manager.signupForActivity(0);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
            }
        }
        al.close();
    }
}