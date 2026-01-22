Viikko 2
Mockdata.kt tiedostosta saadaan listana valmiiksi syötettyä tietoa jotka on alustettu data classissa id: Int, title: String, description: String, priority: Int, dueDate: String, done: Boolean

Kaikki funktionaalisuus ja sovelluksen asettelu olen hoitanun function.kt tiedostossa, josta sitten exporttaan HomeScreen näkymän MainActivityyn. Tässä tehtävässä käytetään viewModelia joten function piti siirtää erilliseen viewModel kansioon.
Jetpack Compose toimii siten että sovellus piirtää ne osat sovelluksesta uudelleen, joiden tilat muuttuvat.
Remember säilyttää tilan recompositioiden ajan mutta hävittää tiedon konfiguraatiomuutoksissa (esim näytön kääntö).
ViewModel säilyttää datan ja UI-tilan, eikä Composable itse.
