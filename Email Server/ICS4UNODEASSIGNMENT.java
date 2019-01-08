public class ICS4UNODEASSIGNMENT {
    public static void main (String[] args) {
	Tree t = new Tree();
	String[] fifty = new String[50];
	TNode p;
	int count = 0;
	while(count < 10000){
	    p = new TNode(Utils.leftPad("" + (int)(Math.random()*10000), 5, '0'), 1, null, null, null);
	    if(count < 50){
		fifty[count] = p.getIdentification();
		System.out.println(fifty[count]);
	    }
	    if(t.findNode(p.getIdentification()) == null){
		t.insertNode(p);
		count++;
	    }
	}
	count = 0;
	while(count < 500){
	    boolean found = false;
	    p = new TNode(Utils.leftPad("" + (int)(Math.random()*10000), 5, '0'), 1, null, null, null);
	    if(t.findNode(p.getIdentification()) != null ){
		for(int i = 0; i < 50 && !found; i++){
		    if(p.getIdentification().equals(fifty[i])){
			found = true;
		    }
		}
		if(!found){
		    System.out.println("test");
		    p = t.findNode(p.getIdentification());
		    t.deleteNode(p);
		    count++;
		}
	    }
	}
	t.printTree();
    } 
}
