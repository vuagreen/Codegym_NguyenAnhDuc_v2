export interface Action {
  payload?: any;
}
export class SpeakingStarted implements Action {}
export class SpeakingEnded implements Action {}

export class ListeningStarted implements Action {}
export class ListeningEnded implements Action {}

export class RecognizedTextAction implements Action {
  constructor(public payload: string) {}
}
export class SpeakAction implements Action {
  constructor(public payload: string) {}
}
