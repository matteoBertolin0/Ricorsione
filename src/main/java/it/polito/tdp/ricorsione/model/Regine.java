package it.polito.tdp.ricorsione.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {
	
	private List<List<Integer>> tutte;
	
	public List<List<Integer>> cercaRegine(int N) {
		this.tutte = new ArrayList<List<Integer>>();
		List<Integer> parziale = new ArrayList<Integer>();
		regineRicorsive(parziale, 0, N);
		return this.tutte;
	}
	
	/*
	 * se voglio ottenere solo la prima soluzione rendo il metodo ricorsivo booleano in modo
	 * che ogni livello possa dire a quello precedente quando fermarsi (partendo dall'ultimo che è l'unico che 
	 * sa quando bisogna fermarsi)
	 * Se il livello inferiore ritorna false allora non continuo altrimenti procedo
	 * Questo rende il processo estremamente più rapido
	 */
	private void regineRicorsive(List<Integer> parziale, int livello, int N) {
		if(livello==N) {
			//System.out.println(parziale);
			this.tutte.add(new ArrayList<Integer>(parziale));
			/* devo aggiungere la copia e non il riferimento
			 * perchè quando torno indietro nella ricorsione parziale viene svuotata
			 */
		}else {
			for(int col = 0; col<N; col++) {
				if(compatibile(col, livello, parziale)) {
					parziale.add(col);
					regineRicorsive(parziale, livello+1, N);
					parziale.remove(parziale.size()-1); //backtraking
				}
			}
		}
	}
	
	private boolean compatibile(int col, int livello, List<Integer> parziale) {
		if(parziale.contains(col)) {
			return false;
		}
		for(int riga = 0; riga<parziale.size(); riga++) {
			if(riga + parziale.get(riga) == livello+col) {
				return false;
			}
			if(riga - parziale.get(riga) == livello-col) {
				return false;
			}
		}
		return true;
	}
	
	
}
