package treeview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Obituary
 */
// every tree has ONE SINGLE root 
// leaf elm that dont have any children 
public class Main extends Application {

    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("TreeView Demo");

        TreeItem<String> root, branch1Bucky, branch2Megan;

        //Root 
        root = new TreeItem<>();
        // whenever a program first start it's going to set everything = expanded?
        // meaning it can start with everything collapsed
        // or expanded by default (folders) like here
        root.setExpanded(true);

        //Bucky 
        branch1Bucky = makeBranch("branch1Bucky", root);
        makeBranch("thenewboston", branch1Bucky);
        makeBranch("Youtube", branch1Bucky);
        makeBranch("Chicken", branch1Bucky);

        //Megan 
        branch2Megan = makeBranch("branch2Megan", root);
        makeBranch("Glitter", branch2Megan);
        makeBranch("Makeup", branch2Megan);
        
        //Create tree 
        tree = new TreeView<>(root);
        // if not false, if true the user need to expand root each time
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->{
            if(newValue != null)
                System.out.println(newValue.getValue());
        });
        
        //Layout 
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    // makes the branch
    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

}
