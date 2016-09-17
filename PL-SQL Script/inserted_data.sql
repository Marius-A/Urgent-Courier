/*Adresa_sediu 15 inregistrari 
  Un sediu poate avea o singura adresa
  O adresa poate fi asociata uni singur sediu*/
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (1,'Dolj' , 'Craiova' , 'Bulevardul Gheorghe ChiTu',14);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (2,'Dolj' , 'Craiova' , 'D10or Victor Papilian',5);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (4,'Alba' , 'Runc' , 'Bulevardul Gheorghe ChiTu',54);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (5,'Alba' , 'Noslac' , 'Bulevardul Gheorghe ChiTu',21);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (6,'Mures','Targu Mures','Piata Republici',39);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (8,'Buzau','Buzau','Bulevardul Unirii',50);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (9,'Buzau','Craiova','1 Septembrie',31);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (11,'Bihor','Paulesti','Mihai Eminescu',25);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (12,'Botosani','Slobozia','Ioan Slavici',98);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES (13,'Cluj','Cheia','Drumul Sarii',46);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar) VALUES	(15,'Gorj','Damboja','Mihai Viteazu',1);
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES	(14,'Covasna','Bradet','Dezrobirii',30 , 'M8' , '5' , '3');
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES (10,'Buzau','Craiova','Drumul Apelor',47 , 'F4' , '7' , '2');
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES (7,'Mures','Targu Mures','Sinaia',74 , 'D31' , '112' , '3');
INSERT INTO Adresa_sediu(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES (3,'Dolj' , 'Craiova' , 'Fratii Golesti' , 69 , 'C54' , '14' , '1');
			
	
	
	

/*Sediu 15 inregistrari
   Sediul cu id-ul 1 are adresa cu id-ul 1 (din tabelul Adresa_sediu)*/	
INSERT INTO SEDIU Values (1,1);
INSERT INTO SEDIU Values (2,2);
INSERT INTO SEDIU Values (3,3);
INSERT INTO SEDIU Values (4,4);
INSERT INTO SEDIU Values (5,5);
INSERT INTO SEDIU Values (6,6);
INSERT INTO SEDIU Values (7,7);
INSERT INTO SEDIU Values (8,8);
INSERT INTO SEDIU Values (9,9);
INSERT INTO SEDIU Values (10,10);
INSERT INTO SEDIU Values (11,11);
INSERT INTO SEDIU Values (12,12);
INSERT INTO SEDIU Values (13,3);
INSERT INTO SEDIU Values (14,14);
INSERT INTO SEDIU Values (15,15);
	




/*Persoana 35 inregistrari*/	
/*Angajati*/

INSERT INTO Persoana VALUES('1781205345345', 'Anton','Mihai', 'andtonmihai@yahoo.com','0789654345') ;
INSERT INTO Persoana VALUES('2861103350654', 'Dobre','Maria', 'dobremaria@yahoo.com', '0765432896') ;
INSERT INTO Persoana VALUES('1850404123456', 'Dobre','Marius','dobremarius@yahoo.com', '0754658832') ;
INSERT INTO Persoana VALUES('1891121043923', 'Georgescu','Calin', 'georgescucatalin@yahoo.com','0721300400') ;
INSERT INTO Persoana VALUES('1910927278427', 'Georgescu','Laurentiu', 'georgesculaurentiu@yahoo.com','0786886800') ;
INSERT INTO Persoana VALUES('2910504162295', 'Tomescu','Florentina','tomescufloarentina@yahoo.com', '0756432234') ;
INSERT INTO Persoana VALUES('1850327359570', 'Toma','Florin', 'tomaflorin@yahoo.com','0766800702') ;
INSERT INTO Persoana VALUES('1890103393337', 'Mihnea','Aurel','mihneaaurel@yahoo.com', '0766402204') ;
INSERT INTO Persoana VALUES('1850617344940', 'Diaconescu','Gheorghe','diaconugheorghe@yahoo.com', '0723300405') ;
INSERT INTO Persoana VALUES('2851220255016', 'Ivanuta','Elena','ivanutaelena@yahoo.com', '0746004005') ;
INSERT INTO Persoana VALUES('1710902118117', 'Daniel','Feiera','danielfeiera@yahoo.com', '0735607706') ;
INSERT INTO Persoana VALUES('2880826042630', 'Marinescu','Laura','marinesculaura@yahoo.com', '0760356708') ;
INSERT INTO Persoana VALUES('1920307314175', 'Popescu','Georgel','popescugherghet@yahoo.com', '0743567890') ;
INSERT INTO Persoana VALUES('1891121044334', 'Georgescu','Calin-Florin','gflorin@yahoo.com', '0768456076') ;
INSERT INTO Persoana VALUES('1840412735570', 'Tomescu','Florin','tomflorin@yahoo.com', '0760123456') ;

/*Persoana expeditoare*/

INSERT INTO Persoana VALUES('1820617344940', 'Diaconu','Gheorghe','dighe@yahoo.com', '0721006050') ;
INSERT INTO Persoana VALUES('2870305678987', 'Toma','Mariana', 'bunaciuneamica@yahoo.com','0768954625') ;
INSERT INTO Persoana VALUES('1900304567345', 'Gheorghe','Adrian','gdrian@yahoo.com', '0765452134') ;
INSERT INTO Persoana VALUES('2851204456654', 'Bordea','Lavinia','bordeal@yahoo.com', '0723456789') ;
INSERT INTO Persoana VALUES('1841207314175', 'Popescu','Mirel','popmih@yahoo.com', '0743321069') ;
INSERT INTO Persoana VALUES('1781205432545', 'Miurici',' Stefan','miustef@yahoo.com', '0789654345') ;
INSERT INTO Persoana VALUES('2631101350654', 'Mili','Ilonela', 'miliionela@yahoo.com','0765432896') ;
INSERT INTO Persoana VALUES('1891204123456', 'Mihai','Morar','mormih@yahoo.com', '0754658832') ;
INSERT INTO Persoana VALUES('1810421043923', 'Dan','Condurache', 'conduru@yahoo.com','0721300400') ;
INSERT INTO Persoana VALUES('1920927278427', 'Lataretu','Dragos', 'draglitza@yahoo.com','0786886800') ;
INSERT INTO Persoana VALUES('2830504162295', 'Ioanana','Irina','irisms@yahoo.com', '0756432234') ;
INSERT INTO Persoana VALUES('1890327359570', 'Toma','Caragiu', 'tomycaragiu@yahoo.com','0766800702') ;
INSERT INTO Persoana VALUES('1960927278427', 'Dan','Bordeianu', 'dbordei@yahoo.com','0786886880') ;
INSERT INTO Persoana VALUES('2890504162295', 'Petre','Anastasia','fcdsx@yahoo.com', '0756431234') ;
INSERT INTO Persoana VALUES('1910327359570', 'Miu','Ion', 'ionmi@yahoo.com','0766800707') ;

/*Destinatari*/
INSERT INTO Persoana VALUES('1830213662519','Stancioiu','Viorel','stanvio@yahoo.com', '0752321521') ;
INSERT INTO Persoana VALUES('2963205678987', 'Boldeanu','Denisa', 'boldenisaa@yahoo.com','0764523124') ;
INSERT INTO Persoana VALUES('1632541567345', 'Fucusima','Adrian','fucuadr@yahoo.com', '0764563212') ;
INSERT INTO Persoana VALUES('2741204456654', 'Gaita','Loredana','gailore@yahoo.com', '0723456521') ;
INSERT INTO Persoana VALUES('1710907314175', 'Paun','Ion','paunion@yahoo.com', '0796523142') ;
INSERT INTO Persoana VALUES('1411205432545', 'Murgea',' Dorin','murgeadori@yahoo.com', '0785423125') ;
INSERT INTO Persoana VALUES('2990101350654', 'Dan','Viorel', 'danviorel@yahoo.com','0765632412') ;
INSERT INTO Persoana VALUES('1810204123456', 'Jana','Mucu','jmucuh@yahoo.com', '0757854231') ;
INSERT INTO Persoana VALUES('1820621043923', 'Udristoiu','Catalina', 'cataudristoiu@yahoo.com','0795840400') ;
INSERT INTO Persoana VALUES('1990927278427', 'Blegu','Viorel', 'bleguvioa@yahoo.com','0783210800') ;
INSERT INTO Persoana VALUES('2871204162295', 'Blejan','Larisa','blejanlarisa@yahoo.com', '0756322234') ;
INSERT INTO Persoana VALUES('1901127359570', 'Nicola','Vlad', 'nicolavlad@yahoo.com','0769652702') ;
INSERT INTO Persoana VALUES('1950727278427', 'Bala','Dragos', 'balaDragos@yahoo.com','0786021880') ;
INSERT INTO Persoana VALUES('2601004162295', 'Mustatea','Mihaela','mustateamihaela@yahoo.com', '0750231034') ;
INSERT INTO Persoana VALUES('1921027359570', 'Corbeanu','bogdan', 'tunetub@yahoo.com','0766963207') ;






INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (1,'Dolj' , 'Craiova' , 'Bulevardul Gheorghe ChiTu',41);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (2,'Dolj' , 'Craiova' , 'D10or Victor Papilian',25);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (4,'Mures','Targu Mures','Sinaia',34);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (5,'Alba' , 'Noslac' , 'Bulevardul Gheorghe ChiTu',21);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (6,'Mures','Targu Mures','Piata Republici',15);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (8,'Buzau','Buzau','Bulevardul Unirii',59);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (9,'Buzau','Craiova','1 Septembrie',21);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (11,'Covasna','Bradet','Dezrobirii',34);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (12,'Botosani','Slobozia','Ioan Slavici',89);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (13,'Cluj','Cheia','Drumul Sarii',26);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar) VALUES (15,'Gorj','Damboja','Mihai Viteazu',8);
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES	(14,'Bihor','Paulesti','Mihai Eminescu',52 , 'T9' , '7' , '8');
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES (10,'Buzau','Craiova','Drumul Apelor',87 , 'F4' , '1' , '3');
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES (7,'Alba' , 'Runc' , 'Bulevardul Gheorghe ChiTu',9 , 'D31' , '12' , '3');
INSERT INTO Adresa_angajat(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES (3,'Dolj' , 'Craiova' , 'Fratii Golesti' , 21 , 'N74' , '94' , '1');





/*Curieri*/
INSERT INTO Angajat VALUES(13651,'1781205345345', 1,562.1);
INSERT INTO Angajat VALUES(26253,'2861103350654',15,592.1);
INSERT INTO Angajat VALUES(38541,'1850404123456',2,192.1) ;
INSERT INTO Angajat VALUES(49654,'1891121043923',3,162.1) ;
INSERT INTO Angajat VALUES(53215,'1910927278427',4,252.1) ;
INSERT INTO Angajat VALUES(63954,'2910504162295',5,562.1) ;
INSERT INTO Angajat VALUES(72325,'1850327359570',6,362.1) ;
INSERT INTO Angajat VALUES(87854,'1890103393337',7,562.1) ;
INSERT INTO Angajat VALUES(99653,'1850617344940',8,462.1) ;

/*Receptioneri*/
INSERT INTO Angajat VALUES(12587,'2851220255016',9,256.9) ;
INSERT INTO Angajat VALUES(28564,'1710902118117',10,286.9) ;
INSERT INTO Angajat VALUES(32365,'2880826042630',11,256.9) ;
INSERT INTO Angajat VALUES(42395,'1920307314175',12,396.9) ;
INSERT INTO Angajat VALUES(57588,'1891121044334',13,256.9) ;
INSERT INTO Angajat VALUES(61233,'1840412735570',14,466.9) ;








INSERT INTO Curier VALUES(13651,'B',3);
INSERT INTO Curier VALUES(26253,'C',2);
INSERT INTO Curier VALUES(38541,'B',6) ;
INSERT INTO Curier VALUES(49654,'D',7) ;
INSERT INTO Curier VALUES(53215,'E',5) ;
INSERT INTO Curier VALUES(63954,'B',2) ;
INSERT INTO Curier VALUES(72325,'D',7) ;
INSERT INTO Curier VALUES(87854,'E',9) ;
INSERT INTO Curier VALUES(99653,'B',5) ;





INSERT INTO Receptioner VALUES(12587) ;
INSERT INTO Receptioner VALUES(28564) ;
INSERT INTO Receptioner VALUES(32365) ;
INSERT INTO Receptioner VALUES(42395) ;
INSERT INTO Receptioner VALUES(57588) ;
INSERT INTO Receptioner VALUES(61233) ;





INSERT INTO Vehicul VALUES(1,'DJ01UCR',2.4,2.3,'B','noua');
INSERT INTO Vehicul VALUES(2,'DJ02UCR',2.4,2.3,'B','uzata');
INSERT INTO Vehicul VALUES(3,'B03UCR',5.4,9.4,'D','noua');
INSERT INTO Vehicul VALUES(4,'B04UCR',2.4,2.3,'B','ok');
INSERT INTO Vehicul VALUES(5,'MU05UCR',2.4,2.3,'B','noua');
INSERT INTO Vehicul VALUES(6,'MU06UCR',15.4,20.3,'E','noua');
INSERT INTO Vehicul VALUES(7,'DJ07UCR',2.4,2.3,'B','noua');
INSERT INTO Vehicul VALUES(8,'DB08UCR',2.4,2.3,'C','uzata');
INSERT INTO Vehicul VALUES(9,'DJ00UCR',2.4,2.3,'B','noua');
INSERT INTO Vehicul VALUES(10,'GJ10UCR',3.4,5.3,'C','ok');
INSERT INTO Vehicul VALUES(11,'GJ11UCR',2.4,2.3,'B','uzata');
INSERT INTO Vehicul VALUES(12,'AL12UCR',2.4,2.3,'B','noua');
INSERT INTO Vehicul VALUES(13,'AL13UCR',8.4,6.3,'D','ok');
INSERT INTO Vehicul VALUES(14,'BU14UCR',2.4,2.3,'B','noua');
INSERT INTO Vehicul VALUES(15,'BU15UCR',7.4,10.3,'D','ok');



INSERT INTO Detine VALUES(1,1,'04-05-16');
INSERT INTO Detine VALUES(2,2,'04-06-16');
INSERT INTO Detine VALUES(3,3,'04-07-15');
INSERT INTO Detine VALUES(4,4,'04-03-15');
INSERT INTO Detine VALUES(5,5,'04-01-15');
INSERT INTO Detine VALUES(6,6,'04-02-15');
INSERT INTO Detine VALUES(7,7,'04-05-15');
INSERT INTO Detine VALUES(8,8,'04-05-15');
INSERT INTO Detine VALUES(9,9,'04-09-15');
INSERT INTO Detine VALUES(10,10,'04-05-16');
INSERT INTO Detine VALUES(11,11,'04-05-16');
INSERT INTO Detine VALUES(12,12,'04-10-15');
INSERT INTO Detine VALUES(13,13,'04-12-15');
INSERT INTO Detine VALUES(14,14,'04-05-15');
INSERT INTO Detine VALUES(15,1,'04-05-15');
INSERT INTO Detine VALUES(8,7,'04-05-15');
INSERT INTO Detine VALUES(9,7,'04-09-15');
INSERT INTO Detine VALUES(10,7,'04-05-16');
INSERT INTO Detine VALUES(11,7,'04-05-16');
INSERT INTO Detine VALUES(12,9,'04-10-15');
INSERT INTO Detine VALUES(13,9,'04-12-15');
INSERT INTO Detine VALUES(14,9,'04-05-15');
INSERT INTO Detine VALUES(15,15,'04-05-15');

/*Persoane Juridice*/

INSERT INTO Client VALUES(1541,'fidel',3);
INSERT INTO Client VALUES(3256,'nou',1);
INSERT INTO Client VALUES(8754,'nou',1);
INSERT INTO Client VALUES(4535,'nou',1);
INSERT INTO Client VALUES(7877,'nou',1);
INSERT INTO Client VALUES(2121,'nou',1);
INSERT INTO Client VALUES(3423,'nou',1);
INSERT INTO Client VALUES(5464,'nou',1);
INSERT INTO Client VALUES(6754,'nou',1);
INSERT INTO Client VALUES(3443,'nou',1);
INSERT INTO Client VALUES(6432,'nou',1);
INSERT INTO Client VALUES(7453,'nou',1);
INSERT INTO Client VALUES(2342,'nou',1);
INSERT INTO Client VALUES(1234,'nou',1);
INSERT INTO Client VALUES(7432,'nou',1);



/*Persoane Fizice*/
INSERT INTO Client VALUES(5643,'fidel',3);
INSERT INTO Client VALUES(3212,'nou',1);
INSERT INTO Client VALUES(6543,'nou',1);
INSERT INTO Client VALUES(2312,'nou',1);
INSERT INTO Client VALUES(5342,'nou',1);
INSERT INTO Client VALUES(5322,'nou',1);
INSERT INTO Client VALUES(6322,'nou',1);
INSERT INTO Client VALUES(2397,'nou',1);
INSERT INTO Client VALUES(5432,'nou',1);
INSERT INTO Client VALUES(2357,'nou',1);
INSERT INTO Client VALUES(5462,'nou',1);
INSERT INTO Client VALUES(3425,'nou',1);
INSERT INTO Client VALUES(8976,'nou',1);
INSERT INTO Client VALUES(7896,'nou',1);
INSERT INTO Client VALUES(8643,'nou',1);






INSERT INTO Persoana_expeditoare VALUES('1820617344940',5643);
INSERT INTO Persoana_expeditoare VALUES('2870305678987',3212) ;
INSERT INTO Persoana_expeditoare VALUES('1900304567345',6543) ;
INSERT INTO Persoana_expeditoare VALUES('2851204456654',2312) ;
INSERT INTO Persoana_expeditoare VALUES('1841207314175',5342) ;
INSERT INTO Persoana_expeditoare VALUES('1781205432545',5322) ;
INSERT INTO Persoana_expeditoare VALUES('2631101350654',6322) ;
INSERT INTO Persoana_expeditoare VALUES('1891204123456',2397) ;
INSERT INTO Persoana_expeditoare VALUES('1810421043923',5432) ;
INSERT INTO Persoana_expeditoare VALUES('1920927278427',2357) ;
INSERT INTO Persoana_expeditoare VALUES('2830504162295',5462) ;
INSERT INTO Persoana_expeditoare VALUES('1890327359570',3425) ;
INSERT INTO Persoana_expeditoare VALUES('1960927278427',8976) ;
INSERT INTO Persoana_expeditoare VALUES('2890504162295',7896) ;
INSERT INTO Persoana_expeditoare VALUES('1910327359570',8643) ;






INSERT INTO Companie VALUES('18787993', 'D & D MEDIA SRL', 'office@dandd.com','0251336952',1541);
INSERT INTO Companie VALUES('16443187', 'CAD WORKS INTERNATIONAL SRL', 'office@cadw.com','0271336957',3256);
INSERT INTO Companie VALUES('56508705', 'RECON SA ','office@recsa.com','0256336912',8754);
INSERT INTO Companie VALUES('73378454', 'WHITE IMPEX SRL', 'office@wis.com','0251336914',4535);
INSERT INTO Companie VALUES('43345343', 'STEEL CONSTRUCT SRL', 'office@steelcon.com','0289336915',7877);
INSERT INTO Companie VALUES('67792616', 'BUZMARCOM SRL', 'office@buzmarcom.com','0241336916',2121);
INSERT INTO Companie VALUES('70994333', 'COLROMA PROD SRL', 'office@colrom.com','0251336917',3423);
INSERT INTO Companie VALUES('82793516', 'VALMIROM PRESTCOM SRL', 'office@valmirom.com','0273336918',5464);
INSERT INTO Companie VALUES('16294999', 'PRETTY HOUSE SRL', 'office@pretyhouse.com','0273336919',6754);
INSERT INTO Companie VALUES('16513339', 'SANTANTONIO SRL', 'office@santantonio.com','0251336920',3443);
INSERT INTO Companie VALUES('54697777', 'PINTEXIM SRL', 'office@pintex.com','0221336921',6432);
INSERT INTO Companie VALUES('74573453', 'PLUS SRL', 'office@plusex.com','0230336922',7453);
INSERT INTO Companie VALUES('85817581', 'NICO STIL SRL', 'office@nicostl.com','0272336923',2342);
INSERT INTO Companie VALUES('15259808', 'ROMANITA SA', 'office@tomex.com','0351336924',1234);
INSERT INTO Companie VALUES('15163452', 'FOTO VENUS SRL', 'office@fotoven.com','0954336925',7432);





INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (1,'Dolj' , 'Bechet' , 'Drumul Sarii',10);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (2,'Dolj' , 'Ostroveni' , 'Ion Tuculescu',8);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (4,'Mures','Voinea','Turlelor',87);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (5,'Alba' , 'Alba-Iulia' , 'Bulevardul Gh. Turda',27);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (6,'Mures','Targu Mures','Bulevardul Unirii',25);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (8,'Buzau','Breaza','Iernii',5);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (9,'Buzau','Nina','1 Septembrie',21);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (11,'Covasna','Vulcan','Nanterre',34);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (12,'Botosani','Munteni','Stefna cel mare',89);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (13,'Cluj','Nunceni','Vinerii',26);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar) VALUES (15,'Gorj','Miruncea','Alexandri',8);
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES	(14,'Bihor','Boldesti','Mihai Eminescu',21 , 'P9' , '7' , '8');
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES (10,'Buzau','Mireni','Drumul Apelor',31 , 'N4' , '1' , '3');
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES (7,'Alba' , 'Bran' , 'Bulevardul Gheorghe ChiTu',9 , 'D11' , '12' , '3');
INSERT INTO Adresa_destinatar(Id_adresa , Judet , Oras , Strada , Numar , Bloc , Apartament, Scara) VALUES (3,'Dolj' , 'Craiova' , 'Fratii Golesti' , 21 , 'c34' , '94' , '1');




