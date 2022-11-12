class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    //O(logn)
    public void addNum(int num) {
        if(right.size() > 0 && num > right.peek()){
            right.add(num);
            if(right.size() - left.size() == 2){ //balancing
                left.add(right.remove());
            }
        }else{
            left.add(num);
            if(left.size() - right.size() == 2){ //balancing
                right.add(left.remove());
            }
        }
    }
    
    //O(1)
    public double findMedian() {
        if(left.size() + right.size() == 0){
           return 0.0;
        }
        
        if(left.size() == right.size()){
            double median = (left.peek() + right.peek()) / 2.0;
            return median;
        }else if(left.size() > right.size()){
            return left.peek();
        }else{
            return right.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
