


class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0) return 0;
        
        if(coins.length == 0) return -1;
        
        Arrays.sort(coins);
        
        int[] minChange = new int[amount + 1];
        
        Arrays.fill(minChange, amount + 1);
        
        minChange[0] = 0;
         
        for(int i = 1; i <= amount; i++) {
            
            for(int j = 0; j < coins.length; j++) {
                
                if(i < coins[j]) break;
                
                minChange[i] = Math.min(minChange[i], (minChange[i - coins[j]] + 1));

            }
        }
        
        return minChange[amount] > amount ? -1 : minChange[amount];
        
    }
}