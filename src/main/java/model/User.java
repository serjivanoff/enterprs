package model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
@NamedQueries({@NamedQuery(name=User.ALL_USERS, query="SELECT u FROM User u ORDER BY u.id"),
               @NamedQuery(name=User.DELETE_USER, query="DELETE FROM User u WHERE u.id=:id"),
               @NamedQuery(name=User.GET_WITH_CONTACTS, query="SELECT u FROM User u LEFT JOIN FETCH u.contacts WHERE u.id=:id"),
               @NamedQuery(name=User.GET_BY_LOGIN, query="select u from User u left join fetch u.conatcts where u.login=:login")})

public class User extends BaseEntity{
    public static final String DELETE_USER = "User.delete";
    public static final String ALL_USERS = "User.getAll";
    public static final String GET_WITH_CONTACTS = "User.getWithContact";
    public static final String GET_BY_LOGIN = "User.getByLogin";

    @Column(name="password")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name="login")
    private String login;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Transient
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
    private LocalDateTime registered;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 100)
    private Set<Role> roles;

    @OneToMany(mappedBy="user")
    private List<Contact> contacts;

    public User() {
    }

    public User(String firstName, String middleName, String lastName, int age, long experience, String registered) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.experience = experience;
        this.registered = LocalDateTime.parse(registered);
    }

    public User(int id, String firstName, String middleName, String lastName, int age, long experience) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName==null?"":middleName;
        this.lastName = lastName;
        this.age = age;
        this.experience = experience;
        this.roles = EnumSet.of(Role.ROLE_ADMIN);
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

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public boolean isNew(){
        return this.getId()<=0;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
