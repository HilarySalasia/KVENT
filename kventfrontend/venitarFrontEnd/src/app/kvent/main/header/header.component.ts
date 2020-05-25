import { Component, OnInit } from '@angular/core';
import DateTimeFormat = Intl.DateTimeFormat;
import {DatePipe} from '@angular/common';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  picHardLink;
  dateNow: Date = new Date();
  constructor(private router: Router) {
    setInterval(() => {
      this.dateNow = new Date();
    }, 1);
  }

  ngOnInit() {
    this.picHardLink = 'assets/TempContent/Pictures/Logo1.png';
  }

  accessProcedure(procType: string) {
    console.log('ProcType: ', procType);
    this.router.navigate(['authenticate', procType]);
  }
}
