public class Radix {
  public static int nth(int n, int col) {
    if (col < 0) {
      throw new IllegalArgumentException("column cannot be negative!");
    }
    return (int)((n / Math.pow(10, col)) % 10);
  }

  public static int length(int n) {
    if (n == 0) {
      return 1;
    }
    return (int)(Math.log10(Math.abs(n)) + 1);
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }
    int colNum = 0;
    int maxLength = 0;
    while (colNum <= maxLength) {
      while (data.size() > 0) {
        int current = data.remove(0);
        int colDigit = nth(current, colNum);
        buckets[colDigit].add(current);
        if (colNum == 0 && length(current) > maxLength) {
          maxLength = length(current);
        }
      }
      colNum++;
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[19];
    for (int i = 0; i < 19; i++) {
      buckets[i] = new SortableLinkedList();
    }
    int colNum = 0;
    int maxLength = 0;
    while (colNum <= maxLength) {
      while (data.size() > 0) {
        int current = data.remove(0);
        int colDigit = nth(current, colNum) + 9;
        buckets[colDigit].add(current);
        if (colNum == 0 && length(current) > maxLength) {
          maxLength = length(current);
        }
      }
      colNum++;
      merge(data, buckets);
    }
  }
}
