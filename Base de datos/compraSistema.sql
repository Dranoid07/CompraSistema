PGDMP                	        |            compraSistema    16.2    16.2 O    B           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            C           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            D           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            E           1262    19621    compraSistema    DATABASE     �   CREATE DATABASE "compraSistema" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Dominican Republic.1252';
    DROP DATABASE "compraSistema";
                postgres    false            �            1255    19759    actualizar_existencia()    FUNCTION     �  CREATE FUNCTION public.actualizar_existencia() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    -- Verificar si la orden de compra está aprobada
    IF NEW.estado = 'Aprobada' THEN
        -- Actualizar la existencia del artículo en la tabla Articulos
        UPDATE Articulos
        SET existencia = existencia + NEW.cantidad
        WHERE id = NEW.articulo_id;
    END IF;
    
    RETURN NEW;
END;
$$;
 .   DROP FUNCTION public.actualizar_existencia();
       public          postgres    false            �            1259    19622 	   articulos    TABLE     �   CREATE TABLE public.articulos (
    id integer NOT NULL,
    descripcion character varying(100),
    marca_id integer,
    unidad_de_medida_id integer,
    existencia integer,
    estado character varying(20)
);
    DROP TABLE public.articulos;
       public         heap    postgres    false            �            1259    19625    articulos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.articulos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.articulos_id_seq;
       public          postgres    false    215            F           0    0    articulos_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.articulos_id_seq OWNED BY public.articulos.id;
          public          postgres    false    216            �            1259    19626    departamentos    TABLE     �   CREATE TABLE public.departamentos (
    id integer NOT NULL,
    descripcion character varying(100),
    estado character varying(20)
);
 !   DROP TABLE public.departamentos;
       public         heap    postgres    false            �            1259    19629    departamentos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.departamentos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.departamentos_id_seq;
       public          postgres    false    217            G           0    0    departamentos_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.departamentos_id_seq OWNED BY public.departamentos.id;
          public          postgres    false    218            �            1259    19630 	   empleados    TABLE     �   CREATE TABLE public.empleados (
    id integer NOT NULL,
    cedula character varying(20),
    descripcion character varying(100),
    departamento_id integer,
    estado character varying(20)
);
    DROP TABLE public.empleados;
       public         heap    postgres    false            �            1259    19633    empleados_id_seq    SEQUENCE     �   CREATE SEQUENCE public.empleados_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.empleados_id_seq;
       public          postgres    false    219            H           0    0    empleados_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.empleados_id_seq OWNED BY public.empleados.id;
          public          postgres    false    220            �            1259    19634    login    TABLE     �   CREATE TABLE public.login (
    id integer NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);
    DROP TABLE public.login;
       public         heap    postgres    false            �            1259    19639    login_id_seq    SEQUENCE     �   CREATE SEQUENCE public.login_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.login_id_seq;
       public          postgres    false    221            I           0    0    login_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.login_id_seq OWNED BY public.login.id;
          public          postgres    false    222            �            1259    19640    marcas    TABLE     �   CREATE TABLE public.marcas (
    id integer NOT NULL,
    descripcion character varying(100),
    estado character varying(20)
);
    DROP TABLE public.marcas;
       public         heap    postgres    false            �            1259    19643    marcas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.marcas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.marcas_id_seq;
       public          postgres    false    223            J           0    0    marcas_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.marcas_id_seq OWNED BY public.marcas.id;
          public          postgres    false    224            �            1259    19644    ordenes_de_compra    TABLE     '  CREATE TABLE public.ordenes_de_compra (
    numero_orden integer NOT NULL,
    solicitud_id integer,
    fecha_orden date,
    estado character varying(20),
    articulo_id integer,
    cantidad integer,
    unidad_de_medida_id integer,
    marca_id integer,
    costo_unitario numeric(10,2)
);
 %   DROP TABLE public.ordenes_de_compra;
       public         heap    postgres    false            �            1259    19647 "   ordenes_de_compra_numero_orden_seq    SEQUENCE     �   CREATE SEQUENCE public.ordenes_de_compra_numero_orden_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.ordenes_de_compra_numero_orden_seq;
       public          postgres    false    225            K           0    0 "   ordenes_de_compra_numero_orden_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.ordenes_de_compra_numero_orden_seq OWNED BY public.ordenes_de_compra.numero_orden;
          public          postgres    false    226            �            1259    19648    proveedores    TABLE     �   CREATE TABLE public.proveedores (
    id integer NOT NULL,
    cedula_rnc character varying(20),
    nombre_comercial character varying(100),
    estado character varying(20)
);
    DROP TABLE public.proveedores;
       public         heap    postgres    false            �            1259    19651    proveedores_id_seq    SEQUENCE     �   CREATE SEQUENCE public.proveedores_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.proveedores_id_seq;
       public          postgres    false    227            L           0    0    proveedores_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.proveedores_id_seq OWNED BY public.proveedores.id;
          public          postgres    false    228            �            1259    19652    solicitudes_de_articulos    TABLE     �   CREATE TABLE public.solicitudes_de_articulos (
    id integer NOT NULL,
    empleado_solicitante integer,
    fecha_solicitud date,
    articulo_id integer,
    cantidad integer,
    unidad_de_medida_id integer,
    estado character varying(20)
);
 ,   DROP TABLE public.solicitudes_de_articulos;
       public         heap    postgres    false            �            1259    19655    solicitudes_de_articulos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.solicitudes_de_articulos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.solicitudes_de_articulos_id_seq;
       public          postgres    false    229            M           0    0    solicitudes_de_articulos_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.solicitudes_de_articulos_id_seq OWNED BY public.solicitudes_de_articulos.id;
          public          postgres    false    230            �            1259    19656    unidades_de_medida    TABLE     �   CREATE TABLE public.unidades_de_medida (
    id integer NOT NULL,
    descripcion character varying(100),
    estado character varying(20)
);
 &   DROP TABLE public.unidades_de_medida;
       public         heap    postgres    false            �            1259    19659    unidades_de_medida_id_seq    SEQUENCE     �   CREATE SEQUENCE public.unidades_de_medida_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.unidades_de_medida_id_seq;
       public          postgres    false    231            N           0    0    unidades_de_medida_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.unidades_de_medida_id_seq OWNED BY public.unidades_de_medida.id;
          public          postgres    false    232            y           2604    19660    articulos id    DEFAULT     l   ALTER TABLE ONLY public.articulos ALTER COLUMN id SET DEFAULT nextval('public.articulos_id_seq'::regclass);
 ;   ALTER TABLE public.articulos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            z           2604    19661    departamentos id    DEFAULT     t   ALTER TABLE ONLY public.departamentos ALTER COLUMN id SET DEFAULT nextval('public.departamentos_id_seq'::regclass);
 ?   ALTER TABLE public.departamentos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217            {           2604    19662    empleados id    DEFAULT     l   ALTER TABLE ONLY public.empleados ALTER COLUMN id SET DEFAULT nextval('public.empleados_id_seq'::regclass);
 ;   ALTER TABLE public.empleados ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219            |           2604    19663    login id    DEFAULT     d   ALTER TABLE ONLY public.login ALTER COLUMN id SET DEFAULT nextval('public.login_id_seq'::regclass);
 7   ALTER TABLE public.login ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    221            }           2604    19664 	   marcas id    DEFAULT     f   ALTER TABLE ONLY public.marcas ALTER COLUMN id SET DEFAULT nextval('public.marcas_id_seq'::regclass);
 8   ALTER TABLE public.marcas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223            ~           2604    19665    ordenes_de_compra numero_orden    DEFAULT     �   ALTER TABLE ONLY public.ordenes_de_compra ALTER COLUMN numero_orden SET DEFAULT nextval('public.ordenes_de_compra_numero_orden_seq'::regclass);
 M   ALTER TABLE public.ordenes_de_compra ALTER COLUMN numero_orden DROP DEFAULT;
       public          postgres    false    226    225                       2604    19666    proveedores id    DEFAULT     p   ALTER TABLE ONLY public.proveedores ALTER COLUMN id SET DEFAULT nextval('public.proveedores_id_seq'::regclass);
 =   ALTER TABLE public.proveedores ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    227            �           2604    19667    solicitudes_de_articulos id    DEFAULT     �   ALTER TABLE ONLY public.solicitudes_de_articulos ALTER COLUMN id SET DEFAULT nextval('public.solicitudes_de_articulos_id_seq'::regclass);
 J   ALTER TABLE public.solicitudes_de_articulos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    230    229            �           2604    19668    unidades_de_medida id    DEFAULT     ~   ALTER TABLE ONLY public.unidades_de_medida ALTER COLUMN id SET DEFAULT nextval('public.unidades_de_medida_id_seq'::regclass);
 D   ALTER TABLE public.unidades_de_medida ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    232    231            .          0    19622 	   articulos 
   TABLE DATA           g   COPY public.articulos (id, descripcion, marca_id, unidad_de_medida_id, existencia, estado) FROM stdin;
    public          postgres    false    215   �a       0          0    19626    departamentos 
   TABLE DATA           @   COPY public.departamentos (id, descripcion, estado) FROM stdin;
    public          postgres    false    217   yb       2          0    19630 	   empleados 
   TABLE DATA           U   COPY public.empleados (id, cedula, descripcion, departamento_id, estado) FROM stdin;
    public          postgres    false    219   c       4          0    19634    login 
   TABLE DATA           7   COPY public.login (id, username, password) FROM stdin;
    public          postgres    false    221   �c       6          0    19640    marcas 
   TABLE DATA           9   COPY public.marcas (id, descripcion, estado) FROM stdin;
    public          postgres    false    223   �c       8          0    19644    ordenes_de_compra 
   TABLE DATA           �   COPY public.ordenes_de_compra (numero_orden, solicitud_id, fecha_orden, estado, articulo_id, cantidad, unidad_de_medida_id, marca_id, costo_unitario) FROM stdin;
    public          postgres    false    225   Md       :          0    19648    proveedores 
   TABLE DATA           O   COPY public.proveedores (id, cedula_rnc, nombre_comercial, estado) FROM stdin;
    public          postgres    false    227   �d       <          0    19652    solicitudes_de_articulos 
   TABLE DATA           �   COPY public.solicitudes_de_articulos (id, empleado_solicitante, fecha_solicitud, articulo_id, cantidad, unidad_de_medida_id, estado) FROM stdin;
    public          postgres    false    229   [e       >          0    19656    unidades_de_medida 
   TABLE DATA           E   COPY public.unidades_de_medida (id, descripcion, estado) FROM stdin;
    public          postgres    false    231   �e       O           0    0    articulos_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.articulos_id_seq', 7, true);
          public          postgres    false    216            P           0    0    departamentos_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.departamentos_id_seq', 8, true);
          public          postgres    false    218            Q           0    0    empleados_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.empleados_id_seq', 16, true);
          public          postgres    false    220            R           0    0    login_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.login_id_seq', 3, true);
          public          postgres    false    222            S           0    0    marcas_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.marcas_id_seq', 5, true);
          public          postgres    false    224            T           0    0 "   ordenes_de_compra_numero_orden_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.ordenes_de_compra_numero_orden_seq', 6, true);
          public          postgres    false    226            U           0    0    proveedores_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.proveedores_id_seq', 9, true);
          public          postgres    false    228            V           0    0    solicitudes_de_articulos_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.solicitudes_de_articulos_id_seq', 8, true);
          public          postgres    false    230            W           0    0    unidades_de_medida_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.unidades_de_medida_id_seq', 5, true);
          public          postgres    false    232            �           2606    19670    articulos articulos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.articulos
    ADD CONSTRAINT articulos_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.articulos DROP CONSTRAINT articulos_pkey;
       public            postgres    false    215            �           2606    19672     departamentos departamentos_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.departamentos
    ADD CONSTRAINT departamentos_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.departamentos DROP CONSTRAINT departamentos_pkey;
       public            postgres    false    217            �           2606    19674    empleados empleados_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT empleados_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.empleados DROP CONSTRAINT empleados_pkey;
       public            postgres    false    219            �           2606    19676    login login_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.login DROP CONSTRAINT login_pkey;
       public            postgres    false    221            �           2606    19678    marcas marcas_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.marcas
    ADD CONSTRAINT marcas_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.marcas DROP CONSTRAINT marcas_pkey;
       public            postgres    false    223            �           2606    19680 (   ordenes_de_compra ordenes_de_compra_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.ordenes_de_compra
    ADD CONSTRAINT ordenes_de_compra_pkey PRIMARY KEY (numero_orden);
 R   ALTER TABLE ONLY public.ordenes_de_compra DROP CONSTRAINT ordenes_de_compra_pkey;
       public            postgres    false    225            �           2606    19682    proveedores proveedores_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.proveedores DROP CONSTRAINT proveedores_pkey;
       public            postgres    false    227            �           2606    19684 6   solicitudes_de_articulos solicitudes_de_articulos_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.solicitudes_de_articulos
    ADD CONSTRAINT solicitudes_de_articulos_pkey PRIMARY KEY (id);
 `   ALTER TABLE ONLY public.solicitudes_de_articulos DROP CONSTRAINT solicitudes_de_articulos_pkey;
       public            postgres    false    229            �           2606    19686 *   unidades_de_medida unidades_de_medida_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.unidades_de_medida
    ADD CONSTRAINT unidades_de_medida_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.unidades_de_medida DROP CONSTRAINT unidades_de_medida_pkey;
       public            postgres    false    231            �           2620    19760 /   ordenes_de_compra trigger_actualizar_existencia    TRIGGER     �   CREATE TRIGGER trigger_actualizar_existencia AFTER INSERT ON public.ordenes_de_compra FOR EACH ROW EXECUTE FUNCTION public.actualizar_existencia();
 H   DROP TRIGGER trigger_actualizar_existencia ON public.ordenes_de_compra;
       public          postgres    false    233    225            �           2606    19687 !   articulos articulos_marca_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.articulos
    ADD CONSTRAINT articulos_marca_id_fkey FOREIGN KEY (marca_id) REFERENCES public.marcas(id);
 K   ALTER TABLE ONLY public.articulos DROP CONSTRAINT articulos_marca_id_fkey;
       public          postgres    false    4747    223    215            �           2606    19692 ,   articulos articulos_unidad_de_medida_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.articulos
    ADD CONSTRAINT articulos_unidad_de_medida_id_fkey FOREIGN KEY (unidad_de_medida_id) REFERENCES public.unidades_de_medida(id);
 V   ALTER TABLE ONLY public.articulos DROP CONSTRAINT articulos_unidad_de_medida_id_fkey;
       public          postgres    false    4755    231    215            �           2606    19697 (   empleados empleados_departamento_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT empleados_departamento_id_fkey FOREIGN KEY (departamento_id) REFERENCES public.departamentos(id);
 R   ALTER TABLE ONLY public.empleados DROP CONSTRAINT empleados_departamento_id_fkey;
       public          postgres    false    217    219    4741            �           2606    19702 4   ordenes_de_compra ordenes_de_compra_articulo_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ordenes_de_compra
    ADD CONSTRAINT ordenes_de_compra_articulo_id_fkey FOREIGN KEY (articulo_id) REFERENCES public.articulos(id);
 ^   ALTER TABLE ONLY public.ordenes_de_compra DROP CONSTRAINT ordenes_de_compra_articulo_id_fkey;
       public          postgres    false    4739    225    215            �           2606    19707 1   ordenes_de_compra ordenes_de_compra_marca_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ordenes_de_compra
    ADD CONSTRAINT ordenes_de_compra_marca_id_fkey FOREIGN KEY (marca_id) REFERENCES public.marcas(id);
 [   ALTER TABLE ONLY public.ordenes_de_compra DROP CONSTRAINT ordenes_de_compra_marca_id_fkey;
       public          postgres    false    223    4747    225            �           2606    19712 5   ordenes_de_compra ordenes_de_compra_solicitud_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ordenes_de_compra
    ADD CONSTRAINT ordenes_de_compra_solicitud_id_fkey FOREIGN KEY (solicitud_id) REFERENCES public.solicitudes_de_articulos(id);
 _   ALTER TABLE ONLY public.ordenes_de_compra DROP CONSTRAINT ordenes_de_compra_solicitud_id_fkey;
       public          postgres    false    229    4753    225            �           2606    19717 <   ordenes_de_compra ordenes_de_compra_unidad_de_medida_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ordenes_de_compra
    ADD CONSTRAINT ordenes_de_compra_unidad_de_medida_id_fkey FOREIGN KEY (unidad_de_medida_id) REFERENCES public.unidades_de_medida(id);
 f   ALTER TABLE ONLY public.ordenes_de_compra DROP CONSTRAINT ordenes_de_compra_unidad_de_medida_id_fkey;
       public          postgres    false    231    4755    225            �           2606    19722 B   solicitudes_de_articulos solicitudes_de_articulos_articulo_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.solicitudes_de_articulos
    ADD CONSTRAINT solicitudes_de_articulos_articulo_id_fkey FOREIGN KEY (articulo_id) REFERENCES public.articulos(id);
 l   ALTER TABLE ONLY public.solicitudes_de_articulos DROP CONSTRAINT solicitudes_de_articulos_articulo_id_fkey;
       public          postgres    false    215    229    4739            �           2606    19727 K   solicitudes_de_articulos solicitudes_de_articulos_empleado_solicitante_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.solicitudes_de_articulos
    ADD CONSTRAINT solicitudes_de_articulos_empleado_solicitante_fkey FOREIGN KEY (empleado_solicitante) REFERENCES public.empleados(id);
 u   ALTER TABLE ONLY public.solicitudes_de_articulos DROP CONSTRAINT solicitudes_de_articulos_empleado_solicitante_fkey;
       public          postgres    false    4743    219    229            �           2606    19732 J   solicitudes_de_articulos solicitudes_de_articulos_unidad_de_medida_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.solicitudes_de_articulos
    ADD CONSTRAINT solicitudes_de_articulos_unidad_de_medida_id_fkey FOREIGN KEY (unidad_de_medida_id) REFERENCES public.unidades_de_medida(id);
 t   ALTER TABLE ONLY public.solicitudes_de_articulos DROP CONSTRAINT solicitudes_de_articulos_unidad_de_medida_id_fkey;
       public          postgres    false    4755    231    229            .   �   x�U�1�0���ǈI;\�tt9k����+�}�v��|������sZ2��5Fcq�,�����L�ą!�65��.{0����/I?l�݇��lN�֒�u$-�̺:��AzE�,�Z�c�Er;�      0   {   x�3�K�+I,�tL.�,��2�IM����O?�6&h���\ZT�_��Q����Wn��Ԟ�������陗7��/H-JL���K�+6��M,�N-��K焪3��-(��dq����� �6Z      2   �   x�M�;�0D��)|G���SR�#"q�4��1ȁ�U��Ų!�f��7C��)����p�C�M��U;��A8����������<ǜB��pI�Gj��B�A��-�u	�r���n4�H��wT|�M�� ��=��ڍB�k��oU
��Ӻ�mv��!�]70      4   4   x�3��M�+M��442�2��H,ʩ,�415�2�tJ-��L�4�������  P
�      6   E   x�3�t,(�I�tL.�,��2�N�-.�K�	s�f&�秕pz�%BM8=`
L9]Rsr`�=... k��      8   B   x�3�4�4202�5 "Nǂ���ĔDN3N#NC �01�30�2�@(�D(3+3�4� +����� ��      :   �   x�E��
�0Eד�)�dY���	��F4���F���Egy�9��HF�BB��]�Kd���h�[ޞ�Z����\��|�V�<�uG$ Z�V*���T�8����sC���:s�1L���X%J� �z�����yWJ#qk���\���ȃ�
h�ۣ��.��k0H^      <   E   x�3�4�4202�5 "N3N# t,(�OJLI�2q�eM8��@.\�(k�,k�i�,�Y6F��� 4��      >   H   x�3���LIL�tL.�,��2�t�ON�K��9�3s�Ӌs�aB&�>�%E���y�SN�T� T>F��� ڔ^     