
public class PokemonControls extends Controller{
	
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
}
