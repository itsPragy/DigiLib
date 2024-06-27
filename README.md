# Library Management System
## Project Overview
This project implements a digital portal for a library, focusing on book borrowing and returning operations using queues and linked lists. The system efficiently handles book requests, manages borrowed books, and tracks pending requests for books that are currently unavailable.
## Key Features

Book borrowing and returning
Request queue management
Pending requests tracking
Automatic processing of book requests
Response generation for book availability and waiting times

## Core Components

BookData: Stores book information (borrow status, ISBN, publisher, author, return date)
MyDate: Handles date representation
Node<T>: Generic node for linked data structures
RequestData: Manages book request information
Response: Generates response data for book requests
UserData: Stores user information
RequestQueue: Implements a queue for book requests
PendingRequests: Manages a linked list of pending book requests
LibraryStorage: Core class handling library operations

## Implemented Functionality
RequestQueue

getLength(): Returns the length of the queue
push(int ISBN, int UserID): Adds a new request to the back of the queue
pop(): Removes a request from the front of the queue

PendingRequests

insert(Node<RequestData> insnode): Adds a request to the end of the linked list
delete(Node<RequestData> delnode): Deletes a given request from the linked list
find(int ISBN): Returns the first node with the given ISBN

LibraryStorage

processQueue(): Processes the request at the front of the queue
processReturn(BookData book): Handles returned books and updates pending requests

## Usage
The DriverCode class contains a main method that sets up a LibraryStorage instance and performs basic testing of the system's functionality. You can modify this class to further test or demonstrate specific features of the library management system.
Project Structure
The project is organized into several classes, each responsible for a specific aspect of the library system. The main classes interact to create a cohesive system for managing book requests and loans.
