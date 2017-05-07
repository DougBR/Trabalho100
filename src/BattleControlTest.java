import static org.junit.Assert.*;

import org.junit.Test;

public class BattleControlTest {

	@Test
	public void test() {
		
		BattleControl bc = new BattleControl();
		long tm = System.currentTimeMillis();
		Treinador t1 = new Ash();
		Treinador t2 = new Cagao();
		bc.addEvent(bc.new Batalhar(t1, t2, tm));
		bc.run();
		System.out.println("Fim de batalha");
		
	}

}
