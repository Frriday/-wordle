create database if not exists game;
use game;
create table if not exists answer(
    id int primary key auto_increment comment '数据词条的id',
    answer_date date unique comment '答案的日期',
    answer_solution varchar(100) comment '答案'
);