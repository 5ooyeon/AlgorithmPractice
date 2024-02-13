package swea;

import java.util.Scanner;

class Node {
    int num;
    Node prev;
    Node next;

    Node() {

    }

    Node(int num) {
        this.num = num;
    }
}

class DoublyLinkedList {
    Node head = new Node();
    Node tail = new Node();

    DoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public void add(int num) {
        Node startNode = tail.prev;
        Node newNode = new Node(num);
        
        startNode.next = newNode;
        newNode.prev = startNode;

        newNode.next = tail;
        tail.prev = newNode;
    }

    public void getList() {
        Node n = head;
        for(int i=0;i<10;i++) {
            System.out.print(n.next.num+" ");
            n = n.next;
        }
        System.out.println();
    }

	public void I(int idx, int num) {
		Node startNode = head;
		Node endNode = head;
		for(int i=0;i<idx;i++) {
			startNode = startNode.next;
			endNode = endNode.next;
		}
		endNode = endNode.next;
		
		Node nd = new Node(num);
		startNode.next = nd;
		nd.prev = startNode;
		
		endNode.prev = nd;
		nd.next = endNode;
		
		
	}

	public void D(int idx, int cnt) {
		Node startNode = head;
		Node endNode = head;
		for(int i=0;i<idx;i++) {
			startNode = startNode.next;
			endNode = endNode.next;
		}
		
		for(int i=0;i<=cnt;i++) {
			endNode = endNode.next;
		}
		
		startNode.next = endNode;
		endNode.prev = startNode;
		
	}
}
public class 암호문3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int tc = 1; tc <= 10; tc++) {
            DoublyLinkedList dll = new DoublyLinkedList();
            int N = sc.nextInt();

            for(int i=0;i<N;i++) {
                dll.add(sc.nextInt());
            }
            
            int func = sc.nextInt();
            
            for(int ttc=0;ttc<func;ttc++) {
            	String getInput = sc.next();
            	if(getInput.equals("I")) {
            		int idx = sc.nextInt();
            		int cnt = sc.nextInt();
            		for(int i=0;i<cnt;i++) {
            			dll.I(idx++, sc.nextInt());
            		}
            	} else if(getInput.equals("A")) {
            		int cnt = sc.nextInt();
            		for(int i=0;i<cnt;i++) {
            			dll.add(sc.nextInt());
            		}
            	} else if(getInput.equals("D")) {
            		int idx = sc.nextInt();
            		int cnt = sc.nextInt();
            		dll.D(idx, cnt);
            	}
            }
            
            System.out.print("#"+tc+" ");
            dll.getList();
        }

    }
}
