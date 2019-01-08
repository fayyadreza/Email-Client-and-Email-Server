public class Testing    {
    public static void main(String[] args)  {
	SLList list = new SLList();
	
	SNode p = new SNode ("John", 82.6, null);
	list.insertNode(p);

	p = new SNode("Paul", 97, null);
	list.insertNode(p);
	
	list.insertNode(new SNode("Fayyad", 42, null));
	list.insertNode(new SNode("Peggy", 42, null));
	list.insertNode(new SNode("Kohava", 42, null));
	list.insertNode(new SNode("Nafis", 42, null));
	list.insertNode(new SNode("Mario", 42, null));
	list.insertNode(new SNode("Peter", 42, null));
	
	System.out.println(list);
	
	list.deleteNode(list.findNode("Mario"));
	System.out.println("");
	System.out.println(list);
	//System.out.println(p != null ? p.toString() : "Not Found");
    }
}

