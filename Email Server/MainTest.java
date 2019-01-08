import java.io.*; 
//change name to emailserver
public class MainTest   {
    public static void main(String[] args)  {
	int error = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	
	if (error == Globals.PROCESS_OK)    {
	    try {
		Globals.msg.writeBytes("012345678901233460123456789012334601234567890123346012345678901233460123456789011111");
		Globals.msg.writeBytes("012345678901233460123456789012334601234567890123346012345678901233460123456789011111");
		Globals.msg.writeBytes("012345678901233460123456789012334601234567890123346012345678901233460123456789011111");
		Globals.msg.writeBytes("012345678901233460123456789012334601234567890123346012345678901233460123456789011111");
		Globals.msg.writeBytes("012345678901233460123456789012334601234567890123346012345678901233460123456789011111");
	    }
	    catch (IOException err)   {
		System.out.println("Error writing");
	    }
	    
	
	    FileIO.closeMessagesFile(); 
	}
	else    {
	    System.out.println("Error");
	}        
    }
}
