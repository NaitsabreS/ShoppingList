import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<ShoppingItem> dairy;
    private ArrayList<ShoppingItem> sweets;
    private ArrayList<ShoppingItem> bread;
    private ArrayList<ShoppingItem> vegetablesAndFruits;
    private ArrayList<ShoppingItem> others;

    public ShoppingList() {
        dairy = new ArrayList<>();
        sweets = new ArrayList<>();
        bread = new ArrayList<>();
        vegetablesAndFruits = new ArrayList<>();
        others = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "dairy=" + dairy.toString() +
                ", sweets=" + sweets.toString() +
                ", bread=" + bread.toString() +
                ", vegetablesAndFruits=" + vegetablesAndFruits.toString() +
                ", others=" + others.toString() +
                '}';
    }

    public static void addShoppingItem(ArrayList<ShoppingItem> shoppingList, ShoppingItem shoppingItem) {
        shoppingList.add(shoppingItem);
    }

    public static void main(String[] args) {
        ShoppingList ModelShoppingList = new ShoppingList();

        System.out.println("Model shopping list before adding: " + ModelShoppingList.dairy.toString());
        ShoppingItem bananas = new ShoppingItem("banany", "vegetables and fruits");
        ModelShoppingList.addAccordingToType(bananas);
        ShoppingItem oranges = new ShoppingItem("pomarańcze", "vegetables and fruits");
        ModelShoppingList.addAccordingToType(oranges);
        ShoppingItem apples = new ShoppingItem("jabłka", "vegetables and fruits");
        ModelShoppingList.addAccordingToType(apples);
        ShoppingItem yoghurt = new ShoppingItem("jogurt", "dairy");
        ModelShoppingList.addAccordingToType(yoghurt);
        ShoppingItem milk = new ShoppingItem("mleko", "dairy");
        ModelShoppingList.addAccordingToType(milk);
        ShoppingItem eggs = new ShoppingItem("jajka", "dairy");
        ModelShoppingList.addAccordingToType(eggs);
        ShoppingItem eggzzz = new ShoppingItem("jajka", "dairy");
        ModelShoppingList.addAccordingToType(eggzzz);
        System.out.println("Model shopping list after adding: " + ModelShoppingList.toString());

    }

    public void addAccordingToType(ShoppingItem shoppingItem) {
        switch (shoppingItem.getType()) {
            case "dairy":
                if (!dairy.contains(shoppingItem)) {
                    ShoppingList.addShoppingItem(dairy, shoppingItem);
                }
                break;
            case "vegetables and fruits":
                if (!vegetablesAndFruits.contains(shoppingItem)) {
                    ShoppingList.addShoppingItem(vegetablesAndFruits, shoppingItem);
                }
                break;
            case "others":
                if (!others.contains(shoppingItem)) {
                    ShoppingList.addShoppingItem(others, shoppingItem);
                }
                break;
            default:
                System.out.println("Nie można dodać produktu do listy");

        }
    }

    public boolean checkingIfProductAlreadyBelongToList(ShoppingItem item) {

        for (int i = 0; i < dairy.size(); i++) {
            if (item.getName().equals(dairy.get(i).getName())) {
                System.out.println("The product is already on the list");
                return true;
            }
        }
        return false;
    }

    public static String[] recipeTextArray(String recipeText) {
        recipeText = recipeText.toLowerCase();
        recipeText = recipeText.replaceAll("[^a-zA-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ]", "!");
        recipeText = recipeText.replaceAll("!+", " ");
        recipeText = recipeText.trim();
        String[] recipeTextArray = recipeText.split(" ");
        return recipeTextArray;
    }

    public static ArrayList<ShoppingItem> readingRecipe(String recipeText, ArrayList<ShoppingItem> sampleList) {
        ArrayList<ShoppingItem> resultList = new ArrayList<ShoppingItem>();
        String[] recipeTextArray = recipeTextArray(recipeText);
        int i = 0;

        while (i < sampleList.size()) {
            int j = 0;
            String nameOfTheProductFromSampleList = sampleList.get(i).getName();
            String checkedWord = nameOfTheProductFromSampleList.substring(0, nameOfTheProductFromSampleList.length() - 2);
            while (j < recipeTextArray.length) {
                if (recipeTextArray[j].contains(checkedWord)) {
                    resultList.add(sampleList.get(i));
                    break;
                }
                j++;
            }
            i++;
        }
        return resultList;
    }


}

