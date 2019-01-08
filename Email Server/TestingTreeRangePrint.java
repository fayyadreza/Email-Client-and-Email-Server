public class TestingTreeRangePrint  {
    public static void main(String[] args)  {
	String id = "";
	Tree tree = new Tree();
	TNode p = null;
	TNode q = null;
	
	for (int i = 0; i < 99; i++)    {
	    p = new TNode(Utils.leftPad("" + i, 4, '0'), 0, null, null, null);
	    tree.insertNode(p);
	}
	
	for (int i = 1000; i < 1060; i++)   {
	    p = new TNode(Utils.leftPad("" + i, 4, '0'), 0, null, null, null);
	    tree.insertNode(p);
	}
	
	for (int i = 3000; i < 3600; i++)   {
	    p = new TNode(Utils.leftPad("" + i, 4, '0'), 0, null, null, null);
	    tree.insertNode(p);
	}
	
	p = tree.findNode("105", 0);
	q = tree.findNode("105", 1);
	
	tree.printTree(p,q);
    
    
    }
}
