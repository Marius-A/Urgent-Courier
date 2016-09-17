
/*1*/
Select COUNT(*) FROM Client INNER JOIN (
				(Select * From Comanda INNER JOIN Factura 
				ON(Comanda.Id_comanda = Factura.Id_comanda AND Factura.Valoare_discount>10) )TmpComenzi)
				ON(Client.Id_client=TmpComenzi.Id_client AND
				(EXTRACT(month FROM TmpComenzi.Data_preluare) = 5 OR 
				(EXTRACT(month FROM TmpComenzi.Data_preluare) = 10)));

/*2*/
Select AVG(Factura.Valoare_efectiva) From Factura NATURAL JOIN (
	SELECT * FROM Receptioner NATURAL JOIN (
		(SELECT * FROM Angajat INNER JOIN (
			(Select * From Sediu INNER JOIN Adresa_Sediu 
			ON(Sediu.Id_adresa = Adresa_Sediu.Id_adresa
			AND Adresa_Sediu.Oras = 'Craiova')) TmpSediu)
	ON(Angajat.Id_sediu = TmpSediu.Id_sediu))TmpAngajat));
	
	
/*3*/	
SELECT * FROM (SELECT Vehicul.Id_vehicul, Vehicul.Nr_inmatriculate ,
	Count(*) AS Nr_curse FROM Vehicul, Planificare 
	WHERE Vehicul.Id_vehicul=Planificare.Id_vehicul AND Vehicul.Stare_tehnica = 'noua' 
	GROUP BY Vehicul.Id_vehicul,Vehicul.Nr_inmatriculate
	ORDER BY COUNT(*)  DESC)tempVeh where tempVeh.Nr_curse 
		> (SELECT AVG(Average.num)   FROM (SELECT COUNT(*) As num 
		FROM  Planificare GROUP BY Planificare.Id_vehicul) Average)
		
/*4*/

Select Sediu.Id_sediu , Count(Detine.Id_sediu) 
	As Nr_masini_detinute from Sediu , Detine 
	Where Sediu.Id_sediu = Detine.Id_sediu  Group by Sediu.Id_sediu
Having Count(Detine.Id_sediu)>3


/*5*/

Select Client.Id_client , Companie.Nume , Companie.CUI 
	From Client , Companie 
	WHERE Client.Id_client = Companie.Id_client 
		AND Client.Tip_client = 'fidel' 
		AND Companie.Numar_telefon LIKE '0251%'
		
		
/*6*/
Select MIN(cli.num) FROM (
	Select COUNT(*)  AS num,EXTRACT(month FROM tmp.Data_preluare) As Luna 
	FROM ((SELECT DISTINCT * From Client, Comanda 
		WHERE Client.Id_client = Comanda.Id_client 
			And (EXTRACT(year FROM Comanda.Data_preluare) = 2015))tmp) 
	GROUP BY EXTRACT(month FROM tmp.Data_preluare))cli



/*7*/

SELECT AVG(tmp.monthf) AS Average FROM
        (SELECT TO_NUMBER(SUBSTR(Persoana_expeditoare.CNP, 4, 2) , '99') AS monthf ,
TO_NUMBER(SUBSTR(Persoana_expeditoare.CNP, 1, 1) , '99') AS gen  
FROM Persoana_expeditoare , Client
        WHERE Persoana_expeditoare.Id_client = Client.Id_client)tmp WHERE tmp.monthf = 3     
AND tmp.gen = 1;
		

/*8*/
Select Persoana.Nume , Persoana.Prenume , Destinatar.CNP_Destinatar, COUNT(*) AS Nr_pachete FROM Persoana , Destinatar , Pachet 
	WHERE Persoana.CNP = Destinatar.CNP_Destinatar And Destinatar.CNP_Destinatar = Pachet.Id_destinatar 
	GROUP BY Destinatar.CNP_Destinatar ,Persoana.Nume , Persoana.Prenume ;
	
/*9*/
Select AVG(Pachet.Greutate) AS Greutatea_medie FROM Pachet , Comanda WHERE EXTRACT(year FROM Comanda.Data_preluare) = (select to_char(sysdate, 'YYYY') from dual) 
			AND EXTRACT(month FROM Comanda.Data_preluare) = 5;
			
/*10*/
Select Persoana.Nume , Persoana.Prenume , Curier.Id_angajat , Curier.Ani_experienta FROM Persoana , Curier , Angajat 
		WHERE Persoana.CNP = Angajat.CNP_Angajat AND Angajat.Id_angajat = Curier.Id_angajat  AND Curier.Ani_experienta > 3;
		
/*11*/
Select Vehicul.Nr_inmatriculate , Vehicul.Id_vehicul FROM Vehicul 
	Where Vehicul.Id_vehicul NOT IN 
	(Select Planificare.Id_vehicul From Planificare INNER JOIN Cursa ON(Cursa.Id_cursa = Planificare.Id_cursa AND EXTRACT(year FROM Cursa.Data_plecare) = (select to_char(sysdate, 'YYYY') from dual) 
	AND  EXTRACT(month FROM Cursa.Data_plecare) > (SELECT MOD(TO_NUMBER(12+(to_char(sysdate, 'MM')-6) , 99),12)+1 FROM DUAL) )) GROUP BY Vehicul.Nr_inmatriculate , Vehicul.Id_vehicul;
	
/*12*/
Select jur.PC - fiz.PP FROM 
	((Select COUNT(*) AS PP from Persoana_expeditoare , Client , Comanda , Pachet 
		WHERE Persoana_expeditoare.Id_client = Client.Id_client AND Comanda.Id_client= Client.Id_client  AND Comanda.Id_comanda = Pachet.Id_comanda )fiz) ,
		
	((Select  COUNT(*) AS PC FROM Companie , Client , Comanda , Pachet 
		WHERE Companie.Id_client = Client.Id_client AND Comanda.Id_client= Client.Id_client  AND Comanda.Id_comanda = Pachet.Id_comanda )jur);
		
/*13*/
Select Persoana.Nume , Persoana.Prenume , Receptioner.Id_angajat  FROM Persoana , Angajat , Receptioner , Factura 
	WHERE Receptioner.Id_angajat = Angajat.Id_angajat AND Persoana.CNP = Angajat.CNP_Angajat AND 
	((SELECT * FROM (SELECT Factura.Id_receptioner FROM  Factura GROUP BY Factura.Id_receptioner 
	ORDER BY COUNT(*)  DESC) where rownum <= 1)=Receptioner.Id_angajat and rownum <= 1);
	
/*14*/
SELECT * FROM (Select Vehicul.Nr_inmatriculate , Vehicul.Id_vehicul , Vehicul.Consum_mediu FROM Vehicul ORDER BY Vehicul.Consum_mediu DESC ) where rownum <= 3


/*15*/
Select * FROM (
Select Pachet.Id_pachet , (2*Pachet.Lungime*Pachet.Inaltime + Pachet.Latime*Pachet.Inaltime + Pachet.Latime*Pachet.Lungime) AS Arie FROM Pachet  ORDER BY Arie DESC ) 
where rownum <= 5


/*16*/
SELECT Oras FROM Adresa_sediu
UNION
SELECT Oras FROM Adresa_angajat
UNION
SELECT Oras FROM Adresa_destinatar
Order by Oras

/*17*/


