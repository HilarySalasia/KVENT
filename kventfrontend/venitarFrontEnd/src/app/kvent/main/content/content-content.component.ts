import { Component, OnInit } from '@angular/core';
import {Mixes} from '../models/mixes';
import {MainService} from '../services/main-service.service';


@Component({
  selector: 'app-home-content',
  templateUrl: './content-content.component.html',
  styleUrls: ['./content-content.component.scss']
})

export class ContentContentComponent implements OnInit {
qMixes: Mixes[];
  constructor(private mainService: MainService) { }

  ngOnInit() {
    this.mainService.getAllMixes()
      .subscribe( mix => {
                  this.qMixes = mix;
    });
  }

}
