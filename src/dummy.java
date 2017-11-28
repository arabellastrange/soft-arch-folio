import model.*;
import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import javax.naming.InvalidNameException;
import java.io.File;
import java.io.IOException;

public class dummy {
    public static void main(String[] args) throws WebsiteDataException, NegativeSharesException, InvalidNameException, NoSuchTickerException, IOException, ClassNotFoundException, DuplicateFolioException {
        IFolioTracker f = new FolioTracker();
        IFolio f1 = f.createFolio("asd");
        IFolio f2 = f.createFolio("sad");
        f1.createStock("x", "asd", 12);
        f1.createStock("MSFT", "d", 13);
        f2.createStock("sd", "asd", 1);
        f.saveToDisk(new File("anyfile.folio"));

        IFolioTracker ff = IFolioTracker.load(new File("anyfile.folio"));
        System.out.println(ff + " " + f);
    }
}

//todo
/*
adjust error meesages
input validation (trim etc)
definde what edit share means, edit name is not a requirement and deleting a share can be performed by selling all stock
unserializable fields like timer need to be made transient
make stuff that doesnt hcange final and private

other comments idk

 */
