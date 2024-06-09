create table users(
    id serial not null primary key,
    name varchar(255) not null,
    email varchar(500) not null unique,
    password varchar(100) not null,
    profile varchar(5) not null
);

create table courses(
    id serial not null primary key,
    name varchar(255) not null unique,
    category varchar(100) not null
);

create table topics(

    id serial not null primary key,
    title varchar(255) not null unique,
    message varchar(500) not null unique,
    creation_date timestamp not null,
    status boolean not null,
    user_id bigint not null,
    course_id bigint not null,

    constraint fk_topics_user_id foreign key(user_id) references users(id),
    constraint fk_topics_course_id foreign key(course_id) references courses(id)
);

create table answers(
    id serial not null primary key,
    message varchar(500) not null unique,
    topic_id bigint not null,
    user_id bigint not null,
    creation_date timestamp not null,

    constraint fk_answers_topic_id foreign key(topic_id) references topics(id),
    constraint fk_answers_user_id foreign key(user_id) references users(id)
);





