/*==============================================================*/
/* Nom de SGBD : MySQL 5.0 */
/* Date de création : 26/06/2012 14:41:11 */
/*==============================================================*/


drop table if exists ABONNE;

drop table if exists ABONNEMENT;

drop table if exists CATEGORIEPERMIS;

drop table if exists CATEGORIEVEHICULE;

drop table if exists DETENIR;

drop table if exists EMPLACEMENT;

drop table if exists EMPLOYE;

drop table if exists HISTORIQUEABONNEMENT;

drop table if exists INCLURE;

drop table if exists POINTLOCATION;

drop table if exists REGISTRE;

drop table if exists RESAGLOBALE;

drop table if exists TYPEABONNEMENT;

drop table if exists UTILISATEUR;

drop table if exists VEHICULE;

drop table if exists VILLE;

/*==============================================================*/
/* Table : ABONNE */
/*==============================================================*/
create table ABONNE
(
   IDABONNE int not null auto_increment,
   IDVILLE int not null,
   NOMABONNE varchar(50) not null,
   PRENOMABONNE varchar(50) not null,
   ADRESSE varchar(200) not null,
   TEL varchar(50) not null,
   DATENAISSANCE date not null,
   SEXE varchar(1) not null,
   TITULAIRECOMPTE varchar(50) not null,
   CODEBANQUE varchar(30) not null,
   CODEAGENCE varchar(30) not null,
   NUMEROCOMPTE varchar(30) not null,
   CLEFRIB varchar(30) not null,
   primary key (IDABONNE)
);

/*==============================================================*/
/* Table : ABONNEMENT */
/*==============================================================*/
create table ABONNEMENT
(
   IDABONNEMENT int not null auto_increment,
   IDTYPE int not null,
   IDABONNE int not null,
   DHSOUSCRIPTION datetime not null,
   DHRESILIATION datetime,
   primary key (IDABONNEMENT)
);

/*==============================================================*/
/* Table : CATEGORIEPERMIS */
/*==============================================================*/
create table CATEGORIEPERMIS
(
   IDCATEGORIEPERMIS int not null auto_increment,
   NOMPERMIS varchar(20) not null,
   primary key (IDCATEGORIEPERMIS)
);

/*==============================================================*/
/* Table : CATEGORIEVEHICULE */
/*==============================================================*/
create table CATEGORIEVEHICULE
(
   IDCATEGORIEVEHICULE int not null auto_increment,
   IDCATEGORIEPERMIS int,
   NOMTYPEVEHICULE varchar(50),
   TAUXHORAIRE float,
   TAUXKILOMETRIQUE float,
   primary key (IDCATEGORIEVEHICULE)
);

/*==============================================================*/
/* Table : DETENIR */
/*==============================================================*/
create table DETENIR
(
   IDABONNE int not null,
   IDCATEGORIEPERMIS int not null,
   primary key (IDABONNE, IDCATEGORIEPERMIS)
   
);

/*==============================================================*/
/* Table : EMPLACEMENT */
/*==============================================================*/
create table EMPLACEMENT
(
   IDEMPLACEMENT int not null auto_increment,
   IDCATEGORIEVEHICULE int not null,
   IDPOINTLOCATION int not null,
   primary key (IDEMPLACEMENT)
);

/*==============================================================*/
/* Table : EMPLOYE */
/*==============================================================*/
create table EMPLOYE
(
   IDEMPLOYE int not null auto_increment,
   NOMEMPLOYE varchar(45) not null,
   PRENOMEMPLOYE varchar(45) not null,
   SERVICE varchar(45),
   primary key (IDEMPLOYE)
);

/*==============================================================*/
/* Table : HISTORIQUEABONNEMENT */
/*==============================================================*/
create table HISTORIQUEABONNEMENT
(
   IDTYPEFINABONNEMENT int not null,
   IDTYPEDEBUTABONNEMENT int not null,
   IDABONNEMENT int not null,
   DHHISTORIQUE datetime not null
);

