class SpiralMatrixBuilder {
    int[][] buildMatrixOfSize(int size) {
        int[][] result = new int[size][size];
        int count = 1;

        for (int layer = 0; layer < (size + 1) / 2; layer++) {
            for (int ptr = layer; ptr < size - layer; ptr++) {
                result[layer][ptr] = count++;
            }
            for (int ptr = layer + 1; ptr < size - layer; ptr++) {
                result[ptr][size - layer - 1] = count++;
            }
            for (int ptr = layer + 1; ptr < size - layer; ptr++) {
                result[size - layer - 1][size - ptr - 1] = count++;
            }
            for (int ptr = layer + 1; ptr < size - layer - 1; ptr++) {
                result[size - ptr - 1][layer] = count++;
            }
        }

        return result;
    }
}