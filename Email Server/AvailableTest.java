public class AvailableTest  {
    public static void main(String[] args)  {
	AvailableList list = new AvailableList();
	list.addRecord(5);
	list.addRecord(7);
	list.addRecord(10);
	list.addRecord(0);
	System.out.println(list);
    }
}
