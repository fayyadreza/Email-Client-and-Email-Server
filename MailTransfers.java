public class MailTransfers  {
    public static int EmailClientRequestAllMail (int whatId)    {
	int error = Globals.NET_RECEIVE_ERROR;
	
	String identification = NetIO.myUserName();
	identification = Utils.leftPad(identification, Globals.CLIENT_ID_LEN, '0');
	
	char command = whatId == Globals.RECEIVER_ID ? Globals.IN_BOX : Globals.OUT_BOX;
	
	do {
	    error = NetIO.sendRequest(Globals.STR_NULL + command + identification, Globals.SERVER_IP_ADDRESS);
	    
	    if (error == Globals.NET_OK)    {
		String boxMessages = NetIO.receiveRequest();
		int i = 0;
		while (!boxMessages.equals(Utils.intToBytesStr(Globals.END_OF_MESSAGES_TRANSMISSION))) {
		    Globals.boxMessages[i] = boxMessages.substring(0, boxMessages.indexOf(Utils.intToBytesStr(Globals.END_OF_MESSAGE)));
		    boxMessages = boxMessages.substring(boxMessages.indexOf(Utils.intToBytesStr(Globals.END_OF_MESSAGE)) + Globals.LENGTH_OF_INT);
		    i++;
		}
	    }
	    
	} while(error != Globals.NET_OK);

	
	
	return error; 
    }
    

    
    public static void main(String[] args)  {
	for (int i = 0; i < Globals.boxMessages.length; i++)    {
	    Globals.boxMessages[i] = Globals.EMPTY_CLIENT_MESSAGE;
	}
	
	EmailClientRequestAllMail(Globals.RECEIVER_ID);
	
	int i = 0;
	while (!Globals.boxMessages[i].equals(Globals.EMPTY_CLIENT_MESSAGE))    {
	    String s = Globals.boxMessages[i];
	    System.out.println(s.substring(0, 19) + s.substring(27));
	    i++;
	}
    }   
}
