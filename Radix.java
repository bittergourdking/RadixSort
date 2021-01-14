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
    return (n + "").length();
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
    boolean next = true;
    while (next) {
      next = false;
      while (data.size() > 0) {
        int currentNum = data.remove(0);
        int digitEnd = nth(currentNum, colNum);
        buckets[digitEnd].add(currentNum);
        if (length(currentNum) > colNum + 1) {
          next = true;
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
    boolean next = true;
    while (next) {
      next = false;
      while (data.size() > 0) {
        int currentNum = data.remove(0);
        int digitEnd = nth(currentNum, colNum)+9;
        buckets[digitEnd].add(currentNum);
        if (length(currentNum) > colNum + 1) {
          next = true;
        }
      }
      colNum++;
      merge(data, buckets);
    }
  }
}
