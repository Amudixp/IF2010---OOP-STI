/**
 * TungTungTungSahur.java
 * [kelas untuk mengatur eksekusi dan cancellation dalam memasak sahur]
 * 
 * @author [18223049] [Amudi Purba]
 */

import java.util.ArrayList;
import java.util.List;

public class TungTungTungSahur {
    private List<ICommandAction> recipeSteps = new ArrayList<>();
    private List<ICommandAction> completedSteps = new ArrayList<>();
    
    /**
     * Menambahkan langkah baru ke dalam daftar langkah-langkah memasak
     * 
     * @param action Langkah memasak (Command) yang akan ditambahkan
     */
    public void addStep(ICommandAction action) {
        recipeSteps.add(action);
    }
    
    /**
     * Melaksanakan langkah memasak berikutnya dari daftar
     * Setelah dieksekusi, langkah tersebut dipindahkan dari recipeSteps ke
     * completedSteps untuk memungkinkan proses pembatalan
     * 
     * Keluarkan "No cooking steps remaining" apabila tidak ada elemen
     * pada recipeSteps
     */
    public void cook() {
        if(recipeSteps.isEmpty()){
            System.out.println("No cooking steps remaining");
            return;
        }else {
            ICommandAction step = recipeSteps.remove(0);
            step.execute();
            completedSteps.add(step);
        }
    }
    
    /**
     * Membatalkan langkah memasak terakhir yang telah dilaksanakan
     * Langkah tersebut dipindahkan kembali dari completedSteps ke awal
     * recipeSteps untuk dapat dijalankan kembali jika diinginkan
     * 
     * Keluarkan "No cooking steps to cancel" apabila tidak ada elemen
     * pada completedSteps
     */
    public void cancel() {
        if (completedSteps.isEmpty()){
            System.out.println("No cooking steps to cancel");
            return;
        }else {
            ICommandAction step = completedSteps.remove(completedSteps.size() - 1);
            step.undo();
            recipeSteps.add(0, step);
        }
    }
    
    /**
     * Melaksanakan semua langkah memasak secara berurutan
     * Metode ini mengeksekusi semua langkah yang tersisa dalam daftar recipeSteps
     */
    public void cookAll() {
        while (!recipeSteps.isEmpty()){
            cook();
        }
    }
    
    /**
     * Membatalkan semua langkah memasak yang telah dilaksanakan
     * Metode ini membatalkan semua langkah dalam daftar completedSteps, dalam
     * urutan terbalik (LIFO - Last In First Out)
     */
    public void cancelAll() {
        while (!completedSteps.isEmpty()) {
            cancel();
        }
    }
}