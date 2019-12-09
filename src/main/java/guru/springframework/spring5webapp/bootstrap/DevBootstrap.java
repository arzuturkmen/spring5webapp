package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component // for spring boot wrap up this class
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;



  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    initData();
  }


  private void initData(){

    Author eric = new Author("Arzu","Türkmen");
    Publisher pub1 = new Publisher("Harper Collins","Adress1");
    Book ddd = new Book("Domain Driven Design","1234",pub1);

    authorRepository.save(eric);
    publisherRepository.save(pub1);
    bookRepository.save(ddd);


    Author rod = new Author("Rodi","Williams");
    Publisher pub2 = new Publisher("Worx","Adress2");
    Book noEJB = new Book("J'EEE Development without EJB","2345",pub2);

    authorRepository.save(rod);
    publisherRepository.save(pub2);
    bookRepository.save(noEJB);



  }
}
