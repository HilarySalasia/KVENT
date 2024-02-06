package com.mixapp.venitar.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "vent_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vent-event-seq")
    @SequenceGenerator(name = "vent-event-seq", sequenceName = "vent_event_seq", allocationSize = 1)
    @Column(name ="evnt_id")
    private Long eventId;

    @Column(name ="evnt_name")
    private String eventTitle;

    @Column(name ="evnt_location")
    private String eventLocation;

    @Column(name ="evnt_loc_long")
    private String eventLocLongitude;

    @Column(name ="evnt_loc_lat")
    private String eventLocLatitude;

    @Column(name = "evnt_capacity")
    private String eventCapacity;

    @Column(name = "evnt_cost")
    private String eventCost;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name ="evnt_start_date")
    private Date eventStartDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name ="evnt_end_date")
    private Date eventEndDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evnt_comp_id", nullable = false)
    private Company company;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evnt_curr_id", nullable = false)
    private Currency currency;

    @Column(name = "evnt_user_id")
    private Long userId;


}
