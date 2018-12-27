class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        
        if(s.length==0){return 0;}
       
        Arrays.sort(g);
        
        Arrays.sort(s);
      
        int k =0;
        int res=0;
        for(int i  = 0;i<s.length;i++){
            if(g[k]<=s[i]){
                res++;
                k++;
                if(k==g.length)
                {return res;}
            }
            
        }
        
        return res;
        
    }
}