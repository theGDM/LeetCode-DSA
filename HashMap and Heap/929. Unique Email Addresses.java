//O(n)
class Solution {
    public int numUniqueEmails(String[] emails) {
        if(emails.length == 0) return 0;
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(String email : emails){
            String[] arr = email.split("\\@");
            
            String local = arr[0].split("\\+")[0]; //local part after ignoring charachters after +
            String domain = arr[1]; //domain part
            String[] frag = local.split("\\.");
            
            StringBuilder sb = new StringBuilder();
            for(String f : frag){
                sb.append(f);
            }
            
            sb.append("@" + domain);
            System.out.println(sb.toString());
            String key = sb.toString();
            
            if(hm.containsKey(key)){
                hm.put(key, hm.get(key) + 1);
            }else{
                hm.put(key, 1);
            }
            
        }
        
        return hm.keySet().size();
    } 
}

//O(n * emails[i].length) ~ O(n * 100) ~ O(n)
class Solution {
    public int numUniqueEmails(String[] emails) {
        if(emails.length == 0) return 0;
        
        HashSet<String> set = new HashSet<>();
        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            
            //making clean local part
            int i = 0;
            while(i < email.length()){
                char ch = email.charAt(i);
                if(ch == '.'){
                    i++;
                    continue;
                }else if(ch == '+' || ch == '@'){
                    break;
                }else{
                   sb.append(ch); 
                }
                i++;
            }
            
            //adding domain part
            while(i < email.length()){
                char ch = email.charAt(i);{
                    if(ch == '@'){
                        sb.append(email.substring(i));
                    }
                }
                
                i++;
            }
            set.add(sb.toString());
        }
        
        return set.size();
    } 
}
