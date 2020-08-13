import { Component, OnInit } from '@angular/core';
import {faCheckCircle} from '@fortawesome/free-solid-svg-icons';
import {MainService} from '../../services/main-service.service';
import {Company} from '../../models/company';
import {Mixes} from '../../models/mixes';
import {ReactiveFormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import {Picture} from '../../models/picture';
import {HeaderComponent} from '../../header/header.component';
import {SitesessionServiceService} from '../../services/sitesession-service.service';
import {mergeMap} from 'rxjs/operators';
import {forkJoin, of, pipe} from 'rxjs';
import {FileUpload} from '../../models/fileUpload';
import {HeaderService} from '../../header/header.service';

@Component({
  selector: 'app-upload-mix',
  templateUrl: './upload-mix.component.html',
  styleUrls: ['./upload-mix.component.scss']
})
export class UploadMixComponent implements OnInit {
    url: string | ArrayBuffer;
    companies: Company[];
    mix: Mixes = <Mixes> {mixCompany: {}, picture: {}};
    userID: number;
    mixFile: File;
    lgnError: string;
    picId: number;
    allowPicUpload: boolean =  false;
    fileUploaded: FileUpload;
  constructor(private mainService: MainService,
              private router: Router,
              private ssS: SitesessionServiceService,
              private headerService: HeaderService) { }
  public faCheckCircle = faCheckCircle;
  ngOnInit() {
    this.lgnError = 'Please Login to continue';
    this.userID = this.ssS.getUserId();
    this.headerService.setTitle('Upload Music');
    this.load();
  }

  load() {
    this.mainService.getCompanies()
      .subscribe( company => {this.companies = company; });
  }

  onChangeFile(event: any) {
    this.mixFile = event.target.files[0];
    console.log('File: ', event);
  }

  onUpload() {
    this.mainService.uploadFile(this.mixFile, this.userID)
      .pipe(
        mergeMap(upload => {
          this.allowPicUpload = true;
          return of(upload);
        })
      )
      .subscribe( (fileUploaded) => {
        this.fileUploaded = fileUploaded;
        console.log('File Uploaded');
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

  onAddMix(uploadedMsg: FileUpload) {
    this.mix.userId = this.userID;
    this.mix.mixLink = uploadedMsg.fileLink;
    this.mainService.addMix(this.mix)
      .subscribe( mix => {
        console.log('Mix Uploaded!!');
        });
  }

  getPicture($event: Picture) {
    this.mix.picture = $event;
    console.log('Picture: ', this.mix.picture);
  }

  getPicId(picId: number) {
    this.mix.picture.picId = this.picId;
    if (this.fileUploaded != null && picId != null) {
      this.onAddMix(this.fileUploaded);
    }
  }
}
