package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="venitar_transc")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public Long getTranscId() {
        return transcId;
    }

    public void setTranscId(Long transcId) {
        this.transcId = transcId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getAudioId() {
        return audioId;
    }

    public void setAudioId(Long audioId) {
        this.audioId = audioId;
    }

    public Date getTranscDate() {
        return transcDate;
    }

    public void setTranscDate(Date transcDate) {
        this.transcDate = transcDate;
    }

    public Long getTranscType() {
        return transcType;
    }

    public void setTranscType(Long transcType) {
        this.transcType = transcType;
    }

    public Long getTranscTypeValue() {
        return transcTypeValue;
    }

    public void setTranscTypeValue(Long transcTypeValue) {
        this.transcTypeValue = transcTypeValue;
    }

    public Long getTranscRef() {
        return transcRef;
    }

    public void setTranscRef(Long transcRef) {
        this.transcRef = transcRef;
    }
}
