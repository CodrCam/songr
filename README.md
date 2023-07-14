# Songr App

## Overview

Songr is a web application that allows users to view and add new albums, capitalize text, and now includes a user management system. It is built using Spring Boot, Thymeleaf, JPA, and basic CSS for styling.

## Classes and Pages

1. `Album` and `Song`: These classes act as models for album and song data, representing album and song entities respectively.

2. `AppUser`: This class acts as a model for user data, representing user entity. It includes functionalities for creating new users and validating user login credentials.

3. `AlbumRepository`, `SongRepository`, `AppUserRepository`: These interfaces extend `JpaRepository` and allow the application to perform CRUD operations on the respective models.

4. `HomeController`: This class acts as a controller for handling HTTP requests and returning appropriate views. It includes routes for user registration, login, logout, album viewing and adding, song viewing and adding, text capitalizing and the home page.

The following pages are associated with each route:

1. `index.html`: The home page displaying user information if logged in.
2. `hello.html`: A simple page displaying a "Hello, World!" message.
3. `capitalize.html`: A page that displays the capitalized input text.
4. `albums.html`: A page that displays a list of albums, with album art, title, artist, song count, and length. It also includes a form to add new albums to the database.
5. `login.html`: The login page for existing users.
6. `signup.html`: The registration page for new users.

## Updates

With the addition of user management system, users can now register and login to the application. Once logged in, users can view and add albums and songs.

## Problem Domain

The goal of the Songr app is to provide a web application that demonstrates Spring Boot functionality, including routing, rendering views, using JPA to interact with a database, and managing user authentication.

## Algorithm

1. Start the Spring Boot application.
2. Process HTTP requests based on the route.
3. Perform the necessary operations and interact with the database as needed.
4. Render the appropriate view based on the route.
5. Display the response to the user.

## Visual Aid

```md
| HTTP Request|---->| HomeController |---->| Thymeleaf View|
                               |
                               V
                    | AlbumRepository |----> | AppUserRepository | ----> | SongRepository |

```

## Big O

The Songr app mainly deals with rendering views and interacting with the database. Most routes have constant time complexity, O(1), as they do not perform any computation or looping. However, routes that interact with the database may have a higher time complexity depending on the size of the data.

## Pseudo Code

```java
start_application()
    configure_database()
    route_to_controller_based_on_request()

route_to_controller(request)
    if request == "/hello":
        display_hello_page()
    elif request == "/capitalize/{text}":
        capitalize_text(text)
        display_capitalized_text_page()
    elif request == "/":
        display_home_page()
    elif request == "/albums":
        if request.method == "GET":
            fetch_albums_from_database()
            display_albums_page()
        elif request.method == "POST":
            create_new_album()
            save_album_to_database()
            redirect_to_albums_page()
    elif request == "/login":
        if request.method == "GET":
            display_login_page()
        elif request.method == "POST":
            validate_login_credentials()
            redirect_to_home_page_or_display_error_message()
    elif request == "/signup":
        if request.method == "GET":
            display_signup_page()
        elif request.method == "POST":
            create_new_user()
            save_user_to_database()
            redirect_to_login_page_or_display_error_message()
    elif request == "/logout":
        invalidate_user_session()
        redirect_to_home_page()
```

## Time Spent on lab

.5 hours prep and reading

6.5 hours on the build (additional 2 hours for user management system)

7 hours total