package FuncionesSudoku;

public class Sudoku_EnriqueBellido {

	private static int[][] PlantillaSudoku(int[][] sudoku) {//Nos crea la plantilla del sudoku completa 
		int i, numero=1, nuevonumero=1,j;
		for (i=0;i<9;i++) {//Para que la fila empieze donde nuevonumero indique
			numero=nuevonumero;
		
		for (j=0;j<9;j++) {
			if (numero<=9) {
				sudoku [i][j]=numero;
				numero++;
			}else {
				numero=1;//vuelve a 1 si llega a 9
				sudoku[i][j]=numero;
				numero++;
			}
		}
		nuevonumero=numero+3;//Hace que empieze con otra sucesion de numeros distinta con una suma de 3 
		if (numero==10) {//Cuando llega a la cuarta fila empieza con un numero distinto con los dos if
			nuevonumero=4;
		}
		if(nuevonumero>9) {
			nuevonumero=(nuevonumero%9+1);
		}
		}
		return sudoku;
	}

	private static int[][] cambiofilas(int[][] sudoku) {//Baraja las filas del sudoku
		int fila1, veces, fila2;
		for (veces=0; veces<((int)(Math.random()*4)+1);veces++) {//baraja las filas de los 3 primeros "bloques" del sudoku de 1 a 5
			fila1=(int)(Math.random()*3);
			fila2=(int)(Math.random()*3);
			if (fila1!=fila2) {
				int j, aux;
				for (j=0;j<9;j++) {//Guardamos la fila en un aux para luego cambiar el aux tras sustituir la fila
					aux=sudoku[fila1][j];
					sudoku[fila1][j]=sudoku[fila2][j];
					sudoku[fila2][j]=aux;
				}
			}
		}
		for (veces=0; veces<((int)(Math.random()*4)+1);veces++) {//salta a los siguientes 3 "bloques"
			fila1=(int)(Math.random()*3)+3;
			fila2=(int)(Math.random()*3)+3;
			if (fila1!=fila2) {
				int j, aux;
				for (j=0;j<9;j++) {
					aux=sudoku[fila1][j];
					sudoku[fila1][j]=sudoku[fila2][j];
					sudoku[fila2][j]=aux;
				}
			}
		}
		for (veces=0; veces<((int)(Math.random()*4)+1);veces++) {//Y aqui baraja la de los ultimos 3 "bloques"
			fila1=(int)(Math.random()*3)+6;
			fila2=(int)(Math.random()*3)+6;
			if (fila1!=fila2) {
				int j, aux;
				for (j=0;j<9;j++) {
					aux=sudoku[fila1][j];
					sudoku[fila1][j]=sudoku[fila2][j];
					sudoku[fila2][j]=aux;
				}
			}
		}
		return sudoku;
	}

	private static int[][] cambiocolumnas(int[][] sudoku) {//Baraja las columnas del sudoku
		int columna1, veces, columna2;
		for (veces=0; veces<((int)(Math.random()*4)+1);veces++) {//baraja las columnas de los 3 primeros "bloques" del sudoku de 1 a 5
			columna1=(int)(Math.random()*3);
			columna2=(int)(Math.random()*3);
			if (columna1!=columna2) {
				int j, aux;
				for (j=0;j<9;j++) {
					aux=sudoku[columna1][j];//Guardamos la columna en un aux para luego cambiar el aux tras sustituir la fila
					sudoku[columna1][j]=sudoku[columna2][j];
					sudoku[columna2][j]=aux;
				}
			}
		}
		for (veces=0; veces<((int)(Math.random()*4)+1);veces++) {//salta a los siguientes 3 "bloques"//salta a los siguientes 3 "bloques"
			columna1=(int)(Math.random()*3)+3;
			columna2=(int)(Math.random()*3)+3;
			if (columna1!=columna2) {
				int j, aux;
				for (j=0;j<9;j++) {
					aux=sudoku[columna1][j];
					sudoku[columna1][j]=sudoku[columna2][j];
					sudoku[columna2][j]=aux;
				}
			}
		}
		for (veces=0; veces<((int)(Math.random()*4)+1);veces++) {//Y aqui baraja la de los ultimos 3 "bloques"//Y aqui baraja la de los ultimos 3 "bloques"
			columna1=(int)(Math.random()*3)+6;
			columna2=(int)(Math.random()*3)+6;
			if (columna1!=columna2) {
				int j, aux;
				for (j=0;j<9;j++) {
					aux=sudoku[columna1][j];
					sudoku[columna1][j]=sudoku[columna2][j];
					sudoku[columna2][j]=aux;
				}
			}
		}
		return sudoku;
	}

	private static int[][] huecosvacios(int[][] sudoku) {//nos borra los huevos necesarios de nuestro sudoku
		int i, c=0,f=0,j,borrarn,cont=0,huecosvacios,huecostotales=0;
		while (huecostotales<40) {//Ponemos un limite de 40 huecos que son los que se van a borrar en nuestro sudoku
			huecosvacios=0;
			borrarn=0;
			borrarn=((int)(Math.random()*3)+3);//Para borrar los huevos por "bloques" de 3 a 5 huecos como maximo
			while (huecosvacios<borrarn) {
				i=((int)(Math.random()*3)+f);//controlamos que salte de "bloque"a las 3 siguientes filas
				j=((int)(Math.random()*3)+c);//controlamos que salte de "bloque"a las 3 siguientes columnas
				if (sudoku[i][j]!=0) {
					sudoku [i][j]=0;
					huecosvacios++;
					huecostotales++;
				}
			}
			cont=cont+1;//Controlamos que solo entre una vez en la matriz para que no entre mas de una y borre mas huecos de lo necesario
			if(cont==9) {
				huecostotales=40;
			}
			c=c+3;//Sumamos 3 ala fila, columna y que se vuelvan 0 cuando llege al final
			if (c==9) {
				c=0;
				f=f+3;
			}
		}
		return sudoku;
	}

	private static void Isudoku(int[][] sudoku) {//Nos muestra el resultado de nuestro sudoku por pantalla
		int i,j;
		for (i=0;i<9;i++) {
			for (j=0;j<9;j++) {
				if (sudoku[i][j]==0) {
					System.out.print("[ ]");
				}else {
					System.out.print("["+sudoku[i][j]+"]");
				}
			}
			System.out.println();
		}
	}

	public static void jugarsudoku() {//definimos nuestro sudoku con todas las funciones anteriores y nos lo muestra por pantalla
		int [][] sudoku= new int [9][9];
		sudoku=Sudoku_EnriqueBellido.PlantillaSudoku(sudoku);
		sudoku=Sudoku_EnriqueBellido.cambiofilas(sudoku);
		sudoku=Sudoku_EnriqueBellido.cambiocolumnas(sudoku);
		sudoku=Sudoku_EnriqueBellido.huecosvacios(sudoku);
		Sudoku_EnriqueBellido.Isudoku(sudoku);
	}

}


