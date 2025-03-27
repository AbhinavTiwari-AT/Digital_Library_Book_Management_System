# Digital_Library_Book_Management_System #

##  **Deployed Link**
  Access the live project here:  
 **[Digital Library System Deployment](YOUR_DEPLOYMENT_LINK_HERE)**


## Objective
Develop an application system to enable librarians to efficiently **add, update, search, and remove books** while maintaining their availability status.

---

## Tech Stack
- **Backend tech:** Java, Spring Boot, Spring Validation,Loombok 
- **Database:** In-memory Collection (eg. ArrayList)
- **Build Tool:** Maven
- **Ttesting:** Junit
- **UUID:** Used to generate unique Book ID  

---

## Features
### 1. Add a Book
- Accepts Book ID *(auto-generated UUID)*, Title, Author, Genre, and Availability Status as input.
- Stores book details in a collection.

 **Validations:**
- Title and Author cannot be empty.
- Genre cannot be empty.
- Book ID is unique.

### 2. View All Books
- Displays a list of all books with their details.

### 3. Search Book by ID or Title
- Allows searching for a book using **Book ID** or **Title**.

### 4. Update Book Details
- Modifies book details *(e.g., change availability status, update title or author)*.

### 5. Delete a Book Record
- Removes a book from the catalog.

### 6. Exit System
- Provides an option to **close the program** using an API call.

## Exception Handling
### 1. global exception handling
Our application includes a **global exception handling mechanism** to ensure proper error responses when an invalid request is made.

## 2. Custom Exception - `ResourceNotFoundException`
When a requested book is not found, a **custom exception** is thrown with a meaningful message.

---

## API Endpoints
| **Method** | **Endpoint**       | **Description** |
|------------|-------------------|----------------|
| **POST**   | `/books`          | Add a new book |
| **GET**    | `/books`          | Retrieve all books |
| **GET**    | `/books/{id}`     | Get a book by its ID |
| **GET**    | `/books/title/{title}` | Get a book by Title |
| **PUT**    | `/books/{id}`     | Update book details |
| **DELETE** | `/books/{id}`     | Delete a book |
| **POST**   | `/books/exit`     | Exit the system |

---

## Test Cases Implemented

| **Test Case**       | **Description** |
|---------------------|----------------|
| **Add Book**     | Ensures books can be added successfully. |
| **Get All Books** | Retrieves the list of stored books. |
| **Get Book by ID** | Fetches book details using a unique ID. |
| **Get Book by Title** | Finds a book based on its title. |
| **Update Book** | Updates book details and ensures persistence. |
| **Delete Book** | Removes a book and verifies deletion. |

---

##  Challenges Faced

During the development of the **Digital Library Book Management System**, we encountered several challenges:

- **Implementing Exceptions**
-  Used **Global Exception Handling** with `@ControllerAdvice` to manage errors like:  
  -`ResourceNotFoundException` → Handles cases when a book is **not found**.
   

- **Handling unique Book ID generation using UUID**  
  Instead of user-provided Book IDs, we leveraged **Java UUID** to generate **unique identifiers** for each book.

- **Designing modular services for scalability**  
  Followed a **service-based architecture**, ensuring that **BookService** and **BookController** are decoupled for **better maintainability**.

---

## Future Improvements

To enhance the **scalability and usability**, the following improvements can be implemented:

- **Integrate MySQL**  
  Replace in-memory collection with **MySQL database** for **persistent storage**.

- **Add Swagger API Documentation**  
  Improve usability by **integrating Swagger UI**, making it easier to explore APIs.

- **Implement Authentication & Authorization (JWT)**  
  Secure APIs using **Spring Security** with **JWT authentication**.

---

**Project by Abhinav Tiwari** 
💡 **GitHub Repo:** [Digital Library Book Management System](https://github.com/AbhinavTiwari-AT/Digital_Library-Book_Management_System)
