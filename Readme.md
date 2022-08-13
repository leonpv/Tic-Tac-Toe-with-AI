<h2 align="center">
  Battleship
</h2>

<h3 align="left">
  Description
</h3>

After finishing this project, you'll get to know a lot about planning and developing a complex program from scratch, using classes and methods, handling errors, and processing user input. You will also learn to use OOP (Object-Oriented Programming) in the process.

<h3 align="left">
Objectives
</h3>

At this level "Easy" the computer makes random moves. At level "Medium" will be a lot harder to beat than easy, even though the initial moves are still random. When the AI is playing at medium level, it wins when it can because of its first rule, and stops all simple attempts to beat it due to its second.

1. If it already has two in a row and can win with one further move, it does so.
2. If its opponent can win with one move, it plays the move necessary to block this.
3. Otherwise, it makes a random move.

When the AI is playing at "Hard" level, it doesn't just look one move ahead to see an immediate win or prevent an immediate loss. At this level, it can look two moves ahead, three moves ahead, and even further. It can calculate all possible moves that might be played during the game, and choose the best one based on the assumption that its opponent will also play perfectly. So, it doesn't rely on the mistakes of its opponent and plays the game without fault from start to finish regardless of the opponent's skill!

The algorithm that implements this is called minimax. It's a brute force algorithm that maximizes the value of the AI's position and minimizes the worth of its opponent's. Minimax is not just for Tic-Tac-Toe. You can use it with any other game where two players make alternate moves, such as chess.

<h3 align="left">
Examples
</h3>

https://user-images.githubusercontent.com/31758212/184498593-7ff14417-bf37-4c01-958a-cb3a474d6ab4.mp4

