# Shorter
#### Making internet links... shorter!

---

This is a personal project aiming to get to know Kotlin and Springboot environment better.

---

# Building
- ```git clone it```
- ```docker compose up --build```

---

# Web
- Access it through ```localhost:8080```
- Paste the unshortened link
- Copy the shorterned link

---

# API endpoints
To create a short link:
- POST ```http://localhost:8080/api```
- Request JSON Body Example: ```{"longUrl":"https://github.com/"}```
- Response JSON Body Example: ```{"shortUrl": "AI7ERT", "longUrl": "https://github.com/", "createdAt": "2024-11-11T22:52:52.9540185"}```

To retrieve a long link:
- GET ```http://localhost:8080/api```
- Request PARAMS Example: ```http://localhost:8080/api/AI7ERT```
- Response Example: ```https://github.com/```
