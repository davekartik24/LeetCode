class CoinChange2 {
    public int change(int amount, int[] coins) {
        
        int[] memo = new int[amount + 1];
    
        
        memo[0] = 1;
        
        for(int i = 0; i < coins.length; i++) {
            
            for(int j = coins[i]; j <= amount; j++) {
                
                memo[j] = memo[j] + memo[j - coins[i]];
            }
        }
        
        return memo[amount]; 
        
    }

}