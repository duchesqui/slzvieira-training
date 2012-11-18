public class MegaSena {

    public static void main(String[] args) {

        for (int i = 0; i < 6; i++) {
            int numero = (int) (Math.random() * 60) + 1;
            System.out.print(numero);
            System.out.print(" ");
        }
    }
}
