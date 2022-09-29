/*
658. Find K Closest Elements
Medium
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the
array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]


Constraints:

1 <= k <= arr.length
1 <= arr.length <= 10^4
arr is sorted in ascending order.
-10^4 <= arr[i], x <= 10^4
*/
package FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

class FindKClosestElements {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> kClosest = new ArrayList<>(k);
    if (arr.length == k) {
      for (int num : arr) {
        kClosest.add(num);
      }
      return kClosest;
    }
    int closest = binaryClosestSearch(arr, x, 0, arr.length - 1);
    if (k == 1) {
      kClosest.add(arr[closest]);
      return kClosest;
    }
    int left = closest;
    int right = closest;
    while (right - left + 1 < k) {
      if (left == 0) {
        for (int i = k - (right - left) - 1; i > 0; i--) {
          // kClosest.add(arr[right]);
          right++;
        }
        break;
      }
      if (right == arr.length - 1) {
        for (int i = k - (right - left) - 1; i > 0; i--) {
          // kClosest.add(arr[left - i]);
          left--;
        }
        break;
      }
      if (Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x)) {
        left -= 1;
      } else {
        right += 1;
      }
    }
    for (int i = left; i <= right; i++) {
      kClosest.add(arr[i]);
    }
    return kClosest;
  }

  private int binaryClosestSearch(int[] arr, int x, int left, int right) {
    int length = right - left + 1;
    if (length <= 2) {
      if (Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
        return right;
      } else {
        return left;
      }
    }
    int middle = (length - 1) / 2 + left;
    if (x < arr[middle]) {
      return binaryClosestSearch(arr, x, left, middle);
    } else {
      return binaryClosestSearch(arr, x, middle, right);
    }
  }
}
