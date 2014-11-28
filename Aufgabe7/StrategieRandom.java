
public class StrategieRandom implements Strategie {



	public AntDirections dice() {

		double dice = Math.random();

		if ( dice < 1/4 ) {
			return AntDirections.rechts;
		}
			
			else if ( dice < 1/2 ) {
				return AntDirections.links;
			}
			else if ( dice < 3/4 ) {
				return AntDirections.oben;
			}
			else if (dice >= 3/4 ) {
				return AntDirections.unten;
			}
		
		return AntDirections.sleep; //should never happen

		}


		public void sleep(int n) throws InterruptedException {
			try {
				Thread.sleep(n);
			} catch(InterruptedException ex) {
				System.out.println("InterruptedException occured in StrategieRandom");
			}
		}
	}
