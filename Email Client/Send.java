import hsa.*;
public class Send   {
   public static void main(String[] args)    {
	String message = "";
	String ipAddress = "";
	int errorCode = -1;
	
	Console sender = new Console(NetIO.myIPAddress());
	do {
	    sender.print("Message: ");
	    message = sender.readLine();
	    sender.print("Destination IP Address: ");
	    ipAddress = sender.readLine();
	    
	    errorCode = NetIO.sendRequest(message, ipAddress);
	}   while (true);
   }
}    
