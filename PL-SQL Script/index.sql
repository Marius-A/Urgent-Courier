--Sa se indexeze tabelul Vehicul dupa numarul de inmatriculare
CREATE INDEX index_veh_nr_inmatriculare
ON Vehicul(Nr_inmatriculate)

--Sa se indexeze tabelul Angajat dupa CNP-UL fiecaruia
CREATE INDEX index_ang_cnp
ON Angajat(CNP_Angajat)

--Sa se indexeze tabelul Companie dupa numarul de telefon
CREATE INDEX index_companie_nr_tel
ON Companie(Numar_telefon)

--Sa se indexeze tabelul Companie dupa nume si email
CREATE INDEX index_companie_ne
ON Companie(Nume, Email)