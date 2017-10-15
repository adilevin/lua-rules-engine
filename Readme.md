## The grammar

The grammar for our DSL is in `src/main/antlr4/IfThen.g4`


## How to generate the parser

The Antlr4 Maven plugin automatically generates the parser code under `target/generated-sources/`  

#### Invoking from IntelliJ

1. Open `Maven Projects` window
2. Run the goal `antlr4:antlr4` under `Plugins -> antlr4`

#### Invoking using Maven

Type this in the command line from the project folder:

    mvn antlr4:antlr4