

public class PokemonControls extends Controller{
	
	private int rounds;
	
	private class daCabecada extends Event {
		Pokemon atacado;
		int forca = 20;
		public daCabecada(Pokemon p, long eventTime){
			super(eventTime);
			atacado = p;
		}
		@Override
		public void action() {
			atacado.vida -= forca;
			
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	private class Restart extends Event {
		public Restart(long eventTime) {
			super(eventTime);
		}
		public void action() {
			long tm = System.currentTimeMillis();
			// Instead of hard-wiring, you could parse
			// configuration information from a text
			// file here:
			rounds = 5;
			addEvent(new daCabecada(new Pokemon(), tm));
			// Can even add a Restart object!
			addEvent(new Restart(tm + 20000));
		}
		public String description() {
			return "Restarting system";
		}
	}
	public static void main(String[] args) {
		PokemonControls pc = new PokemonControls();
		long tm = System.currentTimeMillis();
		pc.addEvent(pc.new Restart(tm));
		pc.run();
	}
}
