

insert into address (state, city,street,latitude,longitude) values ('United States','Panama City','3151 West 10th Street',30.167530,-85.703880);
insert into address (state, city,street,latitude,longitude) values ('United States','Key West',' 201 Margaret Street',24.561550,-81.800150);
insert into address (state, city,street,latitude,longitude) values ('United States','Key West',' 5950 Peninsular Avenue',24.563920,-81.728150);
insert into address (state, city,street,latitude,longitude) values ('United States','Key West','  North Roosevelt Boulevard',24.565670,-81.772880);
insert into address (state, city,street,latitude,longitude) values ('United States','Destin',' 210 Harbor Boulevard',30.3934711,-86.5068368);
insert into address (state, city,street,latitude,longitude) values ('United States','Destin',' 214 Harbor Boulevard',30.392942,-86.5063408);
insert into address (state, city,street,latitude,longitude) values ('United States','St. Petersburg',' 3600 Poplar Street Northeast',27.805171,-82.6278321);
insert into address (state, city,street,latitude,longitude) values ('United States','St. Petersburg',' 9600 Bay Pines Boulevard',27.8141447,-82.7718856);
insert into address (state, city,street,latitude,longitude) values ('United States','Miami',' 3400 Pan American Dr,',25.7269537,-80.2354768);
insert into address (state, city,street,latitude,longitude) values ('United States','Miami','Northwest 7th Street Road 945',25.7269537,-80.2354768);
insert into address (state, city,street,latitude,longitude) values ('United States','San Diego',' 955 Harbor Island Drive',32.7251557,-117.1917584);
insert into address (state, city,street,latitude,longitude) values ('United States','San Diego','Emerson Street 2803',32.7234718,-117.227589);


insert into authority(id, name) values (1, 'ROLE_SYSADMIN');

insert into authority(id, name) values (2, 'ROLE_ADMIN');

insert into authority(id, name) values (3, 'ROLE_INSTRUCTOR');

insert into authority(id, name) values (4, 'ROLE_CLIENT');
insert into authority(id, name) values (6, 'ROLE_BOAT_OWNER');

insert into authority(id, name) values (5, 'ROLE_COTTAGE_OWNER');



insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Instructor','truman', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Truman', 'Willis', 'isa.booking22@gmail.com', '305-555-0163',1,true,'1983-07-12 21:30:55.888',false);
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Instructor','raymond', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Raymond', 'Weaving', 'isa.booking22@gmail.com', '305-555-0720',2,true,'1983-07-12 21:30:55.888',false);
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Instructor','stewart', '222', 'Stewart', 'Lindsey', 'isa.booking22@gmail.com', '305-555-0000',3,true,'1983-07-12 21:30:55.888',false);
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Instructor','bruno', '333', 'Bruno', 'Nicholson', 'isa.booking22@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888',false);
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Client','ana', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Ana', 'Anic', 'isa.booking22@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888',false);
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Instructor','lana', '$2a$10$PTOW/.r9dgjokBc60GGnIO6csC4ReF7ql/F21IE/spO4fhCQLP9XK', 'Lana', 'Laic', 'isa.booking22@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888',false);
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Client','laza', '$2a$10$sfvnEaK0mFaQB1VH3b.5k.ZloVuTXQ4DmM/uJazZNWh8.gcMa/2Bi', 'Laza', 'Anic', 'isa.booking22@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888',false);
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Client','dusko', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Dusko', 'Dusic', 'isa.booking22@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888',false);
insert into user ( role,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Client','daca', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Danica', 'Danicic', 'isa.booking22@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888',false);
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('SysAdmin','taylor', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Taylor', 'Smith', 'isa.booking22@gmail.com', '305-666-0163',3,true,'1983-07-12 21:30:55.888',false);
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('CottageOwner','anna', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Ana', 'Popovic', 'isa.booking22@gmail.com', '305-555-0163',1,true,'1983-07-12 21:30:55.888',false);
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Client','Maya', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Maya', 'Smith', 'isa.booking22@gmail.com', '305-555-0163',5,true,'1983-07-12 21:30:55.888',false);
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Instructor','tanya', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Tanya', 'Smith', 'isa.booking22@gmail.com', '305-555-0163',5,false,'1983-07-12 21:30:55.888',false);
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('Cottage Owner','sam', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Sam', 'Smith', 'isa.booking22@gmail.com', '305-555-0163',5,false,'1983-07-12 21:30:55.888',false);
insert into user (role, username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date,deleted) values ('BoatOwner','naomi', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Naomi', 'Willis', 'isa.booking22@gmail.com', '305-555-0163',3,true,'1983-07-12 21:30:55.888',false);




insert into user_authority (user_id,authority_id) values (1,3);
insert into user_authority (user_id,authority_id) values (2,3);
insert into user_authority (user_id,authority_id) values (3,3);
insert into user_authority (user_id,authority_id) values (4,3);
insert into user_authority (user_id,authority_id) values (5,4);
insert into user_authority (user_id,authority_id) values (6,3);
insert into user_authority (user_id,authority_id) values (7,4);
insert into user_authority (user_id,authority_id) values (8,4);
insert into user_authority (user_id,authority_id) values (9,4);
insert into user_authority (user_id,authority_id) values (11,5);
insert into user_authority (user_id,authority_id) values (15,6);

insert into user_authority (user_id,authority_id) values (10,1);


insert into instructor (id,biography,grade) values (1,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',3);
insert into instructor (id,biography,grade) values (2,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',4);
insert into instructor (id,biography,grade) values (3,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',3);
insert into instructor (id,biography,grade) values (4,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',5);
insert into instructor (id,biography,grade) values (6,'I was born and raised in Key West, Fl. Fishing and diving have been a part of my life since I was 6 years old. Being on the water has always been my favorite thing to do and love taking people out on the beautiful water of Key West where they can make memories.',2);

insert into cottage_owner (id,grade) values (11,3);

insert into boat_owner (id,grade) values (15,4);

insert into client (id,number_of_penals) values (5,0);
insert into client (id,number_of_penals) values (7,0);
insert into client (id,number_of_penals) values (8,0);
insert into client (id,number_of_penals) values (9,0);

insert into admin(id,first_login) values(10,false);

insert into adventure_fishing_equipment(name) values ('cumberland');
insert into adventure_fishing_equipment(name) values ('soft baits');
insert into adventure_fishing_equipment(name) values ('frogs');
insert into adventure_fishing_equipment(name) values ('fishing rods');

insert into adventure_behavioral_rule(rule) values ('Child Friendly');
insert into adventure_behavioral_rule(rule) values ('Forbidden for childer under 5 yo');
insert into adventure_behavioral_rule(rule) values ('Just bring good energy');
insert into adventure_behavioral_rule(rule) values ('You Keep Catch');
insert into adventure_behavioral_rule(rule) values ('Catch and Release Allowed');

insert into boat_behavioral_rule(rule) values ('Pet friendly');

insert into cottage_behavioral_rule(rule) values ('Pet friendly');


insert into adventure(name,description,average_grade,price,max_persons,main_picture,address_id,instructor_id,cancellation_percentage,deleted) 
values ('Lucky B Sportfishing','Lucky B Sportfishing welcomes you to one of the most beautiful fisheries in the world. This charter service is operated by a professional crew that always strives to exceed their guests’ expectations. No matter what time of year you join, you can always count on a great water experience.The adventure starts on a 36’ Yellowfin boat . The boat features all necessary safety gear, modern navigational electronics, a live bait tank, and a cooler.You can fish the inshore waters of Coronado Islands or visit offshore spots for big game fish. Some of the species you’ll target on your trip are Calico Bass, Halibut, Lingcod, Tuna, Swordfish, Mahi Mahi, and many more. With such a variety of fish species and fishing techniques, it never gets boring or repetitive on board.The only thing you need to prepare in advance is your fishing license. The crew takes care of everything else - your fishing equipment, catch cleaning, snacks, and drinks.The main goal for the Lucky B Sportfishing’s crew is for you to have a memorable and enjoyable experience. They look forward to seeing you on their boat!',5.0,100,10,'/assets/adventure/Adventure1.jpg',1,1,0,false);
insert into adventure(name,description,average_grade,price,max_persons,main_picture,address_id,instructor_id,cancellation_percentage,deleted) 
values('The Long Run Sportfishing','No matter what kind of fishing trip you’re looking for, The Long Run is at your disposal. She’s a 40’ Hershine boat that’s got plenty of room for up to 6 anglers to be fishing in comfort. This is a spacious vessel with a pair of private heads, an outfitted kitchen, an air-conditioned cabin, and more.On shorter trips, you can expect to target Barracuda, Dorado, Yellowtail or bottom fish such as Lingcod, Sand Bass, Rockfish, and Halibut. Overnight trips will take you out for Yellowfin, Bluefin and Albacore Tuna, Dorado, Yellowtail, Marlin, and more. During shorter trips, you can also leave some lobster hoops in pristine locations when the season is open.All the fishing equipment, including bait, is provided for your convenience – all you need to do is get that daily license and some food and beverages and start bagging fish! For maximum comfort, bring a pair of polarized sunglasses and get ready to have some fun.',9,80,7,'/assets/adventure/Adventure2.jpg',2,1,10,false); 
insert into adventure(name,description,average_grade,price,max_persons,main_picture,address_id,instructor_id,cancellation_percentage,deleted) 
values ('Reel Floridian Fishing','Head out to some of the richest waters of the mighty Atlantic as you search for some trophy specimens. There’s a whole host of fish species inhabiting these waters, and some of them that you can expect to target are Snapper, Scup, Grouper, King Mackerel, Cobia, Sailfish, and Mahi Mahi.You’ll be fishing using Shimano rods, reels, and tackle, and Capt. Tyler will be happy to clean and fillet your catch for you to take home for a nice dinner. Feel free to bring your kids along, but note that you should bring life jackets for them. From viewing various marine life like turtles and dolphins to catching the fish of a lifetime, this is an adventure you won’t forget!Make sure to bring some food and drinks, especially on longer trips to stay refreshed throughout the day,Join Reel Floridian Fishing and let Capt. Tyler show you a great time, fishing under the Floridian sun!',7,250,5,'/assets/adventure/Adventure3.jpg',10,1,15,false);
insert into adventure(name,description,average_grade,price,max_persons,main_picture,address_id,instructor_id,cancellation_percentage,deleted) 
values ('Fishing river','Head out to some of the richest waters of the mighty Atlantic as you search for some trophy specimens. There’s a whole host of fish species inhabiting these waters, and some of them that you can expect to target are Snapper, Scup, Grouper, King Mackerel, Cobia, Sailfish, and Mahi Mahi.You’ll be fishing using Shimano rods, reels, and tackle, and Capt. Tyler will be happy to clean and fillet your catch for you to take home for a nice dinner. Feel free to bring your kids along, but note that you should bring life jackets for them. From viewing various marine life like turtles and dolphins to catching the fish of a lifetime, this is an adventure you won’t forget!Make sure to bring some food and drinks, especially on longer trips to stay refreshed throughout the day,Join Reel Floridian Fishing and let Capt. Tyler show you a great time, fishing under the Floridian sun!',0,250,5,'/assets/adventure/Adventure5.jpg',1,2,15,false);
insert into adventure(name,description,average_grade,price,max_persons,main_picture,address_id,instructor_id,cancellation_percentage,deleted) 
values ('Super star fishing','Head out to some of the richest waters of the mighty Atlantic as you search for some trophy specimens. There’s a whole host of fish species inhabiting these waters, and some of them that you can expect to target are Snapper, Scup, Grouper, King Mackerel, Cobia, Sailfish, and Mahi Mahi.You’ll be fishing using Shimano rods, reels, and tackle, and Capt. Tyler will be happy to clean and fillet your catch for you to take home for a nice dinner. Feel free to bring your kids along, but note that you should bring life jackets for them. From viewing various marine life like turtles and dolphins to catching the fish of a lifetime, this is an adventure you won’t forget!Make sure to bring some food and drinks, especially on longer trips to stay refreshed throughout the day,Join Reel Floridian Fishing and let Capt. Tyler show you a great time, fishing under the Floridian sun!',0,415,8,'/assets/adventure/Adventure4.jpg',5,1,20,false);


insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id, cancellation_percentage, price, max_persons, owner_id, deleted) 
values ('Marina',50,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades ',40,10,3,3,100,'/assets/boats/slika1.jpeg',1,15,150, 10, 15, false);
insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id, cancellation_percentage, price, max_persons, owner_id, deleted) 
values ('Golden',40,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades and Dodecanese',23,9,33,3,10,'/assets/boats/slika2.jpeg',2,20,250, 15, 15, false);
insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id, cancellation_percentage, price, max_persons, owner_id, deleted) 
values ('Blue sky',30,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki,',9,7,333,1,1000,'/assets/boats/slika3.jpeg',3,10,300, 20, 15, false);
insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id, cancellation_percentage, price, max_persons, owner_id, deleted) 
values ('Blue star',20,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades ',10,9,33,1,100,'/assets/boats/slika4.jpeg',4,50,180, 30, 15, false);
insert into boat(name,capacity,description,length,grade,max_speed,motor_number,motor_power,main_picture,address_id, cancellation_percentage, price, max_persons, owner_id, deleted) 
values ('Sky',10,'ur yachts are offered from the company operated main base and corporate bases across the most important and famous Greek islands, covering Ionian, Sporades, Chalkidiki, Cyclades and Dodecanese ',15,6,333,1,10,'/assets/boats/slika1.jpeg',5,30,120, 20, 15, false);

insert into cottage(description,  grade, main_picture, name,address_id, cottage_owner_id, cancellation_percentage, max_persons, price,deleted) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 10, 'assets/cottages/vikendica1.jpg','Sun cottage',1, 11, 20, 5, 120,false);
insert into cottage(description,  grade, main_picture, name,address_id, cottage_owner_id, cancellation_percentage, max_persons, price,deleted) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 8, 'assets/cottages/vikendica5.jpg','Star cottage',5, 11, 30, 10, 100,false);
insert into cottage(description, grade, main_picture, name,address_id, cottage_owner_id, cancellation_percentage, max_persons, price,deleted) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 8, 'assets/cottages/vikendica3.jpg','Moon cottage',4, 11, 15, 4, 50,false);
insert into cottage(description,  grade, main_picture, name,address_id, cottage_owner_id, cancellation_percentage, max_persons, price,deleted) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 9, 'assets/cottages/vikendica4.jpg','shooting star cottage',3, 11, 10, 2, 150,false);
insert into cottage(description, grade, main_picture, name,address_id, cottage_owner_id, cancellation_percentage, max_persons, price,deleted) values ('small wooden cottage on the river bank. Pleasant bird worm all day long. the murmur of the river awakens in the early hours.', 7, 'assets/cottages/vikendica5.jpg','Sky cottage',6, 11, 40, 3, 100,false);



insert into additional_item(name,price) values ('Fishing License',20);
insert into additional_item(name,price) values ('Live Bait',5);
insert into additional_item(name,price) values ('Fridge',5);
insert into additional_item(name,price) values ('Kitchen',10);
insert into additional_item(name,price) values ('fishfinder',15);
insert into additional_item(name,price) values ('Rend a car',15);
insert into additional_item(name,price) values ('Spa',5);
insert into additional_item(name,price) values ('Wi-fi',5);

insert into navigation_equipment (name, price) values ('Gyro Compass', 10);
insert into navigation_equipment (name, price) values ('Radar', 12);
insert into navigation_equipment (name, price) values ('Magnetic Compass', 15);
insert into navigation_equipment (name, price) values ('Autopilot', 45);
insert into navigation_equipment (name, price) values ('Speed & Distance Log Device', 78);


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

insert into boat_behavioral_rules(boat_id,rule_id) values (1,1);
insert into boat_behavioral_rules(boat_id,rule_id) values (2,1);
insert into boat_behavioral_rules(boat_id,rule_id) values (3,1);
insert into boat_behavioral_rules(boat_id,rule_id) values (4,1);
insert into boat_behavioral_rules(boat_id,rule_id) values (5,1);

insert into cottage_behavioral_rules(cottage_id,rule_id) values (1,1);
insert into cottage_behavioral_rules(cottage_id,rule_id) values (2,1);
insert into cottage_behavioral_rules(cottage_id,rule_id) values (3,1);
insert into cottage_behavioral_rules(cottage_id,rule_id) values (4,1);
insert into cottage_behavioral_rules(cottage_id,rule_id) values (5,1);

insert into adventure_additional_items(adventure_id,additional_item_id) values(1,1);
insert into adventure_additional_items(adventure_id,additional_item_id) values(1,2);
insert into adventure_additional_items(adventure_id,additional_item_id) values(1,3);
insert into adventure_additional_items(adventure_id,additional_item_id) values(2,2);
insert into adventure_additional_items(adventure_id,additional_item_id) values(2,4);
insert into adventure_additional_items(adventure_id,additional_item_id) values(3,1);

insert into cottage_items(cottage_id,additional_item_id) values(1,3);
insert into cottage_items(cottage_id,additional_item_id) values(1,7);
insert into cottage_items(cottage_id,additional_item_id) values(2,4);
insert into cottage_items(cottage_id,additional_item_id) values(2,6);
insert into cottage_items(cottage_id,additional_item_id) values(3,7);
insert into cottage_items(cottage_id,additional_item_id) values(3,8);
insert into cottage_items(cottage_id,additional_item_id) values(4,8);
insert into cottage_items(cottage_id,additional_item_id) values(5,6);

insert into boat_additional_items(boat_id,additional_item_id) values(1,1);
insert into boat_additional_items(boat_id,additional_item_id) values(2,2);
insert into boat_additional_items(boat_id,additional_item_id) values(3,3);
insert into boat_additional_items(boat_id,additional_item_id) values(4,4);
insert into boat_additional_items(boat_id,additional_item_id) values(5,5);
insert into boat_additional_items(boat_id,additional_item_id) values(1,8);
 

insert into boat_navigation_equipment(boat_id,equipment_id) values (1,1);
insert into boat_navigation_equipment(boat_id,equipment_id) values (1,2);
insert into boat_navigation_equipment(boat_id,equipment_id) values (1,3);
insert into boat_navigation_equipment(boat_id,equipment_id) values (2,1);
insert into boat_navigation_equipment(boat_id,equipment_id) values (2,4);
insert into boat_navigation_equipment(boat_id,equipment_id) values (3,5);
insert into boat_navigation_equipment(boat_id,equipment_id) values (3,4);
insert into boat_navigation_equipment(boat_id,equipment_id) values (4,3);
insert into boat_navigation_equipment(boat_id,equipment_id) values (5,2);

insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,system_earning,deleted) values('2022-07-10-07-00-00','2022-11-12-13-00-00',3,2000,1,5,200,false); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,system_earning,deleted) values('2022-09-10-07-00-00','2022-02-10-13-00-00',3,3000,2,8,300,false); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,system_earning,deleted) values('2022-08-10-07-00-00','2022-08-30-13-00-00',3,2500,3,8,250,false); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,system_earning,deleted) values('2021-9-10-07-00-00','2021-9-12-13-00-00',3,6000,4,8,600,false); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,system_earning,deleted) values('2023-7-10-07-00-00','2023-7-12-13-00-00',3,5400,1,8,540,false); 
insert into adventure_reservation(reservation_start,reservation_end,number_of_persons,price,adventure_id,client_id,system_earning,deleted) values('2021-8-10-07-00-00','2021-8-12-13-00-00',3,3000,1,5,300,false); 


--insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (1,1);
--insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (2,2);
--insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (3,3);
--insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (4,4);
--insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (1,5);
--insert into adventure_adventure_reservations(adventure_id,adventure_reservations_id)values (1,6);

insert into client_adventure_reservations(client_id,adventure_reservations_id) values(5,1);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(8,2);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(8,3);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(8,4);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(8,5);
insert into client_adventure_reservations(client_id,adventure_reservations_id) values(5,6);


insert into adventure_fast_reservation(reservation_start,reservation_end,validity_start,validity_end,max_persons,price,adventure_id) values ('2022-07-20-13-00-00','2022-10-15-16-00-00','2022-05-15','2022-08-10',4,460,1);
insert into adventure_fast_reservation(reservation_start,reservation_end,validity_start,validity_end,max_persons,price,adventure_id) values ('2022-08-01-7-00-00','2022-09-25-15-00-00','2022-05-10','2022-08-15',2,100,1);

insert into cottage_fast_reservation(reservation_start,reservation_end,date,time,duration,validity_start,validity_end,max_persons,price,cottage_id) values ('2021-12-10-06-30-00','2021-12-15-06-30-00',"2021-12-10T06:30:00","06:30:00",3,'2022-12-10','2022-12-14',4,460,1);
insert into cottage_fast_reservation(reservation_start,reservation_end,date,time,duration,validity_start,validity_end,max_persons,price,cottage_id) values ('2021-12-20-06-30-00','2021-12-24-06-30-00',"2021-12-20T06:30:00","06:30:00",2,'2022-12-12','2022-12-24',2,100,1);

