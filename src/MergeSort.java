import java.util.Arrays;
/**
 * Class that preforms merge sort on basic array of ints
 */
public class MergeSort{

    protected int [] before = {21, 13, 8, 5, 3, 2, 1, 1};
    protected int [] after;

    // fields

    // construtor
    MergeSort(){

    }
    //methods
    protected void preformMergeSort(int[] unsorted){
        // base case -> contains single element; single elements are inherintly sorted
        if(unsorted.length == 1){
            return;
        }
        int midPoint = unsorted.length / 2;
        int endPoint = unsorted.length;

        int [] splitRight = Arrays.copyOfRange(unsorted, 0, midPoint);
        int [] splitLeft = Arrays.copyOfRange(unsorted, midPoint, endPoint);

        // recursive calls 
        preformMergeSort(splitRight);
        preformMergeSort(splitLeft);
        this. after = this.sort(splitRight, splitLeft);
        


    }

    private int [] sort(int [] right, int[] left ){
        int max;
        int total = right.length + left.length;
        // new int array to be returned
        int [] merged = new int[total];

        if(right.length >= left.length){
            max = right.length;
        }else{
            max = left.length;
        }

        int r, l, m;
        r = l = m = 0; 
        
        while((l < max) && (r < max)){
            if(right[r] < left[l]){
                merged[m] = right[r];
                ++l;
            }else{
                merged[m] = left[l];
                ++r;
            }
            ++m;
        }

        // exhaust all left over elements
        while (r < max) {
            merged[m] = right[r];
            ++r;
            ++m;
        }

        while (l < max) {
            merged[m] = left[l];
            ++l;
            ++m;
        }
        
        return merged;
    }

    public void printPre(){
        System.out.println("Array before running merge sort");
        for (int i : this.before) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public void printPost(){
        System.out.println("Array after running merge sort");
        for (int i : this.after) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public static void main(String[] args){
        MergeSort dnc = new MergeSort();
        dnc.printPre();
        dnc.preformMergeSort(dnc.before);
        dnc.printPost();
        
        

    }

}