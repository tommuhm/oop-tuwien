package at.tuwien.oopj4;

import java.util.Date;

public class Rental extends Surfarticle{
	private Date date;

	public Rental(Surfarticle surfarticle, Date date) {
		super(surfarticle);
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return this.getArticleName() + " " + this.date.toString();
	}

}
