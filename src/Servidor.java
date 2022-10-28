import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(9999);
            String str;
            Float num1, num2, resultado = null;

            while (true) {
                Socket c = s.accept();
                InputStream i = c.getInputStream();
                OutputStream o = c.getOutputStream();
                do {
                    byte[] line = new byte[100];

                    i.read(line);

                    str = new String(line);

                    //Retira todos os espaços em branco da expressão
                    str = str.replaceAll("\\s+", "");

                    //Verifica se tem o operador na expressão
                    if (str.indexOf("+") >= 0) {
                        String[] str2 = str.split("\\+");
                        System.out.println("\nÉ adição");
                        num1 = Float.parseFloat(str2[0]);
                        num2 = Float.parseFloat(str2[1]);
                        resultado = Soma_numeros(num1, num2);//Chama o metodo de adição
                    }

                    //Verifica se tem o operador na expressão
                    if (str.indexOf("-") >= 0) {
                        String[] str2 = str.split("-");
                        System.out.println("\nÉ subtração");
                        num1 = Float.parseFloat(str2[0]);
                        num2 = Float.parseFloat(str2[1]);
                        resultado = Subtrai_numeros(num1, num2);//Chama o metodo de subtração
                    }

                    //Verifica se tem o operador na expressão
                    if (str.indexOf("*") >= 0) {
                        String[] str2 = str.split("\\*");
                        System.out.println("\nÉ multipliação");
                        num1 = Float.parseFloat(str2[0]);
                        num2 = Float.parseFloat(str2[1]);
                        resultado = Multiplica_numeros(num1, num2);//Chama o metodo de multiplição
                    }

                    //Verifica se tem o operador na expressão
                    if (str.indexOf("/") >= 0) {
                        String[] str2 = str.split("/");
                        System.out.println("\nÉ divisão");
                        num1 = Float.parseFloat(str2[0]);
                        num2 = Float.parseFloat(str2[1]);
                        resultado = Divide_numeros(num1, num2);//Chama o metodo divisão
                    }

                    str = String.valueOf(resultado);
                    o.write(str.getBytes());

                    System.out.println("Resultado => " + str);

                    str = new String(line);
                    } while (!str.trim().equals("sair"));
                c.close();
            }
        } catch (Exception err) {
            System.err.println(err);
        }
    }


    public static float Soma_numeros(float x, float y) {
        float soma = x + y;
        return soma;
    }

    public static float Subtrai_numeros(float x, float y) {
        float subtracao = x - y;
        return subtracao;
    }

    public static float Multiplica_numeros(float x, float y) {
        float multiplicacao = (x * y);
        return multiplicacao;
    }

    public static float Divide_numeros(float x, float y) {
        float divisao = (x / y);
        return divisao;
    }
}