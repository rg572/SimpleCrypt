public class Vigenere extends ROT13 {

    public Vigenere(String password){
        super.calculateEncryptArray(password);
        super.calculateDecryptArray();
    }
}
