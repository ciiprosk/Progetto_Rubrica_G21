# Configurazione del Database Locale
L'applicazione si appoggia a un database remototo e per tale ragione c'è bisogno di essere connessi a Internet per poter sfruttare il database remoto.
   Le sue credenziali sono-> nome utente: postgres (utente di default di postgres)
                             nome database: postgres
                             password: Farinotta01_
                             nome tabella: rubrica
Nel caso in cui non si fosse a disposizione di una connessione Internet il sistema cercherà di connettersi a un database Locale.
E' possibile inseirire quelle stesse credenziali per il proprio database locale nel caso in cui non si voglia modificare gli attributi del codice nella classe Database.

Il sistema ha inoltre una funzione di importa/esporta che permette all'utente di salvare i propri contatti su un file.
   -Nel caso in cui l'applicazione si appoggi a un database locale/remoto si possono esportare i dati inseriti su un file e poi imporartare sul database locale/remoto quando vi è la necessità.
   

Ecco di seguito mostrati i passaggi per configurare correttamente il database locale. 

1. **Installazione di PostgreSQL**:
   - Scarica e installa PostgreSQL dal sito ufficiale: [PostgreSQL Download](https://www.postgresql.org/download/).

2. **Creazione del Database**:
   - Accedi a PostgreSQL e crea un database:

     ```bash
     psql -U postgres
     CREATE DATABASE nome_del_database;
     ```
     - Il nome del database deve essere necessriamente "postgres"(quello già esistente), ma è possibile modificarlo nella classe Database nell'attributo URL :
            String URLLocale=" jdbc:postgresql://localhost:5432/nome_database"
     - La password da utilizzare è quella dell'utente postgres scritta al momento dell'installazione, è possibile modiifcarla nel codice nella classe Database password
     - Il nome della tabella può essere passata al costruttore.

3 . Di seguito è presentato lo script per la creazione della tabella. 
  ```bash 
      psql -U postgres -d nome_del_database -c
    "CREATE TABLE IF NOT EXISTS public.rubrica
(
    id integer NOT NULL DEFAULT nextval('rubrica_id_seq'::regclass),
    nome character varying COLLATE pg_catalog."default",
    cognome character varying COLLATE pg_catalog."default",
    telefono1 character varying COLLATE pg_catalog."default",
    telefono2 character varying COLLATE pg_catalog."default",
    telefono3 character varying COLLATE pg_catalog."default",
    email1 character varying COLLATE pg_catalog."default",
    email2 character varying COLLATE pg_catalog."default",
    email3 character varying COLLATE pg_catalog."default",
    CONSTRAINT rubrica_pkey PRIMARY KEY (id)
  )
  TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.rubrica
    OWNER to postgres;

"
 ```



4. **Test di Connessione**:
   - Avvia il tuo progetto senza essere connesso a Internet e verifica che la connessione al database funzioni correttamente.

