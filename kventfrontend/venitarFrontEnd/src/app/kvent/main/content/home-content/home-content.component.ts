import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {MainService} from '../../services/main-service.service';
import {Mixes} from '../../models/mixes';
import {faDownload, faPlayCircle} from '@fortawesome/free-solid-svg-icons';

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
              private _cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.picHardLink = 'assets/TempContent/Pictures/';
    this.musicHardLink = 'assets/TempContent/Music/';
    this.mainService.getAllMixes()
      .subscribe( mix => {
                  this.qMixes = mix;
                  this._cdr.detectChanges();
        console.log('Miix: ', mix, 'Link: ', this.qMixes[0].picture.picLink);
    });
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
