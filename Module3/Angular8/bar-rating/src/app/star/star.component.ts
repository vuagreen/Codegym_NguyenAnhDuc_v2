import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-star',
  templateUrl: './star.component.html',
  styleUrls: ['./star.component.css']
})
export class StarComponent implements OnInit {
  @Input() startId;
  @Input() rating;

  @Output() startEnter: EventEmitter<number> = new EventEmitter();
  @Output() startLeave: EventEmitter<number> = new EventEmitter();
  @Output() startClicked: EventEmitter<number> = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

  onStartEnter() {
    this.startEnter.emit(this.startId);
  }

  onStarLeave() {
    this.startLeave.emit();
  }

  onStarClick() {
    this.startClicked.emit(this.startId);
  }
}
