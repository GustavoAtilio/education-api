
--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1 (Debian 15.1-1.pgdg110+1)
-- Dumped by pg_dump version 15.1 (Debian 15.1-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: occurrence_model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.occurrence_model (
    id bigint NOT NULL,
    date_description character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    student_id bigint,
    teacher_id bigint
);


ALTER TABLE public.occurrence_model OWNER TO postgres;

--
-- Name: occurrence_model_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.occurrence_model_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.occurrence_model_seq OWNER TO postgres;

--
-- Name: student_model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student_model (
    id bigint NOT NULL,
    cpf character varying(11) NOT NULL,
    date_of_birth character varying(255),
    father character varying(255),
    last_name character varying(255) NOT NULL,
    mother character varying(255),
    name character varying(255) NOT NULL
);


ALTER TABLE public.student_model OWNER TO postgres;

--
-- Name: student_model_occurrences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student_model_occurrences (
    student_model_id bigint NOT NULL,
    occurrences_id bigint NOT NULL
);


ALTER TABLE public.student_model_occurrences OWNER TO postgres;

--
-- Name: student_model_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_model_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_model_seq OWNER TO postgres;

--
-- Name: teacher_model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teacher_model (
    id bigint NOT NULL,
    last_name character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    office character varying(255) NOT NULL
);


ALTER TABLE public.teacher_model OWNER TO postgres;

--
-- Name: teacher_model_occurrences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teacher_model_occurrences (
    teacher_model_id bigint NOT NULL,
    occurrences_id bigint NOT NULL
);


ALTER TABLE public.teacher_model_occurrences OWNER TO postgres;

--
-- Name: teacher_model_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.teacher_model_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.teacher_model_seq OWNER TO postgres;

--
-- Data for Name: occurrence_model; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.occurrence_model (id, date_description, description, student_id, teacher_id) FROM stdin;
32022-12-06T00:26:30.371192900ZNão entregou as tarefas452152
42022-12-06T00:27:10.358655ZAgressividade452152
22022-12-06T00:25:48.977164700Zdesrespeito452152
\.


--
-- Data for Name: student_model; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student_model (id, cpf, date_of_birth, father, last_name, mother, name) FROM stdin;
45205127574373\NJoseDal CantonEliseteGustavo
\.


--
-- Data for Name: student_model_occurrences; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student_model_occurrences (student_model_id, occurrences_id) FROM stdin;
\.


--
-- Data for Name: teacher_model; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teacher_model (id, last_name, name, office) FROM stdin;
152Dal CantonMateusProgramador
252Dal CantonMarceloProgramador
\.


--
-- Data for Name: teacher_model_occurrences; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teacher_model_occurrences (teacher_model_id, occurrences_id) FROM stdin;
\.


--
-- Name: occurrence_model_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.occurrence_model_seq', 51, true);


--
-- Name: student_model_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_model_seq', 501, true);


--
-- Name: teacher_model_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teacher_model_seq', 301, true);


--
-- Name: occurrence_model occurrence_model_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.occurrence_model
    ADD CONSTRAINT occurrence_model_pkey PRIMARY KEY (id);


--
-- Name: student_model student_model_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_model
    ADD CONSTRAINT student_model_pkey PRIMARY KEY (id);


--
-- Name: teacher_model teacher_model_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher_model
    ADD CONSTRAINT teacher_model_pkey PRIMARY KEY (id);


--
-- Name: student_model_occurrences uk_dv154pm5s65u7iv0p7uamtmv1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_model_occurrences
    ADD CONSTRAINT uk_dv154pm5s65u7iv0p7uamtmv1 UNIQUE (occurrences_id);


--
-- Name: teacher_model_occurrences uk_lw6xa9nx7eh5wsg0yjyecmnhb; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher_model_occurrences
    ADD CONSTRAINT uk_lw6xa9nx7eh5wsg0yjyecmnhb UNIQUE (occurrences_id);


--
-- Name: student_model_occurrences fk17afktew9w1vghf7t362blkiy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_model_occurrences
    ADD CONSTRAINT fk17afktew9w1vghf7t362blkiy FOREIGN KEY (occurrences_id) REFERENCES public.occurrence_model(id);


--
-- Name: student_model_occurrences fk1guahq4b5f6js2lewmuua333h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_model_occurrences
    ADD CONSTRAINT fk1guahq4b5f6js2lewmuua333h FOREIGN KEY (student_model_id) REFERENCES public.student_model(id);


--
-- Name: teacher_model_occurrences fk46ukwjvi5uyetei370qewedta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher_model_occurrences
    ADD CONSTRAINT fk46ukwjvi5uyetei370qewedta FOREIGN KEY (occurrences_id) REFERENCES public.occurrence_model(id);


--
-- Name: teacher_model_occurrences fk8g5uvg58vvbrxfnufq25lyuq1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher_model_occurrences
    ADD CONSTRAINT fk8g5uvg58vvbrxfnufq25lyuq1 FOREIGN KEY (teacher_model_id) REFERENCES public.teacher_model(id);


--
-- Name: occurrence_model fkcibdn99p0u8r58uuxf9cik9dt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.occurrence_model
    ADD CONSTRAINT fkcibdn99p0u8r58uuxf9cik9dt FOREIGN KEY (student_id) REFERENCES public.student_model(id);


--
-- Name: occurrence_model fkj20f796eh7j6ts47whw80n76y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.occurrence_model
    ADD CONSTRAINT fkj20f796eh7j6ts47whw80n76y FOREIGN KEY (teacher_id) REFERENCES public.teacher_model(id);


--
-- PostgreSQL database dump complete
--

