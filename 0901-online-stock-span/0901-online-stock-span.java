class StockSpanner {
    Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int b=1;
        while(!stack.isEmpty() && stack.peek().a <= price){
            b+= stack.pop().b;
        }
        stack.push(new Pair(price, b));
        return b;
    }
}
class Pair{
    int a, b;
    Pair(int a, int b){
        this.a=a;
        this.b=b;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */