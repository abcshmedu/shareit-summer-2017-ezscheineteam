# 2. Pratkikumsaufgabe Software-Architektur Sommer 2017
Heroku Deployment:
-
Link: [ShareIt](https://shareit-ezscheine.herokuapp.com/)

Link: [OAuth](https://auth-server-ezschein.herokuapp.com/)

REST-API Interface Dokumentation:
-
### Anwendung:

URI|Methode|Beschreibung
--- | --- | --- 
/media/books|POST|Neues Medium Buch anlegen
/media/books{isbn}|GET|Eine JSON-Repryaesentation eines gespeicherten Buches liefern, falls vorhanden
/media/books|GET|Alle Buecher auflisten
/media/books/{isbn}|PUT|Daten zu vorhandenem Buch modifizieren (JSON-Daten enthalten nur die zu modifizierenden Attribute). Ist das Buch(ISBN) nicht enthalten, wird das Buch erstellt, wenn alle Attribute angegeben wurden.
/media/discs|POST|Neues Medium Disc anlegen
/media/discs|GET|Alle Discs auflisten
/media/discs/{barcode}|GET|Eine JSON-Repraesentation einer gespeicherten Disc liefern, falls vorhanden
/media/discs/{barcode}|PUT|Daten zur vorhandenen Disc modifizieren (JSON-Daten enthalten nur die zu modifizierenden Attribute). Ist die Disc(Barcode) nicht enthalten wird sie erstellt, wenn alle Attribute angegeben wurde.
/copy|POST|Neues Exemplar anlegen
/copy|GET|Alle Exemplare auflisten
/copy/books|GET|Alle Buch Exemplare auflisten
/copy/discs|GET|Alle Disc Exemplare auflisten
/copy/{owner}|GET|Alle Exemplare des Besitzers auflisten
/copy/{owner}/books/{isbn}|GET|Ein bestimmtes Exemplar Buch auflisten
/copy/{owner}/discs/{barcode}|GET|Ein bestimmtes Exemplar Disc auflisten
/copy/{owner}/books/{isbn}|DELETE|Ein bestimmtes Exemplar Buch löschen
/copy/{owner}/discs/{barcode}|DELETE|Ein bestimmtes Exemplar Disc löschen
/copy/{owner}/books/{isbn}|PUT|Ein bestimmtes Exemplar Buch aktualisieren
/copy/{owner}/discs/{barcode}|PUT|Ein bestimmtes Exemplar Disc aktualisieren


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
#### Buch Exemplar:
```javascript
{
    "medium"   : {
                     "type" : "book", 
                     <Buch JSON Rumpf>,
                  },
    "owner"    : "<string>",
    "quantity" : <integer>,
}
```
#### Disc Exemplar:
```javascript
{
    "medium"   : {
                     "type" : "disc", 
                     <Disc JSON Rumpf>,
                  },
    "owner"    : "<string>",
    "quantity" : <integer>,
}
```