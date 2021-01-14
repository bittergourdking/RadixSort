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
  for (int i = 0; i < buckets.length; i++) {
    buckets[i] = new SortableLinkedList();
  }
  int digitNum = 0;
  boolean yes = true;
  while (yes) {
    yes = false;
    while (data.size() > 0) {
      System.out.println(data.get(0));
      int currentNum = data.remove(0);
      int digitEnd = nth(currentNum, digitNum);
      buckets[digitEnd].add(currentNum);
      if (Radix.length(currentNum) > digitNum + 1) {
        yes = true;
      }
    }
    digitNum++;
    merge(data, buckets);
  }
}

public static void radixSort(SortableLinkedList data) {
  SortableLinkedList[] buckets = new SortableLinkedList[19];
  for (int i = 0; i <= 18; i++) {
    buckets[i] = new SortableLinkedList();
  }
  int digitNum = 0;
  boolean yes = true;
  while (yes) {
    yes = false;
    while (data.size() > 0) {
      int currentNum = data.remove(0);
      int digitEnd = nth(currentNum, digitNum)+9;
      buckets[digitEnd].add(currentNum);
      if (Radix.length(currentNum) > digitNum + 1) {
        yes = true;
      }
    }
    digitNum++;
    merge(data, buckets);
  }
}

/*
  public static void radixSortSimple(SortableLinkedList data) {
    int maxLength = 0;
    int current = 0;
    int start = 0;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }
    for (int j = 0; j < data.size(); j++) {
      current = length(data.get(j));
      if (current > maxLength) {
        maxLength = current;
      }
      current = data.remove(0);
      buckets[nth(current, 0)].add(current);
    }
    merge(data, buckets);
    for (int k = 1; k < maxLength; k++) {
      for (int l = start; l < data.size(); l++) {
        current = data.get(l);
        if (length(current) >= k) {
          buckets[nth(current, k)].add(current);
          data.remove(l);
        }
      }
      start = data.size() - 1;
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList negative = new SortableLinkedList();
    SortableLinkedList positive = new SortableLinkedList();
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) < 0) {
        negative.add(data.remove(i));
      } else {
        positive.add(data.remove(i));
      }
    }
    radixSortSimple(positive);
    radixSortSimple(negative);
    for (int j = negative.size() - 1; j > -1; j--) {
      negative.add(negative.remove(j));
    }
    data.extend(negative);
    data.extend(positive);
  }
  */
}
