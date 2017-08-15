/*
 * 2017-08-14
 */
package ru.edible.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edible.dao.WordsDao;
import ru.edible.domain.Card;
import ru.edible.domain.Word;

import java.util.*;

/**
 * @author StarovoytovD
 */
@RestController
public class WordService {

    @Autowired
    private WordsDao dao;

    @RequestMapping(path = "words")
    public List<Word> getWords() {
        return dao.findAll();
    }

    @RequestMapping(path = "words/{id}")
    public Word getWord(@PathVariable String id) {
        return dao.findOne(id);
    }

    @RequestMapping(path = "five")
    public List<Card> getFiveRandom() {
        List<Word> words = dao.findAll();
        Random rnd = new Random();

        Set<Word> five = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Word randomWord = words.get(rnd.nextInt(words.size()));
            while (five.contains(randomWord)) {
                randomWord = words.get(rnd.nextInt(words.size()));
            }
            five.add(randomWord);
        }

        List<Card> fiveCard = new ArrayList<>();
        five.forEach(word -> {
            Card card = new Card();
            card.setId(word.getId());
            card.setWord(word.getWord().toLowerCase());
            fiveCard.add(card);
        });

        return fiveCard;
    }

}
