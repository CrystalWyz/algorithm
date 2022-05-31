package leetcode;
/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

class VersionControl {
    boolean isBadVersion(int version){return true;}
}
class FirstBadVersion extends VersionControl  {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}