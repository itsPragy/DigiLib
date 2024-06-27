import java.util.*;

import Includes.*;

public class LibraryStorage {
    // HashMap
    // process return
    HashMap<Integer, BookData> storage;
    private RequestQueue rqQueue;
    private PendingRequests prLinkedList;

    public LibraryStorage() {
        storage = new HashMap<Integer, BookData>();
        for (int i=100001; i<100011; i++) {
            BookData book = new BookData();
            MyDate dateor = new MyDate();
            dateor.month = 0;
            dateor.year = 0;
            book.BorrowedStatus = false;
            book.BorrowedByUserID = 0;
            book.ISBN = i;
            book.Publisher = "publisher";
            book.Author = "author";
            book.DateOfReturn = dateor;
            storage.put(i, book);
        }

        rqQueue = new RequestQueue();
        prLinkedList = new PendingRequests();
    }

    public void push(int ISBN, int UserID) {
        rqQueue.push(ISBN, UserID);
    }

    public boolean processQueue() {
        RequestData req = this.rqQueue.getFront();
        if (req == null){return true;}
        this.rqQueue.pop();
        BookData book = storage.get(req.ISBN);
        if ( book != null) {
            if (!book.BorrowedStatus) {
                    book.BorrowedByUserID = req.UserID;
                    book.BorrowedStatus = true;
                    return true;
            }
            else {
                Node<RequestData> node = new Node<RequestData>();
                node.data = req;
                return prLinkedList.insert(node);
            }
        }
        return false;
    }

    public boolean processReturn(BookData book) {          // I have assumed this takes BookData object as argument, can also work with ISBN perhaps
        if(book == null){return false;}
        if (book.BorrowedStatus){
            Node<RequestData> node = prLinkedList.find(book.ISBN);
            if(node == null){
                book.BorrowedStatus = false;
                return true;
            }
            book.BorrowedStatus = prLinkedList.delete(node);
            return true;
        }
        return false;
    }

    public String rqQueueToString(){
        return rqQueue.toString();
    }

    public String prLinkedListToString(){
        return prLinkedList.toString();
    }
}
