package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="venitar_transc")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venitar-transc-seq")
    @SequenceGenerator(name = "venitar-transc-seq", sequenceName = "venitar_transc_seq", allocationSize = 1)
    @Column(name="v_transc")
    private Long transcId;

    @Column(name="user_id")
    private Long userId;

    @Column(name="evnt_id")
    private Long eventId;

    @Column(name="audio_id")
    private Long audioId;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name="v_tranc_date")
    private Date transcDate;

    @Column(name="v_transc_type")
    private Long transcType;

    @Column(name="v_type_value")
    private Long transcTypeValue;

    @Column(name="ref_tranc")
    private Long transcRef;


}
