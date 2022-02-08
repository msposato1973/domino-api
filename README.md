# Domino-api
Write an application that, given in input a list of domino pieces, calculates the chain with the highest value that can be built starting from one of the pieces. The starting piece is given in input to the application, too.

# Details
1. The starting piece has no special property, it’s just the algorithm entry point;
2. Each domino piece has two values, each one ranging from 1 to 10;
3. Values on a piece can’t be equal. I.e.: (4, 4) isn’t a valid piece, while (2, 4) is;
4. Two pieces can be connected in the chain if they share a common value;
5. Each piece can be used only once in the chain;
6. When two pieces are connected, the common value is elided and the couple acts like
a piece whose values are the non-common ones. I.e.: (1, 5) - (5, 3) is a valid
connection. To connect a third piece to the chain, it must have a 1 or a 3, since the
value 5 cannot be used to extend this chain;

7. The value of a chain is computed by summing the common values between
connected pieces. I.e.: (7, 1) - (1, 5) - (5, 3) - (3, 2) has a value of 1 + 5 + 3 = 9;

## Objectives
1. Application can be either a command line application or a web application with a
REST api. Bonus point for building a REST api;

2. Use maven to define the project;

3. Use Spring framework to connect the pieces of the application. It is not mandatory to
use Spring Boot

4. Write JUnit tests. Good test coverage gets bonus points.
