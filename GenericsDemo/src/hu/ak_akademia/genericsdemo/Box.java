package hu.ak_akademia.genericsdemo;

public class Box<T> {
	private T content;

	public boolean isEmpty() {
		return content == null;
	}

	public void put(T object) {
		if (isEmpty()) {
			content = object;
		} else {
			throw new IllegalStateException("A doboz nem üres, ezért nem lehet bele tenni újabb objektumot");
		}
	}

	public T get() {
		if (isEmpty()) {
			throw new IllegalStateException("A doboz üres, ezért nem lehet belőle kivenni objektumot.");
		}
		T object = content;
		content = null;
		return object;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "A doboz üres.";
		} else {
			return "A doboz tartalma: " + content;
		}
	}

}
