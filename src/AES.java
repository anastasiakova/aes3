public class AES {
    private byte[][][] _keys;
    private RoundKey roundKey = new RoundKey();
    private Shift shift = new Shift();

    public byte[][][] encrypt(byte[][][] massege, byte[][][] keys) {
        this._keys = keys;
        byte[][][] encrypted = new byte[massege.length][massege[0].length][massege[0][0].length];
        for (int blocksNumber = 0 ; blocksNumber < massege.length ; blocksNumber++){
            encrypted[blocksNumber] = encryptBlock(massege[blocksNumber]);
        }
        return encrypted;
    }

    private byte[][] encryptBlock(byte[][] block) {
        System.out.println("newblock:");

        byte[][] encryptedBlock = block;
        for (int key = 0 ; key < _keys.length ; key++){
            encryptedBlock = roundKey.addRoundKey(shift.shift(encryptedBlock), _keys[key]);
        }
        return encryptedBlock;
    }


    public byte[][][] decrypt(byte[][][] cypher, byte[][][] keys) {
        this._keys = keys;
        byte[][][] decrypted = new byte[cypher.length][cypher[0].length][cypher[0][0].length];
        for (int blocksNumber = 0 ; blocksNumber < cypher.length ; blocksNumber++){
            decrypted[blocksNumber] = decryptBlock(cypher[blocksNumber]);
        }
        return decrypted;
    }

    private byte[][] decryptBlock(byte[][] block) {
        byte[][] decryptedBlock = block;
        for (int key = _keys.length - 1  ; key >= 0 ; key--){
            decryptedBlock = shift.shift(shift.shift(shift.shift(roundKey.addRoundKey(block,_keys[key]))));
        }
        return decryptedBlock;
    }


}
