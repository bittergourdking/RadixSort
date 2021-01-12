public class Radix {
  public static int Nth(int n, int col) {
    return ((n / (10 * col)) % 10);
  }
  public static int length(int n) {
    return (n + "").length();
  }
}
