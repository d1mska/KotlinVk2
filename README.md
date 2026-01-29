Viikko 3


MVVM arkkitehtuuri jakaa sovelluksen kolmeen pääosaan:


Model:     Sisältää kaikki sovelluksen tiedot. Ei tiedä käyttöliittymästä mitään.

View:      Sovellukset käyttöliittymä. Lähettää käyttäjän tekemät toiminnot ViewModelille.

ViewModel: Välikerros UI:n ja Modelin välillä. Käsittelee käyttäjän toiminnot (View) ja päivittää datan (Model).


Stateflow pitää aina nykyisen arvon tallessa ja ilmoittaa kaikille functioille, kun sen arvo muuttuu.
