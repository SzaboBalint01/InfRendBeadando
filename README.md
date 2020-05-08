# Informatikai Rendszerek Építése Beadandó 
# SZABÓ BÁLINT - COUDEM

# Felhasznált eszközök
Jboss Wildfly 12
MySQL 8.0
Primefaces JSF 8.0


# Architektúra

A feladatok tipikusan olyan alkalmazások példái, ahol egy cég, vagy szervezet ügyfeleinek és eszközeinek közös nyilvántartását kell megoldani. Az elkészült szoftver JBoss EAP vagy JBoss Wildfly alkalmazás legyen JSF (Primefaces keretrendszer felhasználásával):

-   Adatbázis: JDBC alapú relációs adatbázis, lehet MySQL, de lehet a JBoss beépített Hypersonic adatbázis kezelője 

Az alkalmazottaknak nem szükséges azonosítani magukat az adatbázis elérésénél, és minden alkalmazott ugyan olyan felhasználói jogokkal rendelkezik.

## Feladat: 4. Autókölcsönző nyilvántartás

### Általános leírás

A cél, egy képzeletbeli autókölcsönzők munkáját segítő szoftver tervezése és implementálása. A kölcsönzőben 4 kerekű és vizi járműveket lehet kölcsönözni. Az alkalmazást a kölcsönző vezetője és dolgozói használják a kölcsönzések menedzselésére, a kölcsönzési díj kiszámítására, az esetleges sérülések regisztrálására.

#### Felhasználási esetek

##### Ügyfelek nyílvántartása

Csak az kölcsönözhet, akit a rendszerben nyílvántartásba vettek. Név, cím, igazolványszám, telefon, stb megadása kötelező.

##### Készletnyílvántartás

A rendszer nyílvántartja a kölönböző járművek adatait: pl. típus, gyártó, rendszám, alvázszám, beszerzés dátuma, sorszám, kölcsönzési díj, futott km díj, státusz (szabad, kikölcsönzött, selejtezett). Itt lehet az új járműveket nyílvántartásba venni. A kölcsönző járműveit lehet listázni, keresni típus, rendszám szerint. Meg lehet tekinteni melyik járművet kölcsönözték ki éppen és melyik szabad.

##### Kölcsönzés

A kölcsönzéshez szükséges egy ügyfél létrehozása. A kölcsönzéskor egy adott ügyfélhez rendeljük a kölcsönzött jármű azonosítóját. Egy ügyfél több járművet is kölcsönözhet egyszerre. (pl. ha az ügyfél egy cég)

##### Kölcsönzés befejezése

A kölcsönvett járművet visszahozzák. A kölcsönzési díj kiszámítása ilyenkor történik. A díj, napi alapon kerül meghatározásra, ehhez hozzáadódik a futott kilométerdíj. Ha az autó sérülten érkezik vissza, akkor a kölcsönzési díj egy előre megadott összeggel nő. (mivel a többi kárt a biztosító fizeti)
