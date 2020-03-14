package it.univpm.Project.utils;

import it.univpm.Project.dataset.Funding;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.catalina.User;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonParser{
	{
	try {
	    // create Gson instance
	    Gson gson = new Gson();

	    // create a reader
	    Reader reader = Files.newBufferedReader(Paths.get("dataFile.json"));

	    // convert JSON array to list of users
	    List<Funding> fundings = new Gson().fromJson(reader, new TypeToken<List<Funding>>() {}.getType());

	    // print users
	    fundings.forEach(System.out::println);

	    // close reader
	    reader.close();

	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	}

}
