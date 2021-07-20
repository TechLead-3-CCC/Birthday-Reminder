package principal;
import principal.controller.*;
import principal.model.*;
import principal.vue.*;


import principal.vue.Fenetre;

public class Playbook {

	public static void main(String[] args) {
		Traitement model=new Traitement();
		Fenetre view =new Fenetre ();
		Control control = new Control(model, view);
		
		control.init();
		

	}

}
