package org.example;

public class Matrix {
    double[][] matrix;
    private Matrix inverse;

    public Matrix(double[][] m)
    {
        this.matrix = new double[m.length][m[0].length];

        for(int i = 0; i < m.length; i++)
        {
            for(int j = 0; j < m.length; j++)
            {
                this.matrix[i][j] = m[i][j];
            }
        }

    }

    public Matrix(int scale)
    {
        this.matrix = new double[scale][scale];

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                this.matrix[i][j] = 0;
            }
        }
    }

    public Matrix getInverse() {
        if(inverse == null)
        {
            inverse = invert();
        }
        return inverse;
    }

    public static Matrix identity(int scale)
    {

        double[][] m = new double[scale][scale];
        for(int i = 0; i < scale; i++)
        {
            for(int j = 0; j < scale; j++)
            {
                m[i][j] = 0;
            }
        }
        for(int i = 0; i < scale; i++)
        {
            m[i][i] = 1;
        }

        return new Matrix(m);
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
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || getClass() != obj.getClass()) return false;
        Matrix m = (Matrix) obj;
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
    public Matrix mult(double scale)
    {
        double[][] res = new double[matrix.length][matrix.length];

        for(int i = 0; i < matrix.length; i++)//rows
        {
            for(int j = 0; j < matrix.length; j++)//columns
            {
                res[i][j] = this.matrix[i][j] * scale;
            }
        }
        return new Matrix(res);
    }
    public Matrix mult(Matrix m)
    {
        if(this.matrix[0].length != m.getMatrix().length) return this; //check if this columns equals objects rows

        double[][] res = new double[matrix.length][m.getMatrix()[0].length];

        for(int i = 0; i < this.matrix[0].length; i++)//rows
        {
            for(int j = 0; j < m.getMatrix().length; j++)//columns
            {
                for(int k = 0; k < matrix.length; k++)//component multiplication
                {
                    res[i][j] += this.matrix[i][k] * m.getMatrix()[k][j];
                }
            }
        }
        return new Matrix(res);
    }

    public Vector mult(Vector v)
    {
        if(this.matrix.length != 4) return v;

        double x = 0;
        double y = 0;
        double z = 0;
        double w = 0;

        for(int i = 0; i < this.matrix.length; i++)//rows
        {
            double temp = 0;
            for(int j = 0; j < this.matrix.length; j++)//columns
            {
                switch (j) {
                    case 0 -> temp += this.getMatrix()[i][j] * v.getX();
                    case 1 -> temp += this.getMatrix()[i][j] * v.getY();
                    case 2 -> temp += this.getMatrix()[i][j] * v.getZ();
                    case 3 -> temp += this.getMatrix()[i][j] * v.getOmega();
                }
            }
            switch (i) {
                case 0 -> x = temp;
                case 1 -> y = temp;
                case 2 -> z = temp;
                case 3 -> w = temp;
            }
        }

        return new Vector(x,y,z,w);
    }

    public Point mult(Point p)
    {
        if(this.matrix.length != 4) return p;

        double x = 0;
        double y = 0;
        double z = 0;
        double w = 0;

        for(int i = 0; i < this.matrix.length; i++)//rows
        {
            double temp = 0;
            for(int j = 0; j < this.matrix.length; j++)//columns
            {
                switch (j) {
                    case 0 -> temp += this.getMatrix()[i][j] * p.getX();
                    case 1 -> temp += this.getMatrix()[i][j] * p.getY();
                    case 2 -> temp += this.getMatrix()[i][j] * p.getZ();
                    case 3 -> temp += this.getMatrix()[i][j] * p.getOmega();
                }
            }
            switch (i) {
                case 0 -> x = temp;
                case 1 -> y = temp;
                case 2 -> z = temp;
                case 3 -> w = temp;
            }
        }
        return new Point(x,y,z,w);
    }

    public Matrix transpose()
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return new Matrix(result);
    }


    public double determinant()
    {
        if (this.matrix.length == 2)
        {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        double det = 0;

        for(int j = 0; j < matrix.length; j++)
        {
            det += matrix[0][j] * this.cofactor(0,j) * Math.pow(-1,j);
        }

        return det;
    }

    private double cofactor(int row, int col)
    {
        double[][] submatrix = new double[matrix.length-1][matrix.length-1];

        int subi = 0;
        int subj = 0;

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                if(i != row && j != col)
                {
                    submatrix[subi][subj++] = matrix[i][j];

                    if (subj == matrix.length - 1) {
                        subj = 0;
                        subi++;
                    }
                }
            }
        }
        Matrix subM = new Matrix(submatrix);

        return subM.determinant();
    }

    public final boolean isInvertible() {
        return determinant() != 0;
    }

    public Matrix adj()
    {
        if (! isInvertible()) {
            throw new RuntimeException("This matrix cannot be inverted");
        }
        double[][] res = new double[matrix.length][matrix.length];

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {

                res[i][j] = this.cofactor(i,j);
            }
        }
        return new Matrix(res);
    }

    public Matrix invert()
    {
        assert this.determinant() != 0 : "Matrix cannot be inverted";

        double scale = 1/determinant();

        return adj().mult(scale);
    }
}

