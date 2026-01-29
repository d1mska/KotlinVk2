##  Viikko 3

MVVM arkkitehtuuri jakaa sovelluksen kolmeen pääosaan:


1. Model: Sisältää kaikki sovelluksen tiedot. Ei tiedä käyttöliittymästä mitään.

2. View: Sovellukset käyttöliittymä. Lähettää käyttäjän tekemät toiminnot ViewModelille.

3. ViewModel: Välikerros UI:n ja Modelin välillä. Käsittelee käyttäjän toiminnot (View) ja päivittää datan (Model).


Stateflow pitää aina nykyisen arvon tallessa ja ilmoittaa kaikille functioille, kun sen arvo muuttuu.
