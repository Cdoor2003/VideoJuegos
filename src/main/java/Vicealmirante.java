public class Vicealmirante extends Enemigo {
	private String[] ataquesEspecialesVicealmirante = new String[]{"Rankyaku","Shigan","golpe con Tekkai", "rokuogan"};

	public Vicealmirante(int fuerza, int velocidad, int vida) {
		super(fuerza, velocidad, vida);
	}

	public String[] getAtaquesEspecialesVicealmirante() {
		return ataquesEspecialesVicealmirante;
	}

	public void setAtaquesEspecialesVicealmirante(String[] ataquesEspecialesVicealmirante) {
		this.ataquesEspecialesVicealmirante = ataquesEspecialesVicealmirante;
	}

	@Override
	public String getTipo() {
		return "Vicealmirante";
	}

	public String toString() {
		return "Enemigo: Vicealmirante \n Vida: "+getVida()+"\n Fuerza: "+getFuerza()+"\n Velocidad: "+getVelocidad();
	}
}