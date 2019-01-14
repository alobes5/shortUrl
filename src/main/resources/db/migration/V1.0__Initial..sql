
create table url_table (
    ID SERIAL primary key,
    KEY_CODE varchar(10) not null ,
    SHORT_URL varchar(100) not null ,
    LONG_URL varchar(200) not null
);

create index IDX_KEY on URL_TABLE(KEY_CODE);
