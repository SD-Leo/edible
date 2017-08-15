package ru.edible.web;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * on 14/08/17.
 *
 * @author danil
 */
@SpringUI
public class WebUI extends UI {

    private final String host = "localhost";
    private final int port = 8081;
    private RestTemplate restTemplate;
    private int currentWordNum;
    private List<Card> cards;
    private Label curCardNum;
    private VerticalLayout v;

    private int score;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        restTemplate = new RestTemplate();
        VerticalLayout root = new VerticalLayout();
        setContent(root);


        Button start = new Button("Начать игру");
        root.addComponent(start);
        root.setComponentAlignment(start, Alignment.TOP_CENTER);
        start.addClickListener(clickEvent -> {
            root.removeAllComponents();
            currentWordNum = 0;
            score = 0;

            cards = getCards();

            curCardNum = new Label();
            Label slash = new Label("/");
            Label allCardsNum = new Label(cards.size() + "");
            HorizontalLayout hl = new HorizontalLayout(curCardNum, slash, allCardsNum);
            root.addComponent(hl);
            root.setComponentAlignment(hl, Alignment.TOP_CENTER);

            v = new VerticalLayout();
            root.addComponent(v);

            next();


//            getCards().forEach(card -> {
//                root.addComponent(new Label(card.getId() + " : " + card.getWord()));
//            });
        });


//        restTemplate.exchange()
    }

    private Component makeCard(Card card) {
        VerticalLayout vl = new VerticalLayout();

        Label word = new Label("<h1>" + card.getWord() + "</h1>");
        word.setContentMode(ContentMode.HTML);

        Button yes = new Button("Да");
        Label isEdible = new Label("съедобно?");
        Button no = new Button("Нет");
        HorizontalLayout buttons = new HorizontalLayout(yes, isEdible, no);


        Button next = new Button("Следующее");
        yes.addClickListener(clickEvent -> {
            yes.setEnabled(false);
            no.setEnabled(false);
            Word w = getWord(card.getId());
            Label answer = new Label("!");
            vl.addComponent(answer);
            vl.setComponentAlignment(answer, Alignment.TOP_CENTER);
            if (w.getEdible()) {
                answer.setValue("ВЕРНО");
                score++;
            } else {
                answer.setValue("НЕВЕРНО");
            }
            Label desc = new Label(w.getDescription());
            vl.addComponent(desc);
            vl.setComponentAlignment(desc, Alignment.TOP_CENTER);
            vl.addComponent(next);
            vl.setComponentAlignment(next, Alignment.TOP_CENTER);
        });
        no.addClickListener(clickEvent -> {
            yes.setEnabled(false);
            no.setEnabled(false);
            Word w = getWord(card.getId());
            Label answer = new Label("");
            vl.addComponent(answer);
            vl.setComponentAlignment(answer, Alignment.TOP_CENTER);
            if (w.getEdible()) {
                answer.setValue("НЕВЕРНО");
            } else {
                answer.setValue("ВЕРНО");
                score++;
            }
            Label desc = new Label(w.getDescription());
            vl.addComponent(desc);
            vl.setComponentAlignment(desc, Alignment.TOP_CENTER);
            vl.addComponent(next);
            vl.setComponentAlignment(next, Alignment.TOP_CENTER);
        });
        next.addClickListener(clickEvent -> next());

        vl.addComponent(word);
        vl.setComponentAlignment(word, Alignment.TOP_CENTER);
        vl.addComponent(buttons);
        vl.setComponentAlignment(buttons, Alignment.TOP_CENTER);

        return vl;
    }

    private void next() {

        v.removeAllComponents();
        if (currentWordNum < cards.size()) {
            curCardNum.setValue(String.valueOf(currentWordNum + 1));
            v.addComponent(makeCard(cards.get(currentWordNum++)));
        } else {
            Label gameOver = new Label("Game Over");
            v.addComponent(gameOver);
            v.setComponentAlignment(gameOver, Alignment.TOP_CENTER);
            Label gameOver1 = new Label("Ты угадал " + score + " слов");
            v.addComponent(gameOver1);
            v.setComponentAlignment(gameOver1, Alignment.TOP_CENTER);
        }


    }


    private List<Card> getCards() {
        ParameterizedTypeReference<List<Card>> type = new ParameterizedTypeReference<List<Card>>() {
        };
        List<Card> cards = restTemplate.exchange("http://" + host + ":" + port + "/five", HttpMethod.GET, null, type).getBody();
        return cards;
    }

    private Word getWord(String id) {
        String url = "http://" + host + ":" + port + "/words/" + id;
        System.out.println(url);
        Word word = restTemplate.getForObject(url, Word.class);
        return word;
    }
}
