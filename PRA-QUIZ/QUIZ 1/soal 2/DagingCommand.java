/**
 * DagingCommand.java
 * [kelas untuk mengelola objek daging]
 * 
 * @author [18223049] [Amudi Purba]
 */

public class DagingCommand implements ICommandAction {
    private Daging daging;
    
    /**
     * Konstruktor untuk membuat command baru dengan objek Daging tertentu
     * 
     * @param daging Objek Daging yang akan dikontrol oleh command ini
     */
    public DagingCommand(Daging daging) {
        this.daging = daging;
    }

    /**
     * Mengeksekusi perintah dengan memanggil metode cutMeat() dan marinate()
     * secara berturut-turut pada objek Daging
     */
    @Override
    public void execute() {
        daging.cutMeat();
        daging.marinate();
    }

    /**
     * Membatalkan perintah dengan memanggil metode cancelMarination() pada
     * objek Daging
     */
    @Override
    public void undo() {
        daging.cancelMarination();
    }
}