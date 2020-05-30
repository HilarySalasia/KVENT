import { Component, OnInit } from '@angular/core';
import {faCheckCircle} from '@fortawesome/free-solid-svg-icons';
import {MainService} from '../../services/main-service.service';
import {Company} from '../../models/company';
import {Mixes} from '../../models/mixes';
import {ReactiveFormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import {Picture} from '../../models/picture';
import {HeaderComponent} from '../../header/header.component';

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
  constructor(private mainService: MainService,
              private router: Router,
              private headerComponent: HeaderComponent) { }
  public faCheckCircle = faCheckCircle;
  ngOnInit() {
    this.userID = this.headerComponent.loginId;
    this.load();
  }

  load() {
    this.mainService.getCompanies()
      .subscribe( company => {this.companies = company; });
  }

  onChangeFile(event: any) {
    this.mix.mixLink = event.target.files[0].name;
    console.log('File: ', event);
  }

  onUpload() {
    if (this.mix.picture.picLink) {
      this.mainService.addMix(this.mix)
        .subscribe( mix => {
          console.log('Data Uploaded');
          // this.router.navigate(['upload/picture']).then( );
        });
    } else {
      console.log('Mix: ', this.mix);
    }
  }


  getPicture($event: Picture) {
    this.mix.picture = $event;
    console.log('Picture: ', this.mix.picture);
  }
}
