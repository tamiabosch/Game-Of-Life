package entradasalida.textoplano;

public class TestCadena {

	public static void main(String[] args) {
		String cadena = "****\n ** ";
		if(cadena.matches("[[*]* \\s*]*")) {
			boolean test = cadena.charAt(3) == '4';
			System.out.println("cadena matches " + cadena.length() + " " + cadena.indexOf('\n') + " " +cadena.indexOf('*') +
					" index: " + test);
			
			String[] lines = cadena.split("\r\n|\r|\n");
			for (String line : lines) {
			    System.out.println(line);
			}
			String lenghtfirst = lines[0];
			int lenghtreal = lenghtfirst.length();
			for (String lenght : lines) {
				if(lenght.length() == lenghtreal) {
					System.out.println("stimmt");
				} else {
					System.out.println("passt nicht");
				}
			}
			int xDim = lines[0].length();
			int yDim = lines.length;
			System.out.println("x:"+ xDim + " y:" + yDim + " cadena:" + lines[1] + lines.length);
			
			for(int y = 0; y<yDim; y++) {
				for(int x = 0; x<xDim; x++) {
					if(lines[y].charAt(x) == '*') {
						System.out.println("*");
						//tablero.setCelda(new Coordenada2D(x,y), EstadoCelda.VIVA);
					} else if(lines[y].charAt(x) == ' ') {
						System.out.println("-");
						//tablero.setCelda(new Coordenada2D(x,y), EstadoCelda.MUERTA);
					}
				}
			}
			
			String newline = System.getProperty("line.separator");
			boolean hasNewline = cadena.contains("\n");
			System.out.println("Has new line: " + hasNewline);
			
		}else System.out.println("fail");

	}

}
