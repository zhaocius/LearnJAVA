package cc150;

public class A2_2 {

	private Node first;
	private int N=0;
	private int pos;
	private class Node{
		int item;
		Node next;
	}
	public boolean isEmpty(){
		return N==0;
	}
    public int size(){
    	return N;
    }
    public void push(int a){
    	Node oldfirst=first;
    	first=new Node();
    	first.item=a;
    	first.next=oldfirst;
        N++;	
    }
    public int pop(){
    	int temp=first.item;
    	first=first.next;
    	N--;
    	return temp;
    }
    
    public void addByPos(int index,int value){
    	Node node=new Node();
    	node.item=value;
    	Node previous=first;
    	Node current=first;
    	while(pos!=index){
    		previous=current;
    		current=current.next;
    		pos++;		
    	}
    	node.next=current;
    	previous.next=node;
    	pos=0;
    	N++;   	
    }
    
    public void add(int value){
    	if(N==0){
    		push(value);
    		return;
    	}
    	Node node=new Node();
    	node.item=value;
    	Node previous=first;
        for(int i=0;i<N-1;i++){
        	previous=previous.next;
        	
        }    	
        previous.next=node;
        N++;
    }
    
    
    
    
    public Node deleteByPos(int index){
    	Node current=first;
    	Node previous=first;
    	while(pos!=index){
    		pos++;
    		previous=current;
    		current=current.next;
    		
    	}
    	if(current==first){
    		first=first.next;
    		N--;
    		
    	}else{
    		pos=0;
    		previous.next=current.next;
    		N--;
    		
    	}
    	return current;
  	
    }
    
    public Node findByPos(int index){
    	if(index>N) return null;
    	Node current=first;
    	while(pos!=index){
    		current=current.next;
    		pos++;
    		
    	}
    	pos=0;
    	return current;
    	
    }
    
    public Node findByItem(int item){
    	Node current=first;
    	while(current.item!=item){
    		if(current.next==null)
    			return null;
    		current=current.next;
    		
    	}
    	return current;
    	
    }
    
    public void display(){
    	Node current=first;
    	while(current!=null){
    		System.out.println(current.item);
    		current=current.next;
    		
    	}
    	
    	
    }
    public  Node call(int a){
    	Node n1=first;
    	Node n2=first;
    	while(pos<a-1){
    		n1=n1.next;
    		pos++;
    	}
    	while(n1.next!=null){
    		n1=n1.next;
    		n2=n2.next;
    	}
    	pos=0;
    	return n2;
    	
    	
    }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       A2_2 a=new A2_2();
       a.add(1);
       a.add(2);
       a.add(3);
       a.add(4);
       a.add(5);
       a.add(6);
       a.add(7);
       a.add(8);
       a.add(9);
       a.add(10);
       a.add(11);
       
       System.out.println(a.call(2).item);
      
	}
}
