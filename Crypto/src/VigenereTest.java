import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VigenereTest {

    @Test
    public void vigenereEncryptTest1(){
        // Arrange
        Vigenere v = new Vigenere("Lemon");
        String input = "ATTACKATDAWN";
        String expected = "LXFOPVEFRNHR";

        // Act
        String actual = v.encrypt(input);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void vigenereEncryptTest2(){
        // Arrange
        Vigenere v = new Vigenere("L,./em o?n");
        String input = "ATTACKATDAWN";
        String expected = "LXFOPVEFRNHR";

        // Act
        String actual = v.encrypt(input);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void vigenereDecryptTest1(){
        // Arrange
        Vigenere v = new Vigenere("LEMON");
        String input = "LXFOPVEFRNHR";
        String expected = "ATTACKATDAWN";

        // Act
        String actual = v.decrypt(input);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void vigenereEncryptDecryptTest1(){
        // Arrange
        Vigenere v = new Vigenere("Swordfish");
        String expected = "Your mother was a hamster";

        // Act
        String actual = v.decrypt(v.encrypt(expected));

        // Assert
        Assert.assertEquals(expected, actual);
    }
}
