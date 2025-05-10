package com.lucasangelo.todosimple.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = user.TABELA_NAME)

public class user {

    public interface criateuser {
    }

    public interface updateuser {
    }

    public static final String TABELA_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)

    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(groups = criateuser.class)
    @NotEmpty(groups = criateuser.class)
    @Size(groups = criateuser.class, min = 2, max = 100)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", length = 60, nullable = false)
    @NotNull(groups = { criateuser.class, updateuser.class })
    @NotEmpty(groups = { criateuser.class, updateuser.class })
    @Size(groups = { criateuser.class, updateuser.class }, min = 6, max = 60)
    private String password;

    // private List<Task> tasks = new ArrayList<Task>();

    public user() {
    }

    public user(Long id,
            @NotNull(groups = criateuser.class) @NotEmpty(groups = criateuser.class) @Size(groups = criateuser.class, min = 2, max = 100) String username,
            @NotNull(groups = { criateuser.class, updateuser.class }) @NotEmpty(groups = { criateuser.class,
                    updateuser.class }) @Size(groups = { criateuser.class,
                            updateuser.class }, min = 6, max = 60) String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static String getTabelaName() {
        return TABELA_NAME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof user))
            return false;
        user other = (user) obj;
        if (this.id == null)
            if (other.id != null)
                return false;
            else if (!this.id.equals(other.id))
                return false;
        return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username)
                && Objects.equals(this.password, other.password);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

}
