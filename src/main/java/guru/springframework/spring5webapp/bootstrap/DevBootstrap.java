package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component // for spring boot wrap up this class
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;


  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    initData();
  }


  private void initData(){

    Author eric = new Author("Arzu","Türkmen");
    Book ddd = new Book("Domain Driven Design","1234","Harper Collins");

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rodi","Williams");
    Book noEJB = new Book("J'EEE Development without EJB","2345","Worx");

    authorRepository.save(rod);
    bookRepository.save(noEJB);



  }
}
