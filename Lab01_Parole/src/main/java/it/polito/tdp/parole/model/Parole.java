package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	Map<String,String> mappaParole;
	public Parole() {
		mappaParole=new TreeMap<String,String>();
	}
	
	public void addParola(String p) {
		mappaParole.put(p, p);
	}
	
	public List<String> getElenco() {
		List<String> listaParole=new ArrayList<String>(mappaParole.values());
		return listaParole;
	}
	
	public void reset() {
		mappaParole.clear();
	}

	public void elimina(String p)
	{
		if(mappaParole.containsKey(p))
			mappaParole.remove(p);
	}
}
