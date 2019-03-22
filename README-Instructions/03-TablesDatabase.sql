-- ---------------------------------------
 -- ********  Table - dbproducts ******** 
-- ---------------------------------------

CREATE SEQUENCE public.tbl_product_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 100000000
  START 1
  CACHE 1;
  
DROP TABLE public.tbl_product;

CREATE TABLE public.tbl_product
(
  id integer NOT NULL DEFAULT nextval('tbl_product_id_seq'::regclass),
  description character varying(150) NOT NULL,
  price numeric(10,2) NOT NULL,
  CONSTRAINT tbl_product_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tbl_product
  OWNER TO postgres;
GRANT ALL ON TABLE public.tbl_product TO postgres;

 -- ---------------------------------------
 -- ********  Tables - dbbusiness ******** 
-- ---------------------------------------
CREATE SEQUENCE public.tbl_payment_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 100000000
  START 1
  CACHE 1;

CREATE SEQUENCE public.tbl_store_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 100000000
  START 1
  CACHE 1;

DROP TABLE public.tbl_payment;

CREATE TABLE public.tbl_payment
(
  id integer NOT NULL DEFAULT nextval('tbl_payment_id_seq'::regclass),
  description character varying(30) NOT NULL,
  CONSTRAINT tbl_payment_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tbl_payment
  OWNER TO postgres;
GRANT ALL ON TABLE public.tbl_payment TO postgres;

DROP TABLE public.tbl_store;

CREATE TABLE public.tbl_store
(
  id integer NOT NULL DEFAULT nextval('tbl_store_id_seq'::regclass),
  name character varying(100),
  address character varying(250),
  CONSTRAINT tbl_store_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tbl_store
  OWNER TO postgres;
GRANT ALL ON TABLE public.tbl_store TO postgres;

 -- ---------------------------------------
 -- ******** Tables - dborders ******** 
-- ---------------------------------------

CREATE SEQUENCE public.tbl_order_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 100000000
  START 1
  CACHE 1;

CREATE SEQUENCE public.tbl_order_item_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 100000000
  START 1
  CACHE 1;

DROP TABLE public.tbl_order;

CREATE TABLE public.tbl_order
(
  id integer NOT NULL DEFAULT nextval('tbl_order_id_seq'::regclass),
  buy_date date NOT NULL,
  confirmation_date date,
  status character varying(1) NOT NULL, -- 1 - pending; 2 - confirmed
  id_store integer NOT NULL,
  id_payment integer NOT NULL,
  CONSTRAINT tbl_order_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tbl_order
  OWNER TO postgres;
COMMENT ON COLUMN public.tbl_order.status IS '1 - pending; 2 - confirmed';

DROP TABLE public.tbl_order_item;

CREATE TABLE public.tbl_order_item
(
  id integer NOT NULL DEFAULT nextval('tbl_order_item_id_seq'::regclass),
  id_order integer NOT NULL,
  id_product integer NOT NULL,
  quantity integer NOT NULL,
  price numeric(10,2) NOT NULL,
  CONSTRAINT tbl_order_item_pk PRIMARY KEY (id),
  CONSTRAINT fk_order_item_order FOREIGN KEY (id_order)
      REFERENCES public.tbl_order (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tbl_order_item
  OWNER TO postgres;





