package ExDomPractica;

import java.util.*;

public class menu {
	private List<comida> menu;
	menu() {
		this.menu = new ArrayList();
	}
	List<comida> getMenu() {
		return menu;
	}
	<E> void add(E a) {
		if(a instanceof comida) {
			comida b = (comida) a;
			this.menu.add(b);
		} else {
			System.out.println("No se ha instanciado la comida como dicho objeto.");
		}
	}
	@Override
	public String toString() {
		return "[" + menu + "]";
	}
}
