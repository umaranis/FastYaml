@echo off
set /p COM= Enter TestRig command (gui, tokens or tree)?
SET CLASSPATH=.;D:\Umar\Antlr\antlr-4.7-complete.jar;%CLASSPATH%
D:\Umar\Java\jdk1.8.0_25\bin\java org.antlr.v4.Tool YamlLexer.g4 -o D:\Umar\IntelijSpace\FastYaml\out\grungui
D:\Umar\Java\jdk1.8.0_25\bin\java org.antlr.v4.Tool YamlParser.g4 -o D:\Umar\IntelijSpace\FastYaml\out\grungui
cd D:\Umar\IntelijSpace\FastYaml\out\grungui
D:\Umar\Java\jdk1.8.0_25\bin\javac Yaml*.java
D:\Umar\Java\jdk1.8.0_25\bin\java org.antlr.v4.gui.TestRig Yaml file -%COM% D:\Umar\IntelijSpace\FastYaml\src\test1.yaml
cd D:\Umar\IntelijSpace\FastYaml\src\antlr