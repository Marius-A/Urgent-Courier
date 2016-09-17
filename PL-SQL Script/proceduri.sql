--1. Sa se creeze o procedura care sterge toate datele unui client al carui id este dat ca parametru.

CREATE OR REPLACE PROCEDURE removeClient(p_nrLeg IN Client.Id_client%Type )
IS
	BEGIN 
		DELETE FROM Comanda
		WHERE Id_client=p_nrLeg ;
		DELETE FROM Persoana_expeditoare 
		WHERE Id_client=p_nrLeg ;
		DELETE FROM Companie 
		WHERE nrLeg=p_nrLeg ;
		DELETE FROM client
		WHERE nrLeg=p_nrLeg ;
	END 
	--apel
	BEGIN
	removeClient('3256') ;
	END
	
	
--2. Sa se creeze o procedura care actualizeaza numele unei compani din baza de date

CREATE OR REPLACE PROCEDURE renameCompany(numeVechi IN Companie.Nume%Type , numeNou IN Companie.Nume%Type)
IS
	BEGIN 
		UPDATE Companie
			SET Nume=numeNou 
		WHERE Nume=numeVechi;

	END 
	--apel
	BEGIN
	renameCompany('D & D MEDIA SRL', ' D & D MEDIA REBRANDED');
	END
	
--3. Sa se creeze actualizeaza salatriul cu un anumit procent ,  unui angajat , cu un anumit id

CREATE OR REPLACE PROCEDURE updateSalary(id_ang IN Angajat.Id_angajat%Type , procent IN number)
IS

old_salary number;

	BEGIN 
		Select TO_NUMBER(Angajat.Salariu) into old_salary FROM Angajat Where Angajat.Id_angajat = id_ang ;
	
		UPDATE Angajat 
                    SET Angajat.Salariu=old_salary+(old_salary*procent/100)
		WHERE Angajat.Id_angajat=id_ang;

	END 
--apel
BEGIN
updateSalary(26253 , 20);
END	