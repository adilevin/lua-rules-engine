# A DSL with LUA code generation
 
## Overview

This project demonstrates transformation of a DSL into LUA code.

The DSL is defined using a [grammar](https://github.com/antlr/antlr4/blob/master/doc/grammars.md) (*.g4) file. 
The parser for this grammar is generated automatically by [ANTLR](https://github.com/antlr/antlr4) from 
the .g4 grammer, at compile time. At run time, we transform a script the follows the DSL's language, 
into executable [LUA](https://www.lua.org/) code.  

## The grammar

The grammar for our DSL is in `src/main/antlr4/IfThen.g4`.

## How to generate the parser

The Antlr4 Maven plugin automatically generates the parser code under `target/generated-sources/`. 
Notice the `<visitor>` option in the pom.xml, which is needed in order to generate Visitor base classes.   

#### Invoking from IntelliJ

1. Open `Maven Projects` window
2. Run the goal `antlr4:antlr4` under `Plugins -> antlr4`

#### Invoking using Maven

Type this in the command line from the project folder:

    mvn antlr4:antlr4
    
## How to run the LUA code generator

Run the class `App` in the project folder. It will read the rules in the resource file `/rule-files/1.rules` 
and will generate `rules.lua`.

## How to execute the LUA code

After generating the LUA code, run the following command in the project folder:

    lua main.lua
    
Notice that `main.lua` "require"s `rules.lua`.