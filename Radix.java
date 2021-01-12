public class Radix {
  public static int Nth(int n, int col) {
    return ((n / (10 * col)) % 10);
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
