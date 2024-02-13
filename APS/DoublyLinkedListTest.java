package APS;

class Node {
    String data;
    Node prev;
    Node next;

    Node() {

    }

    Node(String data) {
        this.data = data;
    }
}

class Queue {
    Node head = new Node();
    Node tail = new Node();

    Queue() {
        head.next = tail;
        tail.prev = head;
    }

    public void offer(String temp) {
        Node nN = new Node(temp);
        tail.prev.next = nN;
        nN.prev = tail.prev;

        nN.next = tail;
        tail.prev = nN;
    }

    public Node poll() {
        Node outputNode = head.next;

        head.next.next.prev = head;
        head.next = head.next.next;

        return outputNode;
    }
}

class Stack {
    Node head = new Node();
    Node tail = new Node();

    Stack() {
        head.next = tail;
        tail.prev = head;
    }

    public void push(String first) {
        Node nd = new Node(first);
        nd.next = head.next;
        head.next.prev = nd;

        nd.prev = head;
        head.next = nd;
    }

    public Node pop() {
        Node nd = head.next;

        head.next = head.next.next;
        head.next.next.prev = head;
        return nd;
    }
}
public class DoublyLinkedListTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        String first = "first";
        String second = "second";
        queue.offer(first); queue.offer(second);

        Node getOutPut = queue.poll();
        System.out.println(getOutPut.data);

        Stack stack = new Stack();
        stack.push(first); stack.push(second);
        System.out.println(stack.pop().data);
    }
}
