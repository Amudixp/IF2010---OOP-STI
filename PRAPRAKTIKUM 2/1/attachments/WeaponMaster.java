/**
 * WeaponMaster.java
 */
public interface WeaponMaster {
    /**
     * Melakukan serangan khusus pada monster
     * 
     * @param monster Monster yang akan diserang
     */
    void specialAttack(Monster monster);
    
    /**
     * Menajamkan senjata untuk meningkatkan attack power
     */
    void sharpenWeapon();
}