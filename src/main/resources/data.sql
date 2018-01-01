DROP TABLE IF EXISTS GOT_HEROES;

CREATE TABLE GOT_HEROES (HERO_ID INT PRIMARY KEY,
HERO_NAME VARCHAR(255),
HERO_TITLE VARCHAR(255),
HERO_ALLEGIANCE VARCHAR(255),
HERO_IMAGE_URL VARCHAR(455));

INSERT INTO GOT_HEROES VALUES (1, 'Daenerys Targaryen', 'Mother of Dragons; Khaleesi','House Targaryen','https://vignette.wikia.nocookie.net/gameofthrones/images/5/5f/Daenerys_Dragonpit.jpg');
INSERT INTO GOT_HEROES VALUES (2, 'Arya Stark', 'Princess; Faceless Men','House Stark','https://vignette.wikia.nocookie.net/gameofthrones/images/5/54/Arya_the_dragon_and_the_wolf_s7.jpg');
INSERT INTO GOT_HEROES VALUES (3, 'Brienne of Tarth', 'Lady Brienne','House Stark','https://vignette.wikia.nocookie.net/gameofthrones/images/6/64/Brienne.PNG');
INSERT INTO GOT_HEROES VALUES (4, 'Yara Greyjoy', 'Queen of Iron Islands','House Targaryen','https://vignette.wikia.nocookie.net/gameofthrones/images/a/a8/Game_of_thrones_6x5_yara_promo.jpg');
INSERT INTO GOT_HEROES VALUES (5, 'Cersei Lannister', 'Queen of Kings Landing','House Lannister','https://vignette.wikia.nocookie.net/gameofthrones/images/c/c3/Profile-CerseiLannister.png');