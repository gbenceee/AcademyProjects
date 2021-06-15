
public class Dimensions {
	private int heightInMillimetres;
	private int widthInMillimetres;
	private int depthInMillimetres;

	public Dimensions() {
	}

	public Dimensions(int heightInMillimetres, int widthInMillimetres, int depthInMillimetres) {
		this.heightInMillimetres = heightInMillimetres;
		this.widthInMillimetres = widthInMillimetres;
		this.depthInMillimetres = depthInMillimetres;
	}

	public int getHeightInMillimetres() {
		return heightInMillimetres;
	}

	public void setHeightInMillimetres(int heightInMillimetres) {
		this.heightInMillimetres = heightInMillimetres;
	}

	public int getWidthInMillimetres() {
		return widthInMillimetres;
	}

	public void setWidthInMillimetres(int widthInMillimetres) {
		this.widthInMillimetres = widthInMillimetres;
	}

	public int getDepthInMillimetres() {
		return depthInMillimetres;
	}

	public void setDepthInMillimetres(int depthInMillimetres) {
		this.depthInMillimetres = depthInMillimetres;
	}

	@Override
	public String toString() {
		return "[szélesség: " + widthInMillimetres + " mm; magasság: " + heightInMillimetres + " mm; mélység: " + depthInMillimetres + "mm]";
	}

}
