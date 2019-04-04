public class AESBreak {
    private static short[][] same = {{0,0,0},
                                    {1,1,0},
                                    {1,0,1},
                                    {0, 1, 1}};

    private static short[][] diff = {{1, 0, 0},
                                        {0, 1, 0},
                                        {0, 0, 1},
                                        {1, 1, 1}};
    private static int sameCount = 0;
    private static int diffCount = 0;
    public byte[][][] getKeys(byte[][][] message, byte[][][] cipher) {
        return null;
    }
}
