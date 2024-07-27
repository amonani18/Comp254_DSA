package exercise1.aniket;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class HashMapTest {

  private static List<Integer> generateRandomKeys(int numElements) {
    Random random = new Random();
    List<Integer> keys = new ArrayList<>();
    for (int i = 0; i < numElements; i++) {
      keys.add(random.nextInt());
    }
    return keys;
  }

  private static List<Integer> generateRandomValues(int numElements) {
    Random random = new Random();
    List<Integer> values = new ArrayList<>();
    for (int i = 0; i < numElements; i++) {
      values.add(random.nextInt());
    }
    return values;
  }

  private static void testProbeHashMap(List<Integer> keys, List<Integer> values) {
    ProbeHashMap<Integer, Integer> probeMap = new ProbeHashMap<>(17, 109345121);


    long startTime = System.nanoTime();
    for (int i = 0; i < keys.size(); i++) {
      probeMap.put(keys.get(i), values.get(i));
    }
    long insertionTime = System.nanoTime() - startTime;

    startTime = System.nanoTime();
    for (Integer key : keys) {
      probeMap.get(key);
    }
    long retrievalTime = System.nanoTime() - startTime;

    System.out.println("ProbeHashMap - Insertion Time: " + insertionTime / 1e6 + " ms, Retrieval Time: " + retrievalTime / 1e6 + " ms");
  }

  private static void testChainHashMap(List<Integer> keys, List<Integer> values) {
    ChainHashMap<Integer, Integer> chainMap = new ChainHashMap<>(17, 109345121);

    long startTime = System.nanoTime();
    for (int i = 0; i < keys.size(); i++) {
      chainMap.put(keys.get(i), values.get(i));
    }
    long insertionTime = System.nanoTime() - startTime;

    startTime = System.nanoTime();
    for (Integer key : keys) {
      chainMap.get(key);
    }
    long retrievalTime = System.nanoTime() - startTime;

    System.out.println("ChainHashMap - Insertion Time: " + insertionTime / 1e6 + " ms, Retrieval Time: " + retrievalTime / 1e6 + " ms");
  }

  public static void main(String[] args) {
    int numElements = 10000;
    List<Integer> keys = generateRandomKeys(numElements);
    List<Integer> values = generateRandomValues(numElements);
    for (int i =0; i < 3;i++) {

      testProbeHashMap(keys, values);
      testChainHashMap(keys, values);
      System.out.println();
    }
  }
}
