public class Utils  {
    public static String leftPad(String ID, int desiredLength, char paddingItem)    {
	int difference = desiredLength - ID.length();
	for (int i = 0; i < difference; i++)    {
		ID = paddingItem + ID;
	}    
    return ID;
    }
    
    public static boolean isANumber(String s)  {
	boolean itIsANumber = true;
	for (int i = 0; i < s.length() && itIsANumber; i++)    {
	    itIsANumber = s.charAt(i) >= '0' && s.charAt(i) <= '9';
	} 
	return itIsANumber;
    }
    
    public static String intToBytesStr(int num) {
	return Globals.STR_NULL + (char) ((num >> 24)) + 
				  (char) ((num & 0xFF0000) >> 16) + 
				  (char) ((num & 0xFF00) >> 8) + 
				  (char) ((num & 0xFF));
    }
    
}
