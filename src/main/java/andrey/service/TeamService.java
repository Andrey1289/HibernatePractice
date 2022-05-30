package andrey.service;

import andrey.model.Team;
import andrey.repository.hibernate.HibernateTeamRepositoryImpl;

import java.util.List;

public class TeamService {
    private final HibernateTeamRepositoryImpl teamRepo;

    public TeamService(){
        teamRepo = new HibernateTeamRepositoryImpl();
    }
    public Team get(Long id){
        return teamRepo.getById(id);
    }
    public List<Team> getAll(){
        return teamRepo.getAll();
    }
    public Team saveTeam(Team team){
        return teamRepo.save(team);
    }
    public Team updateTeam(Team team){
        return teamRepo.update(team);
    }
    public void delete(Long id){
        teamRepo.deleteById(id);
    }
}
