//TC : O(n)
//SC : O(n) worst case : when all the asteroids will have the same direction, either right or left
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < asteroids.length; ++i){
            int currAst = asteroids[i]; //current asteroid
    
            if(dq.size() > 0 && dq.getLast() > 0 && currAst < 0){ //opposite direction(o ---->  <---- o) //Collision will happen, E.g. [10, -6(currAst)]
                boolean flag = true;
                while(dq.size() > 0 && dq.getLast() > 0 && currAst < 0){
                    if(dq.getLast() == Math.abs(currAst)){ //[5, 10, -10(currAst)] = [5]
                        dq.removeLast();
                        flag = false;
                        break; //as both asteroid will get distroyed, so stop here
                    }else if(dq.getLast() < Math.abs(currAst)){ //[10, 10, 6, 7, 8, 9, -10(currAst)] = [10]
                        dq.removeLast();
                    }else{ //dq.getLast() > Math.abs(currAst) [10, -3(currAst)]
                        flag = false;
                        break;
                    }
                }
                
                if(flag == true) dq.addLast(currAst);
                // System.out.println(dq);
            }else if(dq.size() > 0 && dq.getLast() > 0 && currAst > 0){ //same direction, e.g. [5, 7(currAst)]
                dq.addLast(currAst);   
            }else if(dq.size() > 0 && dq.getLast() < 0 && currAst < 0){ //same direction, e.g. [-5, -9(currAst)]
                dq.addLast(currAst);   
            }else if(dq.size() > 0 && dq.getLast() < 0 && currAst > 0){ //opposite direction( <---- o  o---->) //No collision, E.g. [-6, 10(currAst)]
                dq.addLast(currAst); 
            }else{ //dq is empty
                dq.addLast(currAst); 
            }
            // System.out.println(dq);
        }
        
        int[] res = new int[dq.size()];
        int idx = 0;
        while(dq.size() > 0){
            res[idx++] = dq.removeFirst();
        }
        return res;
    }
}

//TC : O(n)
//SC : O(n) worst case : when all the asteroids will have the same direction, either right or left
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < asteroids.length; ++i){
            int currAst = asteroids[i];
    
            if(dq.size() > 0 && dq.getLast() > 0 && currAst < 0){ //opposite direction(o ---->  <---- o) //Collision will happen
                boolean flag = true;
                while(dq.size() > 0 && dq.getLast() > 0 && currAst < 0){
                    if(dq.getLast() == Math.abs(currAst)){
                        dq.removeLast();
                        flag = false;
                        break; //as both asteroid will get distroyed, so stop here
                    }else if(dq.getLast() < Math.abs(currAst)){ //[10, 10, 6, 7, 8, 9, -10(currAst)] = [10]
                        dq.removeLast();
                    }else{ //dq.getLast() > Math.abs(currAst) [10, -3(currAst)]
                        flag = false;
                        break;
                    }
                }
                
                if(flag == true) dq.addLast(currAst);
                // System.out.println(dq);
            }else{ //dq is empty
                dq.addLast(currAst); 
            }
            // System.out.println(dq);
        }
        
        int[] res = new int[dq.size()];
        int idx = 0;
        while(dq.size() > 0){
            res[idx++] = dq.removeFirst();
        }
        return res;
    }
}
