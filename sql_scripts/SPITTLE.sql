create table SPITTLE
(
    ID           SERIAL PRIMARY KEY,
    SPITTER_ID   INT,
    SPITTLE_TEXT CHARACTER VARYING(1000),
    POSTED_TIME  TIMESTAMP,
    constraint FK_SPITTLE_SPITTER
        foreign key (SPITTER_ID) references SPITTER
            on update cascade
);
