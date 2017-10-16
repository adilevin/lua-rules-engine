# A DSL with LUA code generation
 
## Overview

This project demonstrates transformation of a [DSL](https://en.wikipedia.org/wiki/Domain-specific_language) 
into [LUA](https://www.lua.org/) code.

The [DSL](https://en.wikipedia.org/wiki/Domain-specific_language) is defined using a 
[grammar](https://github.com/antlr/antlr4/blob/master/doc/grammars.md) (*.g4) file. 
The parser for this [grammar](https://github.com/antlr/antlr4/blob/master/doc/grammars.md) 
is generated automatically by [ANTLR](https://github.com/antlr/antlr4) from 
the .g4 [grammar](https://github.com/antlr/antlr4/blob/master/doc/grammars.md), 
at compile time. At run time, we transform a script the follows the
[DSL](https://en.wikipedia.org/wiki/Domain-specific_language)'s specification, 
into executable [LUA](https://www.lua.org/) code.  

    DSL grammar -------- compile time -------- > Java parser & code generator

    DSL script  ---------- run time ---------- > LUA code 

## The [DSL](https://en.wikipedia.org/wiki/Domain-specific_language)

The [grammar](https://github.com/antlr/antlr4/blob/master/doc/grammars.md) for our 
[DSL](https://en.wikipedia.org/wiki/Domain-specific_language) 
is in the file [IfThen.g4](src/main/antlr4/com/github/adilevin/IfThen.g4).
Valid scripts include a collection of rules that have the form `if <predicate> then <action>`.
Preciates are comparisons such as `height < 30`, `weight >= 40` or `age >= 6`, 
and actions are only `accept` and `reject`.

See [1.rules](src/main/resources/rule-files/1.rules) for an example of a valid script.

## How to generate the parser

The Antlr4 Maven plugin automatically generates the parser code under `target/generated-sources/`. 
Notice the `<visitor>` option in [pom.xml](pom.xml), which is needed in order to generate Visitor base classes.   

#### Invoking from IntelliJ

1. Open `Maven Projects` window
2. Run the goal `antlr4:antlr4` under `Plugins -> antlr4`

#### Invoking using Maven

Type this in the command line from the project folder:

    mvn antlr4:antlr4
    
## How to run the LUA code generator

Run the class [App](src/main/java/com/github/adilevin/App.java) in the project folder. It will read the rules in the resource file [/rule-files/1.rules](src/main/resources/rule-files/1.rules) 
and will generate [rules.lua](rules.lua).

## How to execute the [LUA](https://www.lua.org/) code

After generating the [LUA](https://www.lua.org/) code, run the following command in the project folder:

    lua main.lua
    
Notice that [main.lua](main.lua) "require"s [rules.lua](rules.lua).