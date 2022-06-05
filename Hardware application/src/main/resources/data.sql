insert into hardware (id, name, code, price, type, units) values (1, 'Asus TUF RTX 3080', '1', 1599.00, 'GPU', 2);
insert into hardware (id, name, code, price, type, units) values (2, 'EVGA XC3 RTX 3070 Ti', '2', 1299.00, 'GPU', 3);
insert into hardware (id, name, code, price, type, units) values (3, 'AMD Ryzen 5950X', '3', 899.00, 'CPU', 2);
insert into hardware (id, name, code, price, type, units) values (4, 'Samsung 980 PRO SSD 1TB', '4', 299.00, 'STORAGE', 10);
insert into hardware (id, name, code, price, type, units) values (5, 'Kingston FURY Beast DDR5 32GB', '5', 699.00, 'RAM', 7);

insert into review (id, headline, text, mark, hardware_id) values(1, 'Works great', 'amazing performance', 5, 1);
insert into review (id, headline, text, mark, hardware_id) values(2, 'Great card', 'very good card but expensive', 4, 1);
insert into review (id, headline, text, mark, hardware_id) values(3, 'Bit overpriced', 'ok performance to price ratio', 3, 2);
insert into review (id, headline, text, mark, hardware_id) values(4, 'Amazing', 'better than intel equivalent', 5, 3);
insert into review (id, headline, text, mark, hardware_id) values(5, 'Best ssd', 'samsung doesnt disappoint', 5, 4);
insert into review (id, headline, text, mark, hardware_id) values(6, 'Ok', 'very expensive', 3, 5);

insert into user(id, username, password)
values
    (1, 'user', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = user
    (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin

insert into authority (id, authority_name) values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

insert into user_authority (user_id, authority_id)
values
    (1, 2),
    (2, 1);