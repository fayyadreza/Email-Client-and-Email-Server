public class TestJan31  {
    public static void main(String[] args)  {
	Record record = new Record();
	Message message = new Message();
	Globals.availableList = new AvailableList();
	
	int open = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	if (open == Globals.PROCESS_OK) {
	    record.deleteFromMessagesFile(1);
	    record.deleteFromMessagesFile(5);
	    record.deleteFromMessagesFile(8);
	}
	
    }
}
