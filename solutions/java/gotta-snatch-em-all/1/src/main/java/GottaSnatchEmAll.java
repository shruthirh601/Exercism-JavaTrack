
import java.util.*;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> newCards = new HashSet<String>();
        newCards.addAll(cards);
        return newCards;
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        if (myCollection.isEmpty() || theirCollection.isEmpty()) {
        return false;
    }
        boolean iHaveSomethingTheyDont = myCollection.stream().anyMatch(item -> !theirCollection.contains(item));
        boolean theyHaveSomethingIDont = theirCollection.stream().anyMatch(item -> !myCollection.contains(item));
        return iHaveSomethingTheyDont && theyHaveSomethingIDont;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> allCards = allCards(collections);
        Set<String> commonCards = new HashSet<>(allCards);
        for (Set<String> collection : collections) {
            commonCards.retainAll(collection);
        }
        return commonCards;
        
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> distinctCards = new HashSet<>();
        for(Set<String> listOfCards: collections){
            distinctCards.addAll(listOfCards);
        }
        return distinctCards;
    }
}
