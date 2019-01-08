public class FayyadReza {
    public static void main(String[] args)  {
	// 3 records
	// record 0 is deleted
	// record 1 and 2 is one connected message
	// then message is added
	
	Globals.availableList = new AvailableList();
	Message message = new Message();
	int err = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	if (err == Globals.PROCESS_OK)   {
	    message.setText("First message, will only be held in one record.");
	    message.writeToMessagesFile();
	    
	    message.setText("Second message, will exceed one record (needs two records to be stored in). Here's some extra filler words :)"); 
	    message.writeToMessagesFile(); //second message added - takes up two records
	    
	    message.deleteFromMessagesFile(0); //first record has been added and deleted from file (position 0 is deleted message)
			
	    message.setText("This record has to be exactly 90 bytes long. So lets type some more to get 90 bytes. Done!");
	    message.writeToMessagesFile(); //final record added that is 90 bytes long
	    
	    System.out.println(Globals.availableList);
	    FileIO.closeMessagesFile();
	}
    }
}
