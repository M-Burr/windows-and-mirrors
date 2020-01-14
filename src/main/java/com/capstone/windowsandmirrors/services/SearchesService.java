package com.capstone.windowsandmirrors.services;

import com.capstone.windowsandmirrors.models.Book;
import com.capstone.windowsandmirrors.models.Tag;
import com.capstone.windowsandmirrors.repositories.BooksRepository;
import com.capstone.windowsandmirrors.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchesService {
    @Autowired
    private TagsRepository tagsRepository;
    @Autowired
    private BooksRepository booksRepository;

    public ArrayList<Tag> findAll(){
        return (ArrayList<Tag>) tagsRepository.findAll();
    }

    public Set<Book> completeSearch(Set<String> identifiers, Set<Integer> ages){
        Iterable<Book> allBooks = booksRepository.findAll();
        Set<Book> filteredBooks = new HashSet<>();

        if (identifiers.isEmpty()){
            allBooks.forEach(book -> {
                filteredBooks.add(book);
            });
        } else {

            // look through each book
            // if that book's tags are included in the tags set, then add this book to the filtered books array
            for (Book book : allBooks) {
                Set<Tag> tags = book.getTags();
                tags.stream()
                        .map(tag -> tag.getIdentifier())
                        .forEach(bookIdentifier -> {
                            if (containsCaseInsensitive(identifiers, bookIdentifier)) {
                                filteredBooks.add(book);
                            }
                        });
            }
        }

        if (ages.isEmpty()){
            return filteredBooks;
        }
        final Set<Book> moreFilteredBooks = filteredBooks.stream()
                .filter(book -> {
                    // based on start age & end age for each book
                    // check to see if any passed in age is contained within the age range
                    // if it is within the range, return true (add to collection); otherwise return false
                    return anyAgeInRange(book.getStartAge(), book.getEndAge(), ages);
                })
                .collect(Collectors.toSet());

        return moreFilteredBooks;
    }

    private boolean anyAgeInRange(Long startAge, Long endAge, Set<Integer> ages) {

        for (int i : ages) {
            if (i >= startAge && i <= endAge) {
                return true;
            }
        }
        return false;
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
