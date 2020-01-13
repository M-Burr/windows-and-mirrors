package com.capstone.windowsandmirrors.services;

import com.capstone.windowsandmirrors.models.Book;
import com.capstone.windowsandmirrors.models.Tag;
import com.capstone.windowsandmirrors.repositories.BooksRepository;
import com.capstone.windowsandmirrors.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class SearchesService {
    @Autowired
    private TagsRepository tagsRepository;
    @Autowired
    private BooksRepository booksRepository;

    public ArrayList<Tag> findAll(){
        return (ArrayList<Tag>) tagsRepository.findAll();
    }
    public Set<Book> completeSearch(Set<String> identifiers){
        Iterable<Book> allBooks = booksRepository.findAll();
        Set<Book> filteredBooks = new HashSet<>();
        for (Book book: allBooks )
        // look through each book
            // if that book's tags are included in the tags set, then add this book to the filtered books array
        {
            Set<Tag> tags = book.getTags();
            tags.stream()
                    .map(tag -> tag.getIdentifier())
                    .forEach(identifier -> {
                        if (containsCaseInsensitive(identifiers, identifier)) {
                            filteredBooks.add(book);
                        }
                    });
        }
        return filteredBooks;
    }

    private boolean containsCaseInsensitive(Set<String> stringSet, String stringMatch){
        for (String s: stringSet){
            if (s.equalsIgnoreCase(stringMatch)) {
                return true;
            }
        }
        return false;
    }
}
