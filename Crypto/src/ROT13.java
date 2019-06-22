import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {

    private Integer[] encryptArray;
    private Integer[] decryptArray;

    ROT13(Character cs, Character cf) {
        cs = Character.toLowerCase(cs);
        cf = Character.toLowerCase(cf);

        this.encryptArray = new Integer[]{cf.hashCode() - cs.hashCode()};
        calculateDecryptArray();
    }

    ROT13() {
        this.encryptArray= new Integer[]{13};
        calculateDecryptArray();
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return encrypt(text);
    }

    public String encrypt(String text) {
        return shiftString(text, encryptArray);
    }

    public String decrypt(String text)
    {
        return shiftString(text, decryptArray);
    }

    public static String rotate(String s, Character c) {
        Integer index = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                index = i;
                break;
            }
        }

        String sub1 = s.substring(0,index);
        String sub2 = s.substring(index);
        return sub2 + sub1;
    }


    protected static Character shiftLetter(Character c, Integer offset, Integer toZero) {
        Integer val = (c - toZero + offset) % 26;
        return (char) (val + toZero);
    }

    protected  String shiftString(String s, Integer[] offsetArray) {
        StringBuilder sbuild = new StringBuilder();
        Integer offsetIndex = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sbuild.append(shiftLetter(c, offsetArray[offsetIndex], Character.hashCode('A')));
                offsetIndex = incrementOffset(offsetIndex);
            } else if (Character.isLowerCase(c)) {
                sbuild.append(shiftLetter(c, offsetArray[offsetIndex], Character.hashCode('a')));
                offsetIndex = incrementOffset(offsetIndex);
            } else {
                sbuild.append(c);
            }
        }
        return sbuild.toString();
    }

    protected void calculateEncryptArray(String password){
        password = password.toLowerCase();
        password = password.replaceAll("[^a-z]","");
        Integer[] encryptArray = new Integer[password.length()];
        for(int i = 0; i < password.length(); i++){
            encryptArray[i] = Character.hashCode(password.charAt(i)) - Character.hashCode('a');
        }
        this.encryptArray = encryptArray;
    }

    protected void calculateDecryptArray(){
        Integer[] decryptArray = new Integer[encryptArray.length];
        for(int i = 0; i < encryptArray.length; i++){
            decryptArray[i] = 26 - encryptArray[i];
        }
        this.decryptArray = decryptArray;
    }

    protected  Integer incrementOffset(Integer offset){
        return (offset == encryptArray.length-1 ? 0 : offset+1);
    }


//    public static void main(String[] args) {
//        Character c1 = 'a';
//        Character c2 = 'z';
//        Character c3 = 'A';
//        Character c4 = 'Z';
//
//
//        System.out.println("a hashcode = " + c1.hashCode());
//        System.out.println("z hashcode = " + c2.hashCode());
//        System.out.println("A hashcode = " + c3.hashCode());
//        System.out.println("Z hashcode = " + c4.hashCode());
//        System.out.println();
//        Integer i1 = 97;
//        System.out.println("97 as char = " + (char)i1.intValue());
//        System.out.println("122 as char = " + Character.toChars(122)[0]);
//        System.out.println("65 as char = " + (char)65);
//        System.out.println("90 as char = " + Character.toChars(90));
//        System.out.println();
//        System.out.println("a cast to int = " + (int)'a');
//    }

}
