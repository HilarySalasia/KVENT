import { Component, OnInit } from '@angular/core';
import {faSpinner} from '@fortawesome/free-solid-svg-icons';
import {Subject} from 'rxjs';
import {LoadingScreenService} from './loading-screen.service';

@Component({
  selector: 'app-loading-screen',
  templateUrl: './loading-screen.component.html',
  styleUrls: ['./loading-screen.component.scss']
})
export class LoadingScreenComponent implements OnInit {
  public faSpinner = faSpinner;
  isLoading: Subject<boolean> = this.loaderService.isLoading;
  constructor(private loaderService: LoadingScreenService) { }

  ngOnInit(): void {
  }

}
