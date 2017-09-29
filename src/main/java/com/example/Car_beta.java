package com.example;

import entity.*;
import imgUrlBND.ImageUrlRight;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@CrossOrigin(origins = "http://localhost:8080//data2", maxAge = 3600)
@RestController
public class Car_beta {

	/**
	 * GloBAL VAlues
	 * 
	 */
	@Autowired
	public StatistikDao statistikDaos;

	public boolean log = true;

	/**
	 * Cars
	 * 
	 * @return max 10 unique Cars
	 */
	@RequestMapping("data2")
	public List<MercedesCar> allow() {
		List<MercedesCar> carListuni = new ArrayList<MercedesCar>();
		;
		try {
			HttpResponse<String> response = Unirest
					.post("https://api-sre.corpinter.net/mofi/modelfinder-backend/api/markets/de_DE/model?count=10&divfield=series")
					.header("content-type", "application/json").header("cache-control", "no-cache")
					.header("postman-token", "3763b2e1-d44b-f4a8-ba42-1a2dc8d8e7d5").body(generatebody()).asString();
			// ** System.out.println(response.getBody());

			final GsonBuilder gsonBuilder = new GsonBuilder();
			final Gson gson = gsonBuilder.create();
			MercedesCar[] carList = gson.fromJson(response.getBody(), MercedesCar[].class);

			/**
			 * LOG FILE PART2
			 */
			if (log == true) {
				try {
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/log/log.txt", true)));
					out.println("Response:");
					out.println("-----------------------------");
					out.println("																");
					out.println(response.getBody());
					out.println("-----------------------------");
					out.println("																");
					out.println("																");
					out.println("																");
					out.close();
				} catch (IOException e) {
					// exception handling left as an exercise for the reader
				}
			}

			// System.out.println(carList.length+" Fahrzeuge geladen");
			carListuni = makeunique(carList);
			carListuni = galleryfiller(carListuni);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		/**
		 * TEST CODESETCORRECTUR
		 */
		// String[] test=codeSetCorrectur(carListuni);
		// for(int i =0;i<carListuni.size();i++){
		// System.out.println(test[i].toString());
		// }

		return carListuni;
	}

	/**
	 * Positive erhalten und in Tabelle speichern
	 * 
	 * @param Car
	 *            input liked cars
	 */
	@RequestMapping(value = "/addpositive", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody List<MercedesCar> Car) {
		/**
		 * LOG FILE PART 3.1
		 */
		if (log == true) {
			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/log/log.txt", true)));
				out.println("																");
				out.println("LIST OF LIKED CARS");
				out.println("-----------------------------");
				for (MercedesCar s : Car) {
					out.println(s.getLabel());
				}
				out.println("-----------------------------");
				out.close();
			} catch (IOException e) {
				// exception handling left as an exercise for the
				// reader
			}
		}

		/*
		 * AUsgabe von geliebten Autos
		 */
		for (MercedesCar s : Car) {
			System.out.println(s.getModel());
		}

		checkintern(Car, true);
		System.out.println("_-----------------------_");
		System.out.println(Car.size());
	}

	/**
	 * Negativ erhalten und in Tabelle speichern
	 * 
	 * @param Car
	 *            Cars disliked
	 */
	@RequestMapping(value = "/addnegative", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateminus(@RequestBody List<MercedesCar> Car) {
		/**
		 * LOG FILE PART 3.2
		 */
		if (log == true) {
			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/log/log.txt", true)));
				out.println("																");
				out.println("LIST OF DISLIKED CARS");
				out.println("-----------------------------");
				for (MercedesCar s : Car) {
					out.println(s.getLabel());
				}
				out.println("-----------------------------");
				out.close();
			} catch (IOException e) {
				// exception handling left as an exercise for the
				// reader
			}
		}

		/*
		 * Ausgabe nicht gemochten Autos
		 */
		checkintern(Car, false);
		for (MercedesCar s : Car) {
			System.out.println(s.getModel());
		}
		System.out.println("_-----------------------_");
		System.out.println(Car.size());
	}

	public int splitter(MercedesCar car) {
		return Integer.parseInt(car.getCodeSet().substring(14, 17));

	}

	public List<MercedesCar> checkintern(List<MercedesCar> input, boolean check) {

		for (MercedesCar s : input) {
			if (statistikDaos.findOne(Integer.parseInt(s.getModel())) == null) {
				Statistik neu = new Statistik(Integer.parseInt(s.getModel()), s.getSeries());
				if (check == true) {
					neu.setLiked(1);
					neu.setDisliked(0);
					neu.setNationalsalestype(splitter(s));
				} else {
					neu.setDisliked(1);
					neu.setLiked(0);
				}
				statistikDaos.save(neu);
			} else {
				if (check == true) {
					Statistik buffer = statistikDaos.findOne(Integer.parseInt(s.getModel()));
					buffer.setLiked(buffer.getLiked() + 1);
					statistikDaos.save(buffer);
				} else {
					Statistik buffer = statistikDaos.findOne(Integer.parseInt(s.getModel()));
					buffer.setDisliked(buffer.getDisliked() + 1);
					statistikDaos.save(buffer);
				}

			}
		}

		return null;
	}

	/**
	 * For mobile devices
	 */
	@RequestMapping("data3")
	public List<MercedesCar> allowmobile() {
		List<MercedesCar> carListuni = new ArrayList<MercedesCar>();
		;
		try {
			HttpResponse<String> response = Unirest
					.post("https://api-sre.corpinter.net/mofi/modelfinder-backend/api/markets/de_DE/model?count=10&divfield=series")
					.header("content-type", "application/json").header("cache-control", "no-cache")
					.header("postman-token", "3763b2e1-d44b-f4a8-ba42-1a2dc8d8e7d5").body(generatebody()).asString();
			// ** System.out.println(response.getBody());
			final GsonBuilder gsonBuilder = new GsonBuilder();
			final Gson gson = gsonBuilder.create();
			MercedesCar[] carList = gson.fromJson(response.getBody(), MercedesCar[].class);
			// System.out.println(carList.length+" Fahrzeuge geladen");
			carListuni = makeunique(carList);
			// carListuni = galleryfiller(carListuni); //not use for mobile
			// devices
		} catch (UnirestException e) {
			e.printStackTrace();

		}
		return carListuni;
	}

	/**
	 * Mobile Devices
	 * 
	 * @param fav1
	 * @param fav2
	 * @return CarList with included Pics
	 */
	@RequestMapping(value = "/data4")
	public @ResponseBody List<MercedesCar> favoritecar(@RequestParam("fav1") String fav1,
			@RequestParam("fav2") String fav2) {

		List<MercedesCar> carListuni = new ArrayList<MercedesCar>();
		;
		try {
			HttpResponse<String> response = Unirest
					.post("https://api-sre.corpinter.net/mofi/modelfinder-backend/api/markets/de_DE/model?count=10&divfield=series")
					.header("content-type", "application/json").header("cache-control", "no-cache")
					.header("postman-token", "3763b2e1-d44b-f4a8-ba42-1a2dc8d8e7d5").body(generatebodyfav(fav1, fav2))
					.asString();
			System.out.println(response.getBody());
			final GsonBuilder gsonBuilder = new GsonBuilder();
			final Gson gson = gsonBuilder.create();
			MercedesCar[] carList = gson.fromJson(response.getBody(), MercedesCar[].class);
			carListuni = makeunique(carList); // überprüfe Unique
			@SuppressWarnings("unused")
			List<MercedesCar> returnCar = galleryfiller(carListuni); // get
																		// right
																		// images
																		// for
																		// HERZCARS
			// carListuni = galleryfiller(carListuni); //not use for mobile
			// devices
		} catch (UnirestException e) {
			e.printStackTrace();

		}
		carListuni = onlineCode(carListuni);
		return carListuni;

	}

	public List<MercedesCar> transformArrayToList(MercedesCar[] input, int j) {

		System.out.println("---------------------------------------------");
		System.out.println("List imported car");
		System.out.println("---------------------");

		for (MercedesCar s : input) {
			System.out.println(s.getLabel());
		}

		List<MercedesCar> output = new ArrayList<MercedesCar>();
		for (MercedesCar s : input) {
			output.add(s);
		}
		return output;

	}

	/***
	 * Nehme die Liste aus HTTPRequest [allow()] und gebe nur die Objekte zurück
	 * die Unique sind:D
	 */
	public List<MercedesCar> makeunique(MercedesCar[] input) {
		System.out.println(" ");
		System.out.println("---------------------------------------------");
		System.out.println("List imported car");
		System.out.println("---------------------");

		for (MercedesCar s : input) {
			System.out.println(s.getLabel());
		}

		List<MercedesCar> output = new ArrayList<MercedesCar>();
		;
		Set<Integer> notset = new HashSet<Integer>();
		for (int i = 0; i < input.length; i++) {
			Integer nottry = i;
			if (notset.contains(nottry)) {

			} else {
				for (int n = 0; n <= (input.length); n++) {
					if (n == i) {
						break;
					} else if (input[i].getLabel().equals(input[n].getLabel())) {
						// Wenn gleicher Label dann in die Schwarze Liste
						Integer notuse = n;
						notset.add(notuse);
						// System.out.println(n);
					}
				}
			}
		}
		for (int n = 0; n < (input.length); n++) {
			if (notset.contains(new Integer(n))) {

			} else {
				output.add(input[n]);
			}
		}
		System.out.println("");
		System.out.println("---------------------------------------------");
		System.out.println("List returned cars (amount: " + output.size() + ")");
		System.out.println("---------------------");
		for (MercedesCar s : output) {
			System.out.println(s.getLabel());
		}

		return output;
	}

	/***
	 * 
	 * @return random JSONRequest
	 */
	public String generatebody() {

		String[] eigenschaften = { "conceptValueRatings.autonom", "conceptValueRatings.effizient",
				"conceptValueRatings.eleganz", "conceptValueRatings.extravaganz", "conceptValueRatings.gelaende",
				"conceptValueRatings.geraeumig", "conceptValueRatings.innenraumLuxus", "conceptValueRatings.innovativ",
				"conceptValueRatings.kompakt", "conceptValueRatings.luxus", "conceptValueRatings.manuell",
				"conceptValueRatings.offenFahren", "conceptValueRatings.puristisch", "conceptValueRatings.rundumSicht",
				"conceptValueRatings.sicherheit", "conceptValueRatings.sportlich",
				"conceptValueRatings.sportlichesDesign", "conceptValueRatings.stauraum",
				"conceptValueRatings.traditionell" };
		Random rand = new Random();
		int randomselect;
		randomselect = rand.nextInt(eigenschaften.length - 0);
		while ((randomselect == 0 || randomselect == 1 || randomselect == 6 || randomselect == 10 || randomselect == 12
				|| randomselect == 13 || randomselect == 18 || randomselect == 7)) {
			randomselect = rand.nextInt(eigenschaften.length - 0);

		}
		String response = "[\r\n  {\r\n    \"filter_type\": \"concept\",\r\n    \"field\": \""
				+ eigenschaften[randomselect] + "\",\r\n    \"value\": " + (rand.nextDouble() % 1) + "\r\n},";

		int randomselect2;
		randomselect2 = rand.nextInt(eigenschaften.length - 0);
		while ((randomselect2 == 0 || randomselect2 == 1 || randomselect2 == 6 || randomselect2 == 10
				|| randomselect2 == 12 || randomselect2 == 13 || randomselect2 == 18 || randomselect2 == 7
				|| randomselect2 == randomselect)) {
			randomselect2 = rand.nextInt(eigenschaften.length - 0);

		}
		String response2 = "\r\n  {\r\n    \"filter_type\": \"concept\",\r\n    \"field\": \""
				+ eigenschaften[randomselect2] + "\",\r\n    \"value\": " + (rand.nextDouble() % 1) + "\r\n  }\r\n]";

		String response_JSON = response + response2;

		/**
		 * LOG FILE PART1
		 */
		if (log == true) {
			try {
				Calendar cal = Calendar.getInstance();
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/log/log.txt", true)));
				out.println("																");
				out.println("																");
				out.println("-------------------START---------------------------------");
				out.println("																");
				out.println("Datum: " + cal.get(Calendar.DAY_OF_MONTH) + "." + (cal.get(Calendar.MONTH) + 1) + "."
						+ cal.get(Calendar.YEAR));
				out.println("Uhrzeit: " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":"
						+ cal.get(Calendar.SECOND) + ":" + cal.get(Calendar.MILLISECOND));

				out.println(
						"URL:\"https://api-sre.corpinter.net/mofi/modelfinder-backend/api/markets/de_DE/model?count=10&divfield=series\"");
				out.println("																");

				out.println("BODY:");
				out.println("-----------------------------");
				out.println(response_JSON);
				out.println("																");
				out.println("-----------------------------");
				out.close();
			} catch (IOException e) {
				// exception handling left as an exercise for the reader
			}
		}

		// System.out.println(response);
		// System.out.println(response2);
		System.out.println("---------------------------------------------");
		System.out.println("Kriterium 1: " + eigenschaften[randomselect]);
		System.out.println("Kriterium 2: " + eigenschaften[randomselect2]);
		System.out.println("---------------------------------------------");
		return response_JSON;

	}

	/***
	 * Generate JSON for favCar
	 */
	public String generatebodyfav(String x, String y) {

		Random rand = new Random();
		double zufall1 = (rand.nextDouble() % 0.5 + 0.5);
		Random rand2 = new Random();
		double zufall2 = (rand2.nextDouble() % 0.5 + 0.5);
		System.out.println("***************************************");
		System.out.println(zufall1);
		System.out.println(zufall2);
		System.out.println("***************************************");

		String response = "[\r\n  {\r\n    \"filter_type\": \"concept\",\r\n    \"field\": " + x
				+ ",\r\n    \"value\": " + zufall1 + "\r\n},";

		String response2 = "\r\n  {\r\n    \"filter_type\": \"concept\",\r\n    \"field\": " + y
				+ ",\r\n    \"value\": " + zufall2 + "\r\n  }\r\n]";
		String response_JSON = response + response2;

		// System.out.println(response);
		// System.out.println(response2);
		System.out.println("---------------------------------------------");
		System.out.println("Kriterium 1: " + x);
		System.out.println("Kriterium 2: " + y);
		System.out.println("---------------------------------------------");
		return response_JSON;
	}

	public String[] auswertenAuswahl(String x, int y) {

		// [typ=Cabrio,
		// typ=Coupe,
		// typ=Limousine,
		// segment=Luxus,
		// segment=gehobeneMittelklasse,
		// segment=Mittelklasse,
		// segment=Kompaktklasse]
		// y-->1 segment --->2---->typ
		String[] ausgabe = new String[2];
		;
		if (y == 1) {
			if (x.equals("Luxus")) {
				ausgabe[0] = "conceptValueRatings.luxus";
				ausgabe[1] = "1";
				return ausgabe;
			} else if (x.equals("gehobeneMittelklasse")) {
				ausgabe[0] = "conceptValueRatings.luxus";
				ausgabe[1] = "0.8";
				return ausgabe;

			} else if (x.equals("Mittelklasse")) {
				ausgabe[0] = "conceptValueRatings.luxus";
				ausgabe[1] = "0.5";
				return ausgabe;

			} else if (x.equals("Kompaktklasse")) {
				ausgabe[0] = "conceptValueRatings.kompakt";
				ausgabe[1] = "1";
				return ausgabe;

			}
		}
		if (y == 2) {
			if (x.equals("Cabrio")) {
				ausgabe[0] = "conceptValueRatings.offenFahren";
				ausgabe[1] = "1";
				return ausgabe;
			} else if (x.equals("Coupe")) {
				ausgabe[0] = "conceptValueRatings.luxus";
				ausgabe[1] = "0.8";
				return ausgabe;

			} else if (x.equals("Limousine")) {
				ausgabe[0] = "1";
				return ausgabe;

			} else if (x.equals("Gelaende")) {
				ausgabe[0] = "conceptValueRatings.kompakt";
				ausgabe[1] = "1";
				return ausgabe;

			}
		}

		return null;

	}

