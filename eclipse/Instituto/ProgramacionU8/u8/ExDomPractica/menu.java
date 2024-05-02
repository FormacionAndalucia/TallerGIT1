package ExDomPractica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;

public class menu {
	private List<comida> menu;
	menu() {
		this.menu = new ArrayList();
	}
	public List<comida> getMenu() {
		return menu;
	}
	public void add(comida a) {
				this.menu.add(a);
				this.menu.remove(null);
	}
	
	public void generaJson() {
		Gson json = new Gson();
		String gson = json.toJson(getMenu());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Usuario\\Desktop\\DEV\\NTTData\\SVC\\eclipse\\Instituto\\ProgramacionU8\\u8\\ExDomPractica\\Menu.json"))){
			bw.write(gson);
			System.out.println("Valor cargado: "+gson);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "[" + menu + "]";
	}
}
