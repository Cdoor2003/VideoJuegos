public class Almirante extends Enemigo {
	private String[] ataquesEspecialesAlmirante = new String[]{"un ataque de la Pika Pika no Mi","un ataque de la Zushi Zushi no Mi","un ataque de la Mori Mori no Mi", "un ataque de la Magu Magu no Mi"};

	public Almirante(int fuerza, int velocidad, int vida) {
		super(fuerza, velocidad, vida);
	}

	public String[] getAtaquesEspecialesAlmirante() {
		return ataquesEspecialesAlmirante;
	}

	public void setAtaquesEspecialesAlmirante(String[] ataquesEspecialesAlmirante) {
		this.ataquesEspecialesAlmirante = ataquesEspecialesAlmirante;
	}

	@Override
	public String getTipo() {
		return "Almirante";
	}

	public String toString() {
		return "Enemigo: Almirante \n Vida: "+getVida()+"\n Fuerza: "+getFuerza()+"\n Velocidad: "+getVelocidad();
	}
}