INSERT INTO Destinatar VALUES('1830213662519',1);
INSERT INTO Destinatar VALUES('2963205678987', 2) ;
INSERT INTO Destinatar VALUES('1632541567345', 3) ;
INSERT INTO Destinatar VALUES('2741204456654', 4) ;
INSERT INTO Destinatar VALUES('1710907314175', 5) ;
INSERT INTO Destinatar VALUES('1411205432545', 6) ;
INSERT INTO Destinatar VALUES('2990101350654', 7) ;
INSERT INTO Destinatar VALUES('1810204123456', 8) ;
INSERT INTO Destinatar VALUES('1820621043923', 9) ;
INSERT INTO Destinatar VALUES('1990927278427', 10) ;
INSERT INTO Destinatar VALUES('2871204162295', 11) ;
INSERT INTO Destinatar VALUES('1901127359570', 12) ;
INSERT INTO Destinatar VALUES('1950727278427', 13) ;
INSERT INTO Destinatar VALUES('2601004162295', 14) ;
INSERT INTO Destinatar VALUES('1921027359570', 15) ;




INSERT INTO Comanda VALUES(1, '03-05-16','04-05-16',2,30.0,1541);
INSERT INTO Comanda VALUES(2, '03-05-16', '04-05-16',1,20.0,3256);
INSERT INTO Comanda VALUES(3, '03-05-16', '04-05-16',1,20.0,8754);
INSERT INTO Comanda VALUES(4, '03-05-16', '04-05-16',1,15.0,1541);
INSERT INTO Comanda VALUES(5, '05-05-16', '07-05-16',1,20.0,4535);
INSERT INTO Comanda VALUES(6, '05-05-16', '07-05-16',1,20.0,7877);
INSERT INTO Comanda VALUES(7, '05-05-16', '07-05-16',1,20.0,2121);
INSERT INTO Comanda VALUES(9, '28-11-15', '30-11-15',1,20.0,5464);
INSERT INTO Comanda VALUES(10, '28-11-15', '30-11-15',1,20.0,6754);
INSERT INTO Comanda VALUES(11, '28-11-15', '30-11-15',1,20.0,3423);
INSERT INTO Comanda VALUES(12, '02-12-15', '05-12-15',1,20.0,3443);
INSERT INTO Comanda VALUES(13, '02-12-15', '05-12-15',1,20.0,6432);
INSERT INTO Comanda VALUES(14, '13-10-15', '14-10-15',1,20.0,7453);
INSERT INTO Comanda VALUES(15, '13-10-15', '14-10-15',1,20.0,2342);
INSERT INTO Comanda VALUES(16, '14-10-15', '14-10-15',1,20.0,1234);
INSERT INTO Comanda VALUES(17, '15-10-15', '16-10-15',1,20.0,7432);
INSERT INTO Comanda VALUES(18, '16-10-15', '17-10-15',1,15.0,1541);


INSERT INTO Comanda VALUES(19, '16-10-15', '19-10-15',2,30.0,5643);
INSERT INTO Comanda VALUES(20, '17-10-15', '19-10-15',1,20.0,3212);
INSERT INTO Comanda VALUES(21, '02-11-15', '04-11-15',1,20.0,6543);
INSERT INTO Comanda VALUES(22, '03-11-15', '04-11-15',1,20.0,2312);
INSERT INTO Comanda VALUES(23, '03-11-15', '04-11-15',2,20.0,5342);
INSERT INTO Comanda VALUES(24, '10-11-15', '15-11-15',1,15.0,5643);
INSERT INTO Comanda VALUES(25, '03-06-16', '04-06-16',1,20.0,5322);
INSERT INTO Comanda VALUES(26, '05-06-16', '07-06-16',1,20.0,6322);
INSERT INTO Comanda VALUES(27, '06-06-16', '07-06-16',1,20.0,2397);
INSERT INTO Comanda VALUES(28, '06-06-16', '07-06-16',1,20.0,5432);
INSERT INTO Comanda VALUES(29, '09-06-16', '12-06-16',1,20.0,2357);
INSERT INTO Comanda VALUES(30, '11-06-16', '11-06-16',1,15.0,5643);
INSERT INTO Comanda VALUES(31, '03-08-16', '04-08-16',1,20.0,5462);
INSERT INTO Comanda VALUES(32, '05-08-16', '07-08-16',1,20.0,3425);
INSERT INTO Comanda VALUES(33, '06-08-16', '07-08-16',1,20.0,8976);
INSERT INTO Comanda VALUES(34, '06-08-16', '07-08-16',1,20.0,7896);
INSERT INTO Comanda VALUES(35, '09-08-16', '12-08-16',1,20.0,8643);




