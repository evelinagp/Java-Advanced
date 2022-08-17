package MultidimensionalArrays2.MultidimensionalArrays2_TheMatrixEx12;

import java.util.List;

public class Matrix {
    private int rows;
    private int cols;
    private char[][] matrix;


    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new char[this.rows][this.cols];
    }

    public void setMatrix(List<String> lines) {
        for (int row = 0; row < lines.size(); row++) {
            this.matrix[row] = lines.get(row).toCharArray();

        }
        {
        }
    }
}
