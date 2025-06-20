import java.util.Scanner;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        int Q = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < Q; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String command = parts[0];

            switch (command) {
                case "tambah":
                    String xAdd = parts[1];
                    stack.push(xAdd);
                    System.out.println("sudah menambahkan " + xAdd);
                    break;

                case "beli":
                    if (stack.empty()) {
                        System.out.println("maaf stock habis");
                    } else {
                        System.out.println("telah membeli " + stack.peek());
                        stack.pop();
                    }
                    break;

                case "lihat":
                    if (stack.empty()) {
                        System.out.println("maaf stock habis");
                    } else {
                        System.out.println("print paling atas adalah " + stack.peek());
                    }
                    break;

                case "habis?":
                    if (stack.empty()) {
                        System.out.println("ya, habis");
                    } else {
                        System.out.println("masih ada kok");
                    }
                    break;
            }
        }

        sc.close();
    }
}