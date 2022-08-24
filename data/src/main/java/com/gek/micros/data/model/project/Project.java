package com.gek.micros.data.model.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gek.micros.data.enums.EnterpriseCategory;
import com.gek.micros.data.enums.Revision;
import com.gek.micros.data.model.enterprise.Enterprise;
import com.gek.micros.data.model.GekBaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "project", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project implements Serializable, GekBaseEntity {
    @Id
    @Column(nullable = false)
    @GenericGenerator(name = "flake", strategy = "com.kaspersky.scad.data.flake.FlakeSequenceGenerator")
    @GeneratedValue(generator = "flake")
    private Long id;

    private String name;

    private String description;

    private Boolean isFolder;

    private Boolean isComplex;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Date createdDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Date modifiedDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String modifiedBy;

    private String enterpriseName;

    private String cipher;

    private Integer maxElementCount;

    private String contractNumber;

    private Date contractDate;

    private String ktGryph;

    private String approveList;

    private Integer releaseYear;

    private String catalogueNumber;

    private String objectTechProcess;

    private String customer;

    private String customerInn;

    private String customerAddress;

    private String infoHolder;

    private String infoHolderAddress;

    private String operator;

    private String operatorAddress;

    @Enumerated(EnumType.STRING)
    private EnterpriseCategory categoryName;

    private String muinCreatorName;

    private String muinCreatorAddress;

    private String designingOrganizationName;

    private String projectNumber;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private byte[] license;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Date lastLicenseRequestDate;

    @Enumerated(EnumType.ORDINAL)
    private Revision projectRevision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Project project;

    // gekTODO add ta settings

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<Enterprise> enterprises = new HashSet<>(0);

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<Project> projects = new HashSet<>(0);

    @JsonIgnore
    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(
        name = "project_user",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>(0);

    public Project(Project project) {
        this.name = project.getName();
        this.description = project.getDescription();
        this.enterpriseName = project.getEnterpriseName();
        this.cipher = project.getCipher();
        this.maxElementCount = project.getMaxElementCount();
        this.contractNumber = project.getContractNumber();
        this.contractDate = project.getContractDate();
        this.ktGryph = project.getKtGryph();
        this.approveList = project.getApproveList();
        this.releaseYear = project.getReleaseYear();
        this.catalogueNumber = project.getCatalogueNumber();
        this.objectTechProcess = project.getObjectTechProcess();
        this.customer = project.getCustomer();
        this.customerInn = project.getCustomerInn();
        this.customerAddress = project.getCustomerAddress();
        this.infoHolder = project.getInfoHolder();
        this.infoHolderAddress = project.getInfoHolderAddress();
        this.operator = project.getOperator();
        this.operatorAddress = project.getOperatorAddress();
        this.categoryName = project.getCategoryName();
        this.muinCreatorName = project.getMuinCreatorName();
        this.muinCreatorAddress = project.getMuinCreatorAddress();
        this.designingOrganizationName = project.getDesigningOrganizationName();
        this.projectNumber = project.getProjectNumber();
    }
}

