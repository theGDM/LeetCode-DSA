//Brute force approch
class SubrectangleQueries {
    int[][] tempRect;
    public SubrectangleQueries(int[][] rectangle) {
        tempRect = rectangle;
    }
    
    //updating TC : O((row2 - row1) * (col2 - col1)) = O(m * n)
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i = row1; i <= row2; ++i){
            for(int j = col1; j <= col2; ++j){
                tempRect[i][j] = newValue;
            }
        }
    }
    
    //geting TC : O(1)
    public int getValue(int row, int col) {
        return tempRect[row][col];
    }
}

// Instead of eagerly updating all the values in the rectangle, we can Just lazily add the operation data to a list. Now when the getValue operation comes, It just becomes the matter of lazily searching if the value at that rectangle was updated.

// Since the max number of operations will be 500, the getValue function takes O(500) time in the worst case!
class SubrectangleQueries {
    int[][] rectangle;
    List<Operation> ops;
    public class Operation{
        int r1;
        int c1;
        int r2;
        int c2;
        int nv;
        
        Operation(int r1, int c1, int r2, int c2, int nv){
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.nv = nv;
        }
    }
    
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        ops = new ArrayList<>();
    }
    
    //updating TC : O(1)
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
       ops.add(new Operation(row1, col1, row2, col2, newValue));
    }
    
    //geting TC : worst case O(Q) => queries => O(500) //There will be at most 500 operations 
    public int getValue(int row, int col) {
        for(int i = ops.size() - 1; i >= 0; --i){
            Operation op = ops.get(i);
            
            if(row >= op.r1 && row <= op.r2 && col >= op.c1 && col <= op.c2){
                return op.nv;
            }
        }
        
        //if no updateSubrectangle
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
