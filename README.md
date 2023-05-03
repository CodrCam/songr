# Songr App

## Overview

Songr is a web application that allows users to view album information, add new albums, and capitalize text. It is built using Spring Boot, Thymeleaf, JPA, and basic CSS for styling.

## Classes and Pages

1. `Album`: This class acts as a model for album data, representing an album entity. It has properties like id, title, artist, song_count, length_in_seconds, and image_url.

2. `AlbumRepository`: This interface extends `CrudRepository` and allows the application to perform CRUD operations on the Album model.

3. `HomeController`: This class acts as a controller for handling HTTP requests and returning appropriate views. It contains the following routes:
   - `/hello`: Displays a "Hello, World!" message.
   - `/capitalize/{text}`: Takes a text string as input and returns the capitalized version of the input text.
   - `/`: Displays the splash (home) page with a navigation bar.
   - `/albums`: Displays a list of album instances and a form to add new albums.

The following pages are associated with each route:

1. `hello.html`: A simple page displaying a "Hello, World!" message.
2. `capitalize.html`: A page that displays the capitalized input text.
3. `index.html`: The splash page for the Songr app with a navigation bar and links to other pages.
4. `albums.html`: A page that displays a list of albums, with album art, title, artist, song count, and length. It also includes a form to add new albums to the database.

## Problem Domain

The goal of the Songr app is to provide a web application that demonstrates Spring Boot functionality, such as routing, rendering views, and using JPA to interact with a database. It allows users to view a list of albums, add new albums, and capitalize text.

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
                    | AlbumRepository |

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
        display_splash_page()
    elif request == "/albums":
        if request.method == "GET":
            fetch_albums_from_database()
            display_albums_page()
        elif request.method == "POST":
            create_new_album()
            save_album_to_database()
            redirect_to_albums_page()
```

## Time Spent on lab

.5 hours prep and reading

4.5 hours on the build

5 hours total