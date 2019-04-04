
public class Main {

    public static void main(String[] args){

        //read args
        if(isValidLengthOfArgs(args)) {
            switch (args[0]) {
                case "-e":
                    String keysPath = args[2];
                    String messagePath = args[4];
                    String cypherPath = args[6];

                    Reader reader = new Reader();
                    byte[][][] keys = reader.readToByteArray(keysPath); // K1, K2, K3
                    byte[][][] messageAsInput = reader.readToByteArray(messagePath);

                    AES aes = new AES();
                    byte[][][] cypherAsOutput =aes.encrypt(messageAsInput, keys);

                    Writer writer = new Writer();
                    writer.writeBytes(cypherAsOutput, cypherPath);

                    break;
                case "-d":
                    keysPath = args[2];
                    cypherPath = args[4];
                    messagePath = args[6];

                    reader = new Reader();
                    keys = reader.readToByteArray(keysPath); // K1, K2, K3
                    byte[][][] cypherAsInput = reader.readToByteArray(cypherPath);

                    aes = new AES();
                    byte[][][] messageAsOutput = aes.decrypt(cypherAsInput, keys);

                    writer = new Writer();
                    writer.writeBytes(messageAsOutput, messagePath);
                    break;
                case "-b":
                    messagePath = args[2];
                    cypherPath = args[4];
                    keysPath = args[6];

                    reader = new Reader();
                    messageAsInput = reader.readToByteArray(messagePath);
                    cypherAsInput = reader.readToByteArray(cypherPath);

                    AESBreak aesBreak = new AESBreak();
                    byte[][][] keysAsOutput = aesBreak.getKeys(messageAsInput, cypherAsInput);

                    writer = new Writer();
                    writer.writeBytes(keysAsOutput, keysPath);

                    break;
                default:
                    System.out.println("Please enter a valid -e for encryption -d for decryption or -b to break");
            }
        }

        else {
            System.out.println("Please enter a valid number of args");
        }
    }

    public static Boolean isValidLengthOfArgs(String[] args){
        return args.length == 7;
    }

}
