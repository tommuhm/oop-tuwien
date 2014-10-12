import java.util.Date;

public class Rental {
	private Surfarticle surfarticle;
	private Date date;

	public Rental(Surfarticle surfarticle, Date date) {
		this.surfarticle = surfarticle;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public Surfarticle getSurfarticle() {
		return surfarticle;
	}

	public float getPriceByNow() {
		return surfarticle.getPricePerHour() * this.getHours();
	}

	public int getHours() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60);
	}

	@Override
	public String toString() {
		return this.surfarticle.getArticleName() + " " + this.date.toString();
	}

}
