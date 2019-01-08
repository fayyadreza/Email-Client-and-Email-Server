public class SLList {
    private SNode head = null;
    private SNode tail = null;
    
    public SLList (){
	this.head = null;
	this.tail = null;
    }
    
    public SNode findNode (String key){
	SNode p = head;
	for (; p != null && !key.equals(p.getName()); p = p.getNext())
	    ;
	
	return p;
    }
    
    public void insertNode (SNode p){
	if (this.head == null){
	    this.head = p;
	    this.tail = p;
	}
	else{
	     SNode q = this.head;
	     SNode r = this.head;
	     
	     while (q != null && q.getName().compareTo(p.getName())<0){
		r = q;
		q = q.getNext();
	     }
	     
	     //if node is inserted at the front
	     if(q == this.head){
		this.head = p;
		p.setNext(q);
	     }
	     else if (q == null) {// checking if element is added at end
		this.tail = p;
		r.setNext(p);
	     }
	     else{ //inserting in the middle of the list
		r.setNext(p);
		p.setNext(q);
	     }
	}
    }
    
    public void deleteNode (SNode p){
	//assuming node p is in list
	if(this.head == this.tail){//if list is empty
	    this.head = null;
	    this.tail = null;
	}
	else if(p == this.head){// if node is at start of list
	    this.head = this.head.getNext();
	}
	else if(p == this.tail){ // if node is at end of list
	    SNode q = head;
	    while (q.getNext() !=p){
		q = q.getNext();
	    }
	    tail = q;
	    q.setNext(null);
	}
	else{ // if node is in the middle of list
	    SNode q = head;
	    while (q.getNext() !=p){
		q = q.getNext();
	    }
	    q.setNext(p.getNext());
	}
    }
      
    public SNode getHead (){
	return this.head;
    }
    
    public SNode getTail(){
	return this.tail;
    }
    
    public void setHead (SNode head){
	this.head = head;
    }
    
    public void setTail (SNode tail){
	this.tail = tail;
    }
    
    public String toString(){
	String message = "";
	for (SNode p = this.head; p != null; p=p.getNext()){
	    message += p.toString() + "\n";
	}
	return message;   
   }
}
