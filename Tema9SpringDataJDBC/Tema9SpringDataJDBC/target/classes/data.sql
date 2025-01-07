DROP TABLE IF EXISTS masini;

CREATE TABLE masini (
    nr_inmatriculare varchar(10) primary key ,
    marca varchar(45),
    an_fabricatie integer,
    culoare varchar(45),
    nr_kilometrii integer
);

insert into masini (nr_inmatriculare, marca, an_fabricatie, culoare, nr_kilometrii) values ("B45FFF", "Peugeout", 2011, "Gri", 250000);
insert into masini (nr_inmatriculare, marca, an_fabricatie, culoare, nr_kilometrii) values ("Ar45XYZ", "Dacia", 2007, "Gri", 380125);
insert into masini (nr_inmatriculare, marca, an_fabricatie, culoare,nr_kilometrii) values ("Ar88KLP", "Ford", 2002, "Gri", 150000);
