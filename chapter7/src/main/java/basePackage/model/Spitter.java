package basePackage.model;


import javax.persistence.*;

@Entity
public class Spitter {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    private String password;

    @Column(name = "FULL_NAME")
    private String fullName;

    private String username;

    private String email;
    @Column(name = "UPDATE_BY_EMAIL")
    private Boolean updateByEmail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    @Override
    public String toString() {
        return "Spitter{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", updateByEmail=" + updateByEmail +
                '}';
    }
}
