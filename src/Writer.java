
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {

    public void writeBytes(byte[][][] content, String path) {
        byte[] readyToWrite = new byte[content.length * content[0].length * content[0][0].length];

        int byteNumber = 0;

        for(int blockNumber = 0 ; blockNumber < content.length ; blockNumber++){
            for(int column = 0 ; column < content[0][0].length  ; column++){
                for (int row = 0 ; row < content[0].length ; row++){
                    readyToWrite[byteNumber] = content[blockNumber][row][column];

                    byteNumber++;
                }
            }
        }
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(readyToWrite);
        } catch (IOException ioe) {
            System.out.println(path + " isn't valid path");
            ioe.printStackTrace();
        }
    }
}
