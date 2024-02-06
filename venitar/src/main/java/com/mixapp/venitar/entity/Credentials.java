package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="vent_cred")
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vent-credentials-seq")
    @SequenceGenerator(name="vent-credentials-seq", sequenceName = "vent_cred_seq", allocationSize = 1)
    @Column(name="cred_id")
    private Long credId;

    @Column(name="password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passCode;

    @Column(name="created_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate;




}
