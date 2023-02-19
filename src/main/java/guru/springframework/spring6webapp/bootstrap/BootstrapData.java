package guru.springframework.spring6webapp.bootstrap;
import guru.springframework.spring6webapp.domain.*;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric=  new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author rod =  new Author();
        eric.setFirstName("Rod");
        eric.setLastName("Johnson");


        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Book noEJB = new Book();
        ddd.setTitle("J2EE Development without EJB");
        ddd.setIsbn("123456");


        Author ericSaved= authorRepository.save(eric);
        Book dddSaved=bookRepository.save(ddd);

        Author rodSaved= authorRepository.save(rod);
        Book noejbSaved=bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noejbSaved);

        System.out.println("InBootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: "+ bookRepository.count());

    }
}
