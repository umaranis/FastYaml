# FastYaml
YAML Parser based on ANTLR parser generator

### Development
- ANTLR grammar is defined in [YamlLexer.g4](https://github.com/umaranis/FastYaml/blob/master/src/antlr/YamlLexer.g4) and [YamlParser.g4](https://github.com/umaranis/FastYaml/blob/master/src/antlr/YamlParser.g4)
- There are 104 Unit tests written as yet (JUnit)
- run genSource.bat to generate classes from grammar
  - to be executed after every change in grammar files
- run grunGUI.bat to run ANTLR Test Rig
  - three options for test rigs are gui, tokens, tree
  - test1.yaml file is used as input
