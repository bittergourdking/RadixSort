public class Radix {
  public static int Nth(int n, int col) {
    if (col < 0) {
      throw new IllegalArgumentException("column cannot be negative!");
    }
    return ((n / (int)Math.pow(10, col)) % 10);
  }
  public static int length(int n) {
    return (n + "").length();
  }
  public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
    for (int i = 0; i < 10; i++) {
      original.extend(buckets[i]);
    }
  }
}
