package ru.edible.dao;

import org.springframework.stereotype.Service;
import ru.edible.domain.Word;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * on 14/08/17.
 *
 * @author danil
 */
@Service
public class WordsDao {

//    private static WordsDao INSTANCE;
//
//    private WordsDao() {
//    }
//
//    public static WordsDao getInstance() {
//        if (INSTANCE == null) {
//            INSTANCE = new WordsDao();
//            init();
//        }
//        return INSTANCE;
//    }

    private Map<String, Word> words = new HashMap<>();

    @PostConstruct
    private void init() {
        this.initWords();
    }

    public List<Word> findAll() {
        List<Word> words1 = new ArrayList<>();
        words.forEach((s, word) -> words1.add(word));
        return words1;
    }

    public Word findOne(String id) {
        return words.get(id);
    }


    private void initWords() {

        Word word;

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("ОРТОЛАНЫ");
        word.setEdible(Boolean.TRUE);
        word.setDescription("Поварское и ресторанное название блюд из жареной мелкой дичи — овсянок, жаворонков и воробьев");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("КИМЧИХИ");
        word.setEdible(Boolean.TRUE);
        word.setDescription("собирательное название блюд корейской кухни, которые готовятся из овощей, фруктов, мяса, рыбы и морепродуктов. Аналог европейских солений и острых закусок");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("КСЕНЬ");
        word.setEdible(Boolean.TRUE);
        word.setDescription("Древнерусское (до XVIII в.) название блюд из рыбьей печени.");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("КУБЕБА");
        word.setEdible(Boolean.TRUE);
        word.setDescription("Вид перца, растущего в Индонезии и Южной Индии и отличающегося наряду с обычным для всех перцев жгучестью особым тонким ароматом и охлаждающим эффектом наподобие мяты\n");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("КРУТОНЫ");
        word.setEdible(Boolean.TRUE);
        word.setDescription("Десертные блюда, комбинированные из хлеба и сладких фруктов (засахаренных или сваренных в сиропе), в которых хлеб служит одновременно и основанием (фундаментом, на который кладут часть персика, абрикоса или лимонного цуката, цитроната (см.), и компонентом, оттеняющим вкус и усиливающим сытность блюда.");
        words.put(word.getId(), word);


        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("ПАРАТХА");
        word.setEdible(Boolean.TRUE);
        word.setDescription("это индийская пресная лепешка, вариантов приготовления которой насчитывается более сорока и которую можно отведать в Малайзии, на Маврикии, Мальдивах, в Бирме и Сингапуре\n");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("АСАДО");
        word.setEdible(Boolean.TRUE);
        word.setDescription("в Аргентине обозначают и блюдо, и технику барбекю, и место встреч людей. Говяжьи ребрышки, свиные сосиски и куриные ножки жарятся на вертеле над открытым огнем в течение двух часов. Это блюдо также готовят в Бразилии, Чили, Колумбии и Перу.\n");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("ВАДА");
        word.setEdible(Boolean.TRUE);
        word.setDescription("Эти чечевичные, картофельные или луковые  пончики (или пирожки) являются типичным завтраком для жителей Южной Индии и Шри-Ланки. Такой пончик, по 300 калорий каждый, употребляют в качестве закуски или подают с основным блюдом.");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("СЕМИТА");
        word.setEdible(Boolean.TRUE);
        word.setDescription("Традиционным блюдом мексиканского городка Пуэбла являются фаршированные бутерброды семита. Их готовят из свинины или говядины с нарезанным на ломтики авокадо, луком, кесильо (сыром) на кунжутной булочке под мексиканским красным соусом.\n");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("АНТИКУЧОС");
        word.setEdible(Boolean.TRUE);
        word.setDescription("представляет собой жареные на вертеле куски мяса (как правило, это говяжье сердце) под соусом. Такое национальное перуанское блюдо можно попробовать и во многих других регионах Южной Америки. Антикучос – классическое уличное блюдо, которое стоит меньше одного доллара за порцию и прекрасно подходит для путешественников со скромным бюджетом.\n");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("КАЛЛАЛУ");
        word.setEdible(Boolean.TRUE);
        word.setDescription("это нечто среднее между такими экзотическими овощами, как водяной шпинат, дашин и амарант. Из этого овоща выходит превосходное рагу или гарнир к мясным блюдам. Несмотря на то, что каллалу выращивают в восточной части Карибских островов, на самом деле овощ имеет африканское происхождение. Из каллалу готовят как вегетарианские блюда с добавлением окры и кокосового молока, так и острые блюда из морепродуктов – краба, омара или ракушек. Варианты блюд из каллалу разнятся в зависимости от страны пребывания.\n");
        words.put(word.getId(), word);



        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Раффлезия");
        word.setEdible(Boolean.FALSE);
        word.setDescription("цветок вонючка. Ни стебля, ни листьев, ни корней у него нет. Зато внутри собирается 5-7 литров воды. Считается паразитом. Паразитирует в основном на лианах. Ареал этого цветка – полуостров Малакка, острова Суматра, Ява, Калимантан, Филиппины.\n");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Мурси");
        word.setEdible(Boolean.FALSE);
        word.setDescription("это необычное и страшное племя в африке");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Гаучо");
        word.setEdible(Boolean.FALSE);
        word.setDescription("социальная, в том числе иногда и субэтническая группа в Аргентине, Уругвае и штате Риу-Гранди-ду-Сул в Бразилии, близкая по духу американским ковбоям\n");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Самбуру");
        word.setEdible(Boolean.FALSE);
        word.setDescription("полукочевой нилотский народ, близкородственный масаям[2][3]; населяющий север и центральные регионы Кении. Самбуру живут за счёт животноводства, выращивая крупный скот, а также овец, коз и верблюдов\n");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Сокотра");
        word.setEdible(Boolean.FALSE);
        word.setDescription("небольшой архипелаг из четырех островов в Индийском океане");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Саксайуаман");
        word.setEdible(Boolean.FALSE);
        word.setDescription("древняя крепость великих Инков");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Кузиманза");
        word.setEdible(Boolean.FALSE);
        word.setDescription("а точнее длинноносая кузиманза, родственница мангустов, только обитающая в Западной Африке. Из интересных фактов можно отметить, что у длинноносой кузиманзы  половой диморфизм не выражен. То есть по внешним признакам невозможно отличить самку от самца. За то длинноносые кузиманзы легко приручаются и их часто содержат в качестве домашних животных\n");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Муфлон");
        word.setEdible(Boolean.FALSE);
        word.setDescription("это просто баран, а баран он и есть баран, даже если у него самое смешное название он всё равно баран");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Мундизал");
        word.setEdible(Boolean.FALSE);
        word.setDescription("противовоспалительный гель");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Скафтафетль");
        word.setEdible(Boolean.FALSE);
        word.setDescription("национальный парк на юге Исландии");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Камба");
        word.setEdible(Boolean.FALSE);
        word.setDescription("народ группы банту, третий по численности народ Кении. Живут в основном на юге в бассейне Ати (в основном в исторической области Укамбани: округа Мачакос, Мвинги, Макуэни и Китуи на юге Восточной провинции). Численность 3,8 млн чел.");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Пауни");
        word.setEdible(Boolean.FALSE);
        word.setDescription("индейский народ, проживавший в прошлом в районе рек Платт, Луп и Репабликан на территории современных Небраски и Канзаса.");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Свази");
        word.setEdible(Boolean.FALSE);
        word.setDescription("народ общей численностью 1,9 млн человек. Основные страны расселения: Южно-Африканская Республика — 1,2 млн человек, Свазиленд — 660 тыс. человек. Живут также в Мозамбике — около 10 тыс. человек. Язык — свати (сисвати, свази). Религиозная принадлежность верующих: христианство, часть — приверженцы традиционных верований.");
        words.put(word.getId(), word);

        word = new Word();
        word.setId(UUID.randomUUID().toString());
        word.setWord("Хауса");
        word.setEdible(Boolean.FALSE);
        word.setDescription("народ в Нигерии, составляет значительную часть населения на севере страны. Живут также в Республиках Камерун, Нигер, Чад, Центральноафриканской Республике и других странах. Численность — 30—35 миллионов человек.");
        words.put(word.getId(), word);

//        word = new Word();
//        word.setId(UUID.randomUUID().toString());
//        word.setWord("");
//        word.setEdible(Boolean.FALSE);
//        word.setDescription("");
//        words.put(word.getId(), word);




    }
}
