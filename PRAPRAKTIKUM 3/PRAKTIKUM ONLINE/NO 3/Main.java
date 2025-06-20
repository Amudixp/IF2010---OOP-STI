import java.util.Scanner;

public class Main {
    /**
     * Fungsi utama dari program kalkulator Hexaesar.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mode = input.nextInt();
        String message = input.next();
        int key = input.nextInt();
        
        switch (mode) {
            case 1: 
                System.out.println(Hexaesar.encrypt(message, key));
                break;
            case 2: 
                System.out.println(Hexaesar.decrypt(message, key));
                break;
            case 3: 
                int plaintextInt = Integer.parseInt(message);
                System.out.println(Hexaesar.encrypt(plaintextInt, key));
                break;
            case 4: 
                int encryptedInt = Integer.parseInt(message);
                System.out.println(Hexaesar.decrypt(encryptedInt, key));
                break;
            default:
                System.out.println("Mode tidak valid");
        }
        
        input.close();
    }
}
