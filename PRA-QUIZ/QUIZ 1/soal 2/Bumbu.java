/**
 * Bumbu.java
 * [Kelas untuk bumbu yang digunakan dalam proses memasak sahur]
 * 
 * @author [18223049] [Amudi Purba]
 */

public class Bumbu {
    private String name;

    public Bumbu(String name) {
        this.name = name;
    }
    
    public void grindSpice() {
        System.out.println("Grinding " + name + " spice");
    }
    
    public void saute() {
        System.out.println("Sauteing " + name + " spice until fragrant");
    }
    
    public void stopSaute() {
        System.out.println("Turning off the heat for " + name + " spice");
    }
}