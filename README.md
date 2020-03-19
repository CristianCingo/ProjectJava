# **Progetto di Programmazione ad Oggetti**
## Descrizione
L’applicazione presente nella repository è un progetto in Java che – tramite l’utilizzo di Spring Boot - consente di decodificare un file JSON e scaricare i dati presenti in un file di tipo JSON. Questo consiste in un insieme di dati della Regione Campania riguardanti i Fondi POR (Programmi Operativi Regionali) che costituisce il quadro di riferimento per l'utilizzo delle risorse comunitarie del Fondo Europeo per lo Sviluppo Regionale. Il dataset può essere consultato al seguente indirizzo: https://dati.regione.campania.it//catalogo//resources//Fondo-Sociale-Europeo.json 
All’interno vi sono diversi campi:
1.	Codice Progetto
2.	Codice CUP
3.	Tipologia CUP
4.	Ambito di Riferimento
5.	Denominazione del Progetto
6.	Sintesi del Progetto
7.	Ubicazione del Progetto
8.	Data d’inizio
9.	Data di Fine prevista
10.	Data di Fine effettiva
11.	Modalità attuativa
12.	Nome del beneficiario
13.	Sede legale del beneficiario
14.	Codice Fiscale del beneficiario
15.	Costo totale
16.	Spesa ammissibile
17.	Quota Unione Europea
18.	Spesa realizzata
19.	Importo certificato
20.	Importo liquidato

## Funzionamento
Tramite Spring Boot l’applicazione crea un server locale (http://localhost:8080) e si utilizza una API REST GET per restituire i metadati (elenco nome, tipo e significato), dati (integralmente o filtrati) e le statistiche sui dati, specificando l’attributo da considerare. Il JSON rappresentate un singolo elemento del dataset si presenta come
```java
{
"CodiceProgetto": "\"16019AP000000748\"", 
"CodiceCUP": "\"B85H18000420009\"",
"TipologiaCUP": "\"Incentivi al lavoro\"",
"AmbitoRiferimento": "\"Incentivi per l’assunzione di lavoratori svantaggiati in Campania – annualità 2016 (DECONTRIBUZIONE)\"",
"DenominazioneProgetto": "\"SANNIOTTICA S.R.L. - 3529 - DECONTRIBUZIONE\"", "SintesiProgetto": "\"INCENTIVI PER L'ASSUNZIONE DI LAVORATORI SVANTAGGIATI IN CAMPANIA - DECONTRIBUZIONE ANNUALITA' 2016\"",
"UbicazioneProgetto": "\"CAMPANIA BENEVENTO Benevento VIA DEI LONGOBARDI, 82100\"",
"DataInizio": "\"06/08/2016\"",
"DataFinePrevista": "\"06/08/2017\"",
"DataFineEffettiva": "\"\"",
"ModalitaAttuativa": "\"Regia\"",
"NomeBeneficiario": "\"SANNIOTTICA SRL\"",
"SedeLegaleBeneficiario": "\"\"",
"CodiceFiscaleBeneficiario": "\"01288940628\"",
"CostoTotale": "\"2042.00\"",
"SpesaAmmissibile": "\"2042\"",
"QuotaUnioneEuropea": "\"1531.5\"",
"SpesaRealizzata": "\"2042\"",
"ImportoCertificato": "\"2042\"",
"ImportoLiquidato": "\"2042\""
},
```
Le statistiche possono essere rilevate su ogni specifica categoria: per quanto riguarda i dati di tipo numerico si possono calcolare Somma, Massimo, Minimo, Media, Deviazione Standard e Numero degli elementi; riguardo i dati di tipo “String” si può calcolare il numero di occorrenze di ogni singola stringa.
Attraverso una serie di chiamate GET o POST si ottengono diversi risultati:
* Route che restituisce la lista dei dati del dataset
```java
GET/data
```
* Route che restituisce la lista dei metadati
```java
GET/metadata
```
* Route che restituisce la lista delle statistiche per i dati numerici
```java
GET/ stat/num
```
* Route che restituisce la lista delle statistiche per i dati "String"
```java
GET /stat/str
```
* Route che restituisce la lista contenente le analisi sui dati filtrati
```java
GET/funding/get?filter=
```
Il filtro dell'API deve essere implementato in questo modo:
```java
?filter=PrimoCampo:operatore:PrimoValore:operatoreLogico:SecondoCampo....
```
In cui
```java
'PrimoCampo': nome del campo sul quale si vuole effettuare il primo filtro
'operatore': operatore di confronto per il primo filtro (<,>,<=,>=,==)
'PrimoValore': valore utilizzato per il confronto nel primo filtro
'operatoreLogico': utilizzato per concatenare più filtri (AND o OR)
```
## Eccezioni
Si sono gestite con i metodi try-catch e throw.
## Librerie esterne
Si sono utilizzate le seguenti librerie:
* org.json.simple (json-simple): per la gestione dei JSONObject nel progetto

## UML
Qui vengono riportati i diagrammi UML inerenti all’applicazione
## Diagramma dei casi d'uso
![Use-Case Diagram](https://github.com/CristianCingo/ProjectJava/blob/master/Use%20case%20diagram.jpeg)

## Diagramma delle sequenza
![Sequence Diagram](https://github.com/CristianCingo/ProjectJava/blob/master/Basic%20UML%20Sequence%20Diagram.jpeg)

## Diagramma delle classi
![Class Diagram](https://github.com/CristianCingo/ProjectJava/blob/master/UML%20Class.jpeg)

**Studenti:** Cristian Cingolani (S1082504) & Christian Ascani (S1084723)
