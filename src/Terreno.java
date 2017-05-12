import java.lang.Math;
public class Terreno {
	private int tatame = 1;
	private int grama  = 0;
	private int maxLength = 100;
	private int[] terreno;
	private Treinador[] tr = new Treinador[2];
	/*Esta classe cria um terreno unidimensional para que os pokémons andem
	 * Locais com valor 0 são grama, com valor 1 são tatames.
	 * */
	public Terreno(Treinador tr1, Treinador tr2){
		terreno  = new int[(int) (maxLength*Math.random() + 1)];
		for (int i = 0; i < terreno.length; i++)
			terreno[i] = (int) (Math.random() + 1);
		tr[0] = tr1;
		tr[1] = tr2;
		position();
	}
	public int getTerreno(Treinador t) {
		return terreno[t.getPosition()];
	}
	void position(){
		tr[0].setPosition((int) (maxLength*Math.random() + 1));
		tr[0].setPosition((int) (maxLength*Math.random() + 1));
	}
	public int getLength() {
		return terreno.length;
	}
}
