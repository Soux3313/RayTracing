package org.example;

public class Matrix {
    double[][] matrix;

    public Matrix(double[][] matrix)
    {
        this.matrix = matrix;
    }

    public Matrix(int scale)
    {
        this.matrix = new double[scale][scale];

        for(int i = 0; i < scale; i++)
        {
            for(int j = 0; j < scale; j++)
            {
                matrix[i][j] = 0;
            }
        }
        for(int i = 0; i < scale; i++)
        {
            matrix[i][i] = 1;
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double getCell(int x, int y)
    {
        return this.matrix[x][y];
    }

    public String toString()
    {
        String matrixString = "";

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                matrixString += matrix[i][j] + ", ";
            }
            if(i < matrix.length - 1) matrixString += "\n";
        }

        return matrixString;
    }

    public boolean equals(Matrix m)
    {
        if(matrix.length != m.getMatrix().length) return false;
        if(matrix[0].length != m.getMatrix()[0].length) return false;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(Math.abs(this.matrix[i][j] - m.getMatrix()[i][j]) > 0.00001) return false;
            }
        }

        return true;
    }
}
