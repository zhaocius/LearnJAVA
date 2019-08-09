package cc150;

public class A2_4 {

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
    public static void  call(A2_4 a, A2_4 b,A2_4 c){
    	int jinwei1=0;
    	int jinwei2=0;
    	int digit1=(a.first.item+b.first.item);
    	if(digit1>9) jinwei1=1; 
    	int digit2=(a.first.next.item+b.first.next.item+jinwei1);
    	if(digit2>9) jinwei2=1;
    	int digit3=(a.first.next.next.item+b.first.next.next.item+jinwei2);
    	c.add(digit1%10);
    	c.add(digit2%10);
    	c.add(digit3%10);
    	if(digit3>9)
    		c.add(1);
    	c.display();
    		
   
    }
 
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       A2_4 a=new A2_4();
       a.add(9);
       a.add(9);
       a.add(9);
       
       A2_4 b=new A2_4();
       b.add(9);
       b.add(9);
       b.add(9);
       
       A2_4 c=new A2_4();
       
       call(a,b,c);
      
      
	}
}
