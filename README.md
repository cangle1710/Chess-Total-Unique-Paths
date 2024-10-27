# KnightUniquePaths

This Java project calculates all unique knight-move paths within an input grid, following specified constraints. The goal is to determine unique paths of exactly 10 cells (9 moves plus starting cell), starting from any valid cell on the grid, satisfying constraints such as limiting vowels and avoiding invalid cells (`#`).

## Requirements

- Java 11 or higher
- Maven (for dependency management)

## Getting Started

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/cangle1710/Chess-Total-Unique-Paths.git
    cd Chess-Total-Unique-Paths/
    ```

2. **Build the Project**:
 Run Maven to compile and set up dependencies:
     ```bash
     mvn clean install
     ```

## Running the Program

To execute the program, run the following Maven command, which will run the main class `MainRunner`:

```bash
mvn exec:java -Dexec.mainClass="MainRunner"
```
Or run the artifact jar file in `artifacts` folder with following command:
```bash
 java -jar ParabolicSurfCangLe.jar
```

## Customizing the Grid

To customize the grid, you can either modify the grid array directly in the input txt file in the resources folder. Format the .txt file where:

    Letters (A-Z) represent valid cells.
    # represents invalid cells that the knight cannot land on.

Example Grid
```
A,B,C,#,E
#,G,H,I,J
K,L,#,N,O
P,Q,R,S,T
U,V,#,#,Y
```
