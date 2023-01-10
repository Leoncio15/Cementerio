
import controlador.CtrlPrincipal;
import vista.frmPrincipal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		frmPrincipal vistaPrincipal = new frmPrincipal();
		
		CtrlPrincipal controller = new CtrlPrincipal(vistaPrincipal);
		
		controller.iniciar();
		
		vistaPrincipal.setVisible(true);
				

	}

}
