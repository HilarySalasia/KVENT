import { Component, OnInit } from '@angular/core';
import {faSpinner} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-loading-screen',
  templateUrl: './loading-screen.component.html',
  styleUrls: ['./loading-screen.component.scss']
})
export class LoadingScreenComponent implements OnInit {
  public faSpinner = faSpinner;
  constructor() { }

  ngOnInit(): void {
  }

}
