create table goods(
	gid varchar(15) primary key,
    title varchar(200) not null,
    image varchar(200),
    price int default 0,
    brand varchar(100),
    maker varchar(100),
    regDate datetime default now()
);

delete from goods where gid='1234';
select count(*) from goods;

select * from goods order by regdate desc;


update goods
set image=null
where gid>'';

alter table goods
add column contents text;

desc goods;

select * from goods order by regdate desc;

update goods
set contents='테스트중입니다.'
where gid='7057422395';


create table attach(
	aid int auto_increment primary key,
    gid varchar(15) not null,
    filename varchar(200) not null,
    foreign key(gid) references goods(gid)
);

desc attach;

select * from attach;
select * from goods;

create table users(
	uid varchar(20) primary key not null,
    upass varchar(500) not null,
    uname varchar(20) not null
);
desc users;

select * from users;




update users
set uname='이블루'
where uid='blue';

create table related(
    gid varchar(15) not null,
    rid varchar(15) not null,
    primary key(gid, rid),
    foreign key(gid) references goods(gid),
    foreign key(rid) references goods(gid)
);

select * from related;
desc related;

select r.*, title,image, price
from goods g inner join related r on r.rid=g.gid
where r.gid='7057422395';

delete from related
where gid>'';

drop table review;
create table review(
	rid int auto_increment primary key,
    gid varchar(15) not null,
    uid varchar(20) not null,
    contents text not null,
    regDate datetime default now(),
    rating float default 0,
    foreign key(gid) references goods(gid),
    foreign key(uid) references users(uid)
);

desc review;
select * from review;