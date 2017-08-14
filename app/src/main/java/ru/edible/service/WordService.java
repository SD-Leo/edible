/*
 * 2017-08-14
 */
package ru.edible.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edible.dao.WordsDao;
import ru.edible.domain.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * @author StarovoytovD
 */
@RestController
public class WordService {

    @Autowired
    private WordsDao dao;

    @RequestMapping (path = "words")
    public List<Word> getWords() {
        return dao.findAll();
    }

}
