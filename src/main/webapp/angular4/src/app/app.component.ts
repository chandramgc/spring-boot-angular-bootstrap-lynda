import {Component, ViewEncapsulation, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class AppComponent implements OnInit {
  title = 'app';

  public submitted: boolean;
  rooms: Rooms[];
  roomsearch: FormGroup;

  ngOnInit() {
    this.roomsearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });

    this.rooms = ROOMS;
  }

  onSubmit({value, valid}: {value: Roomsearch, valid: boolean}) {
    console.log(value);
  }

  reserveRoom(value: string) {
    console.log("Room id for reservation:" + value);
  }

}

export interface Roomsearch {
  checkin: string;
  checkout: string;
}

export interface Rooms {
  id: string;
  roomNumber: string;
  price: string;
  links: string;
}

var ROOMS: Rooms[] = [
  {
    "id": "37489234327",
    "roomNumber": "406",
    "price": "25",
    "links": ""
  },
  {
    "id": "84329874798",
    "roomNumber": "407",
    "price": "20",
    "links": ""
  },
  {
    "id": "17238423787",
    "roomNumber": "408",
    "price": "22",
    "links": ""
  }
];
