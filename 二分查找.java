class BSearchSum {
  public int bsearch(int[] a, int n, int val) {
    return bsearchInternally(a, 0, n - 1, val);
  }

  private int bsearchInternally(int[] a, int low, int high, int value) {
    if (low > high) return -1;
    int mid = low + ((high - low) >> 1);
    if (a[mid] == value) {
      return mid;
    } else if (a[mid] < value) {
      return bsearchInternally(a, mid+1, high, value);
    } else {
      return bsearchInternally(a, low, mid-1, value);
    }
  }

  // 变形 1 - 查找第一个值等于给定值的元素
  public int bsearchV1(int[] a, int n, int val) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      mid = low + ((high - low) >> 2);
      if (a[mid] >= val) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    // 有越界的可能性？- 有越界的可能性！！
    // 只有一个元素时越界
    if (low<n && a[low] == val) {
      return low;
    } else {
      return -1;
    }
  }


  // 变形 2 - 查找最后一个值等于给定值的元素
  public int bsearchV2(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid =  low + ((high - low) >> 1);
      if (a[mid] > value) {
        high = mid - 1;
      } else if (a[mid] < value) {
        low = mid + 1;
      } else {
        // 这里其实暗含了a[mid] == value
        // 先一步做越界判断
        if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
        else low = mid + 1;
      }
    }
    return -1;
  }

  // 变形3 - 查找第一个大于等于给定值的元素
  public int bsearchV3(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid =  low + ((high - low) >> 1);
      if (a[mid] >= value) {
        if ((mid == 0) || (a[mid - 1] < value)) return mid;
        else high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  // 变体四：查找最后一个小于等于给定值的元素
  public int bsearchV4(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid =  low + ((high - low) >> 1);
      if (a[mid] > value) {
        high = mid - 1;
      } else {
        if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
        else low = mid + 1;
      }
    }
    return -1;
  }

}


