### Viikko 4
Navigointi Jetpack Composessa tarkoittaa eri ruutujen (screenien) välistä siirtymistä sovelluksessa.

NavController: hallitsee sovelluksen nykyistä sijaintia ja tarjoaa funktiot, kuten navigate("route") ruutujen välillä liikkumiseen.

NavHost: määrittelee kaikki sovelluksen reitit ja niiden sisällön.

NavHost määrittelee kaksi reittiä: Home ja Calendar. NavController hallitsee, mikä ruutu näytetään milloinkin, ja mahdollistaa siirtymisen ruutujen välillä.

TaskViewModelia ei luoda screeneissä vaan se luodaan navigation komponentissa mistä se sitten annetaan jokaisen screenin käyttöön.

Kalenteri näkymä on toteutettu siten että kaikki tehtävät näkyy columnissa listana laskevan päivämäärän mukaan. Mikäli yhdelle päivälle on merkattu useampi tehtävä, ne näytetään allekkain sen päivän alla.
