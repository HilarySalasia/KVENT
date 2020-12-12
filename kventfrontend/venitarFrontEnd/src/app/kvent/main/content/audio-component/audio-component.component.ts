import {ChangeDetectionStrategy, ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import * as $ from 'jquery';
import {faStopCircle, faVolumeOff, faVolumeUp} from '@fortawesome/free-solid-svg-icons';
import {Transaction} from '../../models/transaction';
import {SitesessionServiceService} from '../../services/sitesession-service.service';
import {TransactionService} from '../../services/transaction.service';
import {TransactService} from '../../services/transact.service';




@Component({
  selector: 'app-audio-component',
  templateUrl: './audio-component.component.html',
  styleUrls: ['./audio-component.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AudioComponent implements OnInit {


  public audioPlayer ;
  private _filePlay: boolean;
  songDur: string;
  audioDur;
  curDur;
  public faStopCircle = faStopCircle;
  public faVolume = faVolumeUp;
  public faVolOff = faVolumeOff;
  chckVol: boolean;
  transact: Transaction = <Transaction>{};
  token: string;
  get filePlay() {
    return this._filePlay;
  }
  @Input()
  set filePlay(value: boolean) {
    this._filePlay = value;
  }
  @Input() fileUrl: string;
  @Input() onStopTracks: boolean;
  @Input() audioId: number;
  @Output() response = new EventEmitter<string>();
  date = new Date();



  constructor(private _cdr: ChangeDetectorRef,
              private ssS: SitesessionServiceService,
              private transactService: TransactService) { }

  ngOnInit(): void {
    const moment = require('moment');
    this.transact.transcDate = moment(this.date, moment.ISO_8601);
    console.log('Curr Date: ', this.transact.transcDate);
    this.onStopTracks && this.audioPlayer ? this.onStopAudio() : this.prepareFileToPlay();
    this.onStopTracks = false;
    this.chckVol = true;
    console.log('Duration: ', this.audioPlayer.duration);
    // this.fileUpload ? this.onPlay(this.fileUpload) : this.onPause();
    this._cdr.detectChanges();
  }

  prepareFileToPlay() {
    this.audioPlayer = new Audio(this.fileUrl);
    this.audioPlayer.autoplay = false;
    this.audioPlayer.onload = true;
    this.audioPlayer.addEventListener('loadedmetadata', this.onPlay(this.filePlay));
    this._cdr.detectChanges();
  }

  onPlay(playAudio: boolean) {
    console.log('Current Duration: ', this.curDur);
    playAudio  ? this.audioPlayer.play().then(play => {
      this.audioDur = this.audioPlayer.duration;
     this.songDur = this.calcDuration(this.audioPlayer.duration);
     this.curDur = parseInt(this.audioPlayer.currentTime, 10);
     this.updateSlider();
     this.response.emit('Played');
     console.log('thisUser: ', this.ssS.getUserId());
     this.transact.userId = this.ssS.getUserId() != null ? this.ssS.getUserId() : 0;
     this.transact.audioId = this.audioId;
     this.transact.transcType = 1;
     this.token = this.ssS.getUserId() ? this.ssS.getUserToken() : '';
     this.transactService.playAudio(this.transact, this.token);
     this._cdr.detectChanges();
    }) : this.onPauseAudio();

    console.log('File is Playing 1');

  }
  onPauseAudio() {
    this.audioPlayer.pause();
    this.transact.transcType = 3;
    this.transact.transcTypeValue = this.curDur;
    this.transactService.pauseAudio(this.transact, this.token);
    this._cdr.detectChanges();
  }

  onStopAudio() {
    console.log('Audio should stop');
    this.audioPlayer.pause();
    this.transact.transcType = 4;
    this.transact.transcTypeValue = this.curDur;
    this.transactService.stopAudio(this.transact, this.token);
    console.log('Link: ', this.fileUrl, 'Not Stopping');
    this.response.emit('Stopped');
    this._cdr.detectChanges();
  }

  calcDuration(seconds: any) {
    const hours = Math.floor((seconds % 86400) / 3600);
    const mins = Math.floor(((seconds % 86400) % 3600) / 60);
    const secs = ((seconds % 86400) % 3600) % 60;
    return (hours === 0 ? '' : hours + 'h:') + mins + 'm:' + Math.round(secs) + 's';
  }

  onSliderChange($event: any) {
    console.log('Slider: ', $event);
    this.audioPlayer.currentTime = $event.target.valueAsNumber;
    this._cdr.detectChanges();
  }

  updateSlider() {
    this.audioPlayer.addEventListener('timeupdate', () => {
      const curTime = parseInt(this.audioPlayer.currentTime, 10);
      this.curDur = curTime;
      console.log('UpdateTime: ', this.curDur);
      if (curTime === parseInt(this.audioPlayer.duration, 10)) {
        this.response.emit('Stopped');
      }
      this._cdr.detectChanges();
    });
  }

  updateValue() {
    console.log('CurrTime: ', this.curDur);
    // const curTime = parseInt(this.aud  console.log('CurrTime: ', this.curDur);
    // const curTime = parseInt(this.audioPlayer.currentTime, 10);
    // $('#' + this.fileUrl).attr('value', curTime);
    // this.curDur = curTime;
  }

  onStopChange() {
    this.onStopAudio();
  }

  onVolumeUp() {

  }

  onVolumeDown() {

  }

  onMute() {
    if (this.chckVol) {
      this.chckVol = false;
      this.audioPlayer.muted = true;
    } else if (!this.chckVol) {
      this.chckVol = true;
      this.audioPlayer.muted = false;
    }
  }
}
