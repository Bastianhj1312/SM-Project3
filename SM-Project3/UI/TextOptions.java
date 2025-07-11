package UI;
import java.util.ArrayList;

public class TextOptions
{
    private ArrayList<String> options;
    private String title;
    private boolean cancellable;

    /**
     * Constructor for objects of class TextOptions
     */
    public TextOptions(String title, String cancelText) {
        // initialise instance variables
        options = new ArrayList<>();
        this.title = title;
        if(cancelText != null) {
            cancellable = true;
        }
        addOption(cancelText);
    }

    public TextOptions(String title) {
        this(title, null);
    }
    
    public void addOption(String option) {
        options.add(option);
    }
    
    public int prompt() {
        System.out.println(title);
        int size = options.size();
        for (int i = 0; i < size; i++){
            String currentOption = options.get(i);
            if (currentOption != null) {
                System.out.println(" [" + i + "]\t" + currentOption);
            }
        }
        int choice = -1;
        int lowerBound = 0;
        if (!cancellable) {
            lowerBound = 1;
        }
        while (choice < lowerBound || choice >= size) {
           choice = TextInput.inputNumber("Vælg et tal"); 
        }
        return choice;
    }
    
}
