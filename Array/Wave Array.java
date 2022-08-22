class Solution {
    public static void convertToWave(int n, int[] a) {
        Arrays.sort(a);
        //swap alternate elements, so between 2 peeks we have one smaller element after sorting
        for(int i = 0; i < a.length - 1; i += 2){
            int temp = a[i];
            a[i] = a[i + 1];
            a[i + 1] = temp;
        }
    }
}
   
