import hsa.*;
public class ReceiveThread implements Runnable {
    public ReceiveThread()  {
    }
    
    public void run()   {
	String message = "";
	Console receiver = new Console("Receiver Window. IP: " + NetIO.myIPAddress());
	
	receiver.println("System ready. Waiting...");
	do  {
	    message = NetIO.receiveRequest();
	    receiver.print(message);
	} while (true);
    }   
}

