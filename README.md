Projeto Java para o BlueJ que produz um simulado de questões com base em um arquivo.

O formato do Arquivo de Questões é:

palavra1;qual seu significado<br/>
palavra2;qual seu significado<br/>
palavra3;qual seu significado<br/>
...

O programa lerá este arquivo e montará uma questão com base no significado, cabe ao usuário marcar qual a palavra correta. Este programa é excelente para treinar matérias no qual é necessário "decorar" vários termos.

Na classe "Arquivo.java" encontramos a seguinte variável: 

  private final String nomeArquivo = "FigurasDeSintaxe.qst";

Ou seja, está apontando para este arquivo que se encontra na pasta /materias, se desejar usar outro basta criar o arquivo e trocar esta variável.

Para executar o programa basta usar:

java Testador

Sendo obviamente necessário compilá-lo primeiro com:

javac Testador

Espero que possa ser muito útil a estudantes. Veja as telas para uma melhor referência

Fernando Anselmo
# projsSoltos
