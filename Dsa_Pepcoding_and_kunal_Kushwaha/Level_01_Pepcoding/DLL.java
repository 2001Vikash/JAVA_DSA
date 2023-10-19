package Level_01_Pepcoding;

public class DLL {
    Node head;// we can put tail here also

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head!=null) {
            head.prev = node;
        }
        head = node;
    }
    // so we can make insertLast and DELETE operation as well as.
    public void insertLast(int val){
        Node node = new Node(val);
        node.next = null;
        if(head == null){
            node.prev=  null;
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;

    }

    public  void insert(int after, int val){
        Node p = find(after);
        if(p==null){
            System.out.println("Does not Exists");
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next!=null) {
            node.next.prev = node;
        }
    }
    public Node find(int val){
           Node temp = head;
        while(temp!=null){
            if(temp.val == val){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void display(){
        Node temp = head;
        Node lastNode = null;// we can use tail if present.
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            lastNode = temp;
            temp = temp.next;
        }
        System.out.println("END");
        // for reverse printing
        while(lastNode!=null){
            System.out.print(lastNode.val+" -> ");
            lastNode=lastNode.prev;
        }
        System.out.println("START");
    }

    private class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val = val;
        }
        public Node(int val,  Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
