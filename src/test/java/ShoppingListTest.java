import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingListTest {
    @Test
    void shouldRecipeTextArray() {
        //given
        String text = "    1/2 kg ziemniaków 1/2 łyżki mąki pszennej 1/4 cebuli jajko sól olej roślinny do smażenia";

        //when
        String [] resultArray=ShoppingList.recipeTextArray(text);
        //then
        String[] expectedArray = {"kg", "ziemniaków", "łyżki", "mąki", "pszennej", "cebuli", "jajko", "sól", "olej", "roślinny", "do", "smażenia"};
        assertThat(resultArray).isEqualTo(expectedArray);

    }

    @Test
    void shouldReadingRecipe() {
        //given
        String text = "    1/2 kg ziemniaków 1/2 łyżki mąki pszennej 1/4 cebuli jajko sól olej roślinny do smażenia";
        ArrayList<ShoppingItem> sampleList =new ArrayList<ShoppingItem>();

        ShoppingItem cebula = new ShoppingItem("cebula", "fruits and vegetables");
        ShoppingItem pomarancza=new ShoppingItem("pomarańcza", "fruits and vegetables");
        ShoppingItem jogurt=new ShoppingItem("jogurt", "dairy");
        ShoppingItem sol=new ShoppingItem("sól", "dairy");
        ShoppingItem ziemniak=new ShoppingItem("ziemniak", "fruits and vegetables");
        ShoppingItem jajka=new ShoppingItem("jajka", "dairy");

        sampleList.add(cebula);
        sampleList.add(pomarancza);
        sampleList.add(jogurt);
        sampleList.add(jajka);
        sampleList.add(ziemniak);
        sampleList.add(sol);

        //when
        ArrayList<ShoppingItem> resultList=ShoppingList.readingRecipe(text, sampleList);
        //then
        ArrayList<ShoppingItem> expectedResultList = new ArrayList<>();
        expectedResultList.add(ziemniak);
        expectedResultList.add(sol);
        expectedResultList.add(jajka);
        expectedResultList.add(cebula);
        assertThat(resultList).containsExactlyInAnyOrderElementsOf(expectedResultList);
    }
}