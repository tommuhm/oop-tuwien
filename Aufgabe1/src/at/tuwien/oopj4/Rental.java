package at.tuwien.oopj4;

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

	@Override
	public String toString() {
		return this.surfarticle.getArticleName() + " " + this.date.toString();
	}

}