INSERT INTO Pachet VALUES(1,2.3,1.1,2.1,0.3,'in curs',15.0,1,'1830213662519');
INSERT INTO Pachet VALUES(2,2.3,1.1,2.1,0.3,'expediat',15.0,1,'2963205678987');
INSERT INTO Pachet VALUES(3,2.3,1.1,2.1,0.3,'expediat',15.0,18,'1830213662519');
INSERT INTO Pachet VALUES(4,2.3,1.1,2.1,0.3,'expediat',15.0,4,'1632541567345');
INSERT INTO Pachet VALUES(5,2.3,1.1,2.1,0.3,'expediat',20.0,2,'2741204456654');
INSERT INTO Pachet VALUES(6,2.3,1.1,2.1,0.3,'expediat',20.0,3,'1710907314175');
INSERT INTO Pachet VALUES(7,2.3,1.1,2.1,0.3,'expediat',20.0,5,'1411205432545');
INSERT INTO Pachet VALUES(8,2.3,1.1,2.1,0.3,'expediat',20.0,6,'2990101350654');
INSERT INTO Pachet VALUES(9,2.3,1.1,2.1,0.3,'expediat',20.0,7,'1810204123456');
INSERT INTO Pachet VALUES(10,2.3,1.1,2.1,0.3,'expediat',20.0,17,'1820621043923');
INSERT INTO Pachet VALUES(11,2.3,1.1,2.1,0.3,'expediat',20.0,9,'1990927278427');
INSERT INTO Pachet VALUES(12,2.3,1.1,2.1,0.3,'expediat',20.0,10,'2871204162295');
INSERT INTO Pachet VALUES(13,2.3,1.1,2.1,0.3,'expediat',20.0,11,'1901127359570');
INSERT INTO Pachet VALUES(14,2.3,1.1,2.1,0.3,'expediat',20.0,12,'1820621043923');
INSERT INTO Pachet VALUES(15,2.3,1.1,2.1,0.3,'expediat',20.0,13,'1950727278427');
INSERT INTO Pachet VALUES(16,2.3,1.1,2.1,0.3,'expediat',20.0,14,'2601004162295');
INSERT INTO Pachet VALUES(17,2.3,1.1,2.1,0.3,'expediat',20.0,15,'1921027359570');
INSERT INTO Pachet VALUES(18,2.3,1.1,2.1,0.3,'expediat',20.0,16,'1710907314175');
INSERT INTO Pachet VALUES(19,2.3,1.1,2.1,0.3,'expediat',20.0,18,'2741204456654');


