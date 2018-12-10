import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit5.*;
import org.loadui.testfx.GuiTest;
import org.testfx.framework.junit5.ApplicationTest;
import phonebook.base.VisualContact;
import phonebook.run.Main;
import static org.junit.jupiter.api.Assertions.*;
import static com.google.common.base.Verify.verify;


public class TestMain extends GuiTest {

    TableView<VisualContact> tableView;

    @Override
    protected Parent getRootNode() {
        Main main = new Main();
        try{
            return main.getRoot();
        }
        catch(Exception e){

        }
        return null;

    }
    @Before
    public void setUp(){
        tableView = find("#contactTable");
    }

    @Test
    public void givenContactTableContainsFourColumns(){
        assertTrue(tableView.getColumns().size()==4);
    }





}
