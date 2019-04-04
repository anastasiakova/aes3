public class Shift {
    public byte[][] shift(byte[][] block) {
        byte[][] shifted = new byte[block.length][block[0].length];

        shifted[0] = block[0];

        for (int row = 1 ; row < block.length ; row++){
            byte[] shiftInRow = new byte[row];
            for (int column = 0 ; column < block[row].length ; column++){
               if(column < row){
                   shiftInRow[column] = block[row][column];
               }
                else {
                   shifted[row][column - row] = block[row][column];
               }
            }
            for (int column = 0 ; column < row ; column++){
                shifted[row][block[row].length - row + column] = shiftInRow[column];
            }
        }

        return shifted;


    }
}