INSERT INTO Pachet VALUES(20,2.3,1.1,2.1,0.3,'in curs',15.0,19,'2963205678987');
INSERT INTO Pachet VALUES(21,2.3,1.1,2.1,0.3,'in curs',15.0,19,'1632541567345');
INSERT INTO Pachet VALUES(22,2.3,1.1,2.1,0.3,'expediat',15.0,24,'1411205432545');
INSERT INTO Pachet VALUES(23,2.3,1.1,2.1,0.3,'expediat',15.0,30,'2990101350654');
INSERT INTO Pachet VALUES(24,2.3,1.1,2.1,0.3,'expediat',20.0,20,'1950727278427');
INSERT INTO Pachet VALUES(25,2.3,1.1,2.1,0.3,'expediat',20.0,21,'1901127359570');
INSERT INTO Pachet VALUES(26,2.3,1.1,2.1,0.3,'expediat',20.0,22,'1990927278427');
INSERT INTO Pachet VALUES(27,2.3,1.1,2.1,0.3,'expediat',20.0,23,'2871204162295');
INSERT INTO Pachet VALUES(28,2.3,1.1,2.1,0.3,'expediat',20.0,25,'1632541567345');
INSERT INTO Pachet VALUES(29,2.3,1.1,2.1,0.3,'expediat',20.0,27,'2990101350654');
INSERT INTO Pachet VALUES(30,2.3,1.1,2.1,0.3,'expediat',20.0,28,'1820621043923');
INSERT INTO Pachet VALUES(31,2.3,1.1,2.1,0.3,'expediat',20.0,29,'1411205432545');
INSERT INTO Pachet VALUES(32,2.3,1.1,2.1,0.3,'expediat',20.0,26,'1820621043923');
INSERT INTO Pachet VALUES(33,2.3,1.1,2.1,0.3,'expediat',20.0,31,'2741204456654');
INSERT INTO Pachet VALUES(34,2.3,1.1,2.1,0.3,'expediat',20.0,32,'1710907314175');
INSERT INTO Pachet VALUES(35,2.3,1.1,2.1,0.3,'expediat',20.0,33,'1411205432545');
INSERT INTO Pachet VALUES(36,2.3,1.1,2.1,0.3,'expediat',20.0,34,'2990101350654');
INSERT INTO Pachet VALUES(37,2.3,1.1,2.1,0.3,'expediat',20.0,35,'1810204123456');





