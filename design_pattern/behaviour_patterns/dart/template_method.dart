abstract class GameLifecycle {
  void start() {
    print('Start the game!');
    loopGame();
    finish();
  }

  void setupScores() {
    print('Setup highest score, current user score is 0.');
  }

  void loopGame();

  void finish() {
    print('Update user score, highest score.');
    print('Finish the game!');
  }
}

class MarioLifecycle extends GameLifecycle {
  @override
  void loopGame() {
    print('Player hit 3 game in a round!');
    print('Player died 3 times!');
    print('Player fall in the hole! Out of lives!');
  }
}

class LeagueOfLegendLifecycle extends GameLifecycle {
  @override
  void loopGame() {
    print('Player farm creep over 300!');
    print('Player has kda 16/9/5!');
    print('Player is legendary!');
    print('Player destroy the enemy \'s base!');
  }

  @override
  void finish() {
    print('Victory!');
  }
}

void main() {
  final mario = MarioLifecycle();
  mario.start();

  final lol = LeagueOfLegendLifecycle();
  lol.start();
}
