package hr.hackaton.codebandits;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Response;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CodebanditsApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CodebanditsApplicationTests {

	private static final String API_ROOT
			= "http://localhost:8081/api/books";

	private Book createRandomBook() {
		Book book = new Book();
		book.setTitle(randomAlphabetic(10));
		book.setAuthor(randomAlphabetic(15));
		return book;
	}

	private String createBookAsUri(Book book) {
		Response response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(book)
				.post(API_ROOT);
		return API_ROOT + "/" + response.jsonPath().get("id");
	}

	@Test
	public void whenGetAllBooks_thenOK() {
		Response response = RestAssured.get(API_ROOT);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetBooksByTitle_thenOK() {
		Book book = createRandomBook();
		createBookAsUri(book);
		Response response = RestAssured.get(
				API_ROOT + "/title/" + book.getTitle());

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		assertTrue(response.as(List.class)
				.size() > 0);
	}
	@Test
	public void whenGetCreatedBookById_thenOK() {
		Book book = createRandomBook();
		String location = createBookAsUri(book);
		Response response = RestAssured.get(location);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		assertEquals(book.getTitle(), response.jsonPath()
				.get("title"));
	}

	@Test
	public void whenGetNotExistBookById_thenNotFound() {
		Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));

		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
	}

}
