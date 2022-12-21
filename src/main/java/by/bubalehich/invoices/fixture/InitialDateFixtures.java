package by.bubalehich.invoices.fixture;

import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.entity.Item;
import by.bubalehich.invoices.repository.CardRepository;
import by.bubalehich.invoices.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ro.polak.springboot.datafixtures.DataFixture;
import ro.polak.springboot.datafixtures.DataFixtureSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:application.properties")
public class InitialDateFixtures implements DataFixture {

    private static final int COUNT_OF_CARDS = 10;

    @Value("${data-fixtures.enabled}")
    private boolean enableDataFixtures;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void load() {
        generateCards();
        generateItems();
    }

    @Override
    public boolean canBeLoaded() {
        return enableDataFixtures;
    }

    @Override
    public DataFixtureSet getSet() {
        return DataFixtureSet.DICTIONARY;
    }

    private void generateCards() {
        List<Card> cardList = new ArrayList<>();

        for (int i = 1; i <= COUNT_OF_CARDS; i++) {
            cardList.add(new Card(String.valueOf(i)));
        }
        cardRepository.saveAll(cardList);
    }

    private void generateItems() {
        List<Item> itemList = List.of(
                new Item(null, "1", "Potato, 1kg", BigDecimal.valueOf(1.2), true),
                new Item(null, "2", "Bread, 200g", BigDecimal.valueOf(0.8), false),
                new Item(null, "3", "Meat, 1kg", BigDecimal.valueOf(2.0), true),
                new Item(null, "4", "Milk, 3.2%, 1l", BigDecimal.valueOf(1.0), false),
                new Item(null, "5", "Water, 1l", BigDecimal.valueOf(1.1), true),
                new Item(null, "6", "Beer, 0.5l", BigDecimal.valueOf(1.8), false),
                new Item(null, "7", "Beer, 1l", BigDecimal.valueOf(3), false),
                new Item(null, "8", "Scotch whisky, 0.75l", BigDecimal.valueOf(9), true),
                new Item(null, "9", "Chipseki, 150g", BigDecimal.valueOf(0.4), false),
                new Item(null, "11", "Orange Juice, 1l", BigDecimal.valueOf(2.6), true),
                new Item(null, "12", "Ice cream, 0.5kg", BigDecimal.valueOf(1.9), false),
                new Item(null, "13", "Zdoroviy son, 24h", BigDecimal.valueOf(8.2), true),
                new Item(null, "14", "Novaya spina, 1 piece", BigDecimal.valueOf(1.2), false),
                new Item(null, "15", "Anime", BigDecimal.valueOf(9.2), false),
                new Item(null, "16", "Gray Cat, 1 piece", BigDecimal.valueOf(99), true),
                new Item(null, "17", "Coca Cola, 1l", BigDecimal.valueOf(1), true),
                new Item(null, "18", "Pizza, 500g", BigDecimal.valueOf(2), false),
                new Item(null, "19", "Мandarin, 1kg", BigDecimal.valueOf(3), true),
                new Item(null, "20", "Christmas mood, 1 piece", BigDecimal.valueOf(4), true)
        );

        itemRepository.saveAll(itemList);
    }
}
