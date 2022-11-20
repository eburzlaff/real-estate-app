create table user
(
    id         int auto_increment
        primary key,
    first_name varchar(200) null,
    last_name  varchar(200) null,
    user_name  varchar(200) null,
    password   varchar(200) null,
    email      varchar(200) null
);

create table property
(
    id                int auto_increment
        primary key,
    address           varchar(200) null,
    price             int          null,
    description       varchar(200) null,
    property_type     varchar(200) null,
    availability_type varchar(200) null,
    bedroom_number    int          null,
    bathroom_number   int          null,
    user_id           int          null,
    constraint user_id
        foreign key (user_id) references user (id)
);

