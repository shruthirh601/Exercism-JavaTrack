import java.util.*;
class Matrix {
    private int[][] finalMatrix;
    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");
        finalMatrix = new int[rows.length][];
        
        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].trim().split("\\s+");
            finalMatrix[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                finalMatrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }

    }

    int[] getRow(int rowNumber) {
        return finalMatrix[rowNumber-1];
    }

    int[] getColumn(int columnNumber) {
        List<Integer> nums = new ArrayList<>();
        int index=0;
        for(int i=0; i<finalMatrix.length; i++, index++)
            {
                nums.add(finalMatrix[i][columnNumber-1]);
            }
        int[] columnToReturn = nums.stream()
                                  .mapToInt(Integer::intValue)
                                  .toArray();;
        return columnToReturn;
    }
}
