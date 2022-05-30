package andrey.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Transient
    private Long teamId;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "developers_skills",
            joinColumns ={@JoinColumn(name = "developer_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private Set<Skill> devSkills = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
            ,fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Developer(Long id, String firstName, String lastName, Long teamId, Set<Skill> skills) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamId = teamId;
        this.devSkills = skills;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Developer(){}

    public Developer(Long id, String firstName, String lastName, Long teamId){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamId = teamId;
    }

    public Developer(String firstName,String lastName,Team team){
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Skill> getSkills() {
        return devSkills;
    }

    public void setSkills(Set<Skill> skills) {
        this.devSkills = skills;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teamId=" + team.getId() +
                ", skills=" + devSkills +
                ", teamName=" + team.getName() +
                '}';
    }
}
