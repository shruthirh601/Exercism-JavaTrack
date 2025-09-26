class RailFenceCipher {

    private final int rows;

    RailFenceCipher(int rows) {
        if (rows <= 0) {
            throw new IllegalArgumentException("Rows must be greater than zero.");
        }
        this.rows = rows;
    }

    String getEncryptedData(String message) {
        if (message == null || message.isEmpty()) {
            return "";
        }

        StringBuilder[] rails = new StringBuilder[rows];
        for (int i = 0; i < rows; i++) {
            rails[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean down = true;

        for (char c : message.toCharArray()) {
            rails[currentRow].append(c);

            if (currentRow == 0) {
                down = true;
            } else if (currentRow == rows - 1) {
                down = false;
            }

            currentRow += down ? 1 : -1;
        }

        StringBuilder encrypted = new StringBuilder();
        for (StringBuilder rail : rails) {
            encrypted.append(rail);
        }

        return encrypted.toString();
    }

    String getDecryptedData(String message) {
        if (message == null || message.isEmpty()) {
            return "";
        }

        int length = message.length();
        int[] railLengths = new int[rows];
        int currentRow = 0;
        boolean down = true;

        for (int i = 0; i < length; i++) {
            railLengths[currentRow]++;

            if (currentRow == 0) {
                down = true;
            } else if (currentRow == rows - 1) {
                down = false;
            }

            currentRow += down ? 1 : -1;
        }

        char[][] rails = new char[rows][];
        int messageIndex = 0;
        for (int i = 0; i < rows; i++) {
            rails[i] = new char[railLengths[i]];
            for (int j = 0; j < railLengths[i]; j++) {
                rails[i][j] = message.charAt(messageIndex++);
            }
        }

        StringBuilder decrypted = new StringBuilder();
        currentRow = 0;
        down = true;
        int[] railIndices = new int[rows];

        for (int i = 0; i < length; i++) {
            decrypted.append(rails[currentRow][railIndices[currentRow]++]);

            if (currentRow == 0) {
                down = true;
            } else if (currentRow == rows - 1) {
                down = false;
            }

            currentRow += down ? 1 : -1;
        }

        return decrypted.toString();
    }
}