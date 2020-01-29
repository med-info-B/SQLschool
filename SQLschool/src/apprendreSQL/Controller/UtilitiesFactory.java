package apprendreSQL.Controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

/**
 * Functions that don't really fit anywhere specific are put in this class.
 *
 */
public class UtilitiesFactory {
	/**
	 * Opens a URL on the web browser.
	 * @param uri
	 */
	public static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * A method that creates the questions in filmExercises.json
	 */
	protected static void createJsonTemp() {
		JsonManager jsonManager = new JsonManager();

		jsonManager.addQuestion("films.db", "SELECT", "Question 1", "1- Lister tous les films existants .",
				"SELECT * FROM FILM;");

		jsonManager.addQuestion("films.db", "SELECT", "Question 2", "2- Afficher les films triés par ordre de sortie .",
				"SELECT * from Film ORDER BY annee; ");
		jsonManager.addQuestion("films.db", "SELECT", "Question 3",
				"3- Afficher le titre de tous les films dont la date d'apparition est 1937 .",
				"SELECT titre FROM Film WHERE annee=1937; ");
		jsonManager.addQuestion("films.db", "SELECT", "Question 4",
				"4- Trouver l' année d'apparition du film 'Star wars' .",
				"SELECT annee From Film WHERE titre='Star Wars';");
		jsonManager.addQuestion("films.db", "SELECT", "Question 5",
				"5- Trouver le nom du réalisateur du film 'Titanic' .",
				"Select realisateur  FROM film WHERE titre='Titanic';");
		jsonManager.addQuestion("films.db", "SELECT", "Question 6",
				"6- Est-ce qu'il existe un film dans la base de données 'Films' qui s'appelle 'Alice In Wonderland'?(afficher tout s'il existe)",
				"Select * FROM film WHERE titre='Alice In Wonderland';");
		jsonManager.addQuestion("films.db", "SELECT", "Question 7",
				"7- Afficher tous les titres des films par ordre Alphabetique",
				"select titre from film order by titre;");
		jsonManager.addQuestion("films.db", "SELECT", "Question 8",
				"8- Afficher tous les nom des critiques par ordre Alphabetique",
				"select nom from critique order by nom;");

		jsonManager.addQuestion("films.db", "SELECT", "Question 9",
				"9- Afficher tous les critiques(nom,rID) par ordre croissant(riD)",
				"select nom,rID from critique order by rID;");
		jsonManager.addQuestion("films.db", "SELECT", "Question 10",
				"10- Afficher toutes les evaluations par ordre de dateEvaluation",
				"select * from evaluation order by dateEvaluation;");

		// Insert

		jsonManager.addQuestion("films.db", "INSERT", "Question 1",
				"1- Ajouter le film 'The Magnificent Seven' de '2016' qui est réalisé par 'Antoine Fuqua' avec mID=111",
				"INSERT INTO FILM VALUES(111,'The Magnificent Seven',2016,'Antoine Fuqua');");
		jsonManager.addQuestion("films.db", "INSERT", "Question 2",
				"2- Ajouter le film réaliser par 'Jacques Audiard' qui porte le titre 'the sisters brothers' , réaliser en '2018' avec mID=112",
				"INSERT INTO FILM VALUES (112,'the sisters brothers' , 2018 , 'Jacques Audiard');");
		jsonManager.addQuestion("films.db", "INSERT", "Question 3",
				"3- Ajouter le film :'111,Joker,2019,Todd Phillips' Ainsi que '110,Avengers Endgame,2019,Anthony et Joe Russo' en utilisant une seule requête.",
				"INSERT INTO FILM VALUES(111,'Joker',2019,'Todd Phillips'),(110,'Avengers Endgame',2019,'Anthony et Joe Russo');");
		jsonManager.addQuestion("films.db", "INSERT", "Question 4",
				"4- Ajouter le critique 'Leonard Maltin' avec rID='209'.",
				"INSERT INTO critique values(209,'Leonard Maltin');");
		jsonManager.addQuestion("films.db", "INSERT", "Question 5",
				"4- Faite en sort que le film 'Titanic'(mid 105) reçoit une critique de (205,'Chris Jackson') avec la note de 5 le '2012-01-01' .",
				"INSERT INTO evaluation values(205,105,5,'2012-01-01');");

		// delete

		jsonManager.addQuestion("films.db", "DELETE", "Question 1", "1- Supprimer le film 'Star wars'.",
				"DELETE FROM Film Where titre = 'Star wars';");
		jsonManager.addQuestion("films.db", "DELETE", "Question 2",
				"2- Supprimer tous les films réaliser par Chris Jackson.",
				"DELETE FROM film where realisateur = 'Chris Jackson';");
		jsonManager.addQuestion("films.db", "DELETE", "Question 3",
				"3- Supprimer tous les films qui ont été réalisé entre 1937 et 1977.",
				"DELETE FROM Film where annee < 1977 and annee > 1937;");
		jsonManager.addQuestion("films.db", "DELETE", "Question 4",
				"4- Supprimer l'évaluation dont le Date d'évaluation est '2011.01.12'.",
				"DELETE FROM evaluation where DateEvaluation='2011-01-12';");

		jsonManager.addQuestion("films.db", "DELETE", "Question 5",
				"5- Supprimer le critique dont le nom est 'Daniel Lewis'.",
				"DELETE FROM critique where nom='Daniel Lewis';");

		jsonManager.addQuestion("films.db", "DELETE", "Question 6",
				"6- Supprimer l'évaluation dont le Date d'évaluation est '2011-01-27' et la note de 4.",
				"DELETE FROM evaluation where DateEvaluation='2011-01-27' and note=4;");

		// JOIN

		jsonManager.addQuestion("films.db", "JOIN", "Question 1 ",
				"1-Donner le titre des films ayant obtenus une note>2",
				"select titre from film inner join evaluation ON (film.mID=evaluation.mId) where EVALUATION.NOTE>2;");
		jsonManager.addQuestion("films.db", "JOIN", "Question 2 ",
				"2-Afficher les film qui ont été noter par Sarah Martinez et qui ont la note de 4 ",
				"select * from ( (film f inner join evaluation e ON (e.mID=f.mID) ) as fe inner join critique c ON (c.rID=fe.rID))  where c.nom='Sarah Martinez';");
		jsonManager.addQuestion("films.db", "JOIN", "Question 3 ",
				"3-Donnez tous les films qui ont été evaluer entre le 01-01-2011 et le 15-01-2011 ",
				"select * from film f inner join evaluation e ON (f.mID = e.mID) where dateEvaluation >'01-01-2011' and dateEvaluation<'15-01-2011';");
		jsonManager.addQuestion("films.db", "JOIN", "Question 4 ",
				"4-Donner les notes du film critiqué par 'James Cameron'",
				"select note from evaluation e , critique c where e.rID=c.rID and c.nom='James Cameron';");
		jsonManager.addQuestion("films.db", "JOIN", "Question 5 ", "5-Quelle est la note du film 'Avatar'",
				"select note from Evaluation e inner join film f ON (e.mID=f.mID) where titre='Avatar';");

		// COUNT/SUM
		jsonManager.addQuestion("films.db", "COUNT&SUM", "Question 1",
				"1- Donner la somme de toutes les étoiles obtenues par tous les films.",
				" select Sum(note) from evaluation;");

		jsonManager.addQuestion("films.db", "COUNT&SUM", "Question 2",
				"2- Répertoriez tous les réalisateurs une seule fois .", "select distinct (realisateur) from film;");

		jsonManager.addQuestion("films.db", "COUNT&SUM", "Question 3",
				"3- Combien de films ont été réalisés par James Cameron.(nombre de titre)",
				" select count(titre) from film where realisateur='James Cameron';");
		jsonManager.addQuestion("films.db", "COUNT&SUM", "Question 4",
				"4- Combien de films ont obtenue une note inférieur à 4 (nombre de mID)",
				" select count(mID) from evaluation where note>4;");
		jsonManager.addQuestion("films.db", "COUNT&SUM", "Question 5",
				"5-Combien de films ont été realiser par James Cameron à l'année 1997 (nombre de titre)",
				"select count(titre) from film where realisateur='James Cameron'and annee=1997;");

		// Update

		jsonManager.addQuestion("films.db", "UPDATE", "Question 1",
				"1- Modifier la date de sortie du film 'titanic' à 1993.",
				"update film set annee=1993 where titre ='Titanic';");

		jsonManager.addQuestion("films.db", "UPDATE", "Question 2",
				"2- Modifier le titre du film de victor fleming à 'GWTW'.",
				"update film set titre='GWTW' where realisateur='Victor Fleming';");

		jsonManager.addQuestion("films.db", "UPDATE", "Question 3",
				"3- Modifier le nom du réalisateur du film Avatar par celui de David Crew .",
				"update film set realisateur='David Crew' where titre='Avatar';");

		jsonManager.addQuestion("films.db", "UPDATE", "Question 4",
				"4- Modifier l'année de réalisation dont le réalisateur est 'James Cameron' à 1944.",
				"update film set annee=1944 where realisateur='James Cameron';");
		jsonManager.addQuestion("films.db", "UPDATE", "Question 5",
				"5- Modifier la note des films dont la note = 2 par la note 4  là où la date d'évaluation est le '2011-01-22'.",
				"update evaluation set note=4 where dateEvaluation='2011-01-22'and note=2;");

		jsonManager.addQuestion("films.db", "UPDATE", "Question 6",
				"6- Changer le nom de critique donc l'rID est 203 par BH.",
				"Update critique set nom='BH' where rId=203;");

		// select dans select

		jsonManager.addQuestion("films.db", "SELECT dans SELECT", "Question 1",
				"1- Indiquez le titre des films où l'année est superieure à celle du film Titanic",
				"select titre from film where annee > (select annee from film where titre='Titanic');");

		jsonManager.addQuestion("films.db", "SELECT dans SELECT", "Question 2 ",
				"2- Afficher tous les film dont le réalisateur est celui du film 'Snow White'",
				"select * from film where realisateur=(select realisateur from film where titre='Snow White');");
		jsonManager.addQuestion("films.db", "SELECT dans SELECT", "Question 3 ",
				"3- Donner le titre ainsi que l'année des films dont l'année de réalisation est inferieure à l'année de réalisation du film Avatar",
				"select titre,annee from film where annee<(select annee from film where titre='Avatar');");

		jsonManager.addQuestion("films.db", "SELECT dans SELECT", "Question 4",
				"4- Donnez les evaluations ayant obtenus la note maximum",
				"select * from evaluation where note=(select max(note) from evaluation);");

		jsonManager.createJSON("resource/filmExercises.json");

	}

}
