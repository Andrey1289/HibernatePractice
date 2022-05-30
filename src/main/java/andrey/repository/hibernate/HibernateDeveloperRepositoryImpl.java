package andrey.repository.hibernate;

import andrey.model.Developer;
import andrey.model.Skill;
import andrey.model.Team;
import andrey.repository.DeveloperRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;


public class HibernateDeveloperRepositoryImpl implements DeveloperRepository {
    @Override
    public List<Developer> getAll() {
        Session session = HibernateUtils.getSession();
        List<Developer> developerList = session.createQuery("FROM Developer").list();
        HibernateUtils.closeSession(session);
        for (Developer dev: developerList) {
            System.out.println(dev);
        }
        return developerList;
    }

    @Override
    public Developer getById(Long id)  {
        Session session =  HibernateUtils.getSession();
        Developer developer = session.get(Developer.class,id);
        HibernateUtils.closeSession(session);
        System.out.println(developer);
        return developer;
    }

    @Override
    public Developer save(Developer developer) {
       Session session = HibernateUtils.getSession();
        Query query = session.createQuery("FROM Team WHERE team_id=: id");
        query.setParameter("id",developer.getTeamId());
        Team team = (Team) query.getSingleResult();
        developer.setTeam(team);

        session.save(developer);
       HibernateUtils.closeSession(session);

        return developer;
    }

    @Override
    public Developer update(Developer developer) {
    Session session = HibernateUtils.getSession();
        Query query = session.createQuery("FROM Team WHERE team_id=: id");
        query.setParameter("id",developer.getTeamId());
        Team team = (Team) query.getSingleResult();
        developer.setTeam(team);
        System.out.println(developer);
    session.update(developer);
    HibernateUtils.closeSession(session);
        return developer;
    }

    @Override
    public void deleteById(Long id) {
        Session session =HibernateUtils.getSession();
       Developer developer = session.get(Developer.class,id);
        try {
          session.delete(developer);
        }catch (IllegalArgumentException e){
          System.out.println("Нет объекта по указанному id " + id);
        }
        HibernateUtils.closeSession(session);
    }
}
