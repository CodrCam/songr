# Songr App

## Overview

Songr is a simple web application that allows users to view album information and capitalize text. It is built using Spring Boot, Thymeleaf, and basic CSS for styling.

## Classes and Pages

1. `Album`: This class acts as a model for album data. It has properties like title, artist, songCount, length (in seconds), and imageUrl (a link to the album's art).

2. `HomeController`: This class acts as a controller for handling HTTP requests and returning appropriate views. It contains the following routes:
    - `/hello`: Displays a "Hello, World!" message.
    - `/capitalize/{text}`: Takes a text string as input and returns the capitalized version of the input text.
    - `/`: Displays the splash (home) page with a navigation bar.
    - `/albums`: Displays a list of hardcoded album instances.

The following pages are associated with each route:

1. `hello.html`: A simple page displaying a "Hello, World!" message.
2. `capitalize.html`: A page that displays the capitalized input text.
3. `index.html`: The splash page for the Songr app with a navigation bar and links to other pages.
4. `albums.html`: A page that displays a list of albums, with album art, title, artist, song count, and length.

## Problem Domain

The goal of the Songr app is to provide a simple web application that demonstrates basic Spring Boot functionality, such as routing and rendering views. It allows users to view a list of albums and capitalize text.

## Algorithm

1. Start the Spring Boot application.
2. Process HTTP requests based on the route.
3. Render the appropriate view based on the route.
4. Display the response to the user.

## Visual Aid

```md

| HTTP Request|---->| HomeController |---->| Thymeleaf View|

```

## Big O

The Songr app mainly deals with rendering views and doesn't involve complex algorithms. Therefore, it doesn't have a significant impact on time complexity. Most routes have constant time complexity, O(1), as they do not perform any computation or looping.

## Pseudo Code

```java
start_application()
    create_album_instances()
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
        display_albums_page()
```
