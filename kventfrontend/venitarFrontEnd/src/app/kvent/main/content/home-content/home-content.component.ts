import { Component, OnInit } from '@angular/core';
import {MainService} from '../../services/main-service.service';
import {Mixes} from '../../models/mixes';
import {mergeMap} from 'rxjs/operators';
import {forkJoin} from 'rxjs';

@Component({
  selector: 'app-home-content',
  templateUrl: './home-content.component.html',
  styleUrls: ['./home-content.component.scss']
})

export class HomeContentComponent implements OnInit {
qMixes: Mixes[] = [];
picHardLink;
  constructor(private mainService: MainService) { }

  ngOnInit() {
    this.mainService.getAllMixes()
      .subscribe( mix => {
                  this.qMixes = mix;
        this.picHardLink = 'assets/TempContent/Pictures/';
        console.log('Miix: ', mix, 'Link: ', this.qMixes[0].picture.picLink);
    });
  }

}
