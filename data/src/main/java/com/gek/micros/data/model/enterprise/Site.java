package com.gek.micros.data.model.enterprise;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@DynamicUpdate
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Proxy(lazy = false)
@Table(name = "site", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Site {
    @Id
    @Column(nullable = false)
    @GenericGenerator(name = "flake", strategy = "com.kaspersky.scad.data.flake.FlakeSequenceGenerator")
    @GeneratedValue(generator = "flake")
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
}
