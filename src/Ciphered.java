public class Ciphered {

    public static String cifrar(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }

    public static String descifrar(String textoCifrado) {
        return new StringBuilder(textoCifrado).reverse().toString();
    }
}

