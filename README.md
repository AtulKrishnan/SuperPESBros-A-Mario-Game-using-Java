# SuperPESBros-A-Mario-Game-using-Java

#### Contributors: Atul Krishnan, Atharv Anant Athavale, Atharva Anil Chanda

## Introduction
In this project, we have made a simple 2D Java game similar to the Super Mario game we all know. 
A single level is designed based on the campus of PES University EC Campus. 
The user will have to login to the game which is connected to mySQL in the backend.
Once the user is logged in, they can start the game, choose character and play. 
The player will have to avoid the obstacle walls, potholes in the ground and the villain bouncers and reach the finish line!

## Getting Started
1. Eclipse was used to develop this project. 
2. JavaSE-1.7, JavaSE-9 and jdk-17.0.1 are the JRE System Libraries that have been added to the environment.
3. mySQL JDBC Connector is added as an external JAR file.
4. Set up a Database and Leaderboard table in mySQL using the following commands:

```
create database SUPERPESBROS ;
use SUPERPESBROS ;
create table Leaderboard(Name varchar(255) , PointsCollected int);

select * from Leaderboard ;
```
5. Create a table user and add the usernames and passwords of the users by using the following commands:

```
use SUPERPESBROS ;

create table USER(username varchar(255) , password varchar(255));
insert into USER values ( "ATHARV" , "Googly" ) ;
insert into USER values ( "ATHARVA" , "Captain" ) ;
insert into USER values ( "ATUL" , "Super" ) ;

select * from USER where username ="ATHARV" ;
```

6. All the media is available in the media folder.
7. Update the paths of all images and audio files to your respective paths in the files 'Frame.java', 'board.java', 'player.java', 'Wall.java', 'Bouncer.java', 'mouseInput.java' and 'audio.java'
8. Change the database username and password in the files 'Leaderboard.java' and 'database.java' to your respective ones.

## Design Patterns Used:
1. Singleton Pattern: In the player class, to allow only one object to be made for the class.
2. Factory Pattern: An obstacle interface is created, which is implemented by classes Wall and Bouncer. The objects are created using the class ObjectFactory
3. Observer Pattern: Not explicitly implemented, but can be seen as the database observes the username of the user who logs in and keeps track of it.

## Hope you guys have fun building and playing this game!
