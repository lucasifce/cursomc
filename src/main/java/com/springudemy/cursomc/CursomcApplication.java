package com.springudemy.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springudemy.cursomc.domain.Categoria;
import com.springudemy.cursomc.domain.Cidade;
import com.springudemy.cursomc.domain.Estado;
import com.springudemy.cursomc.domain.Produto;
import com.springudemy.cursomc.repositories.CategoriaRepository;
import com.springudemy.cursomc.repositories.CidadeRepository;
import com.springudemy.cursomc.repositories.EstadoRepository;
import com.springudemy.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ProdutoRepository proRepo;
	
	@Autowired
	private EstadoRepository estRepo;
	
	@Autowired
	private CidadeRepository cidRepo;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Limpeza");
		
		Produto p1 = new Produto(null, "Computador", 3000.00);
		Produto p2 = new Produto(null, "Mouse", 80.00);
		Produto p3 = new Produto(null, "Impressora", 1000.00);
		Produto p4 = new Produto(null, "Grampeador 26/6", 35.00);
		Produto p5 = new Produto(null, "Carimbo Grande", 60.00);
		Produto p6 = new Produto(null, "Álcool 70%", 15.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p3, p4, p5));
		cat3.getProdutos().addAll(Arrays.asList(p6));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat2));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		
		catRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		proRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));		
		
		estRepo.saveAll(Arrays.asList(est1,est2));
		cidRepo.saveAll(Arrays.asList(c1,c2,c3));
		
	}

}
