public class Strings {
    public static int countDigits(String string){
        int result;
        for (int i = 0; i < string.length(); i++)
            if(Character.isDigit(string.charAt(i))) result ++;
        return result;
    }
}
