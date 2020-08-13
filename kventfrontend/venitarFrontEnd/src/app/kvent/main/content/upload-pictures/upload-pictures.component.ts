import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Picture} from '../../models/picture';
import {MainService} from '../../services/main-service.service';
import {SitesessionServiceService} from '../../services/sitesession-service.service';
import {FileUpload} from '../../models/fileUpload';
import {SetupService} from '../../services/setup.service';

@Component({
  selector: 'app-upload-pictures',
  templateUrl: './upload-pictures.component.html',
  styleUrls: ['./upload-pictures.component.scss']
})
export class UploadPicturesComponent implements OnInit {

  pic: Picture = <Picture> {};
  picHardLink;
  picFile: File;
  userID;
  @Output()
  failedUpload: boolean;
  @Output() pictureFile = new EventEmitter<Picture>();
  @Output() pictureID = new EventEmitter<number>();
  @Input()
  set getAuthorUpload(doUpload: boolean) {
    // tslint:disable-next-line:no-unused-expression
    doUpload ? this.onUpload() : null;
  }

  constructor(private mainService: MainService,
              private ssS: SitesessionServiceService,
              private setupService: SetupService) { }

  ngOnInit() {
    this.userID = this.ssS.getUserId();
  }

  onChangeFile(event: any) {
    console.log('File: ', event);
    this.picFile = event.target.files[0];
    this.picHardLink = 'assets/TempContent/Pictures/' + this.pic.picLink;
  }

  onUpload() {
    this.mainService.uploadFile(this.picFile, this.userID)
      .subscribe( fileUploaded => {
        if (fileUploaded != null) {
          this.onAddPicture(fileUploaded);
        }
      });
    // if (this.mix.picture.picLink) {
    //   this.mainService.addMix(this.mix)
    //     .subscribe( mix => {
    //       console.log('Data Uploaded');
    //       // this.router.navigate(['upload/picture']).then( );
    //     });
    // } else {
    //   console.log('Mix: ', this.mix);
    // }
  }

  onAddPicture(uploadedMsg: FileUpload) {
    this.pic.picLink = uploadedMsg.fileLink;
    this.setupService.addPic(this.pic)
      .subscribe( pic => {
        // console.log('Data Uploaded');
        this.pictureID.emit(pic.picId);
      });
  }
}
