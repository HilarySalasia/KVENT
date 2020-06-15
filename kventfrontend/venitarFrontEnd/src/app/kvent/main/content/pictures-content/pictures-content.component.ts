import { Component, OnInit } from '@angular/core';
import {Picture} from '../../models/picture';
import {MainService} from '../../services/main-service.service';
import {SetupService} from '../../services/setup.service';

@Component({
  selector: 'app-pictures-content',
  templateUrl: './pictures-content.component.html',
  styleUrls: ['./pictures-content.component.scss']
})
export class PicturesContentComponent implements OnInit {
  pic: Picture;
  constructor(private setupService: SetupService) { }

  ngOnInit() {
  }
  onChangeFile(event: any) {
    this.pic.picLink = event.target.files[0].name;
    console.log('File: ', event);
  }

  onUpload() {
    this.setupService.addPic(this.pic)
      .subscribe( mix => {
        // console.log('Data Uploaded');
      });
  }
}
