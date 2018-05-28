
CREATE TABLE UserProfile( email VARCHAR(255), PRIMARY KEY(email) );

INSERT INTO UserProfile(email) VALUES("modi@gmail.com");
INSERT INTO UserProfile(email) VALUES("manmohan@gmail.com");
INSERT INTO UserProfile(email) VALUES("sonia@gmail.com");
INSERT INTO UserProfile(email) VALUES("shah@gmail.com");
INSERT INTO UserProfile(email) VALUES("rahul@gmail.com");
INSERT INTO UserProfile(email) VALUES("manohar@gmail.com");
INSERT INTO UserProfile(email) VALUES("diggi@gmail.com");
INSERT INTO UserProfile(email) VALUES("trumph@gmail.com");
INSERT INTO UserProfile(email) VALUES("kim@gmail.com");
INSERT INTO UserProfile(email) VALUES("nawaz@gmail.com");



CREATE TABLE Friend(id bigint(20) PRIMARY KEY, personOne VARCHAR(255), personTwo VARCHAR(255),FOREIGN KEY (personOne) REFERENCES UserProfile(email),FOREIGN KEY (personTwo) REFERENCES UserProfile(email));
				

INSERT INTO Friend(id, personOne, personTwo) VALUES(1,"modi@gmail.com","shah@gmail.com");
INSERT INTO Friend(id, personOne, personTwo) VALUES(2,"shah@gmail.com","manohar@gmail.com");
INSERT INTO Friend(id, personOne, personTwo) VALUES(3,"trumph@gmail.com","shah@gmail.com");
INSERT INTO Friend(id, personOne, personTwo) VALUES(4,"trumph@gmail.com","manmohan@gmail.com");
INSERT INTO Friend(id, personOne, personTwo) VALUES(5,"trumph@gmail.com","sonia@gmail.com");
INSERT INTO Friend(id, personOne, personTwo) VALUES(6,"kim@gmail.com","nawaz@gmail.com");
				
				
				

				
CREATE TABLE Subscription(id bigint(20) PRIMARY KEY,subscribee VARCHAR(255), subscriber VARCHAR(255),FOREIGN KEY (subscriber) REFERENCES  UserProfile(email),FOREIGN KEY (subscribee) REFERENCES UserProfile(email));
				
				
				INSERT INTO Subscription(id,subscriber,subscribee) VALUES(1,"trumph@gmail.com","modi@gmail.com");
				INSERT INTO Subscription(id,subscriber,subscribee) VALUES(2,"trumph@gmail.com","sonia@gmail.com");
				INSERT INTO Subscription(id,subscriber,subscribee) VALUES(3,"trumph@gmail.com","nawaz@gmail.com");
				
				


CREATE TABLE Block(id bigint(20),blocker VARCHAR(255), blockee VARCHAR(255),FOREIGN KEY (blocker) REFERENCES UserProfile(email),FOREIGN KEY (blockee) REFERENCES UserProfile(email));

				
				
				INSERT INTO Block(id,blocker,blockee) VALUES(1,"modi@gmail.com","sonia@gmail.com");
				INSERT INTO Block(id,blocker,blockee) VALUES(2,"shah@gmail.com","rahul@gmail.com");
