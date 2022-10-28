Calculadora distribuida

======= COMO USAR =======

Para realizar os calculos, basta digitar os seguintes comandos:

1. Operações matemáticas
    - Soma: N1 + N2
    - Subtração: N1 - N2
    - Multiplicaão: N1 * N2
    - Divisão: N1 / N2


2. Como Executar
    - Para executar o projeto, você deve executar primeiramente o SERVIDOR (Servidor.java) e depois executar o CLIENTE (Cliente.java). Após a execução a calculadora estara prota para receber as expressões a serem calculadas
  

3. Explicação do projeto
    - Sobre o Projeto: 
    O projeto foi criado usando o conceito aprendido na disciplina de sistemas distribuídos. De forma resumida, o servidor fica responsável por realizar a operação as    quatro operações matematicos (+, -, *, /). Também foi criado um cliente que é responsavel por ler a informação digitada pelo usuário e vai verificar se há algum erro     na expressão digitada antes de mandar para o servidor. Caso nenhum erro seja encontrado a mensagem é enviada para o servidor para a realização do cálculo. Depois do     cálculo o resultado é enviado para o cliente e o mesmo é mostrado nma tela. 
    
    - O protocolo:
    O protocolo foi criado usando a linguagem de programação JAVA. Ele foi feito com base na leitura de uma expressão para o cálculo, sendo essa expressão composta por dois operanos e um operador. Caso seja qualquer expressao diferente disso, uma mensagem de erro deve ser exibida ao usuário
    
4. O host do Cliente : 127.0.1.1

5. Para o servidor foi usado a porta:9999 (Realiza operações básicas(+, -, *, /))
