/*
 * 2017-08-14
 */
package ru.edible.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edible.domain.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * @author StarovoytovD
 */
@RestController
public class WordService {

    @RequestMapping (path = "words")
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();

        Word word = new Word();
        word.setId("1");
        word.setWord("ОРТОЛАНЫ");
        word.setEdible(Boolean.TRUE);
        word.setDescription("Поварское и ресторанное название блюд из жареной мелкой дичи — овсянок, жаворонков и воробьев");
        words.add(word);


        return words;
    }

}
