public class TestingTree    {
    public static void main(String[] args)  {
	Tree t = new Tree();
	
	t.insertNode(new TNode("00", 1, null, null, null));
	t.insertNode(new TNode("01", 2, null, null, null));
	t.insertNode(new TNode("02", 3, null, null, null));
	t.insertNode(new TNode("03", 4, null, null, null));
	t.insertNode(new TNode("04", 5, null, null, null));
	//t.insertNode(new TNode("06", 6, null, null, null));
	//t.insertNode(new TNode("07", 7, null, null, null));
	
	
	t.printTree(0);
    }
 }
    
