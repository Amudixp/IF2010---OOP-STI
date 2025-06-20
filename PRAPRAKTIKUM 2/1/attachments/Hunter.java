/**
 * Hunter.java
 */
public abstract class Hunter implements Comparable<Hunter> {
    private String name;
    private int health;
    private int attackPower;
    private boolean isStunned;
    private static Hunter[] party;
    private static int partySize;
    private static final int MAX_PARTY_SIZE = 4;

    /**
     * Constructor untuk membuat Hunter baru
     * 
     * @param name Nama Hunter
     * @param health Health points Hunter
     * @param attackPower Kekuatan serangan dasar Hunter
     */
    public Hunter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    /**
     * Mendapatkan nama hunter
     * 
     * @return nama hunter
     */
    public String getName() {
        return name;
    }
        
    /**
     * Mendapatkan health hunter
     * 
     * @return health hunter
     */
    public int getHealth() {
        return health;
    }

    /**
     * Mengatur health hunter
     * 
     * @param health nilai health baru
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Mendapatkan attack power hunter
     * 
     * @return attack power hunter
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Mengatur attack power hunter
     * 
     * @param attackPower nilai attack power baru
     */
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    /**
     * Mendapatkan status stun hunter
     * 
     * @return true jika hunter stunned, false jika tidak
     */
    public boolean isStunned() {
        return isStunned;
    }

    /**
     * Mengatur status stun hunter
     * 
     * @param stunned status stun baru
     */
    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }

    /**
     * Menambahkan Hunter ke party
     * 
     * @param hunter Hunter yang akan ditambahkan
     * @return true jika berhasil ditambahkan, false jika party penuh
     */
    public static boolean addToParty(Hunter hunter) {
        if(partySize >= MAX_PARTY_SIZE){
            return false;
        }party[partySize++] = hunter;
        return true;
    }

    /**
     * Menghapus Hunter dari party
     * 
     * @param hunter Hunter yang akan dihapus
     * @return true jika hunter ada dalam party dan berhasil dihapus dari party
     */
    public static boolean removeFromParty(Hunter hunter) {
        for(int i=0; i<partySize; i++){
            if(party[i]==hunter){
                party[i] = party[partySize-1];
                party[partySize-1] = null;
                partySize--;
                return true;
            }
        } return false;
    }

    /**
     * Mencari monster terlemah (health terendah) untuk diserang
     * 
     * @param monsters Array monster yang akan dicari
     * @return Monster dengan health terendah, atau null jika array kosong
     */
    public static Monster findWeakestMonster(Monster[] monsters) {
        if(monsters.length == 0){
            return null;
        }Monster lemah = monsters[0];
        for(Monster monster:monsters){
            if(monster.getHealth()< lemah.getHealth()){
                lemah = monster;
            }
        }return lemah;
    }

    /**
     * Semua hunter dalam party akan menyerang monster secara berurutan
     * 
     * @param monster Monster yang akan diserang
     * 
     * Output:
     * - "The party has successfully defeated [Nama Monster]!" jika monster dikalahkan
     * - "[Nama Monster] still has [health] health remaining!" jika monster masih hidup
     */
    public static void partyHunt(Monster monster) {
        for(int i = 0; i<partySize; i++){
            if(!party[i].isStunned()){
                monster.setHealth(monster.getHealth()-party[i].getAttackPower());
                if(monster.getHealth()<=0){
                    System.out.println("The party has successfully defeated "+ monster.getName()+"!");
                    return;
                }
            }
        }System.out.println(monster.getName() + " still has "+monster.getHealth()+" health remaining!");
    }

    /**
     * Membandingkan dua Hunter berdasarkan attack power-nya
     * 
     * @param other Hunter lain yang akan dibandingkan
     * @return nilai negatif jika this < other, 0 jika sama, nilai positif jika this > other
     */
    @Override
    public int compareTo(Hunter other) {
        return Integer.compare(this.attackPower, other.attackPower);
    }

    /**
     * Representasi string dari Hunter
     * 
     * @return String yang merepresentasikan Hunter
     */
    @Override
    public String toString() {
        return String.format("%s [Health: %d, Attack: %d, %s]", 
                             name, health, attackPower, isStunned ? "Stunned" : "Active");
    }
}