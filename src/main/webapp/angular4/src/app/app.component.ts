import { Component, ViewEncapsulation, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Http, Response, Headers, RequestOptions, RequestMethod, RequestOptionsArgs } from '@angular/http';
import { Observable } from "rxjs/Rx";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";


@Component( {
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    encapsulation: ViewEncapsulation.None,
} )
export class AppComponent implements OnInit {
    title = 'app';
    constructor( private http: Http ) { }

    private baseUrl: string = 'http://localhost:9020';
    private getUrl: string = this.baseUrl + '/room/resvervation/v1/';
    private postUrl: string = this.baseUrl + '/room/resvervation/v1';
    public submitted: boolean;
    rooms: Rooms[];
    currentCheckInVal: string;
    currentCheckOutVal: string;
    request: ReserveRoomRequest;
    roomsearch: FormGroup;

    ngOnInit() {
        this.roomsearch = new FormGroup( {
            checkin: new FormControl( '' ),
            checkout: new FormControl( '' )
        } );

        const roomsearchValueChanges$ = this.roomsearch.valueChanges;
        roomsearchValueChanges$.subscribe( valChange => {
            this.currentCheckInVal = valChange.checkin;
            this.currentCheckOutVal = valChange.checkout;

        } )
    }


    onSubmit( { value, valid }: { value: Roomsearch, valid: boolean } ) {
        this.getAll()
            .subscribe(
            rooms => this.rooms = rooms,
            err => {
                console.log( err )
            }
            );
    }

    reserveRoom( value: string ) {
        this.request = new ReserveRoomRequest( value, this.currentCheckInVal, this.currentCheckOutVal );
        this.createReservation( this.request );
    }

    getAll(): Observable<Rooms[]> {
        return this.http.get( this.baseUrl + '/room/resvervation/v1?checkin='+ this.currentCheckInVal +'&checkout='+ this.currentCheckOutVal +'' )
            .map( this.mapRoom );
    }

    createReservation( body: ReserveRoomRequest ) {
       
        let bodyString = JSON.stringify( body );
        let headers = new Headers( { 'Content-Type': 'application/json' } );
      
        let options = new RequestOptions( { method: RequestMethod.Post, headers: headers } );
        let requestArg: RequestOptionsArgs = { headers: headers, method: "POST" };
/*        console.log(this.postUrl);
        console.log(body);
        console.log(options);*/
       
        this.http.post( this.getUrl, body, requestArg )
            .subscribe( res => console.log( res ),
                    err => console.log( err ));
    }
    mapRoom( response: Response ): Rooms[] {
        return response.json().content;
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

export class ReserveRoomRequest {
    roomId: string;
    checkin: string;
    checkout: string;

    constructor(
        roomId: string,
        checkin: string,
        checkout: string
    ) {
        this.roomId = roomId;
        this.checkin = checkin;
        this.checkout = checkout;
    }


}
