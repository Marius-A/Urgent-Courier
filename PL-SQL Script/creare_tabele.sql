CREATE TABLE Adresa_sediu(
	Id_adresa int,
	Judet VARCHAR(20) NOT NULL,
	Oras VARCHAR(20) NOT NULL,
	Strada VARCHAR(60) NOT NULL,
	Numar int NOT NULL,
	Bloc VARCHAR(10) DEFAULT '-',
	Apartament VARCHAR(3) DEFAULT '-',
	Scara VARCHAR(3) DEFAULT '-',
	PRIMARY KEY(Id_adresa)
);

CREATE TABLE Sediu(
	Id_sediu int,
	Id_adresa int REFERENCES Adresa_sediu(Id_adresa) ON DELETE CASCADE ON UPDATE CASCADE ,
	PRIMARY KEY(Id_sediu)
);

CREATE TABLE Persoana(
	CNP VARCHAR(13) PRIMARY KEY,
	Nume  VARCHAR(20) NOT NULL,
	Prenume  VARCHAR(20) NOT NULL,
	Email VARCHAR(50) NOT NULL UNIQUE,
	Nr_telefon VARCHAR(15) NOT NULL
);

ALTER TABLE Persoana ADD CHECK (length(CNP) >= 13 AND length(CNP) < 14 AND length(Nume) >= 3 AND length(Prenume) >= 3 );
ALTER tABLE Persoana ADD CHECK (Email LIKE '%@%.%' AND Email NOT LIKE '@%' AND Email NOT LIKE '%@%@%');



CREATE TABLE Adresa_angajat(
	Id_adresa int,
	Judet VARCHAR(20) NOT NULL,
	Oras VARCHAR(20) NOT NULL,
	Strada VARCHAR(60) NOT NULL,
	Numar int NOT NULL,
	Bloc VARCHAR(10) DEFAULT '-',
	Apartament VARCHAR(3) DEFAULT '-',
	Scara VARCHAR(3) DEFAULT '-',
	PRIMARY KEY(Id_adresa)
);

CREATE TABLE Angajat(
	Id_angajat int ,
	CNP_Angajat VARCHAR(13) NOT NULL,
	Id_sediu int ,
	Id_adresa int REFERENCES Adresa_angajat(Id_adresa) ON DELETE CASCADE ON UPDATE CASCADE ,
	PRIMARY KEY (Id_angajat)
);

ALTER TABLE Angajat ADD CONSTRAINT fk_AngCnp FOREIGN KEY (CNP_Angajat) REFERENCES Persoana(CNP)  ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Angajat ADD CONSTRAINT fk_Angidsediu FOREIGN KEY (Id_sediu) REFERENCES Sediu(Id_sediu)  ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Angajat ADD Salariu float;


CREATE TABLE Curier(
	Id_angajat int REFERENCES Angajat(Id_angajat) ON DELETE CASCADE ,
	Tip_permis VARCHAR(20) NOT NULL CHECK (Tip_permis= 'A' OR Tip_permis= 'B' OR Tip_permis= 'C' OR Tip_permis= 'D' OR Tip_permis= 'E'),
	Ani_experienta int NOT NULL
);

ALTER TABLE Curier ADD PRIMARY KEY (Id_angajat);



CREATE TABLE Receptioner(
	Id_angajat int PRIMARY KEY REFERENCES Angajat(Id_angajat) ON DELETE CASCADE
);



CREATE TABLE Vehicul(
	Id_vehicul int ,
	Nr_inmatriculate  VARCHAR(50) NOT NULL UNIQUE,
	Consum_mediu float,
	Capacitate float,
	CategorieNecesara VARCHAR(20) NOT NULL CHECK( CategorieNecesara= 'A' OR CategorieNecesara= 'B' OR CategorieNecesara= 'C' OR CategorieNecesara= 'D' OR CategorieNecesara= 'E'),
	Stare_tehnica VARCHAR(50) CHECK( Stare_tehnica = 'uzata' OR  Stare_tehnica = 'noua'  OR  Stare_tehnica = 'ok'),
	PRIMARY KEY(Id_vehicul)
);

CREATE TABLE Detine(
	Id_vehicul int REFERENCES Vehicul(Id_vehicul) ON DELETE CASCADE ,
	Id_sediu   int REFERENCES Sediu(Id_sediu) ON DELETE CASCADE ,
	Data_detinere DATE NOT NULL
)


