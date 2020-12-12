import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
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


@Component({
  selector: 'app-home-content',
  templateUrl: './home-content.component.html',
  styleUrls: ['./home-content.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class HomeContentComponent implements OnInit {
qMixes: Mixes[] = [];
picHardLink;
musicHardLink;
stopAudio: boolean;
n  = 0;
onPlayer: boolean;
playFile: boolean = false;
response: string;
public faPlayCircle = faPlayCircle;
public faDownload = faDownload;
  mixPlayId: number;
  Lmix: Mixes;
  disbPlay: boolean = false;

  constructor(private mainService: MainService,
              private _cdr: ChangeDetectorRef,
              private sanitzer: DomSanitizer,
              private headerService: HeaderService,
              private trasactService: TransactService) {
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
    });
  }
  onLoad() {
    //check for music Played and not stopped
    this.trasactService.
  }

  onPlayChange(play: boolean, mix: Mixes) {
    this.disbPlay = true;
    play ? this.playFile = true : this.checkPlayer();
    // this.stopAudio = false;
    this.mixPlayId = mix.mixId;
    this.n = 1;
    console.log('File is Playing');
    console.log(this.playFile);
    this._cdr.detectChanges();
  }

  checkPlayer() {
    this.stopAudio = true;
    console.log('Stopped Audio');
    this._cdr.detectChanges();
  }

  checkResponse(value: string){
    if (value === 'Played') {
      this.disbPlay = true;
    } else if (value === 'Stopped') {
      this.disbPlay = false;
      this.mixPlayId = undefined;
      this.playFile = false;
    }
    this._cdr.detectChanges();
  }
}
