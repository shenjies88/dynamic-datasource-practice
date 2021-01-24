create table if not exists datasource1.user
(
    id
    int
    auto_increment
    primary
    key,
    name
    varchar
(
    20
) null,
    age int null
    ) comment '用户';

create table if not exists datasource2.member
(
    id
    int
    auto_increment
    primary
    key,
    name
    varchar
(
    20
) null,
    age int null
    );



