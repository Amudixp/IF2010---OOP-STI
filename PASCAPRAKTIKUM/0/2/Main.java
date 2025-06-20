import java.util.*;

public class Main {

    public static final String[] royalRanks = {"T", "J", "Q", "K", "A"};
    public static final Map<String, Integer> valueMap = new HashMap<>();

    static {
        // Inisialisasi mapping nilai kartu
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        for (int i = 0; i < values.length; i++) {
            valueMap.put(values[i], i);
        }
    }

    public static boolean isRoyal(String[] cards) {
        char suit = cards[0].charAt(0);
        Set<String> ranks = new HashSet<>();
        for (String card : cards) {
            if (card.charAt(0) != suit) return false;
            ranks.add(card.substring(1));
        }
        for (String r : royalRanks) {
            if (!ranks.contains(r)) return false;
        }
        return true;
    }

    public static boolean isFullHouse(String[] cards) {
        Map<String, Integer> freq = new HashMap<>();
        for (String card : cards) {
            String rank = card.substring(1);
            freq.put(rank, freq.getOrDefault(rank, 0) + 1);
        }
        boolean hasThree = false;
        boolean hasTwo = false;
        for (int count : freq.values()) {
            if (count == 3) hasThree = true;
            else if (count == 2) hasTwo = true;
        }
        return hasThree && hasTwo;
    }

    public static boolean isFlush(String[] cards) {
        char suit = cards[0].charAt(0);
        for (String card : cards) {
            if (card.charAt(0) != suit) return false;
        }
        return true;
    }

    public static int getSetRanking(String[] cards) {
        if (isRoyal(cards)) return 3;
        if (isFullHouse(cards)) return 2;
        if (isFlush(cards)) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cardsTuanBil = new String[5];
        String[] cardsTuanMask = new String[5];

        for (int i = 0; i < 5; i++) {
            cardsTuanBil[i] = sc.nextLine();
        }

        for (int i = 0; i < 5; i++) {
            cardsTuanMask[i] = sc.nextLine();
        }

        int rankBil = getSetRanking(cardsTuanBil);
        int rankMask = getSetRanking(cardsTuanMask);

        if (rankBil > rankMask) {
            System.out.println("Tuan Bil");
            System.out.println(rankBil);
        } else if (rankMask > rankBil) {
            System.out.println("Tuan Mask");
            System.out.println(rankMask);
        } else {
            System.out.println("Seri");
            System.out.println(rankBil); // sama saja rankBil == rankMask
        }
    }
}
