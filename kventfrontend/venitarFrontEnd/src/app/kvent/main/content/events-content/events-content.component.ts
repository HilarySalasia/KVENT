import { Component, OnInit } from '@angular/core';
import {GoogleService} from '../../services/extServices/google.service';
import {Event} from '../../models/event';
import {BusinessService} from '../../services/business.service';

@Component({
  selector: 'app-events-content',
  templateUrl: './events-content.component.html',
  styleUrls: ['./events-content.component.scss']
})
export class EventsContentComponent implements OnInit {
  viewEvent: Event[] = [];
  constructor(private googleService: GoogleService,
              private businessService: BusinessService) { }

  ngOnInit() {
    this.businessService.getEvents()
      .subscribe( events => {
        this.viewEvent = events;
      });
  }

}
