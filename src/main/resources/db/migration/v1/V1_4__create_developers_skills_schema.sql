create table developers_skills (
    developer_id bigint,
    skill_id bigint,
    foreign key (developer_id) references developers(id),
    foreign key (skill_id) references skills(id)
)