package question2;
public class TestUnsortedTableMap {
    public static void main(String[] args) {
        UnsortedTableMap<Integer, String> map = new UnsortedTableMap<>();

        // Testing putOnlyIfNull method
        System.out.println("Adding (1, 'A') with putOnlyIfNull: " + map.putOnlyIfNull(1, "A")); // Should add
        System.out.println("Adding (1, 'B') with putOnlyIfNull: " + map.putOnlyIfNull(1, "B")); // Should not add, return "A"
        System.out.println("Adding (2, 'C') with putOnlyIfNull: " + map.putOnlyIfNull(2, "C")); // Should add
        System.out.println("Adding (3, null) with put: " + map.put(3, null)); // Add null value directly
        System.out.println("Adding (3, 'D') with putOnlyIfNull: " + map.putOnlyIfNull(3, "D")); // Should add since current value is null
        System.out.println("Adding (3, 'E') with putOnlyIfNull: " + map.putOnlyIfNull(3, "E")); // Should not add, return "D"

        // Display the contents of the map
        for (Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