INSERT INTO Factura VALUES(1,40.0,13.0,30.0,1,42395);
INSERT INTO Factura VALUES(2,20.0,0.0,20.0,2,32365);
INSERT INTO Factura VALUES(3,20.0,0.0,20.0,3,12587);
INSERT INTO Factura VALUES(4,20.0,0.0,20.0,4,61233);
INSERT INTO Factura VALUES(5,20.0,0.0,20.0,5,32365);
INSERT INTO Factura VALUES(6,20.0,0.0,20.0,6,28564);
INSERT INTO Factura VALUES(7,20.0,0.0,20.0,7,32365);
INSERT INTO Factura VALUES(8,20.0,0.0,20.0,9,61233);
INSERT INTO Factura VALUES(9,20.0,0.0,20.0,10,28564);
INSERT INTO Factura VALUES(10,20.0,0.0,20.0,11,28564);
INSERT INTO Factura VALUES(11,20.0,0.0,20.0,12,32365);
INSERT INTO Factura VALUES(12,20.0,0.0,20.0,13,12587);
INSERT INTO Factura VALUES(13,20.0,0.0,20.0,14,32365);
INSERT INTO Factura VALUES(14,20.0,0.0,20.0,15,42395);
INSERT INTO Factura VALUES(15,20.0,0.0,20.0,16,32365);
INSERT INTO Factura VALUES(16,20.0,0.0,20.0,17,12587);
INSERT INTO Factura VALUES(17,20.0,0.0,20.0,18,28564);

