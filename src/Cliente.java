import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Cliente {

    public static void main(String[] args) 	{
        try {
            Socket s = new Socket("127.0.0.1", 9999);
            InputStream i = s.getInputStream();
            OutputStream o = s.getOutputStream();

            String str;
            String expressao;
            int verifica = 0;

            do {
                byte[] line = new byte[100];
                System.out.println("\nDigite 'sair' para encerrar");
                System.out.println("Digite a expressão a ser calculada:");
                System.in.read(line);
                expressao = new String(line);
                expressao = expressao.trim();

                //Caso a palavra sair seja digitada de formas diferentes, todos os caracteres são transformados em minúsculos em minusculos
                expressao = expressao.toLowerCase();

                //Retira todos os espaços em branco da expressão
                expressao = expressao.replaceAll("\\s+", "");

                //Comdição para verificar a ocorrência de erros na expressão digitada
                if(Verifica(expressao, verifica) >= 1){
                    System.out.println("ERRO! Expressão incorreta");

                }else{//Caso nenhum erro seja encontrado, a mensagem é enviada para o servidor
                    o.write(line);  
                    Arrays.fill(line, (byte) 0);
                    i.read(line);

                    str = new String(line);

                    if (expressao.trim().equals("sair")) {
                        System.out.println("Fechando calculadora");
                    } else {
                        System.out.println("Resposta: " + expressao.trim() + " = " + str.trim());
                    }
                }


            } while (!expressao.trim().equals("sair"));
            s.close();
        }
        catch (Exception err) {
            System.err.println(err);
        }
    }

    public static int Verifica(String expressao, int verifica) { //Verifica erros na expressão que foi digitada
        verifica = 0;
        int qtdOperadores = 0;

        //Transforma a string em um vetor
        String[] separaSrting = expressao.split("(?!^)");

        //Pega o tamanho da expressão(Array)
        int tamanhoExpresao = separaSrting.length;

        //Percorre toda a expressão para verificar se existem caracteres inválidos
        for(int i = 0; i < tamanhoExpresao; i++){
            //Verifica se há caracteres diferentes dos que devem ser aceitos
            if(Pattern.matches( "[^0-9+*/-]" ,  separaSrting[i])){
               verifica++;
            }

            //Verifica quantos operadores tem na expressão
            if(Pattern.matches( "[+*/-]" ,  separaSrting[i])){
                qtdOperadores++;
            }
        }

        //Verifica se há mais de um ou nenhum operador
        if(qtdOperadores == 0 || qtdOperadores >=2){
            verifica++;
        }

        //Verifica se existe operadores na posição inicial ou final da expressão
        if(Pattern.matches( "[+*/-]" ,  separaSrting[tamanhoExpresao-1]) || Pattern.matches( "[+*/-]" ,  separaSrting[0])){
            verifica++;
        }

        //Condição para que se a palavra digitada for 'sair', a mensagem de erro não apareça
        if(Pattern.matches( "sair",  expressao)){
            verifica = 0;
        }

        return verifica;
    }
}
