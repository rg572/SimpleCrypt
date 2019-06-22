import org.junit.Assert;
import org.junit.Test;

public class FileHandlerTest {

    @Test
    public void fileToStringTest1(){
        // Arrange
        FileHandler fr = new FileHandler();
        String path = "sonnet18.txt";
        String expected = "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.\n";

        // Act
        String actual = fr.fileToString(path);

        // Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stringToFileTest1(){
        // Arrange
        FileHandler fh = new FileHandler();
        String path = "text.txt";
        String expected = "This has been a test of the emergency broadcast system.\n" +
                "In the event of a real emergency, expect to be trampled to death in the panicked stampede.\n";

        // Act
        Boolean result = fh.StringToFile(expected, path);
        String actual = fh.fileToString(path);

        // Assert
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(result);
    }
}
