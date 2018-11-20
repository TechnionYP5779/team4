## Development Status
[![Build Status](https://travis-ci.org/TechnionYP5779/team4.svg?branch=master)](https://travis-ci.org/TechnionYP5779/team4)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/TechnionYP5779/team4.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/TechnionYP5779/team4/alerts/)
[![SonarCube](https://sonarcloud.io/api/project_badges/measure?project=team4project&metric=alert_status)](https://sonarcloud.io/dashboard?id=team4project)

[![GitHub issues](https://img.shields.io/github/issues/TechnionYP5779/team2.svg)](https://github.com/TechnionYP5779/team5/issues)
[![GitHub issues closed](https://img.shields.io/github/issues-closed-raw/TechnionYP5779/team4.svg?maxAge=99999)](https://github.com/TechnionYP5779/team4/issues?q=is%3Aissue+is%3Aclosed)

[![codecov](https://codecov.io/gh/TechnionYP5779/team4/branch/master/graph/badge.svg)](https://codecov.io/gh/TechnionYP5779/team4)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/TechnionYP5779/team4.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/TechnionYP5779/team4/context:java)
[![Projects code style](https://img.shields.io/badge/code%20style-spartanized-blue.svg)]()


# Project Description
This is part of the 2018-2019 yearly project @ Technion Israel Institute of Technology.
Project goal is to improve the Spartanizer tool by refactoring it's code, adding documentation, improving test coverage, and much more.

# <a name="introduction"></a>The Spartanizer is:
- An Eclipse plugin
- Offers in the problems view tips for simplifying your code 
- Make your code laconic: say much in few words.
- Platform for other research: nano-patterns, source to source transformation, and The Athenizer

<!-- <img style="float: right;" src="https://www.spartan.org.il/images/logo-header.png"/> -->

The Spartanizer applies the principles of *[Spartan Programming]* to your Java code. It applies many different _tippers_, which are little rules that provide suggestions on how to shorten and
simplify your code, e.g, by using fewer variables, factoring out common structures, more efficient use of control flow, etc. 

The Spartanizer help you make a sequence small, nano-refactorings of your code, to make it shorter, and more conforming to a language of nano-patterns. The resulting code is not just shorter, it is more regular. The spartanization process tries to remove as many distracting details and variations from the code, stripping it to its bare bone.

This includes removal of piles of _syntactic baggage_, which is code that does nothing, except for being there:  curly brackets around one statement, initializations which reiterate the default, modifiers which do not change the semantics, implicit call to `super()` which every constructor has, fancy, but uselessly long variable names, variables which never vary and contain temporaries and  many more. Overall, the Spartanizer has over 100 tippers.

This project was conceived as an academic project in the [Technion - Israel
Institute of Technology], and was later developed for several years by
different students and members of the Computer Science faculty.

The refactorings made by this plug-in are based on the concept of Spartan Programming, which suggests guidelines for writing short, clean code. There's a lot of reading material on the subject in the [project wiki].

## Relevant Links
https://lgtm.com/projects/g/TechnionYP5779/team4/

## References 
This project is a work of team 4 on the original [SpartanRefactoring project](https://github.com/SpartanRefactoring/Main)



