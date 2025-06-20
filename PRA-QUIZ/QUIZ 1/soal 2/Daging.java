/**
 * Daging.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author [NIM] [Nama]
 */

public class Daging {
    private String type;
    
    public Daging(String type) {
        this.type = type;
    }
    
    public void cutMeat() {
        System.out.println("Cutting " + type + " meat into small pieces");
    }
    
    public void marinate() {
        System.out.println("Marinating " + type + " meat with salt and lime juice");
    }
    
    public void cancelMarination() {
        System.out.println("Cleaning marination from " + type + " meat");
    }
}