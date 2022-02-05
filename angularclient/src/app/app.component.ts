import {Component, OnInit} from '@angular/core';
import {Game} from './model/game';
import {GameService} from './service/game-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  game: Game = new Game();
  guessWord: any;
  guessCounter = 0;
  gameInProgress = false;

  constructor(private gameService: GameService) {
  }

  ngOnInit(): void {

  }

  startGame(): void {
    this.guessWord = '';
    this.gameInProgress = true;
    this.guessCounter = 0;
    this.gameService.startGame().subscribe(data => {
      this.game = data;
    });
  }

  onGuess(): void {
    const beforeGuess = this.game.guess;
    for (let i = 0; i < this.game.word.length; i++) {
      if (this.game.word.charAt(i) === this.game.guessChar.toLowerCase()) {
        this.game.guess = this.game.guess.substring(0, i) + this.game.word.substr(i, 1)
          + this.game.guess.substring(i + 1);
      }
    }
    if (beforeGuess === this.game.guess) {
      this.guessCounter++;
    }
    this.game.guessChar = '';
    if (this.guessCounter >= 6) {
      this.gameInProgress = false;
      this.game.guess = this.game.word;
      alert('You\'ve just died!');
    }
  }

  onGuessWord(): void {
    if (this.game.word === this.guessWord.trim()) {
      this.gameIsWon();
    } else {
      this.gameIsLost();
    }
  }

  private gameIsLost(): void {
    this.guessCounter = 6;
    this.gameInProgress = false;
    this.game.guess = this.game.word;
    alert('You\'ve just died!');
  }

  private gameIsWon(): void {
    alert('You won and saved your life!');
    this.game.guess = this.game.word;
    this.gameInProgress = false;
  }

  getImage(): string {
    return '../assets/images/hangman_' + this.guessCounter + '.jpg';
  }
}
