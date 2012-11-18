import java.util.Calendar;

public class Natal {

    public static void main(String[] args) {

        /* Obtem a data de hoje em uma variável do tipo Calendar. */
        Calendar hoje = Calendar.getInstance();

        /* Obtem a data de hoje e modifica-a para o natal do ano atual. */
        Calendar natal = Calendar.getInstance();
        natal.set(Calendar.MONTH, 11); // Avança para dezembro
        natal.set(Calendar.DAY_OF_MONTH, 25); // Avança para o dia 25

        /* Calcula a diferenca entre as datas em milissegundos. */
        long diferenca = natal.getTimeInMillis() - hoje.getTimeInMillis();

        diferenca /= 1000; // Converte de milissegundos para segundos
        diferenca /= 60;   // Converte de segundos para minutos
        diferenca /= 60;   // Converte de minutos para horas
        diferenca /= 24;   // Converte de horas para dias

        System.out.println("Faltam " + diferenca + " dias para o Natal!");
    }
}
