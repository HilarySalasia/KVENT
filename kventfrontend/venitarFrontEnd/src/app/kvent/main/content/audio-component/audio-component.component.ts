import {ChangeDetectionStrategy, ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import * as $ from 'jquery';
import {faStopCircle, faVolumeOff, faVolumeUp} from '@fortawesome/free-solid-svg-icons';




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
  get filePlay() {
    return this._filePlay;
  }
  @Input()
  set filePlay(value: boolean) {
    this._filePlay = value;
  }
  @Input() fileUrl: string;
  @Input() onStopTracks: boolean;
  @Output() response = new EventEmitter<string>();



  constructor(private _cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
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
     this._cdr.detectChanges();
    }) : this.onPauseAudio();

    console.log('File is Playing 1');

  }
  onPauseAudio() {
    this.audioPlayer.pause();
    this._cdr.detectChanges();
  }

  onStopAudio() {
    console.log('Audio should stop');
    this.audioPlayer.pause();
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