INSERT INTO Factura VALUES(18,20.0,0.0,20.0,19,28564);
INSERT INTO Factura VALUES(19,40.0,13.0,30.0,20,32365);
INSERT INTO Factura VALUES(20,20.0,0.0,20.0,21,42395);
INSERT INTO Factura VALUES(21,20.0,0.0,20.0,22,32365);
INSERT INTO Factura VALUES(22,20.0,0.0,20.0,23,12587);
INSERT INTO Factura VALUES(23,20.0,0.0,20.0,24,32365);
INSERT INTO Factura VALUES(24,20.0,0.0,20.0,25,28564);
INSERT INTO Factura VALUES(25,20.0,0.0,20.0,26,28564);
INSERT INTO Factura VALUES(26,20.0,0.0,20.0,27,32365);
INSERT INTO Factura VALUES(27,20.0,0.0,20.0,28,61233);
INSERT INTO Factura VALUES(28,20.0,0.0,20.0,29,28564);
INSERT INTO Factura VALUES(29,20.0,0.0,20.0,30,28564);
INSERT INTO Factura VALUES(30,20.0,0.0,20.0,31,28564);
INSERT INTO Factura VALUES(31,20.0,0.0,20.0,32,12587);
INSERT INTO Factura VALUES(32,20.0,0.0,20.0,33,42395);
INSERT INTO Factura VALUES(33,20.0,0.0,20.0,34,32365);
INSERT INTO Factura VALUES(34,20.0,0.0,20.0,35,12587);





