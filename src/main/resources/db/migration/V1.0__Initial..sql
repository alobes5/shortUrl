create table url_table (
    ID identity not null primary key,
    KEY_CODE varchar(10) not null unique,
    SHORT_URL varchar(100) not null unique,
    LONG_URL varchar(200) not null unique
);

create index IDX_KEY on URL_TABLE(KEY_CODE);
