package andrey.service;

import andrey.model.Developer;
import andrey.repository.hibernate.HibernateDeveloperRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class DeveloperService {
    private final HibernateDeveloperRepositoryImpl devRepo;

    public DeveloperService(){
        devRepo = new HibernateDeveloperRepositoryImpl();
    }

  public Developer get(Long id)  {
        return devRepo.getById(id);
    }
    public List<Developer> getAll(){
        return devRepo.getAll();
    }
    public Developer createDeveloper(Developer developer){
        return devRepo.save(developer);
    }
    public Developer updateDeveloper(Developer developer){
        return devRepo.update(developer);
    }
    public void delete(Long id){
        devRepo.deleteById(id);
    }
}
