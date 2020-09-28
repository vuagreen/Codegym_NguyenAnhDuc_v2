import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SeachService} from '../../Service/seach.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  seach = '';
  @Output() mySeach = new EventEmitter<string>();

  constructor(public seachService: SeachService,
              public router: Router
  ) {
  }

  ngOnInit() {
  }

  addMySeach() {
    this.mySeach.emit(this.seach);
    console.log(this.seach);
  }

  setSeach(value) {
    this.mySeach.emit(value);
  }
}