insert into boat_fast_reservation(reservation_start,reservation_end,date,time,duration,validity_start,validity_end,max_persons,price,boat_id) values ('2022-09-20-10-00-00','2022-09-27-16-00-00',"2021-12-10T06:30:00","06:30:00",3,'2022-12-10','2022-12-14',4,460,1);
insert into boat_fast_reservation(reservation_start,reservation_end,date,time,duration,validity_start,validity_end,max_persons,price,boat_id) values ('2021-12-20-06-30-00','2021-12-24-06-30-00',"2021-12-20T06:30:00","06:30:00",2,'2022-12-12','2022-12-24',2,100,1);

insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id,reservation_start,reservation_end,system_earning,deleted) values ("2016-02-20T06:30:00",10,10,15000,5,1,'2021-11-10-07-00-00','2021-11-12-13-00-00',20,false);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id,reservation_start,reservation_end,system_earning,deleted) values ("2014-02-20T06:30:00",3,2,7000,8,2,'2021-12-4-07-00-00','2021-12-20-14-00-00',30,false);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id,reservation_start,reservation_end,system_earning,deleted) values ("2023-02-20T06:30:00",1,3,3000,8,3,'2021-11-10-07-00-00','2021-11-12-13-00-00',40,false);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id,reservation_start,reservation_end,system_earning,deleted) values ("2017-02-20T06:30:00",3,1,6000,8,1,'2022-1-4-07-00-00','2022-1-30-14-00-00',50,false);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id,reservation_start,reservation_end,system_earning,deleted) values ("2022-02-20T06:30:00",4,5,9000,8,4,'2022-11-10-07-00-00','2022-11-12-13-00-00',60,false);
insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id,reservation_start,reservation_end,system_earning,deleted) values ("2021-02-20T06:30:00",2,5,3400,9,2,'2022-12-4-07-00-00','2022-12-20-14-00-00',10,false);

--insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2016-02-20T06:30:00",10,10,15000,5,1);
--insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2014-02-20T06:30:00",3,2,7000,8,2);
--insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2023-02-20T06:30:00",1,3,3000,8,3);
--insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2017-02-20T06:30:00",3,1,6000,8,1);
--insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2022-02-20T06:30:00",4,5,9000,8,4);
--insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2021-02-20T06:30:00",2,5,3400,9,2);
--insert into cottage_reservation(date,duration,max_persons,price,client_id,cottage_id) values ("2020-02-20T06:30:00",5,6,1200,8,4);


insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (1,1);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (2,2);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (3,3);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (1,4);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (4,5);
insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (2,6);
--insert into cottage_cottage_reservations(cottage_id,cottage_reservations_id)values (4,7);

insert into client_cottage_reservations(client_id,cottage_reservations_id) values(5,1);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(8,2);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(8,3);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(8,4);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(8,5);
insert into client_cottage_reservations(client_id,cottage_reservations_id) values(9,6);
--insert into client_cottage_reservations(client_id,cottage_reservations_id) values(8,7);

insert into boat_reservation(date,duration,number_of_persons,price,client_id,boat_id,reservation_start,reservation_end,system_earning,deleted) values ("2016-02-20T06:30:00",10,10,15000,5,1,'2022-08-10-10-00-00','2022-08-15-16-00-00',120,false);
insert into boat_reservation(date,duration,number_of_persons,price,client_id,boat_id,reservation_start,reservation_end,system_earning,deleted) values ("2014-02-20T06:30:00",3,2,7000,8,2,'2021-12-4-07-00-00','2021-12-20-14-00-00', 150,false);
insert into boat_reservation(date,duration,number_of_persons,price,client_id,boat_id,reservation_start,reservation_end,system_earning,deleted) values ("2021-02-20T06:30:00",1,3,3000,8,3,'2021-11-10-07-00-00','2021-11-12-13-00-00', 200,false);
insert into boat_reservation(date,duration,number_of_persons,price,client_id,boat_id,reservation_start,reservation_end,system_earning,deleted) values ("2017-02-20T06:30:00",3,1,6000,8,1,'2022-1-4-07-00-00','2022-1-30-14-00-00', 250,false);
insert into boat_reservation(date,duration,number_of_persons,price,client_id,boat_id,reservation_start,reservation_end,system_earning,deleted) values ("2025-02-20T06:30:00",4,5,9000,8,4,'2022-11-10-07-00-00','2022-11-12-13-00-00', 300,false);
insert into boat_reservation(date,duration,number_of_persons,price,client_id,boat_id,reservation_start,reservation_end,system_earning,deleted) values ("2021-02-20T06:30:00",2,5,3400,9,2,'2022-12-4-07-00-00','2022-12-20-14-00-00', 100,false);

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

