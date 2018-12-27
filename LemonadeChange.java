class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        
        if(bills.length == 0) return true;
        
        int fiveChange = 0;
        int tenChange = 0;
        
        for(int i = 0; i < bills.length; i++) {
            
            if(fiveChange < 0 || tenChange < 0) return false;
            
            int amount = bills[i];
            
            if(amount == 5) {
                fiveChange++;
            } else if(amount == 10) {
                fiveChange--;
                tenChange++;
            } else {
                if(tenChange == 0) {
                    fiveChange = fiveChange - 3;
                } else {
                    fiveChange--;
                    tenChange--;
                }
            }
        }
        
        if(fiveChange < 0 || tenChange < 0) return false;
        
        return true;
    }
}