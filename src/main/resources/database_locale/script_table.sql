CREATE TABLE IF NOT EXISTS public.rubrica
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
