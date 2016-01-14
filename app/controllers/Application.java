package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application extends Controller {

    public static Result index() throws URISyntaxException {
        URL resource = Application.class.getResource("/test.pdf");
        Path path = Paths.get(resource.toURI());
        long length = path.toFile().length();
        InputStream inputStream = Application.class.getResourceAsStream("/test.pdf");
        response().setHeader("Content-Length", String.valueOf(length));
        return new InputStreamResult(inputStream);
    }

}
