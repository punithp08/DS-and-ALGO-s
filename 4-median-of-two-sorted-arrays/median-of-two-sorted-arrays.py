class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        
        m, n = len(nums1), len(nums2)
        total_length = m + n
        
        half_len = (total_length + 1) // 2
        
        low, high = 0, m
        
        while low <= high:
            i = (low + high) // 2
            j = half_len - i
            
            left1 = nums1[i - 1] if i > 0 else float('-inf')
            right1 = nums1[i] if i < m else float('inf')
            
            left2 = nums2[j - 1] if j > 0 else float('-inf')
            right2 = nums2[j] if j < n else float('inf')
            
            if left1 <= right2 and left2 <= right1:
                if total_length % 2 == 1:
                    return float(max(left1, left2))
                else:
                    return float(max(left1, left2) + min(right1, right2)) / 2.0
            elif left1 > right2:
                high = i - 1
            else:
                low = i + 1
        
        return 0.0
        # bit harder