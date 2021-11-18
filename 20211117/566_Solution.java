class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length == 0 || r * c != mat.length * mat[0].length) {
            return mat;
        }
        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[count / c][count % c] = mat[i][j];
                count++;
            }
        }
        
        return res;
    }
}