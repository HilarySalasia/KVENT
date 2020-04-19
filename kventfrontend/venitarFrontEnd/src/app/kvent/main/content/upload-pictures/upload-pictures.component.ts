import { Component, OnInit } from '@angular/core';
import {Picture} from '../../models/picture';
import {MainService} from '../../services/main-service.service';

@Component({
  selector: 'app-upload-pictures',
  templateUrl: './upload-pictures.component.html',
  styleUrls: ['./upload-pictures.component.scss']
})
export class UploadPicturesComponent implements OnInit {

  pic: Picture = <Picture> {};
  picHardLink;
  constructor(private mainService: MainService) { }

  ngOnInit() {
  }
  onChangeFile(event: any) {
    console.log('File: ', event);
    this.pic.picLink = event.target.files[0].name;
    this.picHardLink = 'assets/TempContent/Pictures/' + this.pic.picLink;
  }

  onUpload() {
    // this.mainService.addPic(this.pic)
    //   .subscribe( mix => {
    //     // console.log('Data Uploaded');
    //   });
  }
}
