class Solution {
    public static void convertToWave(int n, int[] a) {
        //if array is unsorted
        //then make sure that the element at the even position (0, 2, 4, 6, 8), is
        //bigger than its left and right element
        for(int i = 0; i < a.length; i += 2){
            if(i > 0 && a[i - 1] > a[i]){
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
            }
            
            if(i + 1 < a.length && a[i + 1] > a[i]){
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
    }
}
