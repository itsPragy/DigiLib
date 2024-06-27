import Includes.*;

public class RequestQueue {
    private Node<RequestData> front;
    private Node<RequestData> back;
    private int length = 0;

    public RequestData getFront() {
        if(this.front == null){return null;}
        return this.front.data;
    }

    public int getLength() { return this.length; }

    public void push(int ISBN, int UserID) {
         RequestData borrow = new RequestData();
         borrow.ISBN = ISBN;
         borrow.UserID = UserID;
         Node<RequestData> last = new Node<RequestData>();
         last.data = borrow;
         if (this.length == 0) {
             this.front = last;
         }
         else {
             this.back.next = last;
             last.previous = this.back;
         }
         this.back = last;
         this.length += 1;
    }

    public void pop() {
        if(this.front != null) {
            this.front = this.front.next;
            this.length -= 1;
        }
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
