package com.example;

import com.example.entity.Masina;
import com.example.Repository.MasinaJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Scanner;
@SpringBootApplication
public class Tema9SpringDataJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tema9SpringDataJdbcApplication.class, args);
	}
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MasinaJdbcDao repository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean k = true;
        while (k) {
        	 System.out.println("\n--- Meniu ---");
             System.out.println("1. Lista masinilor din tabel");
             System.out.println("2. Inserarea unei masini");
             System.out.println("3. Stergere dupa nr de inmatriculare");
             System.out.println("4. Cautare dupa nr de inmatriculare");
             System.out.println("5. Nr masini cu o anumita marca");
             System.out.println("6. Nr masini care au sub 100000km");
             System.out.println("7. Masini mai noi de 5 ani");
             System.out.println("8. Iesire");
             System.out.print("Alege optiunea: ");
        

            int optiune = scanner.nextInt();
            scanner.nextLine(); 

    	
            switch (optiune) {
            case 1:
                System.out.println("\n--- Lista Masinilor din tabel ---");
                repository.findAll().forEach(System.out::println);
                break;

            case 2:
                System.out.println("\n--- Inserarea unei masini ---");
                Masina masina = new Masina("AB12XYZ", "Toyota", 2015, "rosu", 75000);
                int rand = repository.insert(masina);
                System.out.println("Nr randurilor afectate de inserare: " + rand);
                break;

            case 3:
                System.out.println(" Stergere dupa nr de inmatriculare");
                System.out.print("nr_inmatriculare: ");
                String nr_inmatriculare = scanner.nextLine();
                int randsters = repository.deleteByNr_inmatriculare(nr_inmatriculare);
                System.out.println("Nr randurilor afectate: " + randsters);
                break;

            case 4:
                System.out.println("Cautare dupa nr de inmatriculare");
                System.out.print("nr_inmatriculare: ");
                nr_inmatriculare = scanner.nextLine();
                System.out.println(repository.findByNr_inmatriculare(nr_inmatriculare));
                break;

            case 5:
                System.out.println("Nr masini cu o anumita marca");
                System.out.print("marca: ");
                String marca = scanner.nextLine();
                int countMarca = repository.countByMarca(marca);
                System.out.println("Nr masini cu marca " + marca + ": " + countMarca);
                break;

            case 6:
                System.out.println(" Nr masini care au sub 100000km ");
                int countKilometrii = repository.countByNr_kilometrii_smallerThan(100000);
                System.out.println("Nr masini: " + countKilometrii);
                break;

            case 7:
                System.out.println(" Masini mai noi de 5 ani");
                repository.findMasiniNoi(LocalDate.now().getYear()).forEach(System.out::println);
                break;

            case 8:
                k = false;
                System.out.println("Iesire din aplicatie.");
                break;

            default:
                System.out.println("Optiune invalida. Reincearca!");
                break;
        }
    }

    scanner.close();
}
}