/*==============================================================*/
/* Table : INCLURE */
/*==============================================================*/
create table INCLURE
(
   IDCATEGORIEVEHICULE int not null,
   IDTYPE int not null,
   primary key (IDCATEGORIEVEHICULE, IDTYPE)
);

/*==============================================================*/
/* Table : POINTLOCATION */
/*==============================================================*/
create table POINTLOCATION
(
   IDPOINTLOCATION int not null auto_increment,
   NOMPOINTLOCATION varchar(50) not null,
   LATTITUDE double not null,
   LONGITUDE double not null,
   primary key (IDPOINTLOCATION)
);

/*==============================================================*/
/* Table : REGISTRE */
/*==============================================================*/
create table REGISTRE
(
   IDREGISTRE int not null auto_increment,
   IDPOINTLOCATION int not null,
   POI_IDPOINTLOCATION int,
   IDVEHICULE int,
   IDABONNEMENT int,
   IDRESAGLOBALE int,
   IDEMPLACEMENT int,
   IDEMPLOYE int,
   DHDEBUTLOCATION datetime,
   DHRETOURLOCATION datetime,
   DHARRIVEECLIENT datetime,
   DHRESERVATIONPREVUE datetime,
   DHANNULATIONRESERVATION datetime,
   DHDEBUTDEPLACEMENT datetime,
   DHRETOURDEPLACEMENT datetime,
   primary key (IDREGISTRE)
);

/*==============================================================*/
/* Table : RESAGLOBALE */
/*==============================================================*/
create table RESAGLOBALE
(
   IDRESAGLOBALE int not null auto_increment,
   IDABONNEMENT int not null,
   DHCREATION datetime not null,
   DHANNULATION datetime,
   primary key (IDRESAGLOBALE)
);

/*==============================================================*/
/* Table : TYPEABONNEMENT */
/*==============================================================*/
create table TYPEABONNEMENT
(
   IDTYPE int not null auto_increment,
   NOMABONNEMENT varchar(50) not null,
   COUT float not null,
   primary key (IDTYPE)
);

/*==============================================================*/
/* Table : UTILISATEUR */
/*==============================================================*/
create table UTILISATEUR
(
   IDUTILISATEUR int not null auto_increment,
   IDABONNE int,
   IDEMPLOYE int,
   EMAIL varchar(50) not null,
   MOTDEPASS_HASH varchar(100) not null,
   MOTDEPASS_SALT varchar(100) not null,
   ROLE varchar(50) not null,
   primary key (IDUTILISATEUR)
);

/*==============================================================*/
/* Table : VEHICULE */
/*==============================================================*/
create table VEHICULE
(
   IDVEHICULE int not null auto_increment,
   IDCATEGORIEVEHICULE int not null,
   primary key (IDVEHICULE)
);

/*==============================================================*/
/* Table : VILLE */
/*==============================================================*/
create table VILLE
(
   IDVILLE int not null auto_increment,
   NOMVILLE varchar(50) not null,
   CODEPOSTAL varchar(20) not null,
   primary key (IDVILLE)
);

alter table ABONNE add constraint FK_HABITER foreign key (IDVILLE)
      references VILLE (IDVILLE) on delete restrict on update restrict;

alter table ABONNEMENT add constraint FK_CHOISIR foreign key (IDTYPE)
      references TYPEABONNEMENT (IDTYPE) on delete restrict on update restrict;

alter table ABONNEMENT add constraint FK_SOUSCRIRE foreign key (IDABONNE)
      references ABONNE (IDABONNE) on delete restrict on update restrict;

alter table CATEGORIEVEHICULE add constraint FK_AUTORISER foreign key (IDCATEGORIEPERMIS)
      references CATEGORIEPERMIS (IDCATEGORIEPERMIS) on delete restrict on update restrict;

alter table DETENIR add constraint FK_DETENIR foreign key (IDABONNE)
      references ABONNE (IDABONNE) on delete restrict on update restrict;

alter table DETENIR add constraint FK_DETENIR2 foreign key (IDCATEGORIEPERMIS)
      references CATEGORIEPERMIS (IDCATEGORIEPERMIS) on delete restrict on update restrict;

alter table EMPLACEMENT add constraint FK_CONVENIR foreign key (IDCATEGORIEVEHICULE)
      references CATEGORIEVEHICULE (IDCATEGORIEVEHICULE) on delete restrict on update restrict;

alter table EMPLACEMENT add constraint FK_POSSEDER foreign key (IDPOINTLOCATION)
      references POINTLOCATION (IDPOINTLOCATION) on delete restrict on update restrict;

alter table HISTORIQUEABONNEMENT add constraint FK_AVOIR_DEBUT_ABONNEMENT foreign key (IDTYPEDEBUTABONNEMENT)
      references TYPEABONNEMENT (IDTYPE) on delete restrict on update restrict;

alter table HISTORIQUEABONNEMENT add constraint FK_AVOIR_FIN_ABONNEMENT foreign key (IDTYPEFINABONNEMENT)
      references TYPEABONNEMENT (IDTYPE) on delete restrict on update restrict;

alter table HISTORIQUEABONNEMENT add constraint FK_CONCERNER foreign key (IDABONNEMENT)
      references ABONNEMENT (IDABONNEMENT) on delete restrict on update restrict;

alter table INCLURE add constraint FK_INCLURE foreign key (IDCATEGORIEVEHICULE)
      references CATEGORIEVEHICULE (IDCATEGORIEVEHICULE) on delete restrict on update restrict;

alter table INCLURE add constraint FK_INCLURE2 foreign key (IDTYPE)
      references TYPEABONNEMENT (IDTYPE) on delete restrict on update restrict;

alter table REGISTRE add constraint FK_ARRIVER_LOCATION_DEPLACEMENT foreign key (IDEMPLACEMENT)
      references EMPLACEMENT (IDEMPLACEMENT) on delete restrict on update restrict;

alter table REGISTRE add constraint FK_ARRIVER_RESERVATION foreign key (POI_IDPOINTLOCATION)
      references POINTLOCATION (IDPOINTLOCATION) on delete restrict on update restrict;

alter table REGISTRE add constraint FK_CONTENIR foreign key (IDVEHICULE)
      references VEHICULE (IDVEHICULE) on delete restrict on update restrict;

alter table REGISTRE add constraint FK_DEPART_TRAJET foreign key (IDPOINTLOCATION)
      references POINTLOCATION (IDPOINTLOCATION) on delete restrict on update restrict;

alter table REGISTRE add constraint FK_DEPLACER foreign key (IDEMPLOYE)
      references EMPLOYE (IDEMPLOYE) on delete restrict on update restrict;

alter table REGISTRE add constraint FK_DISPOSER_DE foreign key (IDRESAGLOBALE)
      references RESAGLOBALE (IDRESAGLOBALE) on delete restrict on update restrict;

alter table REGISTRE add constraint FK_LOUER foreign key (IDABONNEMENT)
      references ABONNEMENT (IDABONNEMENT) on delete restrict on update restrict;

alter table RESAGLOBALE add constraint FK_RESERVER foreign key (IDABONNEMENT)
      references ABONNEMENT (IDABONNEMENT) on delete restrict on update restrict;

alter table UTILISATEUR add constraint FK_ETRE_EMPLOYE2 foreign key (IDEMPLOYE)
      references EMPLOYE (IDEMPLOYE) on delete restrict on update restrict;

alter table UTILISATEUR add constraint FK_ETRE_UTILISATEUR2 foreign key (IDABONNE)
      references ABONNE (IDABONNE) on delete restrict on update restrict;

alter table VEHICULE add constraint FK_APPARTENIR foreign key (IDCATEGORIEVEHICULE)
      references CATEGORIEVEHICULE (IDCATEGORIEVEHICULE) on delete restrict on update restrict;