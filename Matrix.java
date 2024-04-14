public class Matrix {
    // Instance variables
    private int rows;
    private int columns;
    private int[][] elements;

    // Constructor
    public Matrix(int rows, int columns, int[][] elements) {
        this.rows = rows;
        this.columns = columns;
        this.elements = elements;
    }

    // Method to get the number of rows
    public int getRows() {
        return rows;
    }

    // Method to get the number of columns
    public int getColumns() {
        return columns;
    }

    // Method to set the element at position (i, j)
    public void setElement(int i, int j, int value) {
        if (i >= 0 && i < rows && j >= 0 && j < columns) {
            elements[i][j] = value;
        } else {
            System.out.println("Invalid position. Element not set.");
        }
    }

    // Method to add two matrices
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            System.out.println("Matrices cannot be added. Dimensions mismatch.");
            return null;
        }

        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = this.elements[i][j] + other.elements[i][j];
            }
        }
        return new Matrix(rows, columns, result);
    }

    // Method to multiply two matrices
    public Matrix multiply(Matrix other) {
        if (this.columns != other.rows) {
            System.out.println("Matrices cannot be multiplied. Inner dimensions mismatch.");
            return null;
        }

        int[][] result = new int[this.rows][other.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result[i][j] += this.elements[i][k] * other.elements[k][j];
                }
            }
        }
        return new Matrix(this.rows, other.columns, result);
    }

    // Method to display the matrix
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(elements[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] data2 = {{7, 8, 9}, {10, 11, 12}};

        Matrix matrix1 = new Matrix(2, 3, data1);
        Matrix matrix2 = new Matrix(2, 3, data2);

        System.out.println("Matrix 1:");
        matrix1.display();
        System.out.println();

        System.out.println("Matrix 2:");
        matrix2.display();
        System.out.println();

        Matrix sum = matrix1.add(matrix2);
        if (sum != null) {
            System.out.println("Sum of matrices:");
            sum.display();
            System.out.println();
        }

        Matrix product = matrix1.multiply(matrix2);
        if (product != null) {
            System.out.println("Product of matrices:");
            product.display();
        }
    }
}
