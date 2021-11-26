insert into role (name) values ('ROLE_USER');
insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_INSTRUCTOR');
insert into role (name) values ('ROLE_COTTAGEOWNER');
insert into role (name) values ('ROLE_BOATOWNER');


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



insert into user ( role_id,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values (3,'truman', '123', 'Truman', 'Willis', 'isa.booking.project+truman@gmail.com', '305-555-0163',1,true,'1983-07-12 21:30:55.888');
insert into user ( role_id,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values (3,'raymond', '111', 'Raymond', 'Weaving', 'isa.booking.project+raymond@gmail.com', '305-555-0720',2,true,'1983-07-12 21:30:55.888');
insert into user ( role_id,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values (3,'stewart', '222', 'Stewart', 'Lindsey', 'isa.booking.project+stewart@gmail.com', '305-555-0000',3,true,'1983-07-12 21:30:55.888');
insert into user ( role_id,username, password, first_name, last_name, email, mobile,address_id,enabled,last_password_reset_date) values (3,'bruno', '333', 'Bruno', 'Nicholson', 'isa.booking.project+brunon@gmail.com', '305-555-0419',4,true,'1983-07-12 21:30:55.888');

insert into instructor (id) values (1);
insert into instructor (id) values (2);
insert into instructor (id) values (3);
insert into instructor (id) values (4);



insert into adventure(name,description,average_grade,max_persons,main_picture,address_id,instructor_id,cancellation) 
values ('Lucky B Sportfishing','Lucky B Sportfishing welcomes you to one of the most beautiful fisheries in the world. This charter service is operated by a professional crew that always strives to exceed their guests’ expectations. No matter what time of year you join, you can always count on a great water experience.The adventure starts on a 36’ Yellowfin boat . The boat features all necessary safety gear, modern navigational electronics, a live bait tank, and a cooler.You can fish the inshore waters of Coronado Islands or visit offshore spots for big game fish. Some of the species you’ll target on your trip are Calico Bass, Halibut, Lingcod, Tuna, Swordfish, Mahi Mahi, and many more. With such a variety of fish species and fishing techniques, it never gets boring or repetitive on board.The only thing you need to prepare in advance is your fishing license. The crew takes care of everything else - your fishing equipment, catch cleaning, snacks, and drinks.The main goal for the Lucky B Sportfishing’s crew is for you to have a memorable and enjoyable experience. They look forward to seeing you on their boat!',5.0,10,'/assets/adventure/Adventure1.jpg',1,1,'FREE');
insert into adventure(name,description,average_grade,max_persons,main_picture,address_id,instructor_id,cancellation) 
values('The Long Run Sportfishing','No matter what kind of fishing trip you’re looking for, The Long Run is at your disposal. She’s a 40’ Hershine boat that’s got plenty of room for up to 6 anglers to be fishing in comfort. This is a spacious vessel with a pair of private heads, an outfitted kitchen, an air-conditioned cabin, and more.On shorter trips, you can expect to target Barracuda, Dorado, Yellowtail or bottom fish such as Lingcod, Sand Bass, Rockfish, and Halibut. Overnight trips will take you out for Yellowfin, Bluefin and Albacore Tuna, Dorado, Yellowtail, Marlin, and more. During shorter trips, you can also leave some lobster hoops in pristine locations when the season is open.All the fishing equipment, including bait, is provided for your convenience – all you need to do is get that daily license and some food and beverages and start bagging fish! For maximum comfort, bring a pair of polarized sunglasses and get ready to have some fun.',0,7,'/assets/adventure/Adventure2.jpg',2,1,'FREE'); 
insert into adventure(name,description,average_grade,max_persons,main_picture,address_id,instructor_id,cancellation) 
values ('Reel Floridian Fishing','Head out to some of the richest waters of the mighty Atlantic as you search for some trophy specimens. There’s a whole host of fish species inhabiting these waters, and some of them that you can expect to target are Snapper, Scup, Grouper, King Mackerel, Cobia, Sailfish, and Mahi Mahi.You’ll be fishing using Shimano rods, reels, and tackle, and Capt. Tyler will be happy to clean and fillet your catch for you to take home for a nice dinner. Feel free to bring your kids along, but note that you should bring life jackets for them. From viewing various marine life like turtles and dolphins to catching the fish of a lifetime, this is an adventure you won’t forget!Make sure to bring some food and drinks, especially on longer trips to stay refreshed throughout the day,Join Reel Floridian Fishing and let Capt. Tyler show you a great time, fishing under the Floridian sun!',0,5,'/assets/adventure/Adventure3.jpg',10,1,'FREE');




 