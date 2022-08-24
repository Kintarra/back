package com.gek.micros.data.model.enterprise;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gek.micros.data.model.DirectoryEntry;
import com.gek.micros.data.model.project.Project;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@DynamicUpdate
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Proxy(lazy = false)
@Table(name = "enterprise", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Enterprise {

    @Id
    @Column(nullable = false)
    @GenericGenerator(name = "flake", strategy = "com.kaspersky.scad.data.flake.FlakeSequenceGenerator")
    @GeneratedValue(generator = "flake")
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "project_id")
    private Project project;



    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Site> sites = new HashSet<>(0);


    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(
        name = "enterprise_directory_entry",
        joinColumns = @JoinColumn(name = "enterprise_id"),
        inverseJoinColumns = @JoinColumn(name = "directory_entry_id")
    )
    private Set<DirectoryEntry> directoryEntries = new HashSet<>(0);


}
