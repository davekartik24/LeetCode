class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;

		int n = matrix[0].length;;

		int[][] newMatrix = new int[m][n];

		for(int i = 0; i < m; i++) {

			for(int j = 0; j < n; j++) {

					newMatrix[i][j] = matrix[i][j];
			}
		}

		for(int i = 0; i < m; i++) {

			for(int j = 0; j < n; j++) {

				if(newMatrix[i][j] == 0) {

					for(int k = 0; k < m; k++) {

						matrix[k][j] = 0;
					}

					for(int l = 0; l < n; l++) {

						matrix[i][l] = 0;
					}
				}
			}
		}
        
    }
}