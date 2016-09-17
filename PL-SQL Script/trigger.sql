CREATE OR REPLACE TRIGGER Print_salary_changes
AFTER DELETE OR INSERT OR UPDATE ON Angajat
FOR EACH ROW
Declare
	sal_dif number;

BEGIN
	sal_dif := :NEW.Salariu - :OLD.Salariu;	
	DBMS_OUTPUT.PUT_LINE('Salariu Vechi : ' || :OLD.Salariu || ' lei');	
	DBMS_OUTPUT.PUT_LINE('Salariu Nou : ' || :NEW.Salariu || ' lei');	
	DBMS_OUTPUT.PUT_LINE('Diferenta : ' || sal_dif || ' lei');	
END;

UPDATE Angajat
SET Salariu=256
WHERE CNP_Angajat='2861103350654';