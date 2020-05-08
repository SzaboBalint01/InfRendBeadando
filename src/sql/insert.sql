INSERT INTO `bead_db`.`jarmu`
(`idjarmu`,`tipus`,`rendszam`,`gyarto`,`alvazszam`,`beszerzesidatum`,`kolcsonzesidij`,`futottkmdij`,`statusz`) 
VALUES (345,"KA_mini","HKB-661","FORD","1G1ZC5E08CF148007",'2020-01-09',5000,100,0);
INSERT INTO `bead_db`.`jarmu`
(`tipus`,`rendszam`,`gyarto`,`alvazszam`,`beszerzesidatum`,`kolcsonzesidij`,`futottkmdij`,`statusz`) 
VALUES ("Spark","312-NSN","Chevrolet","KNDJF723X67268993",'2020-02-10',5100,95,1);
INSERT INTO `bead_db`.`jarmu`
(`tipus`,`rendszam`,`gyarto`,`alvazszam`,`beszerzesidatum`,`kolcsonzesidij`,`futottkmdij`,`statusz`) 
VALUES ("Wagon","ACR-101","Suzuki","5UXWX5C58CL719234",'2020-02-21',4950,105,0);
INSERT INTO `bead_db`.`jarmu`
(`tipus`,`rendszam`,`gyarto`,`alvazszam`,`beszerzesidatum`,`kolcsonzesidij`,`futottkmdij`,`statusz`) 
VALUES ("Swift","AEK-950","Suzuki","1J8FT28W68D760789",'2020-04-08',4500,115,2);
INSERT INTO `bead_db`.`jarmu`
(`tipus`,`rendszam`,`gyarto`,`alvazszam`,`beszerzesidatum`,`kolcsonzesidij`,`futottkmdij`,`statusz`) 
VALUES ("742CU","H-12421","Bayliner","1G1PA5SH0E7260515",'2020-04-17',20000,200,1);
INSERT INTO `bead_db`.`jarmu`
(`tipus`,`rendszam`,`gyarto`,`alvazszam`,`beszerzesidatum`,`kolcsonzesidij`,`futottkmdij`,`statusz`) 
VALUES ("Antares 6OB","H-12532","Beneteau","1HD1KB415AB626001",'2020-04-21',25000,250,0);

INSERT INTO `bead_db`.`ugyfel`(`idugyfel`,`szemelyiszam`,`nev`,`szulido`,`szulhely`,`cim`,`telefon`,`ceg`) 
VALUES (1,"RDWSU9GN","Halász Zsolt",'1962-11-03',"Budapest","Jakabháza Kis Diófa u. 56.","06 70 234 424",0);
INSERT INTO `bead_db`.`ugyfel`(`szemelyiszam`,`nev`,`szulido`,`szulhely`,`cim`,`telefon`,`ceg`) 
VALUES ("753V4B9E","Rácz Szabolcs",'1989-12-07',"Veszprém","Nemesvámos Rákóczi út 26.","06 20 115 141",0);
INSERT INTO `bead_db`.`ugyfel`(`szemelyiszam`,`nev`,`szulido`,`szulhely`,`cim`,`telefon`,`ceg`) 
VALUES ("IMWUNVZ2","Pásztor Balázs",'1988-08-21',"Miskolc","Nagybózsva Hegyalja út 34.", "06 70 194 847","Nemtudom kft.");
INSERT INTO `bead_db`.`ugyfel`(`szemelyiszam`,`nev`,`szulido`,`szulhely`,`cim`,`telefon`,`ceg`) 
VALUES ("C7NJZHFD","Szekeres Erzsébet",'1994-12-08',"Szeged","Bashalom Budaörsi út 4.","06 30 131 855",0);

INSERT INTO `bead_db`.`kolcsonzes` (`idkolcsonzes`,`kolcsonzesideje`,`jarmu`,`ugyfel`) 
VALUES(1,'2020-05-14',346,1);
INSERT INTO `bead_db`.`kolcsonzes` (`idkolcsonzes`,`kolcsonzesideje`,`jarmu`,`ugyfel`) 
VALUES(2,'2020-05-15',349,3);