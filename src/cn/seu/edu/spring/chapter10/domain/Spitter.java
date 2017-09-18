package cn.seu.edu.spring.chapter10.domain;

/**
 * Created by Administrator on 2017/9/18.
 */
public class Spitter {
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private boolean updateByEmail;

    public Spitter(Long id, String username, String password, String fullname, String email, boolean updateByEmail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.updateByEmail = updateByEmail;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }
}
