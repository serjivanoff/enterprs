package model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
@NamedQueries({@NamedQuery(name=User.ALL_USERS, query="SELECT u FROM User u ORDER by u.firstName"),
               @NamedQuery(name=User.DELETE_USER, query="DELETE FROM User u WHERE u.id=:id")})
public class User extends BaseEntity{
    public static final String DELETE_USER = "User.delete";
    public static final String ALL_USERS = "User.getAll";
    @Column(name = "firstname")
    @NotBlank
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    @NotBlank
    private String lastName;

    @Column(name = "age")
    @Range(min=1, max=99)
    private int age;

    @Range(min=0, max=999)
    @Column(name = "experience")
    private long experience;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date registered;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name="user_roles",joinColumns = @JoinColumn(name="user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @OneToMany(mappedBy="user")
    private List<Contact> contacts;

    public User() {
    }

    public User(int id, String firstName, String middleName, String lastName, int age, long experience) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.experience = experience;
        this.registered = new Date();
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
    public boolean isNew(){
        return this.getId()<0;
    }
}
