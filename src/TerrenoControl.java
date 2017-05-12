import java.lang.Math;
public class TerrenoControl {
	private int tatame = 1;
	private int grama  = 0;
	private int maxLength = 100;
	private int[] terreno;
	/*Esta classe cria um terreno unidimensional para que os pokémons andem
	 * Locais com valor 0 são grama, com valor 1 são tatames.
	 * */
	public TerrenoControl(){
		terreno  = new int[(int) (maxLength*Math.random())];
		for (int i = 0; i < terreno.length; i++)
			terreno[i] = (int) (Math.random() + 1);
	}
	public int getTatame(){
		return tatame;
	}
}
