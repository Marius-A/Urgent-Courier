--F1. Sa se scrie o functie care calculeaza cat a cheltuit un client pentru comenzile efectuate.
CREATE or REPLACE FUNCTION getAvgIncasari(f_nume IN VARCHAR2)
RETURN NUMBER
IS
	CURSOR f_suma
	IS
		SELECT suma FROM
		(
			Select AVG(Factura.Valoare_efectiva) AS suma From Factura NATURAL JOIN (
	SELECT * FROM Receptioner NATURAL JOIN (
		(SELECT * FROM Angajat INNER JOIN (
			(Select * From Sediu INNER JOIN Adresa_Sediu 
			ON(Sediu.Id_adresa = Adresa_Sediu.Id_adresa AND Adresa_Sediu.Oras = f_nume)) TmpSediu)
	ON(Angajat.Id_sediu = TmpSediu.Id_sediu))TmpAngajat))
	

		);
		f_value NUMBER;
	BEGIN

		OPEN f_suma;
		FETCH f_suma INTO f_value;
		CLOSE f_suma;
		RETURN f_value;

END getAvgIncasari;

---
DECLARE 
f_nume1 Adresa_sediu.Oras%TYPE:='Craiova' ;
f_nume2 Adresa_sediu.Oras%TYPE:='Slobozia' ;

BEGIN
	DBMS_OUTPUT.PUT_LINE('Valoarea medie a incasarilor de la sediul din '|| f_nume1 ||' este: '||getAvgIncasari(f_nume1));
	DBMS_OUTPUT.PUT_LINE('Valoarea medie a incasarilor de la sediul din '|| f_nume2 ||' este: '||getAvgIncasari(f_nume2));
END;




--F2. Sa se creeze o functie care sa returneze comenzi plasate intr-o anumita luna data ca parametru

CREATE OR REPLACE FUNCTION getCount(f_luna IN NUMBER  , f_an IN NUMBER )
RETURN NUMBER
IS
	CURSOR f_count
	IS
		SELECT Numar FROM
		(
			SELECT  COUNT(d.Id_comanda) AS Numar
			FROM comanda d 
			WHERE EXTRACT(month FROM d.Data_preluare) = f_luna AND
			EXTRACT(year FROM d.Data_preluare) = f_an
		);
		f_value NUMBER ;
	BEGIN
		OPEN f_count ;
		FETCH f_count INTO f_value ;
		CLOSE f_count ;
		RETURN f_value ;
END getCount;
		
DECLARE 
f_an1 NUMBER :=2015;
f_an2 NUMBER :=2016;
f_luna1 NUMBER :=5;
f_luna2 NUMBER :=6;
f_luna3 NUMBER :=11;
f_luna4 NUMBER :=10;

BEGIN
	DBMS_OUTPUT.PUT_LINE('In luna '|| f_luna1 ||' a anului  '||f_an2||' au fost plasate '||getCount(f_luna1,f_an2)||' comenzi.');
	DBMS_OUTPUT.PUT_LINE('In luna '|| f_luna2 ||' a anului  '||f_an2||' au fost plasate '||getCount(f_luna2,f_an2)||' comenzi.');
	DBMS_OUTPUT.PUT_LINE('In luna '|| f_luna3 ||' a anului  '||f_an1||' au fost plasate '||getCount(f_luna3,f_an1)||' comenzi.');
	DBMS_OUTPUT.PUT_LINE('In luna '|| f_luna4 ||' a anului  '||f_an1||' au fost plasate '||getCount(f_luna4,f_an1)||' comenzi.');
	DBMS_OUTPUT.PUT_LINE('In luna '|| f_luna1 ||' a anului  '||f_an1||' au fost plasate '||getCount(f_luna1,f_an1)||' comenzi.');

END;