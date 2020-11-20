# Matthew St Louis - Escape Alpha Todo

## Tests
- 1: Square coordinate should create
- Square coordinate should give its x and y values when asked according to the following table:

| # | x | y |
|---|---|---|
| 2 |  1|  1|
| 3 | -2|  3|
| 4 | 15|  0|

- Square should calculate the distance to another given square coordinate according to the following table:

| # | x1 | y1 | x2 | y2 | distance |
|---|----|----|----|----|----------|
| 5 |  1 |  1 |  1 |  2 |        1 |  
| 6 |  1 |  1 |  5 |  1 |        4 |
| 7 |  2 |  3 |  8 |  5 |        6 |
| 8 | -1 | -3 |  2 |  4 |        7 |
| 9 |  3 |  4 |  3 |  4 |        0 |

- 10: AlphaEscapeGameManager should create
- AlphaEscapeGameManager should create coordinates when asked according to the following table:

|  # |  x |  y |
|----|----|----|
| 11 |  1 |  1 |
| 12 |  2 |  4 |
| 13 |  8 |  9 |

- 14. EscapeGameBulider should build an escape game manager

- Escape Game should populate with pieces according to the following table:

|  # |  x |  y |  Name | Player |
|----|----|----|-------|--------|
| 15 |  4 |  4 | SNAIL |      1 |
| 16 | 10 | 12 | HORSE |      2 |
| 17 |  1 |  1 |  null |   null |
| 18 | -1 | -1 |  null |   null |
| 19 | 50 | 50 |  null |   null |
| 20 |  3 |  5 |  null |   null |

- Escape Game Manager should move pieces with the following results:

|  # | x1 | y1 | x2 | y2 | Result |
| 21 |  4 |  4 |  5 |  5 |   true |
| 22 |  4 |  4 |  3 |  5 |  false |
| 23 |  4 |  4 | 10 | 12 |   true |
| 24 |  4 |  4 |  5 | 12 |   true |
| 25 |  4 |  4 | 50 | 50 |  false |
| 26 |  4 |  4 | -1 | -1 |  false |
| 27 |  4 |  4 |  4 |  4 |   true |
| 28 |  3 |  3 |  5 |  5 |  false |
| 29 | -1 | -1 |  5 |  5 |  false |
| 30 |  3 |  3 | -1 | -1 |  false |
