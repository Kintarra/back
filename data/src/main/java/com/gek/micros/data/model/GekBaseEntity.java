package com.gek.micros.data.model;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.Date;

@NoRepositoryBean
public interface GekBaseEntity {

    Long getId();

    void setId(Long id);

    Date getCreatedDate();

    Date getModifiedDate();

    String getModifiedBy();

    void setCreatedDate(Date date);

    void setModifiedDate(Date date);

    void setModifiedBy(String username);

}
