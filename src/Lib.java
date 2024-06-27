import Includes.*;

public class Lib{

    public static void main(String[] args) {
        testLibraryOperations();
    }

    public static void testLibraryOperations() {
        LibraryStorage library = new LibraryStorage();

        System.out.println("Initial State:");
        printLibraryStatus(library);

        // Test borrow book
        System.out.println("\nTest Case 1: Borrow a Book");
        library.push(100001, 1);
        processAndPrint(library);
        // Expected Output:
        // Request Queue:
        // Length: 0
        //
        // Pending Requests:
        // Length: 0
        // -----------------------------------------

        // Test borrow multiple books
        System.out.println("\nTest Case 2: Borrow Multiple Books");
        library.push(100002, 2);
        library.push(100003, 3);
        processAndPrint(library);
        // Expected Output:
        // Request Queue:
        // Length: 1
        // ISBN: 100003
        // UserID: 3
        //
        // Pending Requests:
        // Length: 0
        // -----------------------------------------

        // Test return book with pending requests
        System.out.println("\nTest Case 3: Return Book with Pending Requests");
        BookData returnedBook = library.storage.get(100002);
        library.processReturn(returnedBook);
        processAndPrint(library);
        // Expected Output:
        // Request Queue:
        // Length: 0
        //
        // Pending Requests:
        // Length: 0
        // -----------------------------------------

        // Test return book without pending requests
        System.out.println("\nTest Case 4: Return Book without Pending Requests");
        returnedBook = library.storage.get(100001);
        library.processReturn(returnedBook);
        processAndPrint(library);
        // Expected Output:
        // Request Queue:
        // Length: 0
        //
        // Pending Requests:
        // Length: 0
        // -----------------------------------------

        // Test handling pending requests
        System.out.println("\nTest Case 5: Handling Pending Requests");
        library.push(100004, 4);
        library.push(100005, 5);
        library.push(100004, 6);
        library.push(100005, 7);
        processAndPrint(library);
        processAndPrint(library);
        processAndPrint(library);
        processAndPrint(library);
        // Expected Output:
        // Request Queue:
        // Length: 1
        // ISBN: 100005
        // UserID: 5
        //
        // Pending Requests:
        // Length: 1
        // ISBN: 100004
        // UserID: 4
        // -----------------------------------------
        // Request Queue:
        // Length: 0
        //
        // Pending Requests:
        // Length: 2
        // ISBN: 100004
        // UserID: 4
        // ISBN: 100005
        // UserID: 5
        // -----------------------------------------

        // Test processing queue with no requests
        System.out.println("\nTest Case 6: Process Queue with No Requests");
        processAndPrint(library);
        // Expected Output:
        // Request Queue:
        // Length: 0
        //
        // Pending Requests:
        // Length: 2
        // ISBN: 100004
        // UserID: 4
        // ISBN: 100005
        // UserID: 5
        // -----------------------------------------
    }

    public static void processAndPrint(LibraryStorage library) {
        library.processQueue();
        printLibraryStatus(library);
    }

    public static void printLibraryStatus(LibraryStorage library) {
        System.out.println("Request Queue:\n" + library.rqQueueToString());
        System.out.println("Pending Requests:\n" + library.prLinkedListToString());
        System.out.println("-----------------------------------------");
    }
}
