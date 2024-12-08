# Content Calendar

![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)

A REST API for the dynamic updating of content to a calendar.

## Install
Download remote repositories to your local machine.

There are 2 components to this project, and they are each stored within their own repositories:
1. Front-End: [my-vanilla-js-frontend](https://github.com/LennyAtomz138/my-vanilla-js-frontend.git)
2. Back-End: [content-calendar](https://github.com/LennyAtomz138/content-calendar/)

## Usage
### Back-End 
*In IntelliJ Community Edition*

Run the application with the IntelliJ IDEA play button.

Homepage runs on: http://localhost:8080/api/content

### H2 Database Console
*If enabled...*

Runs on: http://localhost:8080/h2-console

### Front-End
*In VS Code*

Within the Terminal of `my-vanilla-js-frontend`, to run locally:
* `npm install`
* `npm run dev`

Homepage runs on: http://localhost:5173/

## Interesting Factoids

### H2 Database
#### Console Output when Application is Launched
* Starts a *Hikari Pool*, which is a pool of database connections.
* Log message translation: `H2 console available at '/h2-console'` indicates to use `http://localhost:8080/h2-console`.
* Log message translation: `Database available at 'jdbc:h2:mem:<some>-<hash>-<string>-<right>-<here>'`
  * `jdbc`
    * Java Database Connectivity, which is an API that allows Java applications to connect to and interact with databases.
  * `h2` is an open-source, Java-based, embedded database. 
    * It's very fast and very lightweight. 
    * Typically, it's used as an in-memory database. 
      * Go to [Should I store data "In Memory" or "On Disk"?](https://www.youtube.com/watch?v=3mmMxgBQ0Yc) to watch a great overview of *in-memory* versus *on disk*.
    * Although if we need to persist the data, at the flick of a switch - you can persist data as well.
  * `mem` indicates that this is *in-memory*, which means it stores the data in memory and will not persist data on disk.
    * Go to [Integrating H2 Database with Spring Boot](https://stackabuse.com/integrating-h2-database-with-spring-boot/) for more information on integrating an H2 database with Spring Boot.
  * `<some>-<hash>-<string>-<right>-<here>` represents your UUID