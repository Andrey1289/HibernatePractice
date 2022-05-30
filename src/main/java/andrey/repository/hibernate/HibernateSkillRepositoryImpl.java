package andrey.repository.hibernate;

import andrey.model.Skill;
import andrey.repository.SkillRepository;
import andrey.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class HibernateSkillRepositoryImpl implements SkillRepository {
  @Override
    public List<Skill> getAll() {
      Session session = HibernateUtils.getSession();
        List<Skill> skills = session.createQuery("FROM Skill").list();
        HibernateUtils.closeSession(session);
        for (Skill sk: skills) {
            System.out.println(sk);
        }
        return skills;
    }

    @Override
    public Skill getById(Long id)  {
       Session session = HibernateUtils.getSession();
       Skill skill = session.get(Skill.class,id);
       HibernateUtils.closeSession(session);
        System.out.println(skill);
        return skill;
    }

    @Override
    public Skill save(Skill skill) {
        Session session = HibernateUtils.getSession();
        session.save(skill);
        HibernateUtils.closeSession(session);
        return skill;
    }

    @Override
    public Skill update(Skill skill) {
      Session session = HibernateUtils.getSession();
      session.update(skill);
      HibernateUtils.closeSession(session);
      return skill;
    }

    @Override
    public void deleteById(Long id) {
     Session session = HibernateUtils.getSession();
     Skill skill = session.get(Skill.class,id);
     session.delete(skill);
     HibernateUtils.closeSession(session);
    }
}
