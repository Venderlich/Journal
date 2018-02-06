CREATE TABLE Utilisateur(
    Login VARCHAR,
    Mdp VARCHAR
);

CREATE TABLE TypeDeCour(
    ID INTEGER  PRIMARY KEY,
    Label VARCHAR,
    Rapport INTEGER
);

CREATE TABLE Parametrage(
    VariableObjectif DOUBLE,
    VolumeHorraire DOUBLE
);

CREATE TABLE Matiere(
    ID INTEGER PRIMARY KEY,
    Label VARCHAR
);

CREATE TABLE Filiere(
    ID INTEGER PRIMARY KEY,
    Label VARCHAR,
    IDMatiere INTEGER,
    FOREIGN KEY(IDMatiere) REFERENCES Matiere(ID)
);

CREATE TABLE Seance(
    ID INTEGER PRIMARY KEY,
    Commentaire VARCHAR,
    dateSeance DATE,
    Temps INTEGER,
    Filiere INTEGER,
    TypeDeCourID INTEGER,
    FOREIGN KEY(filiere) REFERENCES Filiere(ID),
    FOREIGN KEY(TypeDeCourId) REFERENCES TypeDeCour(ID)
);