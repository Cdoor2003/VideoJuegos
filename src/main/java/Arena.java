import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Arena {
	public ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
	public ArrayList<Personaje> personajes = new ArrayList<Personaje>();

	public void mostrarMenuPrincipal(){
		System.out.println("1) Pelea contra La Marina");
		System.out.println("2) Pelea contra otro personaje");
		System.out.println("3) Salir del juego");
		System.out.println("Seleccione una opción");
	}

	public void salirMenu() {
		System.out.println("Saliste del juego.");
	}

	public void menuPrincipal(Personaje personaje) {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		do {
			try {
				mostrarMenuPrincipal();
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 3) {
					teclado.nextLine();
					System.err.println("Opción ingresada no valida, por favor intente de nuevo");
				}
				switch (opcion) {
					case 1: {
						menuOpcion1(personaje);
					}
					case 2:{
						System.out.println("Ingrese el nombre del personaje enemigo: ");
						String nombre = teclado.next();
						System.out.println("Ingrese el nombre del ataque del enemigo: ");
						String nombreAtaque = teclado.next();
						Personaje personaje1 = new Personaje(nombre,((int)(Math.random()*(100-1+1)+1)),((int)(Math.random()*(100-1+1)+1)),((int)(Math.random()*(100-1+1)+1)),nombreAtaque);
						peleaContraPersonaje(personaje,personaje1);
					}
				}
			} catch (InputMismatchException e) {
				teclado.nextLine();
				System.err.println("Opción ingresada no valida, por favor intente de nuevo");
			}
		} while (opcion != 3);
		salirMenu();
	}

	public void mostrarMenuOpcion1(){
		System.out.println("1) Capitan");
		System.out.println("2) Vicealmirante");
		System.out.println("3) Almirante");
		System.out.println("4) Volver a menu principal");
		System.out.println("Seleccione la opcion que desee");
	}

	public void menuOpcion1(Personaje personaje){
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		do {
			try {
				mostrarMenuOpcion1();
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 4) {
					teclado.nextLine();
					System.err.println("Opción ingresada no valida, por favor intente de nuevo");
				}
				switch (opcion) {
					case 1:{
						peleaContraCapitan(personaje);
					}
					case 2:{
						peleaContraVicealmirante(personaje);
					}
					case 3:{
						peleaContraAlmirante(personaje);
					}
				}
			} catch (InputMismatchException e) {
				teclado.nextLine();
				System.err.println("Opción ingresada no valida, por favor intente de nuevo");
			}
		} while (opcion != 4);
		salirMenu();
		menuPrincipal(personaje);
	}

	public void peleaContraCapitan(Personaje personaje){
		Capitan capitan = new Capitan(((int)(Math.random()*(30-1+1)+1)),((int)(Math.random()*(30-1+1)+1)),((int)(Math.random()*(30-1+1)+1)));
		String[] ataquesEspeciales = capitan.getAtaquesEspecialesCapitan();
		String ataqueEspecial = ataquesEspeciales[(int)(Math.random()*(4-1+1)+1)];
		while(personaje.getVida() > 0 && capitan.getVida() > 0){
			System.out.println(capitan.toString());
			if(personaje.getVelocidad() > capitan.getVelocidad()){
				int dañoPersonaje = ((int)(Math.random()*((personaje.getFuerza())-(personaje.getFuerza()-20)+1)+(personaje.getFuerza()-20)));
				System.out.println(personaje.getNombre()+" ataca con "+personaje.getAtaque());
				System.out.println("Hace un daño de: "+dañoPersonaje);
				capitan.setVida(capitan.getVida()-dañoPersonaje);
				if(capitan.getVida() > 0){
					int dañoCapitan = ((int)(Math.random()*((capitan.getFuerza())-1+1)+1));
					System.out.println("Capitan de la marina ataca con: "+ataqueEspecial);
					System.out.println("Hace un daño de: "+dañoCapitan);
					personaje.setVida(personaje.getVida()-dañoCapitan);
				}
			}
			else{
				int dañoCapitan = ((int)(Math.random()*((capitan.getFuerza())-1+1)+1));
				System.out.println("Capitan de la marina ataca con: "+ataqueEspecial);
				System.out.println("Hace un daño de: "+dañoCapitan);
				personaje.setVida(personaje.getVida()-dañoCapitan);
				if(personaje.getVida() > 0){
					int dañoPersonaje = ((int)(Math.random()*((personaje.getFuerza())-(personaje.getFuerza()-20)+1)+(personaje.getFuerza()-20)));
					System.out.println(personaje.getNombre()+" ataca con "+personaje.getAtaque());
					System.out.println("Hace un daño de: "+dañoPersonaje);
					capitan.setVida(capitan.getVida()-dañoPersonaje);
				}
			}
		}
		if(personaje.getVida() < 0){
			System.out.println("Has perdido contra Capitan de la marina");
		}
		else{
			System.out.println("Le has ganado al Capitan de la marina");
		}
		menuPrincipal(personaje);
	}

	public void peleaContraVicealmirante(Personaje personaje){
		Vicealmirante vicealmirante = new Vicealmirante(((int)(Math.random()*(60-30+1)+30)),((int)(Math.random()*(60-30+1)+30)),((int)(Math.random()*(60-30+1)+30)));
		String[] ataquesEspeciales = vicealmirante.getAtaquesEspecialesVicealmirante();
		String ataqueEspecial = ataquesEspeciales[(int)(Math.random()*(4-1+1)+1)];
		while(personaje.getVida() > 0 && vicealmirante.getVida() > 0){
			System.out.println(vicealmirante.toString());
			if(personaje.getVelocidad() > vicealmirante.getVelocidad()){
				int dañoPersonaje = ((int)(Math.random()*((personaje.getFuerza())-(personaje.getFuerza()-20)+1)+(personaje.getFuerza()-20)));
				System.out.println(personaje.getNombre()+" ataca con "+personaje.getAtaque());
				System.out.println("Hace un daño de: "+dañoPersonaje);
				vicealmirante.setVida(vicealmirante.getVida()-dañoPersonaje);
				if(vicealmirante.getVida() > 0){
					int dañoVicealmirante = ((int)(Math.random()*((vicealmirante.getFuerza())-1+1)+1));
					System.out.println("Vicealmirante de la marina ataca con: "+ataqueEspecial);
					System.out.println("Hace un daño de: "+dañoVicealmirante);
					personaje.setVida(personaje.getVida()-dañoVicealmirante);
				}
			}
			else{
				int dañoVicealmirante = ((int)(Math.random()*((vicealmirante.getFuerza())-1+1)+1));
				System.out.println("Vicealmirante de la marina ataca con: "+ataqueEspecial);
				System.out.println("Hace un daño de: "+dañoVicealmirante);
				personaje.setVida(personaje.getVida()-dañoVicealmirante);
				if(personaje.getVida() > 0){
					int dañoPersonaje = ((int)(Math.random()*((personaje.getFuerza())-(personaje.getFuerza()-20)+1)+(personaje.getFuerza()-20)));
					System.out.println(personaje.getNombre()+" ataca con "+personaje.getAtaque());
					System.out.println("Hace un daño de: "+dañoPersonaje);
					vicealmirante.setVida(vicealmirante.getVida()-dañoPersonaje);
				}
			}
		}
		if(personaje.getVida() < 0){
			System.out.println("Has perdido contra Vicealmirante de la marina");
		}
		else{
			System.out.println("Le has ganado al Vicealmirante de la marina");
		}
		menuPrincipal(personaje);
	}

	public void peleaContraAlmirante(Personaje personaje){
		Almirante almirante = new Almirante(((int)(Math.random()*(100-60+1)+60)),((int)(Math.random()*(100-60+1)+60)),((int)(Math.random()*(100-60+1)+60)));
		String[] ataquesEspeciales = almirante.getAtaquesEspecialesAlmirante();
		String ataqueEspecial = ataquesEspeciales[(int)(Math.random()*(4-1+1)+1)];
		while(personaje.getVida() > 0 && almirante.getVida() > 0){
			System.out.println(almirante.toString());
			if(personaje.getVelocidad() > almirante.getVelocidad()){
				int dañoPersonaje = ((int)(Math.random()*((personaje.getFuerza())-(personaje.getFuerza()-20)+1)+(personaje.getFuerza()-20)));
				System.out.println(personaje.getNombre()+" ataca con "+personaje.getAtaque());
				System.out.println("Hace un daño de: "+dañoPersonaje);
				almirante.setVida(almirante.getVida()-dañoPersonaje);
				if(almirante.getVida() > 0){
					int dañoAlmirante = ((int)(Math.random()*((almirante.getFuerza())-1+1)+1));
					System.out.println("Almirante de la marina ataca con: "+ataqueEspecial);
					System.out.println("Hace un daño de: "+dañoAlmirante);
					personaje.setVida(personaje.getVida()-dañoAlmirante);
				}
			}
			else{
				int dañoVicealmirante = ((int)(Math.random()*((almirante.getFuerza())-1+1)+1));
				System.out.println("Almirante de la marina ataca con: "+ataqueEspecial);
				System.out.println("Hace un daño de: "+dañoVicealmirante);
				personaje.setVida(personaje.getVida()-dañoVicealmirante);
				if(personaje.getVida() > 0){
					int dañoPersonaje = ((int)(Math.random()*((personaje.getFuerza())-(personaje.getFuerza()-20)+1)+(personaje.getFuerza()-20)));
					System.out.println(personaje.getNombre()+" ataca con "+personaje.getAtaque());
					System.out.println("Hace un daño de: "+dañoPersonaje);
					almirante.setVida(almirante.getVida()-dañoPersonaje);
				}
			}
		}
		if(personaje.getVida() < 0){
			System.out.println("Has perdido contra Almirante de la marina");
		}
		else{
			System.out.println("Le has ganado al Almirante de la marina");
		}
		menuPrincipal(personaje);
	}

	public void peleaContraPersonaje(Personaje personaje, Personaje personaje1){
		while(personaje.getVida() > 0 && personaje1.getVida() > 0){
			System.out.println(personaje1.toString());
			if(personaje.getVelocidad() > personaje1.getVelocidad()){
				int dañoPersonaje = ((int)(Math.random()*((personaje.getFuerza())-(personaje.getFuerza()-20)+1)+(personaje.getFuerza()-20)));
				System.out.println(personaje.getNombre()+" ataca con "+personaje.getAtaque());
				System.out.println("Hace un daño de: "+dañoPersonaje);
				personaje1.setVida(personaje1.getVida()-dañoPersonaje);
				if(personaje1.getVida() > 0){
					int dañoPersonaje1 = ((int)(Math.random()*((personaje1.getFuerza())-1+1)+1));
					System.out.println(personaje1.getNombre()+" ataca con: "+personaje1.getAtaque());
					System.out.println("Hace un daño de: "+dañoPersonaje1);
					personaje.setVida(personaje.getVida()-dañoPersonaje1);
				}
			}
			else{
				int dañoPersonaje1 = ((int)(Math.random()*((personaje1.getFuerza())-1+1)+1));
				System.out.println(personaje1.getNombre()+" ataca con: "+personaje1.getAtaque());
				System.out.println("Hace un daño de: "+dañoPersonaje1);
				personaje.setVida(personaje.getVida()-dañoPersonaje1);
				if(personaje.getVida() > 0){
					int dañoPersonaje = ((int)(Math.random()*((personaje.getFuerza())-(personaje.getFuerza()-20)+1)+(personaje.getFuerza()-20)));
					System.out.println(personaje.getNombre()+" ataca con "+personaje.getAtaque());
					System.out.println("Hace un daño de: "+dañoPersonaje);
					personaje1.setVida(personaje1.getVida()-dañoPersonaje);
				}
			}
		}
		if(personaje.getVida() < 0){
			System.out.println("Has perdido contra "+personaje1.getNombre());
		}
		else{
			System.out.println("Le has ganado ha "+personaje1.getNombre());
		}
		menuPrincipal(personaje);
	}
}