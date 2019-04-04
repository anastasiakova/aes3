public class RoundKey {
    public byte[][] addRoundKey(byte[][] block, byte[][] key) {
        byte[][] rounded = new  byte[block.length][block[0].length];
        for (int row = 0 ; row < block.length ; row++){
            for (int column = 0 ; column < block[0].length ; column++){
                rounded[row][column] = (byte)( (int)block[row][column]^(int)key[row][column]);
            }
        }
        return  rounded;
    }
}
