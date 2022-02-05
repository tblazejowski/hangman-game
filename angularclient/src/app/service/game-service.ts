import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Game} from '../model/game';

@Injectable()
export class GameService {

  private startGameUrl: string;

  constructor(private http: HttpClient) {
    this.startGameUrl = 'http://localhost:8080/game';
  }

  public startGame(): Observable<Game> {
    return this.http.get<Game>(this.startGameUrl);
  }
}