	/**
	 * 
	 * @param segment(1=KOMPAKT||2=Mittelklasse||4=geho.MITTELKLASSE||8=LUXUS)
	 * @return (REQUEST BODY CUSTOM)
	 * @throws JSONException
	 */
	public List<MercedesCar> generatebodycustom(String[] segment, String[] typ) {
		List<MercedesCar> output = new ArrayList<MercedesCar>();
		if (typ.length == 1) {
			try {

				// HttpResponse<String> response = Unirest
				// .get("https://emb-ccore.mercedes-benz.com/embccs/api/v1/markets/de_DE/dataversion/cbb60acd/models?bodyId=1"
				// + auswertenAuswahl(typ[0], 2))
				HttpResponse<String> response = Unirest
						.get("https://emb-ccore.mercedes-benz.com/embccs/api/v1/markets/de_DE/dataversion/cbb60acd/models?bodyId=1")
						.header("cache-control", "no-cache").asString();
				final GsonBuilder gsonBuilder = new GsonBuilder();
				final Gson gson = gsonBuilder.create();
				System.out.println(response.getBody().toString());
				MercedesCar[] carList = gson.fromJson(response.getBody(), MercedesCar[].class);
				List<MercedesCar> carListuni = new ArrayList<MercedesCar>();
				carListuni = makeunique(carList);
				List<MercedesCar> returnCar = galleryfiller(carListuni);
				output = returnCar;

			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (typ.length > 1) {
			for (int i = 0; i < typ.length; i++) {
				try {
					HttpResponse<String> response = Unirest
							.get("https://emb-ccore.mercedes-benz.com/embccs/api/v1/markets/de_DE/dataversion/cbb60acd/models?bodyId="
									+ auswertenAuswahl(typ[i], 2))
							.header("cache-control", "no-cache").asString();
					final GsonBuilder gsonBuilder = new GsonBuilder();
					final Gson gson = gsonBuilder.create();
					MercedesCar[] carList = gson.fromJson(response.getBody(), MercedesCar[].class);
					List<MercedesCar> carListuni = new ArrayList<MercedesCar>();
					carListuni = makeunique(carList);
					List<MercedesCar> returnCar = galleryfiller(carListuni);
					output.add((MercedesCar) returnCar.subList(0, (int) (returnCar.size() / typ.length)));

				} catch (UnirestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return output;
	}

	/***
	 * Bilder vom Server holen
	 * 
	 * @return mindestens 5 Fahrzeuge mit den maximal erreichten guten Links
	 */
	public List<MercedesCar> galleryfiller(List<MercedesCar> input) {
		List<MercedesCar> output = new ArrayList<MercedesCar>();
		List<Integer> fehlerhafteVehicles = new ArrayList<Integer>();
		String codeSet[] = new String[input.size()];
		String url_links_request[] = new String[input.size()];
		for (int i = 0; i < input.size(); i++) {
			codeSet[i] = input.get(i).getCodeSet();
			String modelID = codeSet[i].substring(7, 17);
			String equipment_code = codeSet[i].substring(19, codeSet[i].length());
			equipment_code = equipment_code.replace("_E", "");
			equipment_code = equipment_code.replaceFirst("_S", "asdo8239ausdjn!3s");
			equipment_code = equipment_code.replace("_S", "");
			equipment_code = equipment_code.replace("asdo8239ausdjn!3s", "_S");
			url_links_request[i] = ("https://emb-ccore.mercedes-benz.com/embccs"
					+ "/api/v1/markets/de_DE/dataversion/1/models/" + modelID + "/configurations/" + equipment_code
					+ "?views=MEDIA");
			System.out.println(url_links_request[i]);
		}

		for (int i = 0; i < input.size(); i++) {

			try {
				HttpResponse<String> response = Unirest.get(url_links_request[i]).header("cache-control", "no-cache")
						.header("postman-token", "72c5de04-3566-778a-e3a3-d6fe38f68ff6").asString();
				final GsonBuilder gsonImgUrl = new GsonBuilder();
				final Gson gson = gsonImgUrl.create();
				ImageUrlRight imageSelect = gson.fromJson(response.getBody(), ImageUrlRight.class);
				try {
					String url = imageSelect.getStageInformation().getTemplateUri().toString();
					url = url.replace("${resolution}", "A4");
					url = url.replace("${perspective}", "BE040");
					url = url.replace("${mediaQualifiers}", "PZR");
					input.get(i).setModelImageUrl(url);
					System.out.println(url);
					output.add(input.get(i));
				} catch (Exception e) {
					System.out.println("Generierter Link fehlerhaft.....");
					fehlerhafteVehicles.add(i);
					// e.printStackTrace();
				}
			} catch (UnirestException e) {
				e.printStackTrace();

			}

		}

		System.out.println("Anzahl unique Fahrzeuge mit richtigen Links: " + output.size());

		// Mindestens 5 Fahrzeuge zur Darstellung auf der Website
		if (output.size() < 5) {
			for (int i = 0; i < (7 - output.size()); i++) {
				output.add(input.get(fehlerhafteVehicles.get(i)));
				System.out.println("aufbauen...");
			}
		}

		System.out.println("INSGESAMT WERDEN NUN " + output.size() + " Autos zurückgegeben");
		return output;
	}

	/**
	 * Statisik zurückgeben für Säulendiagramm
	 */
	@RequestMapping("statiAll")
	public Iterable<Statistik> alldata() {
		Iterable<Statistik> alles = statistikDaos.findAll();
		return alles;
	}

	@RequestMapping("statiLiked")
	public Iterable<Statistik> allLiked() {
		Iterable<Statistik> alles = statistikDaos.findAll();
		List<Statistik> test = (List<Statistik>) alles;
		Collections.sort(test, Comparator.comparing(Statistik::getLiked));
		Collections.reverse(test);
		return test;
	}

	@RequestMapping("statiDisliked")
	public Iterable<Statistik> allDisliked() {
		Iterable<Statistik> alles = statistikDaos.findAll();
		List<Statistik> test = (List<Statistik>) alles;
		Collections.sort(test, Comparator.comparing(Statistik::getDisliked));
		Collections.reverse(test);
		return test;
	}

	@RequestMapping("statiMIN")
	public void min() {
		// Iterable<Statistik> alles = statistikDaos.findAll();
		// List<Statistik> simple = (List<Statistik>) new HashSet<Statistik>();
	}

	/**
	 * Statistik-ANALYSE
	 */

	/**
	 * make right EquimentCode
	 * 
	 */

	/**
	 * Make right codeSet array
	 */

	public String[] codeSetCorrectur(List<MercedesCar> input) {
		String codeSet[] = new String[input.size()];
		String rightEquimentCode[] = new String[input.size()];
		for (int i = 0; i < input.size(); i++) {
			codeSet[i] = input.get(i).getCodeSet();
			String modelID = codeSet[i].substring(7, 17);
			String equipment_code = codeSet[i].substring(19, codeSet[i].length());
			equipment_code = equipment_code.replace("_E", "");
			equipment_code = equipment_code.replaceFirst("_S", "asdo8239ausdjn!3s");
			equipment_code = equipment_code.replace("_S", "");
			equipment_code = equipment_code.replace("asdo8239ausdjn!3s", "_S");
			rightEquimentCode[i] = ("de_DE__" + modelID + "__" + equipment_code);
		}

		return rightEquimentCode;

	}

	/**
	 * SetOnlineCode
	 */

	public List<MercedesCar> onlineCode(List<MercedesCar> input) {
		String codeSet[] = codeSetCorrectur(input);

		for (int i = 0; i < input.size(); i++) {
			try {
				HttpResponse<String> response = Unirest
						.post("https://emb-ccore.mercedes-benz.com/embccs/api/v1/onlinecode")
						.header("content-type", "application/json").header("cache-control", "no-cache")
						.header("postman-token", "481c4c67-369e-0e48-bd7b-e56c9a96d809")
						.body("{\"vehicleId\":\"" + codeSet[i] + "\"}").asString();
				// "{"onlineCode":"M4794726"}"

				if (response.getBody().length() > 15) {
					System.out.println("CODE VON " + i + " : "
							+ response.getBody().substring(15, response.getBody().length() - 2));
					input.get(i).setCodeSet("http://www.mercedes-benz.de/MC?extapp=mofi&Mcid="
							+ response.getBody().substring(15, response.getBody().length() - 2));

					/**
					 * Log File Part 4
					 */
					if (log == true) {
						try {
							PrintWriter out = new PrintWriter(
									new BufferedWriter(new FileWriter("C:/log/log.txt", true)));
							out.println("																");
							out.println("CodeSet Favorite Cars No. :" + i);
							out.println("-----------------------------");
							out.println(codeSet[i]);
							out.println("Online Code:");
							out.println(response.getBody().substring(15, response.getBody().length() - 2));
							out.println("-----------------------------");
							if (i == (input.size() - 1)) {
								out.println("*****************************************");
							}
							out.close();
						} catch (IOException e) {
							// exception handling left as an exercise for the
							// reader
						}
					}

				}

			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return input;
	}

	@RequestMapping(value = "/customsearch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MercedesCar> custom(@RequestBody String string) {

		// String input
		// ="typ=Cabrio&typ=Coupe&typ=Limousine&segment=Luxus&segment=gehobeneMittelklasse&segment=Mittelklasse&segment=Kompaktklasse"
		int counter = StringUtils.countMatches(string, "&") + 1; // counter==7
		String[] buffer = StringUtils.splitByWholeSeparator(string, "&", counter);// [typ=Cabrio,
																					// typ=Coupe,
																					// typ=Limousine,
																					// segment=Luxus,
																					// segment=gehobeneMittelklasse,
																					// segment=Mittelklasse,
																					// segment=Kompaktklasse]
		int typ_anzahl = StringUtils.countMatches(string, "typ="); // 3
		int segment_anzahl = StringUtils.countMatches(string, "segment="); // 4
		int wert_anzahl = StringUtils.countMatches(string, "wert="); // 4
		String[] typ = new String[typ_anzahl];
		String[] segment = new String[segment_anzahl];
		String[] wert = new String[wert_anzahl];

		/**
		 * Aufteilen
		 */
		for (int i = 0; i < typ_anzahl; i++) {
			typ[i] = buffer[i].replaceFirst("typ=", "");
			System.out.println(typ[i]);
		}

		for (int i = 0; i < segment_anzahl; i++) {
			segment[i] = buffer[i + typ_anzahl].replaceFirst("segment=", "");
			System.out.println(segment[i]);
		}

		for (int i = 0; i < wert_anzahl; i++) {
			wert[i] = buffer[i + typ_anzahl + segment_anzahl].replaceFirst("wert=", "");
			System.out.println(wert[i]);
		}

		/**
		 * Versuch 1
		 */
		// carListuni = generatebodycustom(segment, typ);
		// filterByTyp(carListuni, segment);
		/**
		 * Abgespackt auf nur wert
		 */
		List<MercedesCar> output = filterbywert(typ, segment, wert);
		System.out.println(output.size());
		return output;

		// * @param fahrzeugtyp
		// * (1=Limosine||2=SUV||4=COUPE||8=CABRIO)
	}

	/**
	 * 
	 * @param input
	 *            CARARRAY
	 * @param typ
	 *            FILTERTYP
	 * @return FILTERED CARARAY
	 */
	public List<MercedesCar> filterByTyp(List<MercedesCar> input, String[] segment) {

		List<MercedesCar> carListuni = new ArrayList<MercedesCar>();
		/**
		 * FILTERN NACH AusWAHL LUXUS UND co....NICHT FERTIG MONTAG
		 */
		carListuni = input;
		System.out.println("eingelesene Autos= " + input.size());
		System.out.println("--------------------------------");
		System.out.println("gefilterte Autos= " + carListuni.size());

		return carListuni;

	}

	/**
	 * 
	 * @param wert
	 *            AUSWAHLKRITERIEN
	 * @return LISTE NEUE AUTOS
	 */
	public List<MercedesCar> filterbywert(String[] typ, String[] segment, String[] wert) {
		String response = "";
		String response_wert = "";
		String response_segment = "";
		String response_typ = "";

		for (int i = 0; i < wert.length; i++) {
			response_wert = response_wert + "\r\n  {\r\n    \"filter_type\": \"concept\",\r\n    \"field\": \""
					+ "conceptValueRatings." + wert[i] + "\",\r\n    \"value\": " + 1 + "\r\n},";
		}

		for (int i = 0; i < segment.length; i++) {
			response_segment = response_segment + "\r\n  {\r\n    \"filter_type\": \"querystring\",\r\n    \"value\": "
					+ "\"segment:" + segment[i] + "\"\r\n},";
		}

		for (int i = 0; i < typ.length; i++) {
			response_typ = response_typ + "\r\n  {\r\n    \"filter_type\": \"querystring\",\r\n    \"value\": "
					+ "\"bodyType:" + typ[i] + "\"\r\n},";
		}

		response = "[" + response_wert + response_segment + response_typ;
		response = response.substring(0, (response.length() - 1)) + "]";
		System.out.println(response);
		List<MercedesCar> output = uni_search(response);
		System.out.println("");
		return output;

	}

	public List<MercedesCar> uni_search(String s) {
		List<MercedesCar> output = new ArrayList<MercedesCar>();

		try {
			String buffer = "https://api-sre.corpinter.net/mofi/modelfinder-backend/api/markets/de_DE/model?count=10&divfield=series";
			HttpResponse<String> response = Unirest
					.post("https://api-sre.corpinter.net/mofi/modelfinder-backend/api/markets/de_DE/model?count=10&divfield=series")
					.header("content-type", "application/json").header("cache-control", "no-cache")
					.header("postman-token", "0ccf9fa4-1c33-cf5c-10b5-1d8a2e356e64").body(s).asString();

			final GsonBuilder gsonBuilder = new GsonBuilder();
			final Gson gson = gsonBuilder.create();
			System.out.println(response.getBody().toString());
			MercedesCar[] carList = gson.fromJson(response.getBody(), MercedesCar[].class);
			if (carList.length < 5) {
				response = Unirest
						.post("https://api-sre.corpinter.net/mofi/modelfinder-backend/api/markets/de_DE/model?count=10")
						.header("content-type", "application/json").header("cache-control", "no-cache")
						.header("postman-token", "0ccf9fa4-1c33-cf5c-10b5-1d8a2e356e64").body(s).asString();
				carList = gson.fromJson(response.getBody(), MercedesCar[].class);
			}

			List<MercedesCar> carListuni = new ArrayList<MercedesCar>();
			carListuni = transformArrayToList(carList, 1);
			List<MercedesCar> returnCar = galleryfiller(carListuni);
			output = returnCar;

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

}