import java.util.TreeSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeSet<Integer> treeSet = new TreeSet<>();
        int Q = Integer.parseInt(input.nextLine());

        for(int i=0; i<Q ; i++){
            String[] masukan = input.nextLine().split(" ");
            String pilih = masukan[0];
            
            if(pilih.equals("add")){
                int x = Integer.parseInt(masukan[1]);
                treeSet.add(x);
            }
            else if(pilih.equals("remove")){
                int x = Integer.parseInt(masukan[1]);
                if(treeSet.contains(x)){
                    treeSet.remove(x);
                }else {
                    System.out.println("Element "+ x +" is not in The TreeSet");
                }
            }
            else if(pilih.equals("first")){
                if(treeSet.isEmpty()){
                    System.out.println("EMPTY");
                }else{
                    System.out.println(treeSet.first());
                }
            }
            else if(pilih.equals("last")){
                if(treeSet.isEmpty()){
                    System.out.println("EMPTY");
                }else{
                    System.out.println(treeSet.last());
                }
            }
        }
        input.close();
    }
}
