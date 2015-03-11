# webproj
A Restful way to concatenate strings

How to run:
-----------

At present, this application has two different parts, a client and a servlet.

The servlet must be served from localhost:8080/. By default (at least on Tomcat) it runs a the address *http://localhost:8080/com.smilius.webproj/string/concatenate*. 

Strings can be concatenated in two ways.

1) By webpage using the HTML in WebContent. Requests can be POSTed to the server from the form on this page.

2) By the client utility. This will take data from standard input, and send the strings using GET. The concatenated string will be output and the program will terminate.


Dependencies:
------------

This program requires The [Java Jersey Libraries](https://jersey.java.net/download.html). At the moment these must be downloaded and the jars placed in the library before compiling.
