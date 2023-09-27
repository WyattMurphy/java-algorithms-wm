
/**
 * A class that conducts merge sort on array of ints
 * 
 * @author Wyatt Murphy
 */
public class MergeSort {

    protected static void mergeSort(int[] ary) {
        // base case -> contains single element; single elements are inherintly sorted
        if (ary.length == 1) {
            return;
        }

        int midPoint = ary.length / 2;
        int endPoint = ary.length;
        int[] left = new int[midPoint];
        int[] right = new int[endPoint - midPoint];

        // populate left and right arrays
        for (int i = 0; i < midPoint; ++i) {
            left[i] = ary[i];
        }

        for (int j = midPoint; j < endPoint; ++j) {
            right[j - midPoint] = ary[j];
        }

        // recursive calls
        mergeSort(left);
        mergeSort(right);

        // merge step
        merge(ary, right, left);

    }

    public static void merge(int[] merged, int[] right, int[] left) {
        int maxRight = right.length;
        int maxLeft = left.length;

        // index pointers
        int r, l, m;
        r = l = m = 0;

        // begin ordered merging
        while ((l < maxLeft) && (r < maxRight)) {
            if (right[r] < left[l]) {
                merged[m] = right[r];
                ++r;
            } else {
                merged[m] = left[l];
                ++l;
            }
            ++m;
        }

        // exhaust all remaining elements
        while (r < maxRight) {
            merged[m] = right[r];
            ++r;
            ++m;
        }

        while (l < maxLeft) {
            merged[m] = left[l];
            ++l;
            ++m;
        }

    }

    public static void printArray(int[] printme) {
        for (int i : printme) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // little demo
        int[] thearray = { 3, 21, 8, 5, 34, 2, 1, 1, 13 };
        System.out.println("Before Sorting");
        printArray(thearray);
        mergeSort(thearray);
        System.out.println("After Sorting");
        printArray(thearray);
    }

}
