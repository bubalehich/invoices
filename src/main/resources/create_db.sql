create table if not exists card
(
    id          bigint       not null,
    barcode     varchar(45)  not null,
    holder_name varchar(255),
    is_active   boolean,
    primary key (id),
    constraint uk_mlbf4rr2ayv1hffdgbfk1uxf9
    unique (barcode),
    );

create table if not exists cash_receipt
(
    id            bigint         not null,
    barcode       varchar(45)    not null,
    cashier       varchar(255)   not null,
    date          timestamp(6)   not null,
    discount      numeric(38, 2),
    taxable_total numeric(38, 2),
    total         numeric(38, 2) not null,
    card_id       bigint,
    primary key (id),
    constraint uk_1ascoc8eol1u1sw15bbl7uwm7
    unique (barcode),
    constraint fklulhueyx3pw0djs2qnqhkj7l3
    foreign key (card_id) references card
    );

create table if not exists item
(
    id             bigint         not null,
    barcode        varchar(45)    not null,
    description    varchar(255)   not null,
    is_on_discount boolean,
    price          numeric(38, 2) not null,
    primary key (id),
    constraint uk_bfo0nhih8f3jl9m9ublnxr4uy
    unique (barcode)
    );

create table if not exists position
(
    id              bigint  not null,
    count           integer not null,
    cash_receipt_id bigint  not null,
    item_id         bigint  not null,
    primary key (id),
    constraint fkergcymjdmlfgl460iy0gvs5os
    foreign key (cash_receipt_id) references cash_receipt,
    constraint fk4povmr863xpok7k7blig5ndqx
    foreign key (item_id) references item
    );
