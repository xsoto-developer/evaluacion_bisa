--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

-- Started on 2022-08-26 13:11:45

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 291541)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cliente (
    id_cliente integer NOT NULL,
    nombre text,
    apellido text,
    nro_documento text,
    moneda character varying(255),
    nro_cuenta integer,
    saldo double precision
);


ALTER TABLE cliente OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 291539)
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cliente_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliente_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 185
-- Name: cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cliente_id_cliente_seq OWNED BY cliente.id_cliente;


--
-- TOC entry 182 (class 1259 OID 291519)
-- Name: cuenta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cuenta (
    id_cuenta integer NOT NULL,
    nro_cuenta integer,
    id_cliente integer,
    saldo double precision,
    moneda text,
    estado text
);


ALTER TABLE cuenta OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 291517)
-- Name: cuenta_id_cuenta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cuenta_id_cuenta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cuenta_id_cuenta_seq OWNER TO postgres;

--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 181
-- Name: cuenta_id_cuenta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cuenta_id_cuenta_seq OWNED BY cuenta.id_cuenta;


--
-- TOC entry 184 (class 1259 OID 291530)
-- Name: transaccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE transaccion (
    id_transaccion integer NOT NULL,
    id_cuenta integer,
    tipo text,
    monto double precision,
    moneda text,
    fecha_hora timestamp with time zone
);


ALTER TABLE transaccion OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 291528)
-- Name: transaccion_id_transaccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE transaccion_id_transaccion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE transaccion_id_transaccion_seq OWNER TO postgres;

--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 183
-- Name: transaccion_id_transaccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE transaccion_id_transaccion_seq OWNED BY transaccion.id_transaccion;


--
-- TOC entry 1998 (class 2604 OID 291544)
-- Name: id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_id_cliente_seq'::regclass);


--
-- TOC entry 1996 (class 2604 OID 291522)
-- Name: id_cuenta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta ALTER COLUMN id_cuenta SET DEFAULT nextval('cuenta_id_cuenta_seq'::regclass);


--
-- TOC entry 1997 (class 2604 OID 291533)
-- Name: id_transaccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transaccion ALTER COLUMN id_transaccion SET DEFAULT nextval('transaccion_id_transaccion_seq'::regclass);


--
-- TOC entry 2124 (class 0 OID 291541)
-- Dependencies: 186
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (id_cliente, nombre, apellido, nro_documento, moneda, nro_cuenta, saldo) FROM stdin;
0	nombre	apellidos	12345678	\N	\N	\N
1	nombre	apellidos	12345678	\N	\N	\N
2	nombre2	apellidos2	123456789	\N	\N	\N
3	nombre3	apellidos3	1234567890	\N	\N	\N
\.


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 185
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_id_cliente_seq', 3, true);


--
-- TOC entry 2120 (class 0 OID 291519)
-- Dependencies: 182
-- Data for Name: cuenta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cuenta (id_cuenta, nro_cuenta, id_cliente, saldo, moneda, estado) FROM stdin;
6	45020148	1	100	BOB	ACTIVE
3	12345631	1	100	BOB	\N
4	45020132	1	100	BOB	\N
5	45020133	1	100	BOB	ACTIVE
1	45020149	1	100	BOB	\N
2	45020130	1	100	BOB	\N
\.


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 181
-- Name: cuenta_id_cuenta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cuenta_id_cuenta_seq', 6, true);


--
-- TOC entry 2122 (class 0 OID 291530)
-- Dependencies: 184
-- Data for Name: transaccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY transaccion (id_transaccion, id_cuenta, tipo, monto, moneda, fecha_hora) FROM stdin;
7	1	D	100	BOB	2022-08-26 05:08:54-04
1	1	H	100	BOB	2022-08-26 05:08:54-04
2	6	H	100	BOB	2022-08-26 05:08:54-04
3	1	H	200	BOB	2022-08-26 05:08:54-04
4	1	H	300	BOB	2022-08-26 05:08:54-04
5	1	H	400	BOB	2022-08-26 05:08:54-04
6	1	D	400	BOB	2022-08-26 05:08:54-04
8	1	D	100	BOB	2022-08-26 05:08:54-04
9	1	D	100	BOB	2022-08-26 05:08:54-04
\.


--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 183
-- Name: transaccion_id_transaccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('transaccion_id_transaccion_seq', 9, true);


--
-- TOC entry 2004 (class 2606 OID 291549)
-- Name: cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 2000 (class 2606 OID 291527)
-- Name: cuenta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (id_cuenta);


--
-- TOC entry 2002 (class 2606 OID 291538)
-- Name: transaccion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transaccion
    ADD CONSTRAINT transaccion_pkey PRIMARY KEY (id_transaccion);


--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2022-08-26 13:11:45

--
-- PostgreSQL database dump complete
--

