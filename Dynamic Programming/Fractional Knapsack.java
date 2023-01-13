//O(N + NlogN + N)
//O(N)
class Solution{
    //Function to get the maximum total value in the knapsack.
    public static class Pair{
        int value;
        int weight;
        double ratio; //(cost/wt)
        
        Pair(int value, int weight, double ratio){
            this.value = value;
            this.weight = weight;
            this.ratio = ratio;
        }
        
        public String toString(){
            return "[" + this.value + ", " + this.weight + ", " + this.ratio + "]";
        }
    }
    
    double fractionalKnapsack(int W, Item[] arr, int n) {
        Pair[] items = new Pair[arr.length]; 
        for(int i = 0; i < arr.length; ++i){
            items[i] = new Pair(arr[i].value, arr[i].weight, (double)(arr[i].value / arr[i].weight));
        }
        
        //sorting items on the basis of ratio
        Arrays.sort(items, (Pair a, Pair b) -> {
            if((double)a.value / a.weight <= (double)b.value / b.weight){
                return 1;
            }
            return -1;
        });
        
        int remain = W;
        double profit = 0.0;
        
        //looping through all items
        for(int i = 0; i < items.length; ++i){
            if(remain - items[i].weight >= 0){
                profit += items[i].value;
                remain -= items[i].weight;
            }else{ //if we can't add current item then add fraction part of it
                profit += ((double)remain / items[i].weight) * items[i].value;
                remain -= ((double)remain / items[i].weight) * items[i].weight;
                break;
            }
        }
    
        return profit;
    }
}
