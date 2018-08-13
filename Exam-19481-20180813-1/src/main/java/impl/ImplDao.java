package impl;

import java.util.ArrayList;

public interface ImplDao {
    boolean checkUser(String username);
    ArrayList<Object> getFilms();
    boolean deleteFilm(String film_id);
    boolean updateFilm(String filmId,String filmTitle,String filmdescription,String filmLanguageId);
    boolean addFilm(String filmId, String filmTitle, String filmdescription, String filmLanguageId);
}
