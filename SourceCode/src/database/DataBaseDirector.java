package database;

import java.util.List;

import databaseContent.Mountain;

public class DataBaseDirector {

	private DataBaseBuilder b;
	private List<Mountain> mountains;

	public DataBaseDirector() {

	}

	public DataBaseDirector(int height) {

		b = new DataBaseBuilder();

		/*
		 * b.insertMountain("Mount Everest", "Himalaje", 8848,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\1.jpg",
		 * "Mount Everest, Czomolungma – najwyższy szczyt Ziemi (8848 m n.p.m., podaje się też wysokość 8844 (pomiary chińskie) lub 8850 (pomiary amerykańskie)), ośmiotysięcznik położony w Himalajach Wysokich (Centralnych), na granicy Nepalu i Chińskiej Republiki Ludowej (Tybetu). Często jest nazywany również Dachem Świata."
		 * );
		 * 
		 * 
		 * b.insertMountain("K2", "Karakorum", 8611,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\2.jpg",
		 * "Ośmiotysięcznik, najwyższy szczyt Karakorum, drugi co do wysokości szczyt Ziemi. Znajduje się na granicy Chin i Pakistanu, jednak Indie wciąż zgłaszają pretensje do całego Kaszmiru, uważając się tym samym również za administratora K2. Z map jednak wynika, że leży on na terenie Pakistanu. Jest to jedyny ośmiotysięcznik dotąd (początek 2018 r.) niezdobyty zimą. Zimą panują bowiem na nim ekstremalne warunki: średnia temperatura w granicach -45°C - -55°C oraz wiatry o średniej prędkości 180 km/h (w porywach nawet 500 km/h)."
		 * );
		 * 
		 * b.insertMountain("Kanczendzonga", "Himalaje", 8586,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\3.jpg",
		 * "Ośmiotysięcznik, drugi co do wysokości szczyt w Himalajach, trzeci co do wysokości szczyt Ziemi, o wysokości 8586 m n.p.m. (według innych źródeł główny wierzchołek liczy 8598 m n.p.m.). Kanczendzonga jest górą trudną, po Annapurnie i Lhotse zanotowano tu najmniej wejść spośród ośmiotysięczników – do końca 2000 udokumentowano 162 wejścia, śmierć poniosło 39 wspinaczy, m.in. Andrzej Czok, czy Wanda Rutkiewicz."
		 * );
		 * 
		 * b.insertMountain("Lhotse", "Himalaje", 8516,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\4.jpg",
		 * "Lhotse – ośmiotysięcznik o wysokości 8516 m n.p.m., czwarty co do wysokości szczyt Ziemi, znajduje się w środkowej części Himalajów Wysokich, na granicy Nepalu i Chin."
		 * );
		 * 
		 * b.insertMountain("Makalu", "Himalaje", 8485,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\5.jpg",
		 * "Makalu – ośmiotysięcznik, piąty co do wysokości szczyt świata. Położony w Himalajach Wysokich, na granicy Chin i Nepalu, 20 km na południowy wschód od Mount Everestu. Osiąga wysokość 8481 m n.p.m., a jego południowa ściana ma 2500 metrów wysokości. Silnie zlodowacony – granica wiecznego śniegu powyżej 5700 m n.p.m. Makalu posiada drugi, niższy wierzchołek – Makalu II (lub Kangchungtse) o wysokości 7678 m."
		 * );
		 * 
		 * b.insertMountain("Czo Oju", "Himalaje", 8201,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\6.jpg",
		 * "Czo Oju (8188 lub 8201 m n.p.m.) – ośmiotysięcznik w głównej grani Himalajów Wysokich, na północny zachód od Mount Everestu, na granicy chińsko-nepalskiej. Indyjska Służba Topograficzna, mimo wykonania przez Brytyjczyków ogromu prac geodezyjnych podczas pomiarów Indii, nie przypisała Czo Oju żadnego numeru. Wydawało się bowiem, że góra ta jest niższa w porównaniu z gigantami widniejącymi na horyzoncie Nepalu od Makalu aż po Dhaulagiri. Szczyt opada w kierunku południowo-wschodnim stromą ścianą o wysokości 2800 metrów. Wysokość względna góry wynosi do około 3,5 kilometra. Jest najłatwiejszym technicznie do zdobycia ze wszystkich czternastu ośmiotysięczników. Odsetek wypadków śmiertelnych jest na nim najniższy ze wszystkich gór ośmiotysięcznych."
		 * );
		 * 
		 * b.insertMountain("Dhualaghiri", "Himalaje", 8167,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\7.jpg",
		 * "Dhaulagiri – szczyt w Himalajach środkowo-zachodnich o wysokości 8167 m n.p.m., oddzielony od pobliskiej Annapurny głęboko wciętą doliną rzeki Kali Gandaki. Różnica wysokości między szczytem Dhaulagiri a rzeką wynosi około 6000 metrów i jest jedną z największych deniwelacji górskich na świecie. Dhaulagiri jest siódmym co do wysokości ośmiotysięcznikiem. Przez pewien czas, od pomiarów dokonanych w 1818 roku aż do połowy XIX wieku, uważany za najwyższą górę świata."
		 * );
		 * 
		 * b.insertMountain("Manaslu", "Himalaje", 8163,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\8.jpg",
		 * "Manaslu – ośmiotysięcznik, ósmy pod względem wysokości szczyt Ziemi. Leży w północnej części Nepalu, osiąga wysokość 8156 m n.p.m. (w niektórych źródłach również 8163 m n.p.m. Obecna nazwa, Manaslu – Góra Ducha, pochodzi z sanskryckiego słowa „manasa” oznaczającego ducha bądź duszę. Ze stoków Manaslu spływają trzy lodowce: Manaslu, Pungen i Thulagi. Znany jest z bardzo dużej, nawet jak na Himalaje, wysokości względnej. Zachodnia ściana góry wznosi się prawie 4 kilometry ponad zalesione moreny u jej postawy."
		 * );
		 * 
		 * b.insertMountain("Nanga Parbat", "Himalaje", 8125,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\9.jpg",
		 * "Nanga Parbat – ośmiotysięcznik, dziewiąty co do wysokości szczyt świata (8126 m n.p.m.). Nazwa góry jest mianem kaszmirskim, wywodzi się z sanskrytu i znaczy „Naga Góra”. Był przedostatnim (obok K2) z niezdobytych zimą ośmiotysięczników. Nanga Parbat została zdobyta zimą w roku 2016, próbowały tego 34 wyprawy, w tym 15 polskich."
		 * );
		 * 
		 * b.insertMountain("Annapurna", "Himalaje", 8091,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\10.jpg",
		 * "Annapurna – ośmiotysięcznik, dziesiąty co do wysokości szczyt Ziemi (8091 m n.p.m.). Po obu stronach głębokiego przełomu rzeki Kali Gandaki w centralnym Nepalu wypiętrzają się potężne masywy górskie. Kulminację jednego z nich stanowi Dhaulagiri, a w odległości 33 km od tego szczytu po wschodniej stronie Kali Gandaki wznosi się drugi olbrzym – Annapurna. Annapurna położona jest na północny zachód od Katmandu. Jest to pierwszy szczyt ośmiotysięczny zdobyty przez człowieka. "
		 * );
		 * 
		 * b.insertMountain("Gaszerbrum I", "Karakorum", 8080,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\11.jpg",
		 * "Gaszerbrum I – ośmiotysięcznik, jest najwyższym z grupy siedmiu Gaszerbrumów, gór leżących w paśmie Karakorum. Jest drugim (po K2) co do wysokości szczytem Karakorum. W pierwszej klasyfikacji Karakorum określany był jako K5. Z wierzchołka odchodzi kilka grani, z których do najważniejszych wspinaczkowo należą grań północna, biegnąca ku Przełęczy Gaszerbrum i dalej skręcająca na zachód w kierunku Gaszerbruma II. Przez szczyt przebiega główna grań Karakorum, dzieląc masyw na dwie flanki: północno-wschodnią i południowo-zachodnią. Strona północno-wschodnia jest słabo poznana ze względu na trudny dostęp. Wysokość względna góry wynosi około 3 kilometrów."
		 * );
		 * 
		 * b.insertMountain("Broad Peak", "Karakorum", 8051,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\12.jpg",
		 * "Broad Peak - dwunasta pod względem wysokości góra na świecie (8051 m n.p.m.), ośmiotysięcznik zlokalizowany na granicy Chin i Pakistanu. W pierwszej klasyfikacji Karakorum dostała nazwę K3. Ten potężny masyw wznosi się na południowy wschód od K2. Wierzchołki obu gór oddalone są od siebie zaledwie o 9 km i leżą po przeciwległych stronach lodowca Godwin-Austen. Ze względu na rozłożystość masywu, Martin Conway w 1892 nazwał go – Szeroki Szczyt (ang. Broad Peak). Od strony południowo-zachodniej wysokość względna szczytu wynosi około 3250 metrów, z czego 2300 metrów to bardzo stroma ściana górska."
		 * );
		 * 
		 * b.insertMountain("Gaszerbrum II", "Karakorum", 8034,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\13.jpg",
		 * "Gaszerbrum II - najniższy ośmiotysięcznik Karakorum o sylwetce regularnej piramidy. Leży na północ od Gaszerbruma I, od którego oddzielony jest przełęczą Gaszerbrum. W pierwszej klasyfikacji Karakorum określany był jako K4. Grupa Gaszerbrum znajduje się w Karakorum, pomiędzy lodowcem Baltoro na zachodzie, lodowcem Gaszerbrum na północy i lodowcem Urdok na wschodzie. Najbliższym szczytem położonym w kierunku północno-zachodnim jest Broad Peak. Wysokość względna góry to około 3000 metrów, z czego 2000 metrów stanowi ściana północno-wschodnia."
		 * );
		 * 
		 * b.insertMountain("Sziszpangma", "Himalaje", 8027,
		 * "C:\\Users\\Kubek\\eclipse-workspace\\sthAboutSummits\\mountains\\14.jpg",
		 * "Sziszapangma – 8013 m n.p.m. ośmiotysięcznik na terytorium Tybetu w Himalajach Wysokich, ok. 120 km na północny zachód od grupy Mount Everestu. Tybetańska nazwa Shi-sha-sbang-ma oznacza Grań nad Trawiastą Równiną. Szczyt tworzy potężny masyw, pokryty wiecznymi śniegami i lodowcami. Na północnym skłonie ma źródła rzeka Arun, należąca do dorzecza Gangesu."
		 * );
		 */

		this.mountains = b.selectMountain(
				"SELECT id_mountain, name, range, height, path, text FROM mountains WHERE height>" + height);

		b.closeConnection();

	}

	public Object[][] setTableContent() {

		Object[][] tab = new Object[mountains.size()][4];

		for (int i = 0; i < mountains.size(); i++) {
			tab[i][0] = mountains.get(i).getId();
			tab[i][1] = mountains.get(i).getName();
			tab[i][2] = mountains.get(i).getRange();
			tab[i][3] = mountains.get(i).getHeight();

		}

		return tab;
	}

	public String[] setTableColumns() {

		String[] columns = new String[] { "Lp.", "Name", "Range", "height" };

		return columns;
	}

	public String[] open(int number) {

		String[] s = new String[3];
		for (int i = 0; i < mountains.size(); i++)
			if (mountains.get(i).getId() == number) {
				s[0] = mountains.get(i).getSciezka();
				s[1] = mountains.get(i).getText();
				s[2] = mountains.get(i).getName();
			}
		return s;
	}

}
