# Home Library Backend

Home Library is a simple Spring Boot backend for managing a personal book library, with support for a PostgreSQL database.

The project is ready to run via Docker, allowing anyone to quickly start the service on their local machine or server.

---

## Running Locally via Docker

### Clone the repository
```
git clone https://github.com/Diancent/home-library.git
cd home-library
```

### Start all services (PostgreSQL + backend)
```
docker compose up --build
```

### Check running containers
```
docker ps
```

### View logs
```
docker compose logs -f
```

### Stop and remove containers
```
docker compose down
```

### Optional: Run the backend manually
```
docker build -t home-library-app .
docker run -p 8080:8080 --name home-library-app --link home-library-db:db home-library-app
```


PostgreSQL is available at localhost:5432

The backend is available at http://localhost:8080

## API Examples

Get the list of books: GET /books

Get a book by ID: GET /books/{id}

Add a new book: POST /books

Update a book by ID: PUT /books/{id}

Delete a book by ID: Delete a book by ID

Request body (JSON):
```
{
  "title": "Book Title",
  "author": "Author Name",
  "description": "Optional description",
  "genre": "FANTASY",
  "language": "ENGLISH",
  "pageCount": 300,
  "publicationYear": 2023,
  "status": "AVAILABLE",
  "isbn": "1234567890"
}
```

Author: Artem Korolchuk
