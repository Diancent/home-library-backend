# Home Library Backend

Home Library — це простий Spring Boot бекенд для керування домашньою бібліотекою книг, з підтримкою PostgreSQL бази даних.  

Проєкт готовий для запуску через Docker, щоб будь-хто міг легко підняти сервіс на своєму комп’ютері або сервері.

---

## Запуск локально через Docker

### Клонування репозиторію
```
git clone https://github.com/Diancent/home-library.git
cd home-library
```

### Запуск всіх сервісів (PostgreSQL + бекенд)
```
docker compose up --build
```

### Перевірка запущених контейнерів
```
docker ps
```

### Перегляд логів
```
docker compose logs -f
```

### Зупинка і видалення контейнерів
```
docker compose down
```

### Якщо потрібно, можна запустити бекенд вручну
```
docker build -t home-library-app .
docker run -p 8080:8080 --name home-library-app --link home-library-db:db home-library-app
```


PostgreSQL доступний на localhost:5432

Бекенд доступний на http://localhost:8080

## Приклади API

Отримати список книг: GET /books

Додати нову книгу: POST /books

Автор: Artem Korolchuk
