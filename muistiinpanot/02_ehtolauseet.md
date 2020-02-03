# Totuusarvot ja ehtolauseet

Katso myös: [Ehtolauseet ja vaihtoehtoinen toiminta, Ohjelmoinnin MOOC 2020](https://ohjelmointi-20.mooc.fi/osa-1/6-ehtolauseet) ja [monimuotokurssin materiaali *Valintarakenne.pdf*](https://haagahelia.sharepoint.com/:b:/r/teams/Ohjelmointi1/Class%20Materials/monimuoto/Valintarakenne.pdf?csf=1&e=OiHQei).

Jatkossa kurssin GitHub-etusivun aikataulussa on linkit monimuotokurssin PDF-kalvosettiin!


## Kertausta

Mistä johtuu, että alla oleva luku näyttää olevan esitetty tarpeettoman suurella tarkkuudella?

![Pyöristysvirhe](assets/pyoristysvirhe.png)

Laskutoimitukset liukuluvuilla ovat erittäin nopeita. Tietokoneet käsittelevät mm. pelien grafiikkaa ja muuta matematiikkaa liukuluvuilla. Esim. Javascript ei muuta käytäkään. Liukulukujen toteutuksesta johtuen niillä laskettaessa esiintyy kuitenkin usein pieniä tarkkuusvirheitä, minkä vuoksi niitä ei tule käyttää täydellistä tarkkuutta vaativissa tarkoituksissa.

Kokeile suorittaa seuraava yhteenlasku. Minkä tuloksen saat?

```java
System.out.println(0.1 + 0.2); // tulostaa 0.30000000000000004
```

Liukulukujen laskuvirhe ei niinkään liity Javaan, vaan yleisesti siihen, miten liukuluvut esitetään tietokoneen muistissa. Kaikkia lukuja ei vain ole mahdollista esittää rajatulla määrällä desimaaleja. Vastaavasti kymmenjärjestelmässä ei voida tarkasti esittää lukua `1/3`.

# Boolean-arvot (totuusarvot)

Javassa on kaksi totuusarvoa:

```java
boolean tosi = true;
boolean epatosi = false;
```

Boolean-tyyppisiä arvoja ja boolean-muuttujia voidaan monella tapaa käyttää kuten numeroita ja merkkijonoja:

```java
System.out.println(true);
System.out.println(false);

boolean totuusarvo = true;
System.out.println(totuusarvo);
```

Boolean arvojen kääntäminen (negaatio):

```java
boolean yes = true;
boolean no = !yes; // --> false
```

## Arvojen vertailu ja loogiset operaatiot

Kun vertailemme Javassa eri arvoja, saamme vertailun tuloksiksi totuusarvoja:

```java
System.out.println(10 > 5);
System.out.println(100 < 3);
```

Edellä esitetyt koodirivit tulostavat ruudulle seuraavat tulokset: 

```
true
false
```

Tulostamisen lisäksi vertailuoperaatioiden arvoja voidaan käyttää kuten muitakin arvoja Javassa. Voimme siis esimerkiksi sijoittaa niitä muuttujiin:

```java
int numero = lukija.nextInt(); // oletetaan että lukija on Scanner-olio

boolean yliKolme = numero > 3;
boolean alleSata = numero < 100;
```


## Vertailuoperaattorit
Javassa löytyy arvojen vertailuun seuraavat operaattorit:

Operaattori | Selitys
------------|-----------
==          | yhtä suuri kuin
!=          | eri suuruinen kuin
&gt;        | suurempi kuin
&gt;=	    | suurempi tai yhtä suuri kuin
&lt;	    | pienempi kuin
&lt;=	    | pienempi tai yhtä suuri kuin
&&	        | ja
\|\|        | tai
!           | negaatio <br />`!false == true`<br /> `!true == false`

https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html


Kaikki seuraavan esimerkin muuttujat saavat arvoikseen `true`, eli vertailujen tulokset ovat tosia:

```java
int luku = 1;

boolean b1 = luku == 1;
boolean b2 = luku > 0;
boolean b3 = luku < 2;
boolean b4 = luku >= 1;
boolean b5 = luku <= 1;
boolean b6 = luku != 0;
```

## Totuustaulut

Totuusarvoja voidaan yhdistellä ja- sekä tai-operaatioilla. Näiden operaatioiden molempien osapuolien on oltava totuusarvoja (tai lausekkeita, joiden tuloksena saadaan totuusarvo).

### Ja (`&&`)

Lausekkeen `a && b` arvoksi tulee `true` vain silloin, kun molemmat arvoista ovat `true`:

| a     | b     | a \&\& b |
|-------|-------|--------  |
| true  | true  | true     |
| True  | false | false    |
| false | true  | false    |
| false | false | false    |


### Tai (`||`)

Lausekkeen `a || b` arvoksi tulee `true` aina, kun vähintään toinen arvoista on `true`:

| a     | b     | a \|\| b |
|-------|-------|----------|
| true  | true  | true     |
| true  | false | true     |
| false | true  | true     |
| false | false | false    |


# If-ehtolause

Totuusarvojen yleinen käyttötarkoitus on koodin suorittaminen vain tietyn ehdon täyttyessä. Tällöin tietyt koodirivit suoritetaan ainoastaan silloin, kun niille asetettu ehto toteutuu.

Tarkastettava ehto kirjoitetaan `if`-avainsanan jälkeen sulkujen sisään: `if (ehto)`. Ehdon toteutuessa suoritettavat koodirivit kirjoitetaan uuteen koodilohkoon `{  }` heti `if`-lauseen jälkeen:

```java
if (ehto) {
    // suoritettava koodi
}
// jos ehto on epätosi, siirtyy suoritus suoraan tänne
```

Ehtona on aina oltava totuusarvo tai totuusarvon saava lauseke, esimerkiksi:

```java
boolean onPaiva = true;

if (onPaiva) {
    // tähän lohkoon kirjoitettu  koodi suoritetaan 
    // vain, jos ehto on tosi
    System.out.println("Hyvää päivää!");
}
```

If-lauseen sulkujen sisällä voi olla myös lauseke, joka evaluoidaan, ja päätös tehdään saadun tuloksen mukaan.

```java
int kello = 16;

if (kello < 18) {
    // tähän lohkoon kirjoitettu koodi suoritetaan, 
    // jos kello-muuttujan arvo on alle 18
    System.out.println("Hyvää päivää!");
}
```

## Vertailu "== true"

Toisinaan ehtolauseen sisään kirjoitetaan kirjoitettavan arvon vertailu `true`-arvoon:

```java
if (ehto == true) { }
```

Tämä on kuitenkin turhaa, koska `ehto == true` saa aina arvokseen saman arvon kuin `ehto`, eli voimme käyttää suoraan `ehto`-muuttujan arvoa:

```java
if (ehto) { }
```

## Loogisten operaattorien käyttäminen

Ehtolauseessa voidaan evaluoida myös monimutkaisempia lausekkeita, joissa tehdään useita eri vertailuja:

```java
int kello = 16;

if (kello >= 10 && kello < 18) {
    // tähän lohkoon kirjoitettu koodi suoritetaan vain,
    // jos kello-muuttujan arvo on suurempi tai 
    // yhtä suuri kuin 10 JA samalla alle 18
    System.out.println("Hyvää päivää!");
}
```

Edellä oleva ehto toteutuu vain, jos arvo on samaan aikaan sekä `>= 10` että `< 18`. Kellonajoista yön voidaan ajatella olevan sekä ensimmäinen että viimeinen vuorokaudenaika, eli yön selvittämisessä riittää että arvo on joko `>= 22` tai `< 7`.

```java
int kello = 16;

if (kello >= 22 || kello < 7) {
    // tähän lohkoon kirjoitettu koodi suoritetaan
    // jos kumpi tahansa ehdoista toteutuu!
    System.out.println("Hyvää yötä!");
}
```

Erilaisia ehtoja voidaan kirjoittaa myös erillisiksi lausekkeiksi, joiden tulos sijoitetaan muuttujaan:

```java
// vertailu suoritetaan ensin ja sen tulos (true tai false) asetetaan muuttujaan
boolean onPaiva = (kello >= 10 && kello < 18);
boolean onYo = (kello >= 22 || kello < 7);
```

## Oikean kellonajan käyttäminen

Kellonajan "kovakoodaaminen", kuten yllä, ei tietenkään ole toiminnallisesti järkevää. Oikeaa kellonaikaa voidaan käyttää esimerkiksi seuraavalla tavalla Javan `LocalTime`-luokan avulla (luokan alkuun "`import java.time.LocalTime;`"):

```java
// luodaan olio ja asetetaan se uuteen muuttujaan:
LocalTime nykyhetki = LocalTime.now();

// kutsutaan getHour-metodia ja otetaan vastaus talteen:
int tunnit = nykyhetki.getHour();

if (tunnit >= 10 && tunnit < 18) {
    // tähän lohkoon kirjoitettu koodi suoritetaan vain,
    // jos tunnit-muuttujan arvo on suurempi tai 
    // yhtä suuri kuin 10, mutta kuitenkin alle 18
    System.out.println("Hyvää päivää!");
}
```

## Else-lohko

Vapaaehtoisessa else-lohkossa oleva koodi suoritetaan, mikäli if-lauseen ehto ei toteutunut:

```java
int kello = 16;

if (kello >= 10 && kello < 18) {
    System.out.println("Hyvää päivää!");
} else {
    // Tässä lohkossa oleva koodi suoritetaan, jos 
    // edellä ollut if-ehto ei toteutunut 
    System.out.println("Tervehdys!");
}
```

Else-avainsana koodilohkoineen kirjoitetaan heti if-lohkon jälkeen.

## if / else if / else

`else if`-lohkossa oleva koodi suoritetaan, jos edeltävien ehtolauseiden ehdot eivät ole toteutuneet ja sen ehto toteutuu:

```java
int kello = 16;

if (kello >= 22) { // Tämä tarkastus tehdään ensin
    System.out.println("Hyvää yötä!");
} else if (kello >= 17) { // tarkastetaan vain, jos ensimmäinen oli epätosi
    System.out.println("Hyvää iltaa!");
} else {
    // Tänne päädytään, jos kaikki edellä olleet ehdot olivat epätosia
    System.out.println("Hyvää päivää!");
}
```

`if-else if-else` -ketjun ehtojen tarkastaminen päättyy aina ensimmäiseen `true`-arvon saaneeseen vertailuun.

## Koodaustehtävä (ks. Viope)
Kirjoita luokka `Tervehdys` ja siihen `main`-metodi, joka tulostaa kellonajasta riippuen erilaisen tervehdyksen.

Aikaväli    | Tervehdys
---------   |----------
7:00-9:59   | Hyvää huomenta!
10:00-16:59 | Hyvää päivää!
17:00-21:59 | Hyvää iltaa!
22:00-6:59  | Hyvää yötä!

## Sisäkkäiset ehtorakenteet

```java
/*
 * Tässä esimerkissä demonstroidaan sisäkkäistä vaihtoehtorakennetta. Käyttäjän
 * ensimmäisestä vastauksesta riippuen häneltä joko kysytään toinen kysymys tai
 * tulostetaan vastaus suoraan. Toisen kysymyksen vastauksesta riippuen
 * suoritetaan jompi kumpi vaihtoehtoisista lohkoista.
 */
public class JunalippujenHinta {

    /*
     * 1. Kysytään ostaako käyttäjä kuukausilipun vai kertalippuja
     * 
     * 2. Jos ostaa kuukausilipun, kerrotaan kuukausihinta
     * 
     * 3. Jos kertalippuja, kysytään kuinka monta, ja kerrotaan tulisiko
     * kuukausilippu halvemmaksi
     */
    public static void main(String[] args) {
        final int kertalipunHinta = 10;
        final int kuukausilipunHinta = 100;

        Scanner lukija = new Scanner(System.in);

        System.out.println("Ostatko kuukausilipun (1) vai kertalippuja (2)?");
        int vastaus = lukija.nextInt();

        if (vastaus == 1) {
            System.out.println("Kuukausilippu maksaa " + kuukausilipunHinta + " €");
        } else {
            System.out.println("Kuinka monta kertalippua käytät kuukaudessa?");
            int kertalippuja = lukija.nextInt();
            int kokonaishinta = kertalippuja * kertalipunHinta;

            if (kokonaishinta > kuukausilipunHinta) {
                System.out.println("Kuukausilippu olisi halvempi");
            } else {
                int saasto = kuukausilipunHinta - kokonaishinta;
                System.out.println("Säästät " + saasto + " € verrattuna kuukausilippuun");
            }
        }

        lukija.close();
    }
}
```

# Kolme eri tapaa vertailla: `!=`, `!` (negaatio) ja `== false`

```java
public class Merkkijonokertaus {

    public static void main(String[] args) {
        String lento = "zz105";

        boolean finnairinLento = lento.startsWith("ay");
        // Kolme eri tapaa tarkastaa sama ehto:

        if (finnairinLento == false) {
            System.out.println("Ei ole finnairin lento");
        }

        if (finnairinLento != true) {
            System.out.println("Ei ole finnairin lento");
        }

        // negaatio: muutta true-arvon falseksi ja toisin päin
        if (!finnairinLento) {
            System.out.println("Ei ole finnairin lento");
        }
    }
}
```

# Syventävää osaamista: switch/case -rakenne 💪
```java
/** By Educative, Inc 
 * https://www.educative.io/edpresso/how-to-use-switch-case-statement-in-java
 * License: Creative Commons -Attribution -ShareAlike 4.0 (CC-BY-SA 4.0)*/
class HelloWorld {
    public static void main( String args[] ) {
      
        int weather = 2;
        //passing variable to the switch
        switch (weather) {
          //comparing value of variable against each case
        case 0:
          System.out.println("It is Sunny today!");
          break;
        case 1:
          System.out.println("It is Raining today!");
          break;
        case 2:
          System.out.println("It is Cloudy today!");
          break;
        //optional
        default:
          System.out.println("Invalid Input!");
        }
    }
}
```

Tutustu `switch-case`-rakenteeseen itsenäisesti esimerkiksi osoitteessa https://www.educative.io/edpresso/how-to-use-switch-case-statement-in-java.

---

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA 3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/) -lisenssillä. 