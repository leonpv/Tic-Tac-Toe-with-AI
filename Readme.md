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



When the AI is playing at hard level, it doesn't just look one move ahead to see an immediate win or prevent an immediate loss. At this level, it can look two moves ahead, three moves ahead, and even further. It can calculate all possible moves that might be played during the game, and choose the best one based on the assumption that its opponent will also play perfectly. So, it doesn't rely on the mistakes of its opponent and plays the game without fault from start to finish regardless of the opponent's skill!

The algorithm that implements this is called minimax. It's a brute force algorithm that maximizes the value of the AI's position and minimizes the worth of its opponent's. Minimax is not just for Tic-Tac-Toe. You can use it with any other game where two players make alternate moves, such as chess.

<h3 align="left">
Examples
</h3>

https://user-images.githubusercontent.com/31758212/184498593-7ff14417-bf37-4c01-958a-cb3a474d6ab4.mp4

The example below shows how your program should work.
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Player 1, place your ships on the game field

    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
Enter the coordinates of the Aircraft Carrier (5 cells):

> F3 F7

    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O O ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |

Enter the coordinates of the Battleship (4 cells):

> A1 D1


    |   1 2 3 4 5 6 7 8 9 10 |
    | A O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O O ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |

Enter the coordinates of the Submarine (3 cells):

> J7 J10

Error! Wrong length of the Submarine! Try again:

> J10 J8


    |   1 2 3 4 5 6 7 8 9 10 |
    | A O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O O ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ O O O  |

Enter the coordinates of the Cruiser (3 cells):

> B9 D8

Error! Wrong ship location! Try again:

> B9 D9

    |   1 2 3 4 5 6 7 8 9 10 |
    | A O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B O ~ ~ ~ ~ ~ ~ ~ O ~  |
    | C O ~ ~ ~ ~ ~ ~ ~ O ~  |
    | D O ~ ~ ~ ~ ~ ~ ~ O ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O O ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ O O O  |

Enter the coordinates of the Destroyer (2 cells):

> E6 D6

Error! You placed it too close to another one. Try again:

> I2 J2

    |   1 2 3 4 5 6 7 8 9 10 |
    | A O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B O ~ ~ ~ ~ ~ ~ ~ O ~  |
    | C O ~ ~ ~ ~ ~ ~ ~ O ~  |
    | D O ~ ~ ~ ~ ~ ~ ~ O ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O O ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ O ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ O ~ ~ ~ ~ ~ O O O  |

Press Enter and pass the move to another player
...
Player 2, place your ships to the game field

    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |

Enter the coordinates of the Aircraft Carrier (5 cells):

> H2 H6

    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ O O O O O ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |

Enter the coordinates of the Battleship (4 cells):

> F3 F6

    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O ~ ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ O O O O O ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |

Enter the coordinates of the Submarine (3 cells):

> H8 F8

    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O ~ O ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ O ~ ~  |
    | H ~ O O O O O ~ O ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |

...

    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ O ~ ~  |
    | D ~ ~ ~ O O O ~ O ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O ~ O ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ O ~ ~  |
    | H ~ O O O O O ~ O ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |

Press Enter and pass the move to another player
...

    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | -----------------------|
    |   1 2 3 4 5 6 7 8 9 10 |
    | A O ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B O ~ ~ ~ ~ ~ ~ ~ O ~  |
    | C O ~ ~ ~ ~ ~ ~ ~ O ~  |
    | D O ~ ~ ~ ~ ~ ~ ~ O ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O O ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ O ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ O ~ ~ ~ ~ ~ O O O  |

Player 1, it's your turn:

> I3

You missed!
Press Enter and pass the move to another player
...


    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | -----------------------|    
    |   1 2 3 4 5 6 7 8 9 10 |
    | A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | C ~ ~ ~ ~ ~ ~ ~ O ~ ~  |
    | D ~ ~ ~ O O O ~ O ~ ~  |
    | E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |
    | F ~ ~ O O O O ~ O ~ ~  |
    | G ~ ~ ~ ~ ~ ~ ~ O ~ ~  |
    | H ~ O O O O O ~ O ~ ~  |
    | I ~ ~ M ~ ~ ~ ~ ~ ~ ~  |
    | J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  |


Player 2, it's your turn:

> A1

You hit a ship!
Press Enter and pass the move to another player
...
