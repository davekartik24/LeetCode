class RotateImage {
    public void rotate(int[][] matrix) {
        
        int nValue = matrix.length;

		for(int i = 0; i < (nValue / 2); i++) {

			for(int j = i; j < (nValue - 1) - i; j++) {

				swap(matrix, i, j, j,((nValue - 1) - i));
				swap(matrix, i, j, ((nValue - 1) - i), ((nValue - 1) - i) - (j - i));
				swap(matrix, i, j, ((nValue - 1) - i) - (j - i),i);
			}
		}
        
    }
    
    public void swap(int[][] matrix, int firstA, int firstB, int secondA, int secondB) {

		int temp = matrix[firstA][firstB];
		matrix[firstA][firstB] = matrix[secondA][secondB];
		matrix[secondA][secondB] = temp;
	}
}