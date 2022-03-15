import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnDestroy, OnInit} from '@angular/core';
import {MainService} from '../../services/main-service.service';
import {Mixes} from '../../models/mixes';
import {faDownload, faPlayCircle} from '@fortawesome/free-solid-svg-icons';
import {mergeMap} from 'rxjs/operators';
import {forkJoin, of} from 'rxjs';
// @ts-ignore
import KventConfig from '../../../../../assets/kventConfig.json';
import {DomSanitizer} from '@angular/platform-browser';
import {HeaderService} from '../../header/header.service';
import {TransactService} from '../../services/transact.service';
import {AudioDets} from '../../models/audioDets';
import { ErrorHandlingService } from '../../error-handling/error-handling.service';
import { Error } from '../../models/error';


@Component({
  selector: 'app-home-content',
  templateUrl: './home-content.component.html',
  styleUrls: ['./home-content.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class HomeContentComponent implements OnInit, OnDestroy {
qMixes: Mixes[] = [];
picHardLink;
musicHardLink;
stopAudio: boolean;
n  = 0;
onPlayer: boolean;
playFile = false;
response: string;
public faPlayCircle = faPlayCircle;
public faDownload = faDownload;
  mixPlayId: number;
  Lmix: Mixes;
  disbPlay = false;
  audioDetails: AudioDets = <AudioDets>{};
  audioCurrTime;
  dataOn: AudioDets = <AudioDets> {};
  _error: Error = <Error> {};

  constructor(private mainService: MainService,
              private _cdr: ChangeDetectorRef,
              private sanitzer: DomSanitizer,
              private headerService: HeaderService,
              private trasactService: TransactService,
              private errorHandlingService: ErrorHandlingService) {
  }

  ngOnInit() {

    this.mainService.getAllMixes()
      .pipe(
        mergeMap( mixes => {
          const configSett$ = this.mainService.configSetting();
          return forkJoin(of(mixes), configSett$);
        })
      )
      .subscribe( ([mix, configSettings]) => {
        this.picHardLink = KventConfig.hardLink;
        this.musicHardLink = KventConfig.hardLink;
        this.qMixes = mix;
        this._cdr.detectChanges();
        this.headerService.setTitle('Music Section');
        // console.log('Miix: ', mix, 'Link: ', this.qMixes[0].picture.picLink);
        this.onLoad();
    },
    (error) => {
      this._error.message = error.statusText;
      this._error.title = 'No data!';
      this._error.type = 'Error';
      this._error.status = true;
      this.errorHandlingService.errors.push(this._error);
      console.log('Error: ', error);
    }
    );
  }
  onLoad() {
    // check for music Played and not stopped
  }

  onPlayChange(play: boolean, mix: Mixes) {
    this.disbPlay = true;
    play ? this.playFile = true : this.checkPlayer();
    // this.stopAudio = false;
    this.mixPlayId = mix.mixId;
    this.n = 1;
    /*console.log('File is Playing');
    console.log(this.playFile);*/
    this._cdr.detectChanges();
  }

  checkPlayer() {
    this.stopAudio = true;
    console.log('Stopped Audio');
    this._cdr.detectChanges();
  }

  checkResponse(value: string) {
    if (value === 'Played') {
      this.disbPlay = true;
    } else if (value === 'Stopped') {
      this.disbPlay = false;
      this.mixPlayId = undefined;
      this.playFile = false;
    }
    this._cdr.detectChanges();
  }

  checkAudioTime(value: number) {
    this.audioCurrTime = value;
  }

  ngOnDestroy() {
    if (this.disbPlay) {
      // this.audioDetails.audioPermit = this.playFile;
      // console.log('Play File', this.playFile);
      this.audioDetails.audioLink = this.musicHardLink + this.mixPlayId;
      this.audioDetails.audioCurrTime = this.audioCurrTime;
      this.audioDetails.audioId = this.mixPlayId;
      this.headerService.setAudioDetails(this.audioDetails);
      this._cdr.detectChanges();
      console.log('Leaving');
    }
  }
}
