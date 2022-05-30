package andrey.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long team_id;
    @Column(name = "name")
    private String name;
    @Column(name = "teamStatus")
    @Enumerated(EnumType.STRING)
    private TeamStatus teamStatus;
    @OneToMany(mappedBy = "team",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Set<Developer> developers = new HashSet<>();

    public Team(){}

    public Team(Long team_id){
        this.team_id = team_id;

    }
    public Team(String name){
        this.name = name;
    }


        public Long getId(){
        return team_id;
    }

        public void setId(Long id) {
        this.team_id = id;
    }

        public String getName() {
        return name;
    }

        public void setName(String name) {
        this.name = name;
    }

          public TeamStatus getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(TeamStatus teamStatus) {
        this.teamStatus = teamStatus;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Team{" +
                "team_id=" + team_id +
                ", name='" + name + '\'' +
                ", teamStatus=" + teamStatus +
                ", developers=" + developers +
                '}';
    }
}
