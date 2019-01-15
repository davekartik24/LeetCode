class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        
        int[][] goal = {{1,2,3}, {4,5,0}};
        
        String target = Arrays.deepToString(goal);
        
        ArrayDeque<Element> queue = new ArrayDeque<>();
        
        HashSet<String> lookup = new HashSet<>();
        
        queue.addLast(new Element(board, 0));
        
        while(!queue.isEmpty()) {
            
            Element focusedElement = queue.removeFirst();
            
            if(target.equals(focusedElement.inputArrayString)) return focusedElement.depth;
            
            lookup.add(focusedElement.inputArrayString); 
            
            int rowPos = focusedElement.zeroPosition[0];
            int colPos = focusedElement.zeroPosition[1];
            
            if((rowPos - 1) >= 0) {
                
                int[][] swappedResult = swapRow(rowPos, rowPos - 1, colPos, focusedElement.inputArray);
                
                Element newElement = new Element(swappedResult, focusedElement.depth + 1, new int[] {rowPos - 1, colPos});
                
                if(!lookup.contains(newElement.inputArrayString)) {
                    
                    queue.addLast(newElement);
                }
            }
            
            if((rowPos + 1) <= 1) {
                
                int[][] swappedResult = swapRow(rowPos, rowPos + 1, colPos, focusedElement.inputArray);
                
                Element newElement = new Element(swappedResult, focusedElement.depth + 1, new int[] {rowPos + 1, colPos});
                
                if(!lookup.contains(newElement.inputArrayString)) {
                    
                    queue.addLast(newElement);
                }
            }
            
            if((colPos - 1) >= 0) {
                
                int[][] swappedResult = swapCol(colPos, colPos - 1, rowPos, focusedElement.inputArray);
                
                Element newElement = new Element(swappedResult, focusedElement.depth + 1, new int[] {rowPos, colPos - 1});
                
                if(!lookup.contains(newElement.inputArrayString)) {
                    
                    queue.addLast(newElement);
                }
            }
            
            if((colPos + 1) <= 2) {
                
                int[][] swappedResult = swapCol(colPos, colPos + 1, rowPos, focusedElement.inputArray);
                
                Element newElement = new Element(swappedResult, focusedElement.depth + 1, new int[] {rowPos, colPos + 1});
                
                if(!lookup.contains(newElement.inputArrayString)) {
                    
                    queue.addLast(newElement);
                }
            }
            
        }
        
        return -1;
        
    }
    
    public int[][] swapRow(int row, int newRow, int colPos,int[][] inputToSwap) {
        
        int[][] deepCopy = new int[inputToSwap.length][inputToSwap[0].length];
        
        for(int i = 0; i < inputToSwap.length; i++) {
            
            for(int j = 0; j < inputToSwap[0].length; j++) {
                
                deepCopy[i][j] = inputToSwap[i][j];
            }
        }
        
        int temp = deepCopy[row][colPos];
        
        deepCopy[row][colPos] = deepCopy[newRow][colPos];
        deepCopy[newRow][colPos] = temp;
        
        return deepCopy;
    }
    
    public int[][] swapCol(int col, int newCol, int rowPos,int[][] inputToSwap) {
        
        int[][] deepCopy = new int[inputToSwap.length][inputToSwap[0].length];
        
        for(int i = 0; i < inputToSwap.length; i++) {
            
            for(int j = 0; j < inputToSwap[0].length; j++) {
                
                deepCopy[i][j] = inputToSwap[i][j];
            }
        }
        
        int temp = deepCopy[rowPos][col];
        
        deepCopy[rowPos][col] = deepCopy[rowPos][newCol];
        deepCopy[rowPos][newCol] = temp;
        
        return deepCopy;
    }
    
    public class Element {
        
        int[][] inputArray;
        String inputArrayString;
        int depth;
        int[] zeroPosition;
        
        public Element(int[][] inputArray, int depth) {
            
            this.inputArray = inputArray;
            this.depth = depth;
            inputArrayString = Arrays.deepToString(inputArray);
            zeroPosition = new int[2];
            
            for(int i = 0; i < inputArray.length; i++) {
                
                for(int j = 0; j < inputArray[0].length; j++) {
                    
                    if(inputArray[i][j] == 0) {
                        
                        zeroPosition[0] = i;
                        zeroPosition[1] = j;
                    }
                }
            }   
        }
        
        public Element(int[][] inputArray, int depth, int[] zeroPosition) {
            
            this.inputArray = inputArray;
            inputArrayString = Arrays.deepToString(inputArray);
            this.depth = depth;
            this.zeroPosition = zeroPosition;        
        }
        
        public boolean equals(Object input) {
            
            if(input instanceof Element) {
                
                Element castInput = (Element)input;
                
                return Arrays.deepEquals(this.inputArray, castInput.inputArray);
            }
            
            return false;
        } 
    }
}