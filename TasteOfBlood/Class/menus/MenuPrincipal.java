package menus;

import main.TasteOfBlood;
import party.Party;
import player.Player;
import read.Read;

public class MenuPrincipal extends MenuTemplate {
	
	public MenuPrincipal(String tittle) {
		super(tittle);
		opc.add("Nueva partida");
		opc.add("Cargar partida");
		opc.add("Borrar Partida");
		opc.add("Salir");
		this.showMenu();
	}

	@Override
	protected void redirectTo(int opc) {
		// TODO Auto-generated method stub
		switch(opc) {
		case 1:
			//Crea una nueva partida
			TasteOfBlood.setParty(new Party());
			if(TasteOfBlood.getBBDD().addPlayer(TasteOfBlood.getParty().getPlayer())) {
				System.out.println("Su personaje se guardó correctamente");
				System.out.println(TasteOfBlood.getBBDD().searchPlayer(TasteOfBlood.getParty().getPlayer().getName()));
			}
			else {
				System.out.println("Error en la conexión con la BBDD");
			}
			break;
		case 2:
			//Cargamos una partida existente
			try {
				System.out.println("Seleccione una partida\n"+TasteOfBlood.getBBDD().searchAllPlayers());
				String BuilderPlayer = TasteOfBlood.getBBDD().searchPlayer(Read.readString("Introduzca su nombre:"));
				//Recreamos el objeto
				String[] BuildPlayer = BuilderPlayer.split(",");
				TasteOfBlood.setParty(new Party(new Player(BuildPlayer[0],BuildPlayer[1])));
				
				//Lo mostramos
				System.out.println("Su nombre es: ");
			}catch(NullPointerException e) {
				System.out.println("No se han encontrado datos");
				System.exit(0);
			}
			break;
		case 3:
			//Borramos una partida existente
			if(TasteOfBlood.getBBDD().deletePlayer(Read.readString("Seleccione una partida\n"+TasteOfBlood.getBBDD().searchAllPlayers()))) {
				System.out.println("Usuario borrado correctamente");
			}
			else {
				System.out.println("No se ha podido borrar el usuario");
			}
			break;
		case 4:
			System.exit(0);
			break;
		}
	}

}
