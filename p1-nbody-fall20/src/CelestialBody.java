

/**
 * Celestial Body class for NBody
 * @author ola
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		this.myXPos = b.myXPos;
		this.myYPos = b.myYPos;
		this.myXVel = b.myXVel;
		this.myYVel = b.myYVel;
		this.myMass = b.myMass;
		this.myFileName = b.myFileName;
	}

	public double getX() {
		return myXPos;
	}
	public double getY() {
		return myYPos;
	}
	public double getXVel() {
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		return myYVel;
	}
	
	public double getMass() {
		return myMass;
	}
	public String getName() {
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		double distance = ((myXPos - b.myXPos) * (myXPos - b.myXPos)) +
						((myYPos - b.myYPos) * (myYPos - b.myYPos));
		return Math.sqrt(distance);
	}

	public double calcForceExertedBy(CelestialBody b) {
		double force = ((myMass * b.myMass)/
						(this.calcDistance(b) * this.calcDistance(b)));
		return force * 6.67E-11;
	}

	public double calcForceExertedByX(CelestialBody b) {
		double force = (b.myXPos - myXPos) /
						(this.calcDistance(b));
		return force * this.calcForceExertedBy(b);
	}
	public double calcForceExertedByY(CelestialBody b) {
		double force = (b.myYPos - myYPos) /
				(this.calcDistance(b));
		return force * this.calcForceExertedBy(b);
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		double sum = 0.0;
		for(CelestialBody b : bodies) {
			if (!b.equals(this)) {
				sum = this.calcForceExertedByX(b) + sum;
			}
		}
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for(CelestialBody b : bodies) {
			if (!b.equals(this)) {
				sum = this.calcForceExertedByY(b) + sum;
			}
		}
		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {

		double ax = xforce / myMass;
		double ay = yforce / myMass;

		double nvx = myXVel + (deltaT * ax);
		double nvy = myYVel + (deltaT * ay);

		double nx = myXPos + (deltaT * nvx);
		double ny = myYPos + (deltaT * nvy);

		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
