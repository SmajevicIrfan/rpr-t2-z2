# RPR Tutorijal 2 2018/2019. Zadatak 2

Na osnovu testova napisati kod.

Potrebno je napraviti klasu Interval koja omogućuje izračunavanje presjeka dva intervala, te provjeru da li se tačka nalazi unutar intervala ili ne.

Klasa treba imati:
- Konstruktor sa četiri parametra: početna tačka, krajnja tačka (obje tipa double), boolean vrijednost koja označava da li početna tačka pripada intervalu ili ne, te isto i za krajnju tačku;
u slučaju da je početna tačka veća od krajnje treba baciti izuzetak tipa IllegalArgumentException
- Konstruktor bez parametara koji kreira "null interval" kod kojeg su početna i krajnja tačka 0 i niti jedna od njih ne pripada intervalu
- isNull koja vraća boolean vrijednost da li je interval null interval ili nije
- isIn metoda koja prima vrijednost tačke (tipa double) i vraća da li tačka pripada intervalu
- Metodu intersect koja vraća presjek dva intervala: metoda treba biti urađena kao klasična public metoda (prima jedan interval) i kao statička metoda (prima dva intervala);

Također treba preklopiti metode klase Object, a to su toString i equals, na način koji ima smisla za te metode.
