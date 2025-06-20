import java.util.Scanner;

public class MainBalala{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Kartu[] kartus = new Kartu[5];  
        for (int i=0; i<5; i++){
            String suit = input.nextLine();
            String rank = input.nextLine();
            int multiplier = input.nextInt();
            input.nextLine();
            kartus[i] = new Kartu(suit,rank,multiplier);
        }
        
        int nilaijoker = input.nextInt();
        int target = input.nextInt();

        Blind blind = new Blind(kartus[0], kartus[1], kartus[2], kartus[3], kartus[4], nilaijoker, target);

        String[] urutan = {"pertama", "kedua", "ketiga", "keempat","kelima"};
        for (int i=0; i<5; i++){
            System.out.println("Kartu "+ urutan[i] + " punya suit " + kartus[i].getSuit() + " dengan rank "+ kartus[i].getRank()+" dan multiplier " + kartus[i].getMultiplier());
        }
        System.out.println("Skor akhir : "+ blind.calculateTotalScore());
        if (blind.isWin()){System.out.println( "MENANG!");}
        else {System.out.println("KALAH!");}
        input.close();
    }
}