CREATE TABLE Client(
	Id_client int ,
	Tip_client VARCHAR(20) NOT NULL CHECK(Tip_client = 'nou' OR Tip_client = 'fidel'),
	NumarComenzi int,
	PRIMARY KEY(Id_client)
);

CREATE TABLE Persoana_expeditoare(
	CNP VARCHAR(13) REFERENCES Persoana(CNP) ON DELETE CASCADE ON UPDATE CASCADE,
	ID_client int REFERENCES Client(Id_client) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Companie(
	CUI VARCHAR(50),
	Nume VARCHAR(20) NOT NULL UNIQUE,
	Email VARCHAR(20) NOT NULL UNIQUE,
	Numar_telefon VARCHAR(20) NOT NULL UNIQUE,
	ID_client int REFERENCES Client(Id_client) ON DELETE CASCADE ON UPDATE CASCADE,
	PRIMARY KEY(CUI)
);


CREATE TABLE Adresa_destinatar(
	Id_adresa int ,
	Judet VARCHAR(20),
	Oras VARCHAR(20),
	Strada VARCHAR(60),
	Numar int,
	Bloc VARCHAR(10) DEFAULT '-',
	Apartament VARCHAR(3) DEFAULT '-',
	Scara VARCHAR(3) DEFAULT '-',
	PRIMARY KEY(Id_adresa)
);


CREATE TABLE Destinatar(
	CNP_Destinatar VARCHAR(13) REFERENCES Persoana(CNP) ON DELETE CASCADE ON UPDATE CASCADE
	Id_adresa int REFERENCES Adresa_destinatar(Id_adresa) ON DELETE CASCADE ON UPDATE CASCADE 
);

ALTER TABLE Destinatar ADD PRIMARY KEY (CNP_Destinatar);




CREATE TABLE Comanda(
	Id_comanda int,
	Data_preluare DATE NOT NULL,
	Data_expediere DATE NOT NULL,
	Numar_produse int,
	Valoare_totala float NOT NULL,
	Id_client int NOT NULL REFERENCES Client(Id_client) ON DELETE CASCADE ON UPDATE CASCADE,
	PRIMARY KEY (Id_comanda)
);
ALTER TABLE Pachet ADD CONSTRAINT CHECK( Numar_produse => 1 AND Valoare_totala >0);
alter session set nls_date_format = 'DD-MM-YY';


CREATE TABLE Pachet(
	Id_pachet int,
	Greutate float NOT NULL,
	Lungime float NOT NULL,
	Latime float NOT NULL,
	Inaltime float NOT NULL,
	Stare VARCHAR(10) NOT NULL,
	Cost_transport float NOT NULL,
	Id_comanda int NOT NULL REFERENCES Comanda(Id_comanda) ON DELETE CASCADE ,
	Id_destinatar VARCHAR(13) NOT NULL REFERENCES Destinatar(CNP_Destinatar) ON DELETE CASCADE ,
	PRIMARY KEY (Id_pachet)
);

ALTER TABLE Pachet ADD CONSTRAINT CHECK( Greutate > 0 AND Lungime > 0 AND Inaltime > 0AND Cost_transport > 0);



CREATE TABLE Factura(
	Cod_factura int,
	Valoare_efectiva float NOT NULL,
	Valoare_discount float NOT NULL,
	Valoare_totala float NOT NULL,
	Id_comanda int NOT NULL REFERENCES Comanda(Id_comanda) ON DELETE CASCADE ,
	Id_receptioner int NOT NULL REFERENCES Receptioner(Id_angajat) ON DELETE CASCADE,
	PRIMARY KEY(Cod_factura)
);

CREATE TABLE Cursa(
	Id_cursa int ,
	Data_plecare DATE NOT NULL,
	Durata_estimativa int , /*in ore*/
	Numar_kilometri int,
	Primary KEY(Id_cursa)
);


CREATE TABLE Planificare(
	Id_curier int NOT NULL REFERENCES Curier(Id_angajat) ON DELETE CASCADE,
	Id_vehicul int NOT NULL REFERENCES Vehicul(Id_vehicul) ON DELETE CASCADE,
	Id_cursa int NOT NULL REFERENCES Cursa(Id_cursa) ON DELETE CASCADE,
	Id_pachet int NOT NULL REFERENCES Pachet(Id_pachet) ON DELETE CASCADE
);



