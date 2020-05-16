package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vent_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss.SSSZ")
    @Column(name ="evnt_start_date")
    private Date eventStartDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss.SSSZ")
    @Column(name ="evnt_end_date")
    private Date eventEndDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evnt_comp_id", nullable = false)
    private Company company;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evnt_curr_id", nullable = false)
    private Currency currency;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventLocLongitude() {
        return eventLocLongitude;
    }

    public void setEventLocLongitude(String eventLocLongitude) {
        this.eventLocLongitude = eventLocLongitude;
    }

    public String getEventLocLatitude() {
        return eventLocLatitude;
    }

    public void setEventLocLatitude(String eventLocLatitude) {
        this.eventLocLatitude = eventLocLatitude;
    }

    public String getEventCapacity() {
        return eventCapacity;
    }

    public void setEventCapacity(String eventCapacity) {
        this.eventCapacity = eventCapacity;
    }

    public String getEventCost() {
        return eventCost;
    }

    public void setEventCost(String eventCost) {
        this.eventCost = eventCost;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
