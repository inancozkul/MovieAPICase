package Client;

import Models.Movies;
import com.google.gson.Gson;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class moviesClient {

    public Movies getMovies()
    {
        //Rest Assured kütüphanesi kullanılarak istek atılıp status kodu(200) kontrol edildi
        //API'den dönen response modele maplenir
        return new Gson().fromJson(given().contentType(ContentType.JSON).param("s","Harry Potter").
                param("apiKey","109b4779").get("http://www.omdbapi.com/").then().statusCode(200).extract().response().
                getBody().asString(),Movies.class);
    }
    public void getMoviesbyID(String id)
    {
        // //Rest Assured kütüphanesi kullanılarak istek atılıp status kodu(200) kontrol edildi
        given().param("i",id).param("apiKey","109b4779").get("http://www.omdbapi.com/").then().statusCode(200);
    }


}
