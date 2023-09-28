
public class Aplicacion {

	public static void main(String[] args) {
		JuegoDos j1 = new JuegoDos(5);
		JuegoDos j2 =new JuegoDos(5);
		j1.MuestraVidasRestantes();
		j1.QuitaVida();
		j1.MuestraVidasRestantes();
		j1.ActualizaRecord();
		j1.ReiniciarPartida();
		j1.MuestraVidasRestantes();
		j1.ActualizaRecord();
		j2.MuestraVidasRestantes();
		j2.ActualizaRecord();
	}
}
