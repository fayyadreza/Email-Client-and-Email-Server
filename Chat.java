import hsa.*;
public class Chat   { //allows for simultaneous sending/receiving 
    public static void main(String[] args)  {
    ReceiveThread receiveThread = new ReceiveThread();
    new Thread(receiveThread).start();
    
    String message = "";
    String ipAddress = "";
    int errorCode = -1;
    Console sender = new Console(NetIO.myIPAddress());
    do  {
	sender.print("Message: ");
	message = sender.readLine();
	sender.print("IP Address: ");
	ipAddress = sender.readLine();
	errorCode = NetIO.sendRequest(message, ipAddress);
    } while (true);
    }
}
