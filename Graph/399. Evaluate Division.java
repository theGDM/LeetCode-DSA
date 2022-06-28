//Very important question
class Solution {
    HashMap<String, String> parent;
    HashMap<String, Double> mult;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        mult = new HashMap<>();
        
        for(List<String> equation : equations){
            addToDSU(equation.get(0));
            addToDSU(equation.get(1));
        }
        
        System.out.println(parent);
        System.out.println(mult);
        int i = 0;
        for(List<String> equation : equations){
            String l0 = find(equation.get(0));
            String l1 = find(equation.get(1));
            
            Double m0 = mult.get(equation.get(0));
            Double m1 = mult.get(equation.get(1));
            
            mult.put(l0, (values[i] * m1) / m0);
            parent.put(l0, l1); //a/b = 3.0 -> a ka parent b
            
            // System.out.println(parent);
            // System.out.println(mult);
            
            i++;
        }
        
        double[] res = new double[queries.size()];
        i = 0;
        
        for(List<String> query : queries){
            if(parent.containsKey(query.get(0)) == false || parent.containsKey(query.get(1)) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            String l0 = find(query.get(0));
            String l1 = find(query.get(1));
            
            if(l0.equals(l1) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            Double m0 = mult.get(query.get(0));
            Double m1 = mult.get(query.get(1));
            res[i] = m0 / m1;
            
            i++;
        }
        
        return res;
    }
    
    public void addToDSU(String s){
        if(parent.containsKey(s) == false){
            parent.put(s, s);
            mult.put(s, 1.0);
        }
    }
    
    public String find(String s){
        if(parent.get(s).equals(s)){
            return parent.get(s);
        }else{
            String cp = parent.get(s);
            String np = find(parent.get(s));
            
            mult.put(s, mult.get(cp) * mult.get(s)); //very important line
            parent.put(s, np);
            return np;
        }
    }
}
