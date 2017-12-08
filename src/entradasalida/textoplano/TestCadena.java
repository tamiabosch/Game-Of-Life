package entradasalida.textoplano;

public class TestCadena {

	public static void main(String[] args) {
		String cadena = " ** \n ** ";
		if(cadena.matches("[[*]* \\s*]*")) {
			System.out.println("cadena matches " + cadena.length());
		}else System.out.println("fail");

	}

}
