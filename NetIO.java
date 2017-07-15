import java.io.*;  // input output package 
import java.net.*; // networking package

public class NetIO  {
    public static String myIPAddress()  {//finds IP address
	String ipAddress = "";
	try { 
	    InetAddress myIP = InetAddress.getLocalHost();
	    ipAddress = myIP.getHostAddress();
	}
	catch(Exception e)  {
	    System.out.println("Error getting IP Address");
	}
	return ipAddress;
    }
    
    public static String myUserName()   { //finds username (TDSB Number)
	return System.getProperty("user.name");
    }
    
    public static int sendRequest(String message, String destinationIPAddress)  { //not exam material
	int errorCode = Globals.NET_SEND_ERROR;
	
	try {
	    //create socket and timeout (certain time where if message does not send, give up)
	    Socket me = new Socket();
	    me.connect(new InetSocketAddress(destinationIPAddress, Globals.PORT_NUMBER), Globals.TIME_OUT);
	    
	    // get output stream and send request
	    DataOutputStream output = new DataOutputStream(me.getOutputStream()); //stream formed with other computer, output is sent through stream
	    output.writeUTF(message);
	    
	    //wait for confirmation from receiving computer
	    DataInputStream input = new DataInputStream(me.getInputStream());
	    String request = input.readUTF();
	    
	    if (Utils.isANumber(request)) 
		errorCode = Integer.parseInt(request);
		
	    me.close();
	}
	catch(IOException e)    {
	    System.out.println("Unable to send message");
	}
	return errorCode;
    } 
    
    public static String receiveRequest()   {
	String request = "";
	int errorCode = Globals.NET_RECEIVE_ERROR;
	
	try {
	    // create server socket
	    ServerSocket server = new ServerSocket(Globals.PORT_NUMBER, 100);
	    
	    // create socket/timeout
	    Socket myComputer = server.accept();
	    myComputer.setSoTimeout(Globals.TIME_OUT);
	    
	    // data input stream
	    DataInputStream input = new DataInputStream(myComputer.getInputStream());
	    request = input.readUTF();
	    
	    // get output stream and send confirmation
	    DataOutputStream output = new DataOutputStream(myComputer.getOutputStream());
	    output.writeUTF("" + Globals.NET_OK);
	    
	    myComputer.close();
	    server.close();
	    errorCode = Globals.NET_OK;
	    
	}
	catch(IOException e) {
	    System.out.println("Unable to receive message");
	} 
	
	return request;
       
    }
}