insert into registration_request(user_id,reason) values (13,'Have many adventures to offer');
insert into registration_request(user_id,reason) values (14,'This site looks pretty amazing and I want to be part of this community');

 insert into profile_delete_request(user_id,reason,type) values (3,'My services are no longer available','Unverified');
insert into profile_delete_request(user_id,reason,type) values (4,'I am getting to old for this :( ','Unverified');
 
 
insert into adventure_subscribers(adventure_id,client_id) values (1,5);
insert into adventure_subscribers(adventure_id,client_id) values (1,8);
insert into adventure_subscribers(adventure_id,client_id) values (3,8);

insert into boat_subscribers(boat_id,client_id) values (1,5);
insert into boat_subscribers(boat_id,client_id) values (1,8);
insert into boat_subscribers(boat_id,client_id) values (4,8);

insert into cottage_subscribers(cottage_id,client_id) values (1,5);
insert into cottage_subscribers(cottage_id,client_id) values (1,8);
insert into cottage_subscribers(cottage_id,client_id) values (5,8);

insert into adventure_complaint(description,client_id,adventure_id,type) values('Instructor was very unpolite and rude!',5,1,'Default');
insert into adventure_complaint(description,client_id,adventure_id,type) values('Service is too expensive. Nothing is like on pictures',8,1,'Default');

