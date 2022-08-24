package com.gek.micros.data.model.project;

import com.gek.micros.data.enums.Relation;
import com.gek.micros.data.enums.UserRole;
import com.gek.micros.data.model.GekBaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@DynamicUpdate //
@EqualsAndHashCode
@Proxy(lazy = false)
@RequiredArgsConstructor
@Table(name = "user", schema = "public")
public class User implements GekBaseEntity {

    @Id
    @Column (nullable = false)
    @GenericGenerator(name = "flake", strategy = "com.gek.backend.data.flake.FlakeSequenceGenerator")
    @GeneratedValue(generator = "flake")
    private Long id;

    private Boolean active;

    private String email;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Date createdDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Date modifiedDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String modifiedBy;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Date lastLoginDate;

    private String lastName;

    private String firstName;

    private String patronymicName;

    private String organization;

    private String position;

    @Enumerated(EnumType.STRING)
    private Relation relation;

    private Long phone;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Boolean passwordStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<Project> projects = new HashSet<>();

    public User(User user) {
        this.active = user.getActive();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.createdDate = user.getCreatedDate();
        this.lastLoginDate = user.getLastLoginDate();
        this.lastName = user.getLastName();
        this.firstName = user.getFirstName();
        this.patronymicName = user.getPatronymicName();
        this.organization = user.getOrganization();
        this.position = user.getPosition();
        this.relation = user.getRelation();
        this.phone = user.getPhone();
        this.passwordStatus = user.getPasswordStatus();
        this.projects = user.getProjects();
    }
}
