package com.capstone.windowsandmirrors.services;

import com.capstone.windowsandmirrors.models.*;
import com.capstone.windowsandmirrors.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Service
public class AddBooksService {
    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private UsersRepository usersRepository;

    public void addBook(AddBookRequest addBookRequest) {
        // check database to see if that title already exists
        String bookTitle = addBookRequest.getTitle();
        Book checkBook = booksRepository.findBookByTitle(bookTitle);
        // if title exists, do not add bookrequest to database

        if (checkBook != null){
            return;
        }

        // if the title is not in the database, check to see if author is in the database
        Set<Author> authors = new HashSet<>();
        addBookRequest.getAuthors().forEach(authorName -> {
            Author author = authorsRepository.findAuthorByName(authorName);
            if (author == null) {
                // if author(s) is in database, use that author's id. if not, assign new id & save.
                author = new Author();
                author.setName(authorName);
                author.setAvgRating(addBookRequest.getRating().doubleValue());
                authorsRepository.save(author);
            } else {
                // TODO update avg author rating
            }
            authors.add(author);
        });

        //load all tag objects to get their id
        Set<Tag> tags = new HashSet<>();
        addBookRequest.getTags().forEach(identifier -> {
            Tag tag = tagsRepository.findTagByIdentifier(identifier);
            if (tag == null) {
                tag = new Tag();
                tag.setIdentifier(identifier);
                tagsRepository.save(tag);
            }
            tags.add(tag);
        });
        //take remaining book information and create book object
        Book newBook = new Book();
        newBook.setTitle(addBookRequest.getTitle());
        newBook.setBookCover(addBookRequest.getBookCover());
        newBook.setAuthors(authors);
        newBook.setTags(tags);
        newBook.setStartAge(addBookRequest.getStartAge());
        newBook.setEndAge(addBookRequest.getEndAge());
        newBook.setStartGrade(addBookRequest.getStartGrade());
        newBook.setEndGrade(addBookRequest.getEndGrade());
        newBook.setSummary(addBookRequest.getSummary());
        newBook.setIsbn10(addBookRequest.getIsbn10());
        newBook.setIsbn13(addBookRequest.getIsbn13());
        newBook.setGenre(addBookRequest.getGenre());
        booksRepository.save(newBook);
        //take review information and make review object
        Review newReview = new Review();
        newReview.setPraise(addBookRequest.getPraise());
        newReview.setConcern(addBookRequest.getConcern());
        newReview.setDiscussionTopics(addBookRequest.getDiscussionTopic());
        newReview.setRating(addBookRequest.getRating());
        newReview.setUserId(addBookRequest.getUserId());
        newReview.setBookId(newBook.getId());
        reviewsRepository.save(newReview);

        newBook.getAuthors().forEach(author -> {
            authorsService.updateAuthorRating(author);
        });
    }

}
