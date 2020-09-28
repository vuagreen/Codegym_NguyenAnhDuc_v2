import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SeachService {
  public seach = '';

  constructor() {
  }

  setSeach(value) {
    this.seach = value;
  }

  getSeach(): string {
    return this.seach;
  }
}
