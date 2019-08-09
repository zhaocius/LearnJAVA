package learnjava;

public class LinkedListTest {

	class Node {
		int num;
		Node next;

		public Node(int num) {
			this.num = num;
		}
	}

	public Node first;
	public int N;
	public int pos;

	public void insertFirst(int num) {
		Node oldfirst = first;
		first = new Node(num);
		first.next = oldfirst;
		N++;
	}

	public int removeFirst() {
		int num = first.num;
		first = first.next;
		N--;
		return num;
	}

	public void insert(int index, int num) {
		if (index > N)
			return;
		if (index == 0)
			this.insertFirst(num);
		else {
			Node current = first;
			Node early = first;
			while (pos <= index - 1) {
				current = current.next;
				early = early.next;
				pos++;
			}
			current = current.next;
			Node node = new Node(num);
			early.next = node;
			node.next = current;
			N++;
			pos=0;
		}

	}
	
	public void insert(int num){
		if(first==null)
			this.insertFirst(num);
		else{
			Node current=first;
			while(pos<N-1){
				current=current.next;
			    pos++;
			}
			pos=0;
			Node node =new Node(num);
			current.next=node;
			N++;
		}
			
	}
	
	public int remove(int index){
		if(index>N)
			return 0;
		else{
			Node current=first;
			Node early=first;
			while(pos<=index-1){
				current=current.next;
				early=early.next;
				pos++;
			}
			pos=0;
			current=current.next;
			int num=current.num;
			early.next=current.next;
			N--;
			return num;
		
		}
		
	}
	
	public void display(){
		Node current=first;
		while(current.next!=null){
			System.out.println(current.num);
			current=current.next;
		}
		System.out.println(current.num);
	}
	public static void main(String[] args){
		LinkedListTest test=new LinkedListTest();
		test.insert(1);
		test.insert(2);
		test.insert(3);
		test.insert(4);
		test.insert(5);
		test.insert(6);
		test.insert(7);
		System.out.println(test.remove(5));
		test.display();
		
	}

}
