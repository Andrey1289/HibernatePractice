package andrey.repository.hibernate;

import andrey.model.Developer;
import andrey.model.Team;
import andrey.repository.TeamRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;
import java.util.List;
import java.util.Set;

public class HibernateTeamRepositoryImpl implements TeamRepository {
    @Override
    public List<Team> getAll() {
     Session session = HibernateUtils.getSession();
        List<Team> teams = HibernateUtils.getSession().createQuery("FROM Team").list();
        HibernateUtils.closeSession(session);
        for (Team tm: teams) {
            System.out.println(tm);
        }
        return teams;
    }

    @Override
    public Team getById(Long id) {
     Session session = HibernateUtils.getSession();
        Team team = HibernateUtils.getSession().get(Team.class,id);
        HibernateUtils.closeSession(session);
        System.out.println(team);
        return team;
    }

    @Override
    public Team save(Team team) {
     Session session =HibernateUtils.getSession();
     session.save(team);
       HibernateUtils.closeSession(session);
        return team;
    }

    @Override
    public Team update(Team team) {
        Session session = HibernateUtils.getSession();
        session.update(team);
        HibernateUtils.closeSession(session);
        return team;
    }

    @Override
    public void deleteById(Long id) {
       Session session = HibernateUtils.getSession();
       Team team = session.get(Team.class,id);
       session.delete(team);
       HibernateUtils.closeSession(session);
    }
}
