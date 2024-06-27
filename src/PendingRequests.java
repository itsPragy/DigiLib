import Includes.*;

public class PendingRequests {
    private int length = 0;
    private Node<RequestData> front;
    private Node<RequestData> back;

    public boolean insert(Node<RequestData> insnode) {
        if(this.front == null) {
            this.front = insnode;
        }
        if(this.back != null){
            this.back.next = insnode;
        }
        insnode.previous = this.back;
        this.back = insnode;
        this.length ++;
        return false;
    }

    public boolean delete(Node<RequestData> delnode) {
        if (delnode == null){return false;}
        Node<RequestData> node = this.front;
        if(node == delnode){
            this.front = node.next;
            this.length --;
            if (node.next != null) {
                node.next.previous = null;
            }
            else{this.back = null;}
            return true;

        }
        node = node.next;
        while(node != null){
            if(node == delnode){
                this.length --;
                {node.previous.next = node.next;}
                if (node.next != null) {
                    node.next.previous = node.previous;
                }
                else{
                    this.back = node.previous;
                }
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Node<RequestData> find(int ISBN) {
        Node<RequestData> nrd = this.front;
        while (nrd != null){
            if (nrd.data.ISBN == ISBN){
                return nrd;
            }
            nrd = nrd.next;
        }
        return null;
    }


    public String toString(){
        Node<RequestData> temp = front;
        String s = "Length: " + length + "\n";
        while(temp != null){
            s += temp.data.toString();
            temp = temp.next;
        }
        return s;
    }
}
