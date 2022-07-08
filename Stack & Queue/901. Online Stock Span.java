//Good Question based on some oops concept
//Here we will maintain a stack of pair (price and its stock span)

class StockSpanner {
    public class Pair{
        int price;
        int span;
        
        Pair(int price, int span){
            this.price = price;
            this.span = span;
        }
    }
    
    Stack<Pair> stk;
    public StockSpanner() {
        stk = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        while(stk.size() > 0 && price >= stk.peek().price){
            span += stk.peek().span;
            stk.pop();
        }
        
        stk.push(new Pair(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
