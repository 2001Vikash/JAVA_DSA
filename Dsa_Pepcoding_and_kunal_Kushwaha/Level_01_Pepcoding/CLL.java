package Level_01_Pepcoding;

public class CLL {
    private Node head;
    private Node tail;
    // if we want to make our own constructor. then but we that this is optional.
    public CLL(){
        this.head = null;
        this.tail = null;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        if(head==null){
            head=tail=node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public int delete(int val){
        if(head==null){
            return 0;
        }
        Node temp = find(val);
        if(temp.next==tail){
            tail=temp;
        }else if(temp.next==head){
                 head = temp.next.next;
        }
        temp.next = temp.next.next;
        return val;
    }
    public Node find(int val){
            Node temp = head;
        while(temp!=null){
            if(temp.next.val == val){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void display(){
        Node temp = head;
        if(head!=null){
            do{
                System.out.print(temp.val+" -> ");
                temp = temp.next;
            }while(temp!=head);


            System.out.println("AGAIN FROM START");
        }
    }
    private class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