INSERT INTO Cursa VALUES(1,'04-05-16' , 10,58);
INSERT INTO Cursa VALUES(2,'04-05-16' ,9,55);
INSERT INTO Cursa VALUES(3,'04-05-16' , 7,50);
INSERT INTO Cursa VALUES(4,'04-05-16' , 10,60);
INSERT INTO Cursa VALUES(5,'07-05-16' , 9,79);
INSERT INTO Cursa VALUES(6,'07-05-16' , 7,53);
INSERT INTO Cursa VALUES(7,'07-05-16' , 10,57);
INSERT INTO Cursa VALUES(8,'30-11-15' , 10,58);
INSERT INTO Cursa VALUES(9,'30-11-15' , 8,48);
INSERT INTO Cursa VALUES(10,'30-11-15' , 10,59);
INSERT INTO Cursa VALUES(11,'05-12-15' , 10,61);
INSERT INTO Cursa VALUES(12,'05-12-15' , 5,40);
INSERT INTO Cursa VALUES(13,'14-10-15' , 10,58);
INSERT INTO Cursa VALUES(14,'14-10-15' , 9,56);
INSERT INTO Cursa VALUES(15,'14-10-15' , 3,20);

INSERT INTO Cursa VALUES(16,'04-05-16' , 10,59);
INSERT INTO Cursa VALUES(17,'04-05-16' ,9,56);
INSERT INTO Cursa VALUES(18,'04-05-16' , 7,28);
INSERT INTO Cursa VALUES(19,'04-05-16' , 10,65);
INSERT INTO Cursa VALUES(20,'07-05-16' , 9,62);
INSERT INTO Cursa VALUES(22,'07-05-16' , 7,52);
INSERT INTO Cursa VALUES(23,'07-05-16' , 10,61);
INSERT INTO Cursa VALUES(24,'30-11-15' , 10,61);
INSERT INTO Cursa VALUES(25,'30-11-15' , 8,32);
INSERT INTO Cursa VALUES(26,'30-11-15' , 10,69);
INSERT INTO Cursa VALUES(27,'05-12-15' , 10,69);
INSERT INTO Cursa VALUES(28,'05-12-15' , 5,23);
INSERT INTO Cursa VALUES(29,'14-10-15' , 10,70);
INSERT INTO Cursa VALUES(30,'14-10-15' , 9,59);
INSERT INTO Cursa VALUES(31,'14-10-15' , 3,23);






INSERT INTO Planificare VALUES (99653,1,1,1);
INSERT INTO Planificare VALUES (13651,2,2,2);
INSERT INTO Planificare VALUES (26253,3,3,3);
INSERT INTO Planificare VALUES (53215,4,4,4);
INSERT INTO Planificare VALUES (38541,4,5,5);
INSERT INTO Planificare VALUES (99653,5,6,6);
INSERT INTO Planificare VALUES (49654,6,7,7);
INSERT INTO Planificare VALUES (87854,7,8,8);
INSERT INTO Planificare VALUES (38541,8,9,9);
INSERT INTO Planificare VALUES (13651,9,10,10);
INSERT INTO Planificare VALUES (26253,10,11,11);
INSERT INTO Planificare VALUES (53215,11,12,12);
INSERT INTO Planificare VALUES (26253,12,13,13);
INSERT INTO Planificare VALUES (63954,13,14,14);
INSERT INTO Planificare VALUES (13651,14,15,15);
INSERT INTO Planificare VALUES (38541,15,16,16);
INSERT INTO Planificare VALUES (13651,1,17,17);
INSERT INTO Planificare VALUES (38541,2,18,18);
INSERT INTO Planificare VALUES (26253,3,19,19);
INSERT INTO Planificare VALUES (63954,4,20,20);
INSERT INTO Planificare VALUES (87854,5,20,21);
INSERT INTO Planificare VALUES (38541,1,22,22);
INSERT INTO Planificare VALUES (13651,6,23,23);
INSERT INTO Planificare VALUES (49654,6,24,24);
INSERT INTO Planificare VALUES (72325,7,25,25);
INSERT INTO Planificare VALUES (26253,8,26,26);
INSERT INTO Planificare VALUES (99653,9,27,27);
INSERT INTO Planificare VALUES (38541,10,28,28);
INSERT INTO Planificare VALUES (72325,12,29,29);
INSERT INTO Planificare VALUES (26253,15,30,30);
INSERT INTO Planificare VALUES (13651,14,1,31);
INSERT INTO Planificare VALUES (49654,13,12,32);
INSERT INTO Planificare VALUES (72325,2,14,33);
INSERT INTO Planificare VALUES (26253,1,17,34);
INSERT INTO Planificare VALUES (49654,9,12,35);
INSERT INTO Planificare VALUES (72325,4,15,36);
INSERT INTO Planificare VALUES (26253,1,18,37);
