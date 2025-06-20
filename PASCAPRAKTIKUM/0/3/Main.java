import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int n4 = sc.nextInt();
        int n5 = sc.nextInt();

        int multi = sc.nextInt();
        int boost = sc.nextInt();

        if (boost == 1){
            System.out.println((n1+n2+n3+n4+n5)*(multi*2));
        }
        else if(boost == 2){
            System.out.println((n1+n2+n3+n4+n5)*(multi*3));
        }
        else{
            System.out.println((n1+n2+n3+n4+n5)*multi);
        }
        sc.close();
    }
}