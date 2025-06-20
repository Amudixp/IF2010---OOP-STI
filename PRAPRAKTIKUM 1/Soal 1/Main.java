import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        CimolBojot[] cimols = new CimolBojot[3];
        for(int i=0; i<3; i++){
            String namaCimol = scanner.next();
            int hargaCimol = scanner.nextInt();
            int stokCimol =scanner.nextInt();
            cimols[i]= new CimolBojot(namaCimol, hargaCimol, stokCimol);
        }
        
        int initialKas = scanner.nextInt();
        Toko toko = new Toko(initialKas);

        for(CimolBojot cimol : cimols){
            toko.addCimolBojot(cimol);
        }
        String cimolDijual = scanner.next();
        int jumlahCimolDijual = scanner.nextInt();
        
        System.out.println(toko.sellCimolBojot(cimolDijual, jumlahCimolDijual));
        System.out.println("Kas kasir sekarang: "+ toko.getKas());
        scanner.close();
    }
}
