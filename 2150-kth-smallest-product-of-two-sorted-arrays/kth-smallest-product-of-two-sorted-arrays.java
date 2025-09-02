class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
     long left = -10000000000L, right = 10000000000L;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (countProducts(nums1, nums2, mid) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private long countProducts(int[] nums1, int[] nums2, long val) {
        long count = 0;
        for (int n1 : nums1) {
            if (n1 == 0) {
                if (val >= 0) {
                    count += nums2.length;
                }
                continue;
            }
            if (n1 > 0) {
                int l = 0, r = nums2.length - 1;
                int pos = -1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if ((long) n1 * nums2[mid] <= val) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                count += (pos + 1);
            } else {
                int l = 0, r = nums2.length - 1;
                int pos = nums2.length;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if ((long) n1 * nums2[mid] <= val) {
                        pos = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                count += (nums2.length - pos);
            }
        }
        return count;   
    }
}