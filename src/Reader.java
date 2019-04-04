import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Reader {
    public byte[][][] readToByteArray(String keysPath) {
        try {
            byte[] fileContent = Files.readAllBytes(new File(keysPath).toPath());
            return breakToBlocks(fileContent);

        } catch (IOException e) {
            System.out.println(keysPath + " isn't a valid path");
            e.getStackTrace();
        }
        return null;
    }

    private byte[][][] breakToBlocks(byte[] fileContent) {
        int numOfBlocks = fileContent.length / 16;
        int byteNumber = 0;
        byte[][][] blocks = new byte[numOfBlocks][4][4];
        for(int blockNumber = 0 ; blockNumber < numOfBlocks ; blockNumber++){
            for(int column = 0 ; column < 4 ; column++){
                for (int row = 0 ; row < 4 ; row++){
                    blocks[blockNumber][row][column] = fileContent[byteNumber];
                    byteNumber++;
                }
            }
        }
        return blocks;
    }
}
