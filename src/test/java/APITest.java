import Client.moviesClient;
import Models.Movies;
import Models.Search;
import com.sun.istack.NotNull;
import org.hamcrest.core.IsNull;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;

public class APITest {
    moviesClient client =new moviesClient();
    @Test
    public void search()
    {
        Movies m = client.getMovies();
        // By Search altındaki parametrelerde Harry Potter araması yapıldı
        m.getSearch().forEach(i->{
            //Gelen alanların boş olmadığı kontrol edilir
            assertThat(i.getTitle(),IsNull.notNullValue());
            assertThat(i.getImdbID(),IsNull.notNullValue());
            assertThat(i.getPoster(),IsNull.notNullValue());
            assertThat(i.getType(),IsNull.notNullValue());
            assertThat(i.getYear(),IsNull.notNullValue());
        });
        //Gelen sonuçlar içerisinde Harry Potter and the Sorcerer's Stone araması yapıldı
        List<Search> s = m.getSearch().stream().filter(x->x.getTitle().equals("Harry Potter and the Sorcerer's Stone")).collect(Collectors.toList());
        //Bulunan sonucun idsi ile get isteği atılıp sonuç çekildi
        client.getMoviesbyID(s.get(0).getImdbID());
    }
}
