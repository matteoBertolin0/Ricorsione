package it.polito.tdp.ricorsione.model;

import java.util.List;

public class testRegine {

	public static void main(String[] args) {
		Regine r = new Regine();
		List<List<Integer>> soluzioni = r.cercaRegine(8);
		System.out.println(soluzioni);
	}

}
