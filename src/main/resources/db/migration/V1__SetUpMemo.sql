create table memos (
    content varchar(200) not null primary key,
    author varchar(200) not null,
    created datetime not null
);

insert into memos (content, author, created) values ('Springを学ぶ', '金次郎', '2016-06-23 17:57:00.0');
insert into memos (content, author, created) values ('Thymeleafを学ぶ', '金次郎', '2016-06-23 17:57:00.0');
insert into memos (content, author, created) values ('Flywayを学ぶ', '金次郎', '2016-06-23 17:57:00.0');
