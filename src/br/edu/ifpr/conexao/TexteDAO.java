package br.edu.ifpr.conexao;

import java.util.ArrayList;
import java.util.Iterator;

import br.edu.ifpr.acessar.bancodados.CampusDAO;
import br.edu.ifpr.paranavai.turma.Campus;

public class TexteDAO {

	public static void main(String[] args) {
		CampusDAO campusDAO = new CampusDAO();
		
		
		ArrayList<Campus> listaCampus = campusDAO.listar();
		
		for (Campus campus : listaCampus) {
			System.out.println(campus.getNome());
		}
	}

}
