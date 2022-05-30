package andrey.controller;

import andrey.model.Developer;
import andrey.model.Skill;
import andrey.model.Team;
import andrey.service.DeveloperService;
import java.util.List;
import java.util.Set;

public class DeveloperController {
    private final DeveloperService devService;

    public DeveloperController() {
        devService = new DeveloperService();
    }


   public Developer get(Long id)  {
        return devService.get(id);
    }
    public List<Developer> getAll(){
        return devService.getAll();
    }

    public Developer create(String firstName, String lastName, Long team_id, Set<Skill> skills){
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setSkills(skills);
        developer.setTeamId(team_id);
        return devService.createDeveloper(developer);
    }

    public Developer update(Long id, String firstName, String lastName, Long team_id){
        Developer developer = new Developer();
        developer.setId(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setTeamId(team_id);
        return devService.updateDeveloper(developer);
    }

    public void delete(Long id){
        devService.delete(id);
    }
}
