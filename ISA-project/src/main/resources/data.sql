

insert into address (state, city,street) values ('United States','Panama City','3151 West 10th Street');
insert into address (state, city,street) values ('United States','Key West',' 201 Margaret Street');
insert into address (state, city,street) values ('United States','Key West',' 5950 Peninsular Avenue');
insert into address (state, city,street) values ('United States','Key West','  North Roosevelt Boulevard');
insert into address (state, city,street) values ('United States','Destin',' 210 Harbor Boulevard');
insert into address (state, city,street) values ('United States','Destin',' 214 Harbor Boulevard');
insert into address (state, city,street) values ('United States','St. Petersburg',' 3600 Poplar Street Northeast');
insert into address (state, city,street) values ('United States','St. Petersburg',' 9600 Bay Pines Boulevard');
insert into address (state, city,street) values ('United States','Miami',' 3400 Pan American Dr,');
insert into address (state, city,street) values ('United States','Miami','Northwest 7th Street Road 945');
insert into address (state, city,street) values ('United States','San Diego',' 955 Harbor Island Drive');
insert into address (state, city,street) values ('United States','San Diego','Emerson Street 2803');


insert into authority(id, name) values (1, 'ROLE_SYS_ADMIN');

insert into authority(id, name) values (2, 'ROLE_ADMIN');

insert into authority(id, name) values (3, 'ROLE_INSTRUCTOR');

insert into authority(id, name) values (4, 'ROLE_CLIENT');




insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values ('Instructor','truman', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Truman', 'Willis', 'isa.booking.project+truman@gmail.com', '305-555-0163',1,true,'1983-07-12 21:30:55.888');
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values ('Instructor','raymond', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Raymond', 'Weaving', 'isa.booking.project+raymond@gmail.com', '305-555-0720',2,true,'1983-07-12 21:30:55.888');
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values ('Instructor','stewart', '222', 'Stewart', 'Lindsey', 'isa.booking.project+stewart@gmail.com', '305-555-0000',3,true,'1983-07-12 21:30:55.888');
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values ('Instructor','bruno', '333', 'Bruno', 'Nicholson', 'isa.booking.project+brunon@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888');
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values ('Client','ana', '$2a$10$qELfQNNCVvxVYgDYv4XUue6QIJ2ca09BFPPC3/M9Ke6q8PqRLkvdy', 'Ana', 'Anic', 'ana@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888');
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values ('Instructor','lana', '$2a$10$PTOW/.r9dgjokBc60GGnIO6csC4ReF7ql/F21IE/spO4fhCQLP9XK', 'Lana', 'Laic', 'lana@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888');
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values ('Client','laza', '$2a$10$sfvnEaK0mFaQB1VH3b.5k.ZloVuTXQ4DmM/uJazZNWh8.gcMa/2Bi', 'Laza', 'Anic', 'lazaa@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888');
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values ('Client','dusko', '$2a$10$sfvnEaK0mFaQB1VH3b.5k.ZloVuTXQ4DmM/uJazZNWh8.gcMa/2Bi', 'Dusko', 'Dusic', 'dusko@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888');
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values ('Client','daca', '$2a$10$sfvnEaK0mFaQB1VH3b.5k.ZloVuTXQ4DmM/uJazZNWh8.gcMa/2Bi', 'Danica', 'Danicic', 'dana@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888');


insert into user_authority (user_id,authority_id) values (1,3);
insert into user_authority (user_id,authority_id) values (2,3);
insert into user_authority (user_id,authority_id) values (3,3);
insert into user_authority (user_id,authority_id) values (4,3);
insert into user_authority (user_id,authority_id) values (5,4);
insert into user_authority (user_id,authority_id) values (6,3);
insert into user_authority (user_id,authority_id) values (7,4);
insert into user_authority (user_id,authority_id) values (8,4);
insert into user_authority (user_id,authority_id) values (9,4);


insert into instructor (id,biography,grade) values (1,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',3);
insert into instructor (id,biography,grade) values (2,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',4);
insert into instructor (id,biography,grade) values (3,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',3);
insert into instructor (id,biography,grade) values (4,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',5);
insert into instructor (id,biography,grade) values (6,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',2);



insert into client (id) values (5);
insert into client (id) values (7);
insert into client (id) values (8);
insert into client (id) values (9);


insert into adventure_fishing_equipment(name) values ('cumberland');
insert into adventure_fishing_equipment(name) values ('soft baits');
insert into adventure_fishing_equipment(name) values ('frogs');
insert into adventure_fishing_equipment(name) values ('fishing rods');

insert into adventure_behavioral_rule(rule) values ('Child Friendly');
insert into adventure_behavioral_rule(rule) values ('Forbidden for childer under 5 yo');
insert into adventure_behavioral_rule(rule) values ('Just bring good energy');
insert into adventure_behavioral_rule(rule) values ('You Keep Catch');
insert into adventure_behavioral_rule(rule) values ('Catch and Release Allowed');




insert into adventure(name,description,average_grade,price,max_persons,main_picture,address_id,instructor_id,cancellation_percentage) 
values ('Lucky B Sportfishing','Lucky B Sportfishing welcomes you to one of the most beautiful fisheries in the world. This charter service is operated by a professional crew that always strives to exceed their guests’ expectations. No matter what time of year you join, you can always count on a great water experience.The adventure starts on a 36’ Yellowfin boat . The boat features all necessary safety gear, modern navigational electronics, a live bait tank, and a cooler.You can fish the inshore waters of Coronado Islands or visit offshore spots for big game fish. Some of the species you’ll target on your trip are Calico Bass, Halibut, Lingcod, Tuna, Swordfish, Mahi Mahi, and many more. With such a variety of fish species and fishing techniques, it never gets boring or repetitive on board.The only thing you need to prepare in advance is your fishing license. The crew takes care of everything else - your fishing equipment, catch cleaning, snacks, and drinks.The main goal for the Lucky B Sportfishing’s crew is for you to have a memorable and enjoyable experience. They look forward to seeing you on their boat!',5.0,100,10,'/assets/adventure/Adventure1.jpg',1,1,0);
insert into adventure(name,description,average_grade,price,max_persons,main_picture,address_id,instructor_id,cancellation_percentage) 
values('The Long Run Sportfishing','No matter what kind of fishing trip you’re looking for, The Long Run is at your disposal. She’s a 40’ Hershine boat that’s got plenty of room for up to 6 anglers to be fishing in comfort. This is a spacious vessel with a pair of private heads, an outfitted kitchen, an air-conditioned cabin, and more.On shorter trips, you can expect to target Barracuda, Dorado, Yellowtail or bottom fish such as Lingcod, Sand Bass, Rockfish, and Halibut. Overnight trips will take you out for Yellowfin, Bluefin and Albacore Tuna, Dorado, Yellowtail, Marlin, and more. During shorter trips, you can also leave some lobster hoops in pristine locations when the season is open.All the fishing equipment, including bait, is provided for your convenience – all you need to do is get that daily license and some food and beverages and start bagging fish! For maximum comfort, bring a pair of polarized sunglasses and get ready to have some fun.',0,80,7,'/assets/adventure/Adventure2.jpg',2,1,10); 
insert into adventure(name,description,average_grade,price,max_persons,main_picture,address_id,instructor_id,cancellation_percentage) 
values ('Reel Floridian Fishing','Head out to some of the richest waters of the mighty Atlantic as you search for some trophy specimens. There’s a whole host of fish species inhabiting these waters, and some of them that you can expect to target are Snapper, Scup, Grouper, King Mackerel, Cobia, Sailfish, and Mahi Mahi.You’ll be fishing using Shimano rods, reels, and tackle, and Capt. Tyler will be happy to clean and fillet your catch for you to take home for a nice dinner. Feel free to bring your kids along, but note that you should bring life jackets for them. From viewing various marine life like turtles and dolphins to catching the fish of a lifetime, this is an adventure you won’t forget!Make sure to bring some food and drinks, especially on longer trips to stay refreshed throughout the day,Join Reel Floridian Fishing and let Capt. Tyler show you a great time, fishing under the Floridian sun!',0,250,5,'/assets/adventure/Adventure3.jpg',10,1,15);
insert into adventure(name,description,average_grade,price,max_persons,main_picture,address_id,instructor_id,cancellation_percentage) 
values ('Fishing river','Head out to some of the richest waters of the mighty Atlantic as you search for some trophy specimens. There’s a whole host of fish species inhabiting these waters, and some of them that you can expect to target are Snapper, Scup, Grouper, King Mackerel, Cobia, Sailfish, and Mahi Mahi.You’ll be fishing using Shimano rods, reels, and tackle, and Capt. Tyler will be happy to clean and fillet your catch for you to take home for a nice dinner. Feel free to bring your kids along, but note that you should bring life jackets for them. From viewing various marine life like turtles and dolphins to catching the fish of a lifetime, this is an adventure you won’t forget!Make sure to bring some food and drinks, especially on longer trips to stay refreshed throughout the day,Join Reel Floridian Fishing and let Capt. Tyler show you a great time, fishing under the Floridian sun!',0,250,5,'/assets/adventure/Adventure5.jpg',1,2,15);


insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id) 
values ('Marina',50,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades ',40,10,3,1,100,'/assets/boats/slika1.jpeg',1);
insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id) 
values ('Golden',40,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades and Dodecanese',23,9,33,1,10,'/assets/boats/slika2.jpeg',2);
insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id) 
values ('Blue sky',30,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki,',9,7,333,1,1000,'/assets/boats/slika3.jpeg',3);
insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id) 
values ('Blue star',20,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades ',10,9,33,1,1,'/assets/boats/slika4.jpeg',4);
insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id) 
values ('Sky',10,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades and Dodecanese ',15,6,333,1,10,'/assets/boats/slika1.jpeg',5);

insert into cottage(description,  grade, main_picture, name,address_id) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 10, 'assets/cottages/vikendica1.jpg','Sun cottage',1);
insert into cottage(description,  grade, main_picture, name,address_id) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 8, 'assets/cottages/vikendica5.jpg','Star cottage',5);
insert into cottage(description, grade, main_picture, name,address_id) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 8, 'assets/cottages/vikendica3.jpg','Moon cottage',4);
insert into cottage(description,  grade, main_picture, name,address_id) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 9, 'assets/cottages/vikendica4.jpg','shooting star cottage',3);
insert into cottage(description, grade, main_picture, name,address_id) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 7, 'assets/cottages/vikendica5.jpg','Sky cottage',6);



insert into additional_item(name,price,adventure_id) values ('Fishing License',20,1);
insert into additional_item(name,price,adventure_id) values ('Live Bait',5,1);
insert into additional_item(name,price,adventure_id) values ('Fridge',5,1);
insert into additional_item(name,price,adventure_id) values ('Kitchen',10,2);
insert into additional_item(name,price,adventure_id) values ('fishfinder',15,2);

insert into adventure_equipment(adventure_id,equipment_id) values (1,1);
insert into adventure_equipment(adventure_id,equipment_id) values (1,2);
insert into adventure_equipment(adventure_id,equipment_id) values (1,4);
insert into adventure_equipment(adventure_id,equipment_id) values (2,1);

insert into adventure_rules(adventure_id,rule_id) values (1,1);
insert into adventure_rules(adventure_id,rule_id) values (1,2);
insert into adventure_rules(adventure_id,rule_id) values (1,4);
insert into adventure_rules(adventure_id,rule_id) values (2,1);
insert into adventure_rules(adventure_id,rule_id) values (2,3);
insert into adventure_rules(adventure_id,rule_id) values (3,2);
insert into adventure_rules(adventure_id,rule_id) values (3,4);
insert into adventure_rules(adventure_id,rule_id) values (3,5);
 

 insert into instructor_report(content,sanctioned,showed_up) values('Everythiing was great',false,true);
 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,report_id) values('2021-11-10-07-00-00','2021-11-12-13-00-00',3,2000,1,5,1); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,report_id) values('2020-11-10-07-00-00','2020-11-12-13-00-00',3,3000,2,8,1); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,report_id) values('2021-10-10-07-00-00','2021-10-12-13-00-00',3,2500,3,8,1); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,report_id) values('2021-9-10-07-00-00','2021-9-12-13-00-00',3,6000,4,8,1); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,report_id) values('2021-7-10-07-00-00','2021-7-12-13-00-00',3,5400,1,8,1); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,report_id) values('2021-8-10-07-00-00','2021-8-12-13-00-00',3,3000,1,5,1); 

insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (1,1);
insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (2,2);
insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (3,3);
insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (4,4);
insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (1,5);
insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (1,6);

insert into client_adventure_reservations(client_id,adventure_reservations_id) values(5,1);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(8,2);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(8,3);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(8,4);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(8,5);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(5,6);

insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2016-02-20T06:30:00",10,10,15000,5,1);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2014-02-20T06:30:00",3,2,7000,8,2);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2015-02-20T06:30:00",1,3,3000,8,3);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2017-02-20T06:30:00",3,1,6000,8,1);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2015-02-20T06:30:00",4,5,9000,8,4);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2021-02-20T06:30:00",2,5,3400,9,2);

insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (1,1);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (2,2);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (3,3);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (1,4);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (4,5);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (2,6);

insert into client_cottage_reservations(client_id,cottage_reservations_id) values(5,1);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(8,2);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(8,3);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(8,4);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(8,5);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(9,6);

insert into boat_reservation(date,duration,max_persons,price,client_id,boat_id) values ("2016-02-20T06:30:00",10,10,15000,5,1);
insert into boat_reservation(date,duration,max_persons,price,client_id,boat_id) values ("2014-02-20T06:30:00",3,2,7000,8,2);
insert into boat_reservation(date,duration,max_persons,price,client_id,boat_id) values ("2015-02-20T06:30:00",1,3,3000,8,3);
insert into boat_reservation(date,duration,max_persons,price,client_id,boat_id) values ("2017-02-20T06:30:00",3,1,6000,8,1);
insert into boat_reservation(date,duration,max_persons,price,client_id,boat_id) values ("2015-02-20T06:30:00",4,5,9000,8,4);
insert into boat_reservation(date,duration,max_persons,price,client_id,boat_id) values ("2021-02-20T06:30:00",2,5,3400,9,2);

insert into boat_boat_reservations(boat_id,boat_reservations_id)values (1,1);
insert into boat_boat_reservations(boat_id,boat_reservations_id)values (2,2);
insert into boat_boat_reservations(boat_id,boat_reservations_id)values (3,3);
insert into boat_boat_reservations(boat_id,boat_reservations_id)values (1,4);
insert into boat_boat_reservations(boat_id,boat_reservations_id)values (4,5);
insert into boat_boat_reservations(boat_id,boat_reservations_id)values (2,6);

insert into client_boat_reservations(client_id,boat_reservations_id) values(5,1);
insert into client_boat_reservations(client_id,boat_reservations_id) values(8,2);
insert into client_boat_reservations(client_id,boat_reservations_id) values(8,3);
insert into client_boat_reservations(client_id,boat_reservations_id) values(8,4);
insert into client_boat_reservations(client_id,boat_reservations_id) values(8,5);
insert into client_boat_reservations(client_id,boat_reservations_id) values(9,6);



 

