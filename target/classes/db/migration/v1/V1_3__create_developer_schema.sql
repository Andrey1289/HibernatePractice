create table developers(
       id serial primary key ,
       firstName varchar(50) not null,
       lastName varchar(50) not null,
       team_id int not null,
       foreign key (team_id) references teams(id)
)