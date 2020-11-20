# Matthew St Louis - Code Blog

## Alpha

### F Nov 13 2020
Watched through the video describing the game specification PDF.

### S Nov 14 2020
Read through the game specification PDF.

### U Nov 15 2020
Watched coordinate implementation hint video

Implemented square coordinates with distance. Chose to extend the coordinate interface with the `MyCoordinate` interface (to be renamed later) to get the x and y value from each coordinate. The distance method for square coordinates currently casts the input to `MyCoordinate`. It should probably attempt to cast to `SquareCoordinate` to make sure that the comparison is valid.

### M Nov 16
Began implementing board object with a hashmap of all notable locations on the board. Created an `EscapeSpace` class to bundle together location, terrain, and piece for each notable space.

### W Nov 18
Revised board organization to use separate HashMaps to store pieces and terrain. This feels much more natural for moving pieces without having to worry about the ground beneath them staying put. To shield the board from the util package, I created the `EscapeBoardHelper` object to take care of forming these HashMaps.

Movement validation currently happens in the board but does not feel like it will scale well.

Added a `StringManager` class to util to keep the string coordinates consistent for HashMap keys.

### R Nov 19
Added in more robust movement validation system with the introduction of the `Validator` interface, `AlphaValidator` class, `Movement Result` enum, and `FilledEscapeSpace` wrapper. This feels much more adherent to the single responsibility principle.

To keep the board and validator separate, I handled validation for movements off of the board in the board class. This feels fairly independent of the rules for a given game, so it feels like a reasonable division to me.

I never realized how helpful toString can be for debugging! It lets you see the whole relevant state of the board at once!

I'm not sure if there will be risk of a circular dependence with how much information about the board that the validator may need for Beta. One thought I have is that I may have the board trace paths and ask the validator if each step along the way is valid to keep the validator from needing to know about the board.