insert into boat_complaint(description,client_id,boat_reservation_id,type) values('Boat owner was very unpolite!',5,1,'Default');
insert into boat_complaint(description,client_id,boat_reservation_id,type) values('Boat is small',8,1,'Default');


insert into cottage_complaint(description,client_id,cottage_reservation_id,type) values('Rooms are dirty!',5,1,'Default');
insert into cottage_complaint(description,client_id,cottage_reservation_id,type) values('There are no enough beds.',8,1,'Default');


insert into revision(grade,revision,type) values(7,'Boat was very dirty','Unchecked');
insert into adventure_revision(revision_id,adventure_reservation_id) values(1,1);

insert into revision(grade,revision,type) values(4,'Beds are very uncomfotable','Unchecked');
insert into cottage_revision(revision_id,cottage_reservation_id) values(2,1);
insert into revision(grade,revision,type) values(3,'Beds are very uncomfotable','Unchecked');
insert into cottage_revision(revision_id,cottage_reservation_id) values(3,2);
insert into revision(grade,revision,type) values(1,'Beds are very uncomfotable','Unchecked');
insert into cottage_revision(revision_id,cottage_reservation_id) values(4,4);
insert into revision(grade,revision,type) values(5,'Beds are very uncomfotable','Unchecked');
insert into cottage_revision(revision_id,cottage_reservation_id) values(5,5);
insert into revision(grade,revision,type) values(2,'Beds are very uncomfotable','Unchecked');
insert into cottage_revision(revision_id,cottage_reservation_id) values(6,6);

insert into revision(grade,revision,type) values(4,'Boat was very dirty','Unchecked');
insert into boat_revision(revision_id,boat_reservation_id) values(7,1);
insert into revision(grade,revision,type) values(3,'Boat was very dirty','Unchecked');
insert into boat_revision(revision_id,boat_reservation_id) values(8,2);


insert into time_period(start,end,type) values ('2022-08-10-10-00-00','2022-08-15-16-00-00','Reservation');
insert into time_period(start,end,type) values ('2022-09-15-10-00-00','2022-09-18-16-00-00','Default');
insert into time_period(start,end,type) values ('2022-09-20-10-00-00','2022-09-27-16-00-00','Action');
insert into time_period(start,end,type) values ('2022-08-02-10-00-00','2022-08-09-16-00-00','Reservation');

insert into boat_unavailability (boat_id,period_id) values (1,1);
insert into boat_unavailability (boat_id,period_id) values (1,2);
insert into boat_unavailability (boat_id,period_id) values (1,3);
