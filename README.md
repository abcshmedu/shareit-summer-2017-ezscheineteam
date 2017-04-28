# 2. Pratkikumsaufgabe Software-Architektur Sommer 2017
Heroku Deployment:
-
Link: [Heroku Deployed](https://sleepy-peak-70358.herokuapp.com/)

REST-API Interface Dokumentation:
-
### Anwendung:

URI|Methode|Beschreibung
--- | --- | --- 
/media/books|POST|Neues Medium Buch anlegen
/media/books{isbn}|GET|Eine JSON-Repr�sentation eines gespeicherten Buches liefern, falls vorhanden
/media/books|GET|Alle B�cher auflisten
/media/books/{isbn}|PUT|Daten zu vorhandenem Buch modifizieren (JSON-Daten enthalten nur die zu modifizierenden Attribute)
/media/discs|POST|Neues Medium Disc anlegen
/media/discs|GET|Alle Discs auflisten
/media/discs/{barcode}|GET|Eine JSON-Repr�sentation einer gespeicherten Disc liefern, falls vorhanden
/media/discs/{barcode}|PUT|Daten zur vorhandenen Disc modifizieren (JSON-Daten enthalten nur die zu modifizierenden Attribute)
/copy/{user}/books|POST|Neues Exemplar Buch dem Konto anlegen
/copy/{user}/books|GET|Alle Exemplare Buch auflisten von dem Konto
/copy/{user}/discs|POST|Neues Exemplar Disc dem Konto anlegen
/copy/{user}/discs|GET|Alle Exemplare Disc auflisten von dem Konto

### JSON-Objekte:
#### Buch:
```javascript
{
    "title"  : "<string>",
    "author" : "<stirng>",
    "isbn"   : "<string>",
}
```
#### Disc:
```javascript
{
    "title"    : "<string>",
    "barcode"  : "<stirng>",
    "director" : "<string>",
    "fsk"      : <integer>,
}